package br.unicamp.ft.a166348.navigationdraweraula;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;



/*
* Naviagation drawer é um padrão utilizado em apps para facilitar a navegação
* Consiste em um menu à esquerda: Navigation Drawer
* E à direita um botão: Overflow
*
*
* NÃO COLOQUE BOTÕES NO MEIO DA TELA: USE O NAVIGATION DRAWER
*
*
* MainActivity: coloque nele a funcionalidade padrão da aplicação
*
*
* Aprendemos que
*
* Programamos em activity e trocamos intents entre activities: não é algo comum
*
*
* Normalmente se usa uma única activity usando FRAGMENTOS
*
* FRAGMENTOS
* -----------
* Fragmentos são quadros
*
* Manipulo fragmentos numa única tela
*
* Passar intents e criar novas activities gasta tempo de processamento
* Precisaria criar o mesmo menu em várias telas: fica mais pesado
*
*
* Por que foram criados?
*
* Na api 3.0 - Tablets começaram a ficar comuns: aplicativos de celular em tablets ficam estranhos
*
* Com fragmentos posso colocar vários fragmentos na mesma tela num tablet e usar várias telas no celular
*
* O fragmento deve ser autocontido: evitar conversas entre fragmentos
* Quando precisamos: usamos a activity como memória compartilhada - redirecionamento de chamadas
*
* */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager frgMngr;
    private BlankFragment frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        /*FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );*/

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        /*--------------------------------------------------*/

        this.frgMngr = getFragmentManager();//Colocar fragmento no frame layout (não uso direto ele)

        //Fragmento estático
        this.frag2 = (BlankFragment) frgMngr.findFragmentById( R.id.dynamic_fragment);


        //Fragmento dinâmico
        //Se for nulo sei que é a primeira execução (e não vou colocar outra instância no layout
        if(savedInstanceState == null){//salva dados - restaurar com ciclo de vida
            FragmentTransaction frgTrans = frgMngr.beginTransaction();
            BlankFragment frag = new BlankFragment();
            frgTrans.add( R.id.dynamic_fragment, frag, "fragment" );
            frgTrans.commit();//Android, coloque na pilha das coisas que você tem a fazer
        }

        Fragment gameFragment = frgMngr.findFragmentByTag( "mail" );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );

        return true;
    }

    /*
    * SE REFERE AO OVERFLOW
    * */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Clicked settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id == R.id.action_about){
            Toast.makeText(this, "Clicked about", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected( item );
    }


    /*
    SE REFERE AO NAV DRAWER
     */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(this, "Clicked A", Toast.LENGTH_SHORT).show();

            FragmentTransaction frgTrans = frgMngr.beginTransaction();
            MenuFragment frag = new MenuFragment();
            frgTrans.replace( R.id.dynamic_fragment, frag, "fragment" );
            frgTrans.commit();//Android, coloque na pilha das coisas que você tem a fazer

        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "Clicked B", Toast.LENGTH_SHORT).show();

            FragmentTransaction frgTrans = frgMngr.beginTransaction();
            BlankFragment frag = new BlankFragment();
            frgTrans.replace( R.id.dynamic_fragment, frag, "fragment" );
            frgTrans.commit();//Android, coloque na pilha das coisas que você tem a fazer

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }



}
