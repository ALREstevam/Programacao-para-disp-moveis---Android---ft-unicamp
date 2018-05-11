package br.unicamp.ft.a166348.aplicacaoartista;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import br.unicamp.ft.a166348.aplicacaoartista.database.ArtistDb;
import br.unicamp.ft.a166348.aplicacaoartista.utils.SimpleAlert;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddArtistFragment extends Fragment {

    private View lView;
    public AddArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setRetainInstance( true );
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(lView == null){
            lView = inflater.inflate( R.layout.fragment_add_artist , container, false );//xml se transformou no lview
        }

        lView.findViewById( R.id.btn_addartist ).setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onAddClick( v );
            }
        } );

        return lView;
    }

    private void onAddClick(View view){
        EditText artistName = (EditText) lView.findViewById( R.id.artistName );

        if(artistName.getText().toString().equals( "" ) ||  artistName.getText().toString().isEmpty()){
            new SimpleAlert().alertOk( "Erro", "Você não colocou nenhum nome para o artista", getContext() );
        }else{
            new InsertAsyncTask().execute(  artistName.getText().toString() );

            new SimpleAlert().alertOk( "Sucesso", "Artista inserido com sucesso", getContext() );
            artistName.setText( "" );
        }
    }


    private class InsertAsyncTask extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            publishProgress( "Iniciando" );
            new ArtistDb( getContext() ).insertArtist(strings[0]);
            publishProgress( "Feito" );
            return true;
        }

        @Override
        protected  void onProgressUpdate(String... progress){
            Toast.makeText(getContext(), progress[0], Toast.LENGTH_SHORT).show();
        }



    }
}
