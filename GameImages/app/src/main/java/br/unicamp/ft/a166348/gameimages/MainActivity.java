package br.unicamp.ft.a166348.gameimages;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private GuessGameFragment gameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.fragmentManager = getFragmentManager();//Colocar fragmento no frame layout (não uso direto ele)

        replaceFragment( "1", new GuessGameFragment(), "game" );

    }

    private void replaceFragment(String toastText, Fragment frag, String tag){
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        FragmentTransaction frgTrans = fragmentManager.beginTransaction();
        frgTrans.replace( R.id.dynamic_fragment, frag, tag );
        frgTrans.addToBackStack( null );//Adicionando à backstack o parâmetro é uma string de tag (para desempilhar manualmente)
        frgTrans.commit();//Android, coloque na pilha das coisas que você tem a fazer
    }
}
