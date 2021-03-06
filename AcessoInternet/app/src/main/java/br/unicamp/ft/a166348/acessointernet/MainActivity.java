package br.unicamp.ft.a166348.acessointernet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText1;
    EditText editText2;
    EditText editTextKey;
    private static String googleApiKeY = "AIzaSyAV3zGJdvJ0H4zcJK9UYyXZDO3SUk1xfr8";



    MyXMLTask myXMLTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textView = (TextView)findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        editText1   = (EditText)findViewById(R.id.editInfo1);
        editText2   = (EditText)findViewById(R.id.editInfo2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onViaCep(View view){
        textView.setText("");
        new MyViaCepAsyncTask(textView).execute(editText1.getText().toString());
    }

    public void onGMaps(View view){

        // Você precisará de uma APIKey obtida em:
        // https://developers.google.com/maps/documentation/geocoding/get-api-key?refresh=1&pli=1
        //https://developers.google.com/maps/documentation/geocoding/get-api-key?refresh=1&pli=1#standard-auth
        textView.setText("");
        //editText1.setText("R. Paschoal Marmo, 1888 - Jd. Nova Itália");
        new MyGMapsAsyncTask(textView).execute(
                //"R. Paschoal Marmo, 1888 - Jd. Nova Itália",
                editText1.getText().toString(),
                googleApiKeY
                //"AIzaSyBG7BqWhWLOIZI_kawMdto0Sz1gqPv_5ZM"
                );
    }

    public void onGRoutes(View view){
        textView.setText("");
        new MyGRoutesAsyncTask(textView).execute(
                "R. Paschoal Marmo, 1888 - Jd. Nova Itália",
                "R. Profa. Carlota Martensen Cavinato, Limeira",
                //googleApiKeY
                "AIzaSyBG7BqWhWLOIZI_kawMdto0Sz1gqPv_5ZM"
                );
    }

    public void onXML(View view){
        textView.setText("");
        new MyXMLTask(textView).execute();
    }
}
