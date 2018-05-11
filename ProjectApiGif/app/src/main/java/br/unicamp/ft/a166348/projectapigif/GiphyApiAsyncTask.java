package br.unicamp.ft.a166348.projectapigif;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by andre on 04/05/2018.
 */

enum JsonType{
    search_gif, random_gif,
}


public class GiphyApiAsyncTask extends AsyncTask<String, Void, String> {

    private SimpleDraweeView picture;
    private String searchTerm;
    private String apiKey;
    private Context context;
    private TextView textView;
    private JsonType jsonType;

    public GiphyApiAsyncTask(SimpleDraweeView picture, TextView textView, String searchTerm, String apiKey, Context context) {
        this.picture = picture;
        this.searchTerm = searchTerm;
        this.apiKey = apiKey;
        this.context = context;
        this.textView = textView;
    }

    private String getUrl(String searchTerm){
        String apiHost = "";
        if(!searchTerm.isEmpty()){
            int offset = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            apiHost = new GiphyApiUrlGenerator(this.apiKey).getSearchEndpointStr( searchTerm, 1, offset, "r", "pt", "json" );
            jsonType = JsonType.search_gif;
        }else{
            apiHost = new GiphyApiUrlGenerator( this.apiKey ).getRandomEndpointStr( "json" );
            jsonType = JsonType.random_gif;
        }
        return apiHost;
    }


    @Override
    protected void onPreExecute() {
        /*Uri uri = Uri.parse( "https://cdn.dribbble.com/users/108390/screenshots/2882839/spinner-loop.gif" );

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri( uri )
                .setAutoPlayAnimations( true )
                .build();
        picture.setController( controller );*/


    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection httpURLConnection;
        try {

            String apiHost = this.getUrl( this.searchTerm );
            Log.e( "API URI", apiHost );
            URL url = new URL(apiHost);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                Log.e( "json", line );
            }
            return sb.toString();
        } catch (IOException e) {
            Log.v("Erro", e.getMessage());
            return "Exception\n" + e.getMessage();
        }

    }


    private String getErrorGif(){
        List<String> errorImgs = new ArrayList<>( );

        if(isOnline()){
            errorImgs.add( "https://media.giphy.com/media/n5bn2qnHEp3bO/giphy.gif" );
            errorImgs.add( "https://media.giphy.com/media/9ohlKnRDAmotG/giphy.gif" );
            errorImgs.add( "https://media.giphy.com/media/l3q2K5jinAlChoCLS/giphy.gif" );
            errorImgs.add( "https://media.giphy.com/media/fpXxIjftmkk9y/giphy.gif" );
            errorImgs.add( "https://media.giphy.com/media/1RkDDoIVs3ntm/giphy.gif" );
        }
        else{
            errorImgs.add( "res:/" + R.drawable.nosignal );
        }


        Random randomizer = new Random();
        return errorImgs.get(randomizer.nextInt(errorImgs.size()));
    }

    @Override
    protected void onPostExecute(String args) {
        Uri uri;
        String imgurl = getErrorGif(), imgTitle = "Nothing found";

        try {
            JSONObject jsonObject = new JSONObject(args);


            switch (jsonType){
                case random_gif:
                    imgurl = jsonObject.getJSONObject( "data" ).getJSONObject( "images" ).getJSONObject( "original" ).getString( "url" );
                    imgTitle = jsonObject.getJSONObject( "data" ).getString( "title" );
                    break;

                case search_gif:
                    imgurl = jsonObject.getJSONArray( "data" ).getJSONObject( 0 ).getJSONObject( "images" ).getJSONObject( "original" ).getString("url");
                    imgTitle = jsonObject.getJSONArray( "data" ).getJSONObject( 0 ).getString( "title" );
                    break;
            }


            Log.e( "img url", imgurl );


        } catch(JSONException e) {
            e.printStackTrace();

            if(isOnline()){
                imgTitle = "Nothing found";
            }else{
                imgTitle = "No internet";
            }

            imgurl = getErrorGif();

        }
        finally {
            uri = Uri.parse(imgurl);
            final String imgTitleFinal = imgTitle;
            final Uri uriFinal = Uri.parse( imgurl );

            this.picture.setOnLongClickListener(
                    new View.OnLongClickListener() {
                        private ClipboardManager myClipboard = (ClipboardManager) context.getSystemService( Context.CLIPBOARD_SERVICE );
                        private ClipData myClip;

                        @Override
                        public boolean onLongClick(View v) {
                            myClip = ClipData.newRawUri( imgTitleFinal, uriFinal);
                            myClipboard.setPrimaryClip(myClip);

                            Toast.makeText(context, "GIF Copied",Toast.LENGTH_SHORT).show();
                            return true;
                        }
                    }

            );

            this.picture.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new GiphyApiAsyncTask( picture, textView, searchTerm, "dc6zaTOxFJmzC", context ).execute(  );

                }
            } );
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(uri)
                    .setAutoPlayAnimations(true)
                    .build();
            picture.setController(controller);
            //picture.setProgressBarImage(new ProgressBarDrawable());

            this.textView.setText( imgTitle );

        }



    }

    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        try{
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
        }
        catch (NullPointerException e){
            return false;
        }

    }
}
