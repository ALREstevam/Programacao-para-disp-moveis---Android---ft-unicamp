package br.unicamp.ft.a166348.asyncproject2;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by andre on 27/04/2018.
 */

public class ImageAsyncTask extends AsyncTask<String, Bitmap, Boolean> {

    static private ImageView imgview;
    public Boolean keepRunning = true;

    public void stopRunning(){
        keepRunning = false;
    }

    public ImageAsyncTask(ImageView imgview) {
        this.imgview = imgview;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        while (keepRunning){
            for(String url : strings){
                try {
                    Bitmap image = ImageLoader.baixarImagem( url );
                    publishProgress( image );
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(100);
                }catch (java.lang.InterruptedException e){}
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
