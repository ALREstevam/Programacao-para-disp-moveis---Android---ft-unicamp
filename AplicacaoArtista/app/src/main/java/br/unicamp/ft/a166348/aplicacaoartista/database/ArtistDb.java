package br.unicamp.ft.a166348.aplicacaoartista.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unicamp.ft.a166348.aplicacaoartista.utils.Touple;

/**
 * Created by andre on 20/04/2018.
 */

public class ArtistDb {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public ArtistDb(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
        sqLiteDatabase = dbHelper.getReadableDatabase();//pega o banco de dados
    }


    public void insertArtist(String artistName){
        ContentValues contentValues = new ContentValues();//Grava chave-valor (<campo do bd>, )
        contentValues.put("name", artistName);
        sqLiteDatabase.insert("artists", null, contentValues);
    }

    public void insertAlbum(String albumName, int artistId){
        ContentValues contentValues = new ContentValues();//Grava chave-valor (<campo do bd>, )
        contentValues.put("title", albumName);
        contentValues.put("artist_id", artistId);

        sqLiteDatabase.insert("albums", null, contentValues);
    }

    public Map<Integer, String> selectAllArtists(){
        String sql = "SELECT * FROM artists";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        Map<Integer, String> outputMap = new HashMap<>();

        if (cursor.moveToFirst()){
            String str = "";
            do {
                int id    = cursor.getInt(0);
                String name = cursor.getString(1);
                outputMap.put( id, name );


            }while(cursor.moveToNext());
        }
        cursor.close();

        return outputMap;
    }

    public List<Touple<String, String>> selectArtistJoinAlbum(){

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT artists.name, albums.title FROM artists INNER JOIN albums ON artists._id = albums.artist_id", null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT title, CAST(artist_id AS varchar) AS artist_id FROM albums", null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT name, CAST(_id AS varchar) AS artist FROM artists", null);

        List<Touple<String, String>> output = new ArrayList<>(  );


        if (cursor.moveToFirst()){
            do {
                String name1   = cursor.getString(0);
                String name2 = cursor.getString(1);

                output.add( new Touple<String, String>(name1, name2 ) );

            }while(cursor.moveToNext());
        }
        cursor.close();
        return output;
    }

    public List<String[]> selectArtistJoinAlbum2(){

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT artists.name, albums.title FROM artists INNER JOIN albums ON artists._id = albums.artist_id", null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT title, CAST(artist_id AS varchar) AS artist_id FROM albums", null);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT name, CAST(_id AS varchar) AS artist FROM artists", null);

        List<String[]> output = new ArrayList<>(  );

        if (cursor.moveToFirst()){
            do {
                String name1   = cursor.getString(0);
                String name2 = cursor.getString(1);

                output.add( new String[] {name1, name2} );

            }while(cursor.moveToNext());
        }
        cursor.close();
        return output;
    }

}
