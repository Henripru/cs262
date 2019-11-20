package edu.calvin.cs262.fdn2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDao {
    @Insert
    void insertGame(Game game);

//    @Update
//    void updateELO(int playerID, double elo);

    @Query("DELETE FROM player_table")
    void deleteAllGames();

    @Query("SELECT * from player_table ORDER BY playerID ASC")
    LiveData<List<Game>> getAllGames();
}
