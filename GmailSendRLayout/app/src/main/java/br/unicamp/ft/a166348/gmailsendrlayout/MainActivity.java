package br.unicamp.ft.a166348.gmailsendrlayout;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        super.onCreate( savedInstanceState );
        setContentView( R.layout.relative_layout );
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        this.toEditText         = (EditText)findViewById(R.id.to);
        this.usernameEditText = (EditText) findViewById( R.id.username );
        this.messageEditText = (EditText) findViewById( R.id.message );
        this.passwordEditText = (EditText) findViewById( R.id.password );
        this.subjectEditText    = (EditText)findViewById(R.id.subject);


    }

    public void onSendButton(View view) {
        Log.v( "MainActivity", "toEditText: "       + this.toEditText.getText() );
        Log.v( "MainActivity", "usernameEditText: " + this.usernameEditText.getText() );
        Log.v( "MainActivity", "messageEditText: "  + this.messageEditText.getText() );
        Log.v( "MainActivity", "passwordEditText: " + this.passwordEditText.getText() );
        Log.v( "MainActivity", "subjectEditText: "  + this.subjectEditText.getText() );

        try{



            GmailSend gmailSend = new GmailSend(
                    this.usernameEditText.getText().toString(),
                    this.passwordEditText.getText().toString(),
                    this.toEditText.getText().toString(),
                    this.subjectEditText.getText().toString(),
                    this.messageEditText.getText().toString()
            );

            gmailSend.SendEmail();

            //alert( "Success", "The e-mail was sendend with success." );

            this.alert( "Data",
                    "Trying to send the message\n" +
                    "username: " + this.usernameEditText.getText() + '\n' +
                    "password: " + "..." + '\n' +  //this.passwordEditText.getText()
                    "To: " + this.toEditText.getText() + '\n' +
                    "subject: " + this.subjectEditText.getText() + '\n' +
                    "message: " + this.messageEditText.getText() + '\n' );
        }
        catch (Exception e){
            alert( "Error", "The e-mail could not be sended." );
        }

    }


    public void alert(String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder( MainActivity.this );
        alert.setTitle( title );
        alert.setMessage( message );
        alert.setPositiveButton( "OK", null );
        alert.show();
    }

    public void cleanDataInput() {
        this.toEditText.setText( "" );
        this.usernameEditText.setText( "" );
        this.messageEditText.setText( "" );
        this.passwordEditText.setText( "" );
        this.subjectEditText.setText( "" );
    }
}




