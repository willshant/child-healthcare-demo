package com.example.will.app_for_child_demo.Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.will.app_for_child_demo.Converter.Converters;
import com.example.will.app_for_child_demo.Dao.ChildDao;
import com.example.will.app_for_child_demo.Entity.Child;

@Database(entities = {Child.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class MyRoomDB extends RoomDatabase {

    public abstract ChildDao childDao();

    private static volatile MyRoomDB INSTANCE;

    public static MyRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDB.class, "my_room_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}