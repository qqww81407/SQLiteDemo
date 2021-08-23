package tw.com.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "stored.db";
    private final static int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一次執行時,會建立資料表                          主建         流水編號(系統自動加1)
        String sql = "create table product(_id integer primary key autoincrement, name varchar(30), price int, amount int)";
        db.execSQL(sql);   //執行上面語法

        //可以繼續寫下去...
        //String sql = "....";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table product";//刪除資料表
        db.execSQL(sql);

    }
}
