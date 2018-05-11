package br.unicamp.ft.a166348.activityunite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox checkBox1;
    CheckBox checkBox2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_check_box );

        checkBox1 = (CheckBox) findViewById(R.id.checkbox_1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox_2);
    }

    /**
     * Chamado quando algum dos CheckBoxes é clicado
     */
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox_1:
                if(checked)
                {
                    Toast.makeText(this, "Checkbox 1 selecionado", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Checkbox 1 não selecionado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_2:
                if(checked)
                {
                    Toast.makeText(this, "Checkbox 2 selecionado", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Checkbox 2 não selecionado", Toast.LENGTH_SHORT).show();
                }
        }
    }

    /**
     * Chamado quando o button é clicado
     */
    public void onClick(View view) {
        boolean checked1 = checkBox1.isChecked();
        boolean checked2 = checkBox2.isChecked();
        if (checked1 && checked2)
        {
            Toast.makeText(this, "Ambos selecionados", Toast.LENGTH_SHORT).show();
        }
        else if(checked1)
        {
            Toast.makeText(this, "Apenas Checkbox 1 selecionado", Toast.LENGTH_SHORT).show();
        }
        else if(checked2)
        {
            Toast.makeText(this, "Apenas Checkbox 2 selecionado", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Nenhum selecionado", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, RadioButtonActivity.class);
        startActivity(intent);

    }
}


