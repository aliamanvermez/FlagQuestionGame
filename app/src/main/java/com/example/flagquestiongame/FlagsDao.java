package com.example.flagquestiongame;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FlagsDao {

     public ArrayList<Flags>random5(Database database){
         ArrayList<Flags> flagsArrayList = new ArrayList<>();
         SQLiteDatabase db = database.getWritableDatabase();
         Cursor c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM () LIMIT 5 ",null);

         while (c.moveToNext()) {
             Flags f = new Flags(c.getInt(c.getColumnIndexOrThrow("bayrak_id"))
                     ,c.getString(c.getColumnIndexOrThrow("bayrak_ad"))
                     ,c.getString(c.getColumnIndexOrThrow("bayrak_resim")));

             flagsArrayList.add(f);

         }
         return flagsArrayList;
     }

    public ArrayList<Flags>random3(Database database ,  int bayrak_id){
        ArrayList<Flags> flagsArrayList = new ArrayList<>();
        SQLiteDatabase db = database.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id !="+bayrak_id+" ORDER BY RANDOM () LIMIT 3 ",null);

        while (c.moveToNext()) {
            Flags f = new Flags(c.getInt(c.getColumnIndexOrThrow("bayrak_id"))
                    ,c.getString(c.getColumnIndexOrThrow("bayrak_ad"))
                    ,c.getString(c.getColumnIndexOrThrow("bayrak_resim")));

            flagsArrayList.add(f);

        }
        return flagsArrayList;
    }


}
