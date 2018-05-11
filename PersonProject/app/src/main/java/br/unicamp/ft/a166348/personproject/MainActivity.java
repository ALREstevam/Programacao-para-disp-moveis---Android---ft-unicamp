package br.unicamp.ft.a166348.personproject;

import android.content.ClipData;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.Random;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Random rn = new Random();
    private Person selectedPerson = null;
    private Person wrongPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mRecyclerView = (RecyclerView) findViewById( R.id.aRecyclerView);


        //Aumento de performance
        /*
        * O RecyclerView reaproveita o espaço quando se dá scroll: não preciso criar 3000 espaços, para
        * 3000 ítens, apenas uns 5 para preencher toda a tela e então coloco os itens no lugar certo
        * no scroll
        * */
        mRecyclerView.setHasFixedSize( true );//Mudanças nos elementos da tabela não irão aumentar o tamanho dela

        mLayoutManager = new LinearLayoutManager( this );//recebe um context, a activity é um context
        mRecyclerView.setLayoutManager( mLayoutManager );//recycler view precisa de um layout manager

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Beatriz",    R.drawable.beatriz      ));
        people.add(new Person("Bomfim",     R.drawable.bomfim       ));
        people.add(new Person("Estevam",    R.drawable.estevam      ));
        people.add(new Person("Fioretti",   R.drawable.fioretti     ));
        people.add(new Person("Goya",       R.drawable.goya         ));
        people.add(new Person("Huanna",     R.drawable.huanna       ));
        people.add(new Person("Morimoto",   R.drawable.morimoto     ));
        people.add(new Person("Paulela",    R.drawable.paulela      ));
        people.add(new Person("Takehama",   R.drawable.takehama     ));
        people.add(new Person("Takeshi",    R.drawable.takeshi      ));
        people.add(new Person("Tamayose",   R.drawable.tamayose     ));
        people.add(new Person("Tavares",    R.drawable.tavares      ));
        people.add(new Person("Tomomitsu",  R.drawable.tomomitsu    ));


        this.wrongPerson = this.choosePerson( people );
        this.wrongPerson.setName( this.getRandomName() );

        mAdapter = new MyAdapter(people, this);
        mRecyclerView.setAdapter( mAdapter );




    }

    @Override
    public void onItemClick(Person person){
        Toast.makeText( this, person.getName(), Toast.LENGTH_LONG ).show();
        this.selectedPerson = person;
    }

    public void onVerify(View view){
        if(selectedPerson == null) {
            this.alert( "Ninguém selecionado", "Selecione quem você acha que está com o nome errado." );
        }else {
            if(this.selectedPerson.equals( this.wrongPerson )) {
                alert( "Parabéns", "Você acertou" );
            }
            else {
                alert( "Vish", "Você não acertou" );
            }
        }

    }

    public void alert(String msgName, String msgContent) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(msgName);
        alert.setMessage(msgContent);
        alert.setPositiveButton("OK",null);
        alert.show();
    }




    public Person choosePerson(ArrayList<Person> personList) {
        return personList.get( rn.nextInt(personList.size()));
    }

    public String getRandomName() {
        String[] names = {"Macedo","Luca","Josivaldo","Edmílson","Wilker","Peter","Thalisson","Gohan","Haroldo","Rosivaldo","Áurea","Linda","Lindaura","Janelle","Morena","Savana","Samilly","Rosivalda","Raynara","Edjane"};
        return names[rn.nextInt(names.length)];
    }



}


