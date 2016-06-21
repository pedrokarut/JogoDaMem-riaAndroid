package pedro.ifsp.br.trabalhobimestral;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "SQLiteExample.db";
    private static final int DATABASE_VERSION = 1;
    public static final String PLAYER_TABLE_NAME = "jogador";
    public static final String PERSON_COLUMN_ID = "_id";
    public static final String PERSON_COLUMN_NAME = "nome";
    public static final String PERSON_COLUMN_COUNTRY = "pais";
    public static final String PERSON_COLUMN_AGE = "age";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PLAYER_TABLE_NAME + "(" +
                PERSON_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                PERSON_COLUMN_NAME + " TEXT, " +
                PERSON_COLUMN_COUNTRY + " TEXT, " +
                PERSON_COLUMN_AGE + " INTEGER)"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PLAYER_TABLE_NAME);
        onCreate(db);
    }


    public boolean insertPlayer(String name, String country, int age) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_COLUMN_NAME, name);
        contentValues.put(PERSON_COLUMN_COUNTRY, country);
        contentValues.put(PERSON_COLUMN_AGE, age);
        db.insert(PLAYER_TABLE_NAME, null, contentValues);
        return true;
    }


    public boolean updatePerson(Integer id, String name, String country, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_COLUMN_NAME, name);
        contentValues.put(PERSON_COLUMN_COUNTRY, country);
        contentValues.put(PERSON_COLUMN_AGE, age);
        db.update(PLAYER_TABLE_NAME, contentValues, PERSON_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }


    public Integer deletePlayer(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(PLAYER_TABLE_NAME,
                PERSON_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }


    public Cursor getPlayer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + PLAYER_TABLE_NAME + " WHERE " +
                PERSON_COLUMN_ID + "=?", new String[] { Integer.toString(id) } );
        return res;
    }


    public Cursor getAllPlayers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + PLAYER_TABLE_NAME, null );
        return res;
    }




}
