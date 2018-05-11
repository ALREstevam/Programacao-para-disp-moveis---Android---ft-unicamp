package br.unicamp.ft.a166348.activityunite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    protected EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_edit_text );

        editText = (EditText)findViewById(R.id.editText);

        Intent intent = getIntent();

        if(intent != null){
            String text = intent.getStringExtra(ButtonActivity.INTENT_TEXT);
            //int number = intent.getIntExtra(ButtonActivity.INTENT_NUMBER);

            Toast toast = Toast.makeText(this, "Valor recebido: "+ text, Toast.LENGTH_SHORT);
            toast.show();

            //this.findViewById(android.R.id.)

        }

    }

    public void onClick(View view){
        String txt = editText.getText().toString();
        Toast toast = Toast.makeText(this, "Você,! escreveu: "+ txt, Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, CheckBoxActivity.class);
        startActivity(intent);

    }

}


