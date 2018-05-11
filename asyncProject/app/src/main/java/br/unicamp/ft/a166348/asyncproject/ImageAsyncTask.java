package br.unicamp.ft.a166348.asyncproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

/**
 * Created by andre on 27/04/2018.
 */

public class ImageAsyncTask extends AsyncTask<String, Bitmap, Boolean> {

    static private ImageView imgview;

    public ImageAsyncTask(ImageView imgview) {
        this.imgview = imgview;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        for(String url : strings){
            try {
                Bitmap image = ImageLoader.baixarImagem( url );
                publishProgress( image );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
    }

    @Override
    protected void onProgressUpdate(Bitmap... values) {
        imgview.setImageBitmap( values[0] );
    }


}
