package edu.calvin.cs262.fdn2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SnapPongDatabaseAPI {
    private PlayerDao myPlayerDao;
    private GameDao myGameDao;
    private LiveData<List<Player>> myPlayerList;

    SnapPongDatabaseAPI(Application application)
    {
        SnapPongRoomDatabase db = SnapPongRoomDatabase.getDatabase(application);
        myPlayerDao = db.playerDaoGetter();
        myPlayerList = myPlayerDao.getAllPlayers();
    }

    LiveData<List<Player>> getAllWords() {
        return myPlayerList;
    }

    public void insertGame (Game game) {
        new insertGameAsyncTask(myGameDao).execute(game);
    }

    private static class insertGameAsyncTask extends AsyncTask<Game, Void, Void> {
        private PlayerDao myAsyncTaskDao;

        insertGameAsyncTask(GameDao dao) {
            myAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Game... params)
        {
            myAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void insertPlayer (Player player) {
        new insertPlayerAsyncTask(myPlayerDao).execute(player);
    }

    private static class insertPlayerAsyncTask extends AsyncTask<Player, Void, Void> {
        private PlayerDao myAsyncTaskDao;

        insertPlayerAsyncTask(PlayerDao dao) {
            myAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Player... params)
        {
            myAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
