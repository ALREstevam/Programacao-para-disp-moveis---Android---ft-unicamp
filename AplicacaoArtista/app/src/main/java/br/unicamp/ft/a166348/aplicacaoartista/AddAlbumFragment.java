package br.unicamp.ft.a166348.aplicacaoartista;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.unicamp.ft.a166348.aplicacaoartista.database.ArtistDb;
import br.unicamp.ft.a166348.aplicacaoartista.utils.SimpleAlert;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddAlbumFragment extends Fragment {

    private View lView;
    private Integer selectedArtistId;


    public AddAlbumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(lView == null){
            lView = inflater.inflate( R.layout.fragment_add_album, container, false );//xml se transformou no lview
        }

        Spinner spn = (Spinner) lView.findViewById( R.id.artist_spinner);
        final Map<Integer, String> artists = new ArtistDb( getContext() ).selectAllArtists();
        final List<String> artistNames = new ArrayList<>(artists.values());


        ArrayAdapter<String> spinnerArrayAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, artistNames); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(spinnerArrayAdapter);



        ((Spinner) lView.findViewById( R.id.artist_spinner )).setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String artistName = artistNames.get( position );
                        //selectedArtistId = artists.

                        for (Integer iterid : artists.keySet()) {
                            if (artists.get( iterid ).equals( artistName )) {
                                selectedArtistId = iterid;
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        selectedArtistId = null;
                    }
                }
        );

        lView.findViewById( R.id.btn_addalbum).setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onAddClick( v );
            }
        } );





        return lView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setRetainInstance( true );
    }

    private void onAddClick(View view){
        EditText albumName = (EditText) lView.findViewById( R.id.albumname );

        if(albumName.getText().toString().isEmpty() || selectedArtistId == null){
            new SimpleAlert().alertOk( "Erro", "Algum campo está incompleto", getContext() );
        }else{
            new ArtistDb( getContext() ).insertAlbum( albumName.getText().toString(), selectedArtistId );
            new SimpleAlert().alertOk( "Sucesso", "Album inserido com sucesso", getContext() );
            albumName.setText( "" );
        }
    }



}


