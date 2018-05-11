package br.unicamp.ft.a166348.activityunite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_radio_button );

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);


    }

    /** Chamado quando o RadioButton é clicado */
    public void onRadioButtonClick(View view) {
        String text=((RadioButton)view).getText().toString();
        Toast.makeText(this, "Você selecionou a "+text, Toast.LENGTH_SHORT).show();
    }

    /** Chamado quando o button é clicado */
    public void onClick(View view) {
        int id = radioGroup.getCheckedRadioButtonId();
        switch(id) {
            case R.id.radio_1:
                Toast.makeText(this, "Você selecionou a primeira,! opção", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_2:
                Toast.makeText(this, "Você selecionou a segunda,! opção", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}





