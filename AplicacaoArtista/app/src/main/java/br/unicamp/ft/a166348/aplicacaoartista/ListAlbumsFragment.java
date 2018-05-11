package br.unicamp.ft.a166348.aplicacaoartista;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import br.unicamp.ft.a166348.aplicacaoartista.database.ArtistDb;
import br.unicamp.ft.a166348.aplicacaoartista.utils.Touple;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListAlbumsFragment extends Fragment {


    public ListAlbumsFragment() {
        // Required empty public constructor
    }

    private View lView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(lView == null){
            lView = inflater.inflate( R.layout.fragment_list_albums , container, false );//xml se transformou no lview
        }

        //List<Touple<String, String>> rsp = new ArtistDb( getContext() ).selectArtistJoinAlbum();
        //List<String[]> rsp = new ArtistDb( getContext() ).selectArtistJoinAlbum2();






        /*for(Touple<String, String> line : rsp){
            text += line.getFirst() + " : " + line.getSecond() + "\n";
        }*/
        new ListAlbumsAsyncTask().execute();




        return lView;
    }


    public class ListAlbumsAsyncTask extends AsyncTask<Void, Integer, List<String[]>>{



        @Override
        protected void onPreExecute(){

        }


        @Override
        protected List<String[]> doInBackground(Void... voids) {

            publishProgress( 0);


            try {
                Thread.sleep( 2000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<String[]> rsp = new ArtistDb( getContext() ).selectArtistJoinAlbum2();
            publishProgress( 100);
            return rsp;
        }


        @Override
        protected  void onProgressUpdate(Integer... progress){
            Toast.makeText(getContext(), "Lendo dados: " + progress[0] + "%", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onPostExecute(List<String[]> rsp){
            TextView txtView = (TextView) lView.findViewById( R.id.list_id);
            String text = "";
            StringBuilder sb = new StringBuilder(  );
            for(String[] line : rsp){
                sb.append(line[0]);
                sb.append( " : " );
                sb.append( line[1] );
                sb.append( '\n' );
            }

            text = sb.toString();
            txtView.setText( text );
        }


    }

}
