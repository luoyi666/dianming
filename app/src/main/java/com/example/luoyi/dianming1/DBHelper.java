package com.example.luoyi.dianming1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by luoyi on 2016/10/26.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("创建表","行了");
        //创建数据表
        String CREATE_TABLE_STUDENT="create table student(sno TEXT,sname TEXT,sclass TEXT,sign1 INTEGER,sign2 INTEGER,test1 INTEGER,test2 INTEGER,test3 INTEGER,test4 INTEGER,test5 INTEGER,score INTEGER,grade INTEGER)";
        db.execSQL(CREATE_TABLE_STUDENT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
        db.execSQL("DROP TABLE IF EXISTS "+ "student");

        //再次创建表
        onCreate(db);
    }
}
