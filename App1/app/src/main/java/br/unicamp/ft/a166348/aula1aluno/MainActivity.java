package br.unicamp.ft.a166348.aula1aluno;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    /*
    Primeiro método do ciclo de vida da activity
    Funciona como um main
     */

    private List<Aluno> alunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        MainActivity alunosObj = new MainActivity();
        /*Aluno[] alunoTest = new Aluno[9];

        int index = 0;
        alunoTest[index++] = new Aluno("Adenilsom", "1234233");
        alunoTest[index++] = new Aluno("Craudinete", "12454554");
        alunoTest[index++] = new Aluno("Janalina", "253212");
        alunoTest[index++] = new Aluno("Kréberson", "43444");
        alunoTest[index++] = new Aluno("Janete", "2342");
        alunoTest[index++] = new Aluno("Janecreuza", "412333456");
        alunoTest[index++] = new Aluno("Joanilsom", "312312");
        alunoTest[index++] = new Aluno("Websley", "5243416");
        alunoTest[index] = new Aluno("Claudinete", "651438");

        for (Aluno al : alunoTest){
            alunosObj.add(al);
        }*/

        //Acessa como objeto a textview marcada com o id `textView` no arquivo `content_main.xml > TextView`
        TextView aTextView = (TextView)findViewById(R.id.textView);

        aTextView.setText("Nenhum aluno cadastrado.");



    }

    public boolean add(Aluno aluno) {
        return this.alunos.add(aluno);
    }


    @Override
    public String toString(){
        String rsp = "";
        for (Aluno aluno : this.alunos){
            rsp += ("#" + (this.alunos.indexOf(aluno) + 1) + " - " + aluno.toString() + '\n');
        }
        return rsp;
    }


    //Executando quando o botão é clicado
    public void onClick(View view){
        TextView resultTextView = (TextView)findViewById(R.id.textView);

        EditText nomeEditText = (EditText)findViewById(R.id.editText1);
        EditText raEditText = (EditText)findViewById(R.id.editText2);

        String nome = nomeEditText.getText().toString();
        String ra = raEditText.getText().toString();

        this.add(new Aluno(nome, ra));

        resultTextView.setText(this.toString());

        nomeEditText.setText("");
        raEditText.setText("");
    }

    public void onClean(View view){
        TextView resultTextView = (TextView)findViewById(R.id.textView);
        resultTextView.setText("");

        this.alunos.clear();
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
