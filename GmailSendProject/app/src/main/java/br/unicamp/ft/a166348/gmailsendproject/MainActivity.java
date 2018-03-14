package br.unicamp.ft.a166348.gmailsendproject;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText toEditText;
    private EditText usernameEditText;
    private EditText subjectEditText;
    private EditText passwordEditText;
    private EditText messageEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.toEditText         = (EditText)findViewById(R.id.to);
        this.usernameEditText   = (EditText)findViewById(R.id.username);
        this.messageEditText    = (EditText)findViewById(R.id.message);
        this.passwordEditText   = (EditText)findViewById(R.id.password);
        this.subjectEditText    = (EditText)findViewById(R.id.subject);


    }

    public void onSendButton(View view){
        //AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //TextView resultTextView = (TextView)findViewById(R.id.textView);



        Log.v("MainActivity", "toEditText: " + this.toEditText.getText());
        Log.v("MainActivity", "usernameEditText: " + this.usernameEditText.getText());
        Log.v("MainActivity", "messageEditText: " + this.messageEditText.getText());
        Log.v("MainActivity", "passwordEditText: " + this.passwordEditText.getText());
        Log.v("MainActivity", "subjectEditText: " + this.subjectEditText.getText());


        this.alert("Dados", "toEditText: " + this.toEditText.getText() + '\n' +
                "usernameEditText: " + this.usernameEditText.getText()+ '\n' +
                "messageEditText: " + this.messageEditText.getText()+ '\n' +
                "passwordEditText: " + this.passwordEditText.getText()+ '\n' +
                "subjectEditText: " + this.subjectEditText.getText()+ '\n');

        GmailSend gmailSend = new GmailSend(
                this.usernameEditText.getText().toString(),
                this.passwordEditText.getText().toString(),
                this.toEditText.getText().toString(),
                this.subjectEditText.getText().toString(),
                this.messageEditText.getText().toString()
                );



        //this.cleanDataInput();
    }


    public void alert(String title, String message){

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton("OK",null);
        alert.show();
    }

    public void cleanDataInput(){
        this.toEditText.setText("");
        this.usernameEditText.setText("");
        this.messageEditText.setText("");
        this.passwordEditText.setText("");
        this.subjectEditText.setText("");
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






}
