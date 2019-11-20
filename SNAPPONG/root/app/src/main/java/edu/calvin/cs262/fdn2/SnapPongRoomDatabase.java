package edu.calvin.cs262.fdn2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Player.class/*, Game.class*/}, version = 1, exportSchema = false)
public abstract class SnapPongRoomDatabase extends RoomDatabase {
    private static SnapPongRoomDatabase INSTANCE;

    public static SnapPongRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SnapPongRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SnapPongRoomDatabase.class, "snappong_database")
                            //Destroys data when application dies .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract PlayerDao playerDaoGetter();
}
