package br.unicamp.ft.h174720.drawer;

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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        BlankFragment f1 = (BlankFragment) fragmentManager.findFragmentById(R.id.fragmento);

        android.support.v4.app.FragmentTransaction fragmentTransaction = null;


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null){
            fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment f2 = new BlankFragment();
            fragmentTransaction.add(R.id.frame, f2,"f2_1");
            fragmentTransaction.commit();
        }




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //overflow(direta)
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment2 f2 = new BlankFragment2();
            fragmentTransaction.replace(R.id.frame, f2, "f2_1");
            fragmentTransaction.commit();
            Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment f2 = new BlankFragment();
            fragmentTransaction.replace(R.id.frame, f2,"f2_2");
            fragmentTransaction.commit();
            Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment3 f3 = new BlankFragment3();
            fragmentTransaction.replace(R.id.frame, f3,"f2_3");
            fragmentTransaction.commit();
            Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

//estaticamente - inserir fragmento dentro do xml
//dinamicamente - insere o fragmento no codico java
