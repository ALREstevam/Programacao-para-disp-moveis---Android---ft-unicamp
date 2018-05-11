package br.unicamp.ft.a166348.projectapigif;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {


    private SimpleDraweeView draweeView;
    private TextView textView;
    private EditText textSearch;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        Fresco.initialize(this);

        setContentView( R.layout.activity_main2 );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG ).setAction( "Action", null ).show();
                new SimpleAlert().alertOk( "Help message",
                                "Hello. \n" +
                                        "This app will bring you some cool GIFs, type something in the text box and click the button to search for what you have written or leave blank to receive a random GIF.\n" +
                                "\nYou can make a long click on the GIF to copy it to the clipboard.",
                        context );


            }
        } );


        draweeView = (SimpleDraweeView) findViewById( R.id.img );
        textView = (TextView) findViewById( R.id.gifname );
        textSearch = (EditText) findViewById( R.id.search_term );

        draweeView.setBackgroundColor( Color.BLACK );

        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setProgressBarImage(new ProgressBarDrawable())
                .setPlaceholderImage( R.drawable.alpapa_loadinggif )
                .setActualImageScaleType( ScalingUtils.ScaleType.FIT_CENTER )
                .build();
        draweeView.setHierarchy(hierarchy);

        List<String> hints = new ArrayList<>( );

        hints.add( "Nyan Cat" );
        hints.add( "Rick Astley" );
        hints.add( "Rick Astley" );
        hints.add( "What" );
        hints.add( "Brent Rembo" );
        hints.add( "Dodge" );
        hints.add( "Kermit" );
        hints.add( "Chloe" );
        hints.add( "Pepe" );
        hints.add( "Monkey" );
        hints.add( "Shocked" );
        hints.add( "Travolta" );
        hints.add( "Oh long johnson" );


        Random randomizer = new Random();
        textSearch.setHint( hints.get(randomizer.nextInt(hints.size())));


        new GiphyApiAsyncTask( draweeView, textView, "", "dc6zaTOxFJmzC", this ).execute(  );
    }



    public void onSearch(View view) {
        String text = this.textSearch.getText().toString();
        new GiphyApiAsyncTask( draweeView, textView, text, "dc6zaTOxFJmzC", this ).execute(  );

    }

    public void onImageClick(View view) {
        //draweeView.setScaleType( ImageView.ScaleType.CENTER_CROP );
        //String text = this.textSearch.getText().toString();
        //new GiphyApiAsyncTask( draweeView, textView, text, "dc6zaTOxFJmzC", this ).execute(  );
    }
}
