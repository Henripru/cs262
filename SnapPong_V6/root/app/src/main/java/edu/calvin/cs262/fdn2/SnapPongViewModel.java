package edu.calvin.cs262.fdn2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SnapPongViewModel extends AndroidViewModel {

    private SnapPongDatabaseAPI mRepository;

    private LiveData<List<Player>> myAllPlayers;
    private LiveData<List<Game>> myAllGames;

    public SnapPongViewModel(Application application) {
        super(application);
        mRepository = new SnapPongDatabaseAPI(application);
        myAllGames = mRepository.getAllGames();
        myAllPlayers = mRepository.getAllPlayers();
    }

    LiveData<List<Player>> getAllPlayers() { return myAllPlayers; }
    LiveData<List<Game>> getAllGames() {return myAllGames;}

    public void insertGame(Game game) {mRepository.insertGame(game);}
    public void insertPlayer(Player player) { mRepository.insertPlayer(player); }
}
