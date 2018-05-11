package br.unicamp.ft.a166348.aplicacaoartista.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MUSIC_DB";
    private static final int DB_VERSION = 1;//importante ser um atributo!
    /*No futuro, se mudar esse número ele vai perceber que houve
    uma mudança na versão do banco de dados*/

    //Construtor - Se precisar de mais de um banco DÊ MAIS DE UM NOME!
    DatabaseHelper(Context context) {
        super( context, DB_NAME, null, DB_VERSION );//Faz a criação do banco de dados
        //Context, Nome do banco de dados, é nulo porque é nulo, a versão do banco
        //Garantir que difentes bancos tem diferentes nomes

    }

    /*
    Executado quando criar um objeto da classe SQLiteOpenHelper e o método
    não tiver sido executado antes
	Faz as configurações iniciais do banco
	Só é executado quando o banco NÃO EXISTE

    */
    @Override
    public void onCreate(SQLiteDatabase db) {//Deve ser sobrescrito do pai (não confunda com o onCreate da main ou do frame)
        /*db.execSQL("CREATE TABLE tabela " +
                "(_id INTEGER PRIMARY KEY);");*/

        /*
        EXECUTADO QUANDO A PRIMERIA QUERY SQL FOR CHAMADA
        */

        db.execSQL( "CREATE TABLE tabela " +
                "(_id INTEGER PRIMARY KEY, " +
                "Texto Text);" );

        //| ArtistId | Name
        //| AlbumId | Title | ArtistId |

        db.execSQL("CREATE TABLE artists (_id INTEGER PRIMARY KEY AUTOINCREMENT, name CHAR(50) NOT NULL);");
        db.execSQL("CREATE TABLE albums (_id INTEGER PRIMARY KEY AUTOINCREMENT, title CHAR(50) NOT NULL, artist_id INTEGER NOT NULL);");

        String[] initialArtists = {
                "AC/DC",
                "Accept",
                "Aerosmith",
                "Alanis Morissette",
                "Alice In Chains",
                "Antônio Carlos Jobim",
                "Apocalyptica",
                "Audioslave",
                "BackBeat",
                "Billy Cobham"};


        for(String artistname : initialArtists){
            db.execSQL( "INSERT INTO artists (name) VALUES ('"+artistname+"');" );
        }

        /*

        _id -> use dessa forma, é  um padrão para dizer que é o id, se não
        fizer vou ter que usar o AS _id no SELECT

        Erro: não achei _id : na string sql preciso converter o nome do id para _id

        */


    }

    @Override
    //Executado quando a versão do banco que tenho é menor que a atual
    //A pessoa tem um banco de dados desatualizado
    //Se o número crescer atualize o banco
    //Se precisar desatualizar o banco - onDowngrade
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Se a pessoa está na versão tal e quer ir para a versão tal: execute tais linhas de código




    }
}
