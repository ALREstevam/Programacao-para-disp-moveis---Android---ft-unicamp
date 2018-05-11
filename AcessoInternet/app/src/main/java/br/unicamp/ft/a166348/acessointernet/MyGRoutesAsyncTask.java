package br.unicamp.ft.a166348.acessointernet;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ulisses on 9/27/17.
 */

public class MyGRoutesAsyncTask extends AsyncTask<String, Void, String> {

    TextView textView;

    public MyGRoutesAsyncTask(TextView textView) {
        this.textView = textView;
    }


    @Override
    protected void onPreExecute() {

        textView.append("####################### \n ");
        textView.append("Iniciando Rotas no Google Maps \n ");
    }

    @Override
    protected String doInBackground(String... args) {
        if (args.length == 0) {
            return "No Parameter";
        }

        HttpURLConnection httpURLConnection;
        try {

            //https://developers.google.com/maps/documentation/directions/intro
            String HOST = "https://maps.googleapis.com/maps/api/directions/json?" +
                    "origin="+URLEncoder.encode(args[0], "UTF-8")+"&destination=" +
                   URLEncoder.encode(args[1], "UTF-8")+"&key="+args[2];


        /*
          Abrindo uma conexão com o servidor
        */

            URL url = new URL(HOST);

            Log.e("uhu", url.toString());

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
        /*
          Lendo a resposta do servidor
        */
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(httpURLConnection.getInputStream()));


            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            Log.v("Erro", e.getMessage());
            return "Exception\n" + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String args) {
        Log.e("Hey",args);

        try {
            JSONObject js1 = new JSONObject(args);
            JSONObject js2 = js1.getJSONArray( "routes" ).getJSONObject( 0 ).getJSONArray( "legs" ).getJSONObject( 0 );



            /*JSONObject json2 = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
            textView.append(json2.getString("lat")+","+json2.getString("lng"));
            textView.append( "\n============================\n" );
            textView.append( args );*/


            textView.append( "Saindo de: " + js2.getString( "start_address" ) + '\n');

            textView.append( "\n" );

            textView.append( "Indo para: : " + js2.getString( "end_address" ) + '\n');

            textView.append( "\n\n" );

            textView.append( "Distância: " + js2.getJSONObject("distance").getString( "text" ) + '\n');
            textView.append( "Duração: " + js2.getJSONObject("duration").getString( "text" ) + '\n');

            textView.append( "\n\n" );

            JSONArray waypoints = js2.getJSONArray("steps");

            for(int i = 0; i < waypoints.length(); i++){
                String command = waypoints.getJSONObject( i ).getString( "html_instructions" );
                String time = waypoints.getJSONObject( i ).getJSONObject( "duration" ).getString( "text" );
                String distance = waypoints.getJSONObject( i ).getJSONObject( "distance" ).getString( "text" );

                //textView.append( distance );
                textView.append( "[" + distance + " | " + time + " ] "  + command.replace( "<b>", "" ).replace( "</b>", "" ) + "\n" );

            }









        } catch(JSONException e){
            textView.append("ERRO: Não foi possível converter em JSONObject: " + args+"\n");
        }




    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}

