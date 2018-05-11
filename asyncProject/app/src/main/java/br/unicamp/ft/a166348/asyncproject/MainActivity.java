package br.unicamp.ft.a166348.asyncproject;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imgView;
    MySimpleAsyncTask mySimpleAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = (TextView) findViewById(R.id.text);
        imgView = (ImageView) findViewById( R.id.image);

        textView.setText( "nothing" );
        imgView.setColorFilter( Color.RED );


        mySimpleAsyncTask = new MySimpleAsyncTask(textView);
        mySimpleAsyncTask.execute("MySimpleAsyncTask");

        //ImageAsyncTask imageAsyncTask = new ImageAsyncTask( imgView );
        //imageAsyncTask.execute( "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/adilson.jpg", "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/america.jpg" );


    }

    public void onRestart(View view){
        textView.setText("");
    }

    public void onFinish(View view){
        mySimpleAsyncTask.stopRunning();
    }
}
