package com.androidlearn.aparat.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.androidlearn.aparat.models.Video;

@Database(entities = {Video.class}, version = 1 , exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {


    public abstract IDAO idao();

    private static AppDataBase instance = null;



    public static synchronized  AppDataBase getInstance(Context context){

        if(instance == null){

     instance =Room.databaseBuilder(context , AppDataBase.class , "videoDb").allowMainThreadQueries().build();

        }
        return instance;
    }
}
