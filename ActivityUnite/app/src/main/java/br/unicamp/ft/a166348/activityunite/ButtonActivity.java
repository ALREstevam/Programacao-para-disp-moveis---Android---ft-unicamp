package br.unicamp.ft.a166348.activityunite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    public static String INTENT_TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_button );
    }

    public void onClick(View view){
        Toast toast = Toast.makeText(this, "Você,pressionou o botão", Toast.LENGTH_SHORT);
        toast.show();

        /*
          # Invocar nova activity: forma explícita ou implícita

          **Explícita**: dizemos quem é a activity
          `Intent` alguma coisa que queremos que acontça, uma mensagem que mandamos para outra activity
         */
        Intent intent = new Intent(this, EditTextActivity.class);
        intent.putExtra(INTENT_TEXT, "Um texto a ser enviado aqui");
        startActivity(intent);


    }
}





