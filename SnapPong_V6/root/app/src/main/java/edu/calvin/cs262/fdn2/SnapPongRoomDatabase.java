package edu.calvin.cs262.fdn2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Player.class, Game.class}, version = 1, exportSchema = false)
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

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    public abstract PlayerDao playerDaoGetter();

    public abstract GameDao gameDaoGetter();

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PlayerDao myPlayerDao;

        PopulateDbAsync(SnapPongRoomDatabase db) {
            myPlayerDao = db.playerDaoGetter();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            myPlayerDao.deleteAll();

            myPlayerDao.insertPlayer(new Player(0, "Bernard",1500.0, "BHT"));
            myPlayerDao.insertPlayer(new Player(1, "Henri",1500.1, "KHvR"));
            myPlayerDao.insertPlayer(new Player(2, "Freddy",0.0, "Bolt"));
            myPlayerDao.insertPlayer(new Player(3, "Daniel",1500.0, "KE"));
            myPlayerDao.insertPlayer(new Player(4, "Nana",1500.0, "KHvR"));


            return null;
        }
    }
}
