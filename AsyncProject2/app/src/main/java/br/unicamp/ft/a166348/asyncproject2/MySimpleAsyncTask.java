package br.unicamp.ft.a166348.asyncproject2;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;


public class MySimpleAsyncTask extends AsyncTask<String, Integer, Boolean> {

    public TextView textView;
    public Boolean keepRunning;



    public MySimpleAsyncTask(TextView textView){
        this.textView = textView;
        this.keepRunning = true;
    }

    public void stopRunning(){
        keepRunning = false;
    }

    @Override
    protected void onPreExecute(){
        textView.append("Iniciado \n ");
    }

    @Override
    protected Boolean doInBackground(String... args){
        int count = 0;
        while (keepRunning){
            publishProgress(count);
            count++;
            if (args.length > 0) {
                Log.v("Background", args[0]);
            }
            try {
                Thread.sleep(1000);
            }catch (java.lang.InterruptedException e){}
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... args){
        textView.append(args[0]+",");
    }

    @Override
    protected void onPostExecute(Boolean args){
        textView.append("finished");
    }
}