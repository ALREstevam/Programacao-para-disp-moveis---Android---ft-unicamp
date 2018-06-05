package br.unicamp.ft.a166348.gameimages;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private GuessGameFragment gameFragment;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.fragmentManager = getFragmentManager();//Colocar fragmento no frame layout (não uso direto ele)

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        String mUsername;
        String mPhotoUrl;

        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity( new Intent( this, SignInActivity.class ) );
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }


        replaceFragment( "1", new GuessGameFragment(), "game" );

    }

    private void replaceFragment(String toastText, Fragment frag, String tag) {
        Toast.makeText( this, toastText, Toast.LENGTH_SHORT ).show();
        FragmentTransaction frgTrans = fragmentManager.beginTransaction();
        frgTrans.replace( R.id.dynamic_fragment, frag, tag );
        frgTrans.addToBackStack( null );//Adicionando à backstack o parâmetro é uma string de tag (para desempilhar manualmente)
        frgTrans.commit();//Android, coloque na pilha das coisas que você tem a fazer
    }
}
