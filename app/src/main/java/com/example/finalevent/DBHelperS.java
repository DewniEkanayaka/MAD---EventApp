package com.example.finalevent;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperS extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Events.db";

    public DBHelperS(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + EventMaster.Events.TABLE_NAME + " (" +
                        EventMaster.Events.ID_S + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        EventMaster.Events.COL_1_S + " TEXT," +
                        EventMaster.Events.COL_2_S + " TEXT," +
                        EventMaster.Events.COL_3_S + " TEXT," +
                        EventMaster.Events.COL_4_S + " TEXT," +
                        EventMaster.Events.COL_5_S + " TEXT," +
                        EventMaster.Events.COL_6_S + " TEXT," +
                        EventMaster.Events.COL_7_S + " TEXT," +
                        EventMaster.Events.COL_8_S + " TEXT," +
                        EventMaster.Events.COL_9_S + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public boolean addInfo(String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8, String col9){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(EventMaster.Events.COL_1_S, col1);
        val.put(EventMaster.Events.COL_2_S, col2);
        val.put(EventMaster.Events.COL_3_S, col3);
        val.put(EventMaster.Events.COL_4_S, col4);
        val.put(EventMaster.Events.COL_5_S, col5);
        val.put(EventMaster.Events.COL_6_S, col6);
        val.put(EventMaster.Events.COL_7_S, col7);
        val.put(EventMaster.Events.COL_8_S, col8);
        val.put(EventMaster.Events.COL_9_S, col9);


        long nRD = db.insert(EventMaster.Events.TABLE_NAME,null,val);
        if(nRD == -1)
            return false;
        else
            return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EventMaster.Events.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
