package navod.dev.android.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHealper extends SQLiteOpenHelper {

//    this class helps to manage version, creation and maintanance

    private static String DB_Name = "homework.db";
    private static String tableName = "cato";
    public DatabaseHealper(@Nullable Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        on create table implimantation current version of database
        db.execSQL("create table "+ tableName +"(cato TEXT, amount INT)");
        insertCato(db,"cato 1",0);
        insertCato(db,"cato 2",0);
        insertCato(db,"cato 3",0);
        insertCato(db,"cato 4",0);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int olderVersion, int currentVersion) {

    }

    public boolean insertCato(SQLiteDatabase db,String cato, int amount){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cato",cato);
        contentValues.put("amount",amount);

        long response = db.insert(tableName,null,contentValues);
        if(response == 1){
            return false;
        }
        return true;
    }

    public Cursor getAllStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from cato",null);
        return cursor;
    }

    public Cursor selectStudent(String cato){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from cato where cato ='"+cato+"'",null);
        return cursor;
    }

    public boolean updateCato(String cato, int amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cato",cato);
        contentValues.put("amount",amount);
        long respons = db.update(tableName,contentValues,"cato=?",new String[]{cato});
        if(respons == 1)
        {
            return false;
        }
        return true;
    }

    public void deleteCato(String cato){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName,"name=?",new String[]{cato});
    }

}
