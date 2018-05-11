package br.unicamp.ft.a166348.asyncproject2;


        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.ImageView;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    MySimpleAsyncTask mySimpleAsyncTask;
    ImageAsyncTask imageAsyncTask;
    boolean finished = false;

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

        textView = (TextView)findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.imageView);


        start();
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

    public void onRestart(View view){
        textView.setText("");

        if(finished){
            start();
            finished = false;
        }

    }

    public void onFinish(View view){
        mySimpleAsyncTask.stopRunning();
        imageAsyncTask.stopRunning();
        finished = true;
    }

    public void start(){
        mySimpleAsyncTask = new MySimpleAsyncTask(textView);
        mySimpleAsyncTask.execute("MySimpleAsyncTask");

        imageAsyncTask = new ImageAsyncTask( imageView );
        imageAsyncTask.executeOnExecutor( AsyncTask.THREAD_POOL_EXECUTOR,
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/adilson.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/america.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/ana_estela.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/Andre_angelis.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/andre_leon.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/zambon_1.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/bernardo_0.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/carmen.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/cassiana.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/cristhof.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/gallep_0.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/dagoberto.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/ursini.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/elaine_2.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/eloisa.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/enelton.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/chico.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/gisel_2.JPG",
                "https://www.ft.unicamp.br/sites/default/files/guilherme.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/ivan_ricarte.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/ieda_0.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/bertini.png",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/magossi_1.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/jose_geraldo.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/juliana_bueno.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/patricia.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/paulo_martins.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/saran.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/photoPlinio.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/foto4.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/renato_falcao.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/ronalton.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/vladimir_0.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/Ulises.JPG",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/victor.jpg",
                "https://www.ft.unicamp.br/sites/default/files/fotosDocentes/varese.JPG"
                );
    }
}