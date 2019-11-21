package edu.calvin.cs262.fdn2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SnapPongDatabaseAPI {
    private PlayerDao myPlayerDao;
    private GameDao myGameDao;
    private LiveData<List<Player>> myPlayerList;
    private LiveData<List<Game>> myGameList;

    SnapPongDatabaseAPI(Application application)
    {
        SnapPongRoomDatabase db = SnapPongRoomDatabase.getDatabase(application);
        myPlayerDao = db.playerDaoGetter();
        myPlayerList = myPlayerDao.getAllPlayers();

        myGameDao = db.gameDaoGetter();
        myGameList = myGameDao.getAllGames();
    }

    LiveData<List<Player>> getAllPlayers() {
        return myPlayerList;
    }

    LiveData<List<Game>> getAllGames() {
        return myGameList;
    }

    public void insertGame (Game game) {
        new insertGameAsyncTask(myGameDao).execute(game);
    }

    private static class insertGameAsyncTask extends AsyncTask<Game, Void, Void> {
        private GameDao myAsyncTaskDao;

        insertGameAsyncTask(GameDao dao) {
            myAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Game... params)
        {
            myAsyncTaskDao.insertGame(params[0]);
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
            myAsyncTaskDao.insertPlayer(params[0]);
            return null;
        }
    }
}
