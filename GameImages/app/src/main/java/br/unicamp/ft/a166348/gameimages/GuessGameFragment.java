package br.unicamp.ft.a166348.gameimages;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuessGameFragment extends Fragment {


    private ArrayList<Person> people = new ArrayList<>();
    private int round = 1;
    private int totalrounds = 10;
    private int[] buttons = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    //private DatabaseReference mFirebaseDatabaseReference;


    private View lView;
    private Person selectedPerson;


    public GuessGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        lView = inflater.inflate( R.layout.fragment_guess_game, container, false );


        View.OnClickListener btnListner = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onButtonClick( view );
            }
        };

        for(int id : buttons){
            lView.findViewById(id).setOnClickListener(btnListner);
        }


        //populateview(getGameRoundList(), new Random().nextInt(8) );
        onNextRound();
        return lView;
    }



    private void populateView(List<Person> people, Person rightOne){

        for(int i = 0; i < 9; i++){
            Button btn = (Button) lView.findViewById( buttons[i]);
            String personName = people.get(i).getName();
            btn.setText( personName );
        }

        unlockButtons();

        ImageView img = (ImageView) lView.findViewById(R.id.flagImageView);
        img.setImageResource(selectedPerson.getImageId());

        TextView question = (TextView) lView.findViewById( R.id.questionNumberTextView );
        question.setText( "Question " + round + " of "+totalrounds);
        TextView result = (TextView)lView.findViewById( R.id.answerTextView );
        result.setVisibility( View.INVISIBLE );

    }




    public void onButtonClick(View view){
        Button btn = (Button) lView.findViewById( view.getId() );

        //Toast.makeText( getContext(), "Clicked: " + btn.getText(), Toast.LENGTH_SHORT ).show();

        btn.setEnabled( false );
        TextView result = (TextView)lView.findViewById( R.id.answerTextView );

        //FIREBASE PUSH
        //Resposta resposta = new Resposta(selectedPerson.getName(), btn.getText().toString());
        //mFirebaseDatabaseReference.child("respostas").push().setValue(resposta);

        if(btn.getText().equals( selectedPerson.getName() )){
            //Acertou
            lockButtons();
            result.setVisibility( View.VISIBLE );
            result.setTextColor( Color.GREEN );
            result.setText( "Você acertou" );
            onNextRound();
        }else{
            //Errou
            result.setVisibility( View.VISIBLE );
            result.setTextColor( Color.RED );
            result.setText( "Resposta errada" );
        }
    }


    private void onNextRound(){
        if(round > totalrounds){
            //Ganhou o jogo
            //Toast.makeText( getContext(), "Você ganhou o jogo", Toast.LENGTH_LONG ).show();


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    round = 1;
                    new SimpleAlert().alertOk( "Parabéns", "Você ganhou o jogo.", getContext() );
                    prepareRound();
                }
            }, 3000);
        }
        else if(round == 1){
            prepareRound();
        }
        else{

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    prepareRound();

                }
            }, 2000);
        }

    }

    private void prepareRound(){
        Collections.shuffle( people );

        int breakLoop = 0;
        Person newSelected;
        do{
           newSelected =  people.get( new Random( ).nextInt(8));
           breakLoop++;

           if(breakLoop >= 10){
               break;
           }

        }while (newSelected == selectedPerson);

        selectedPerson =  newSelected;
        populateView(people, selectedPerson);
        round++;
    }


    private void lockButtons(){
        for(int id : buttons){
            Button btn = lView.findViewById( id );
            btn.setEnabled( false );
        }
    }


    private void unlockButtons(){
        for(int id : buttons){
            Button btn = lView.findViewById( id );
            btn.setEnabled( true );
        }
    }



}
