package edu.calvin.cs262.fdn2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlayerDao {
    @Insert
    void insertPlayer(Player player);

//    @Update
//    void updateELO(int playerID, double elo);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * from player_table ORDER BY playerID ASC")
    LiveData<List<Player>> getAllPlayers();
}
