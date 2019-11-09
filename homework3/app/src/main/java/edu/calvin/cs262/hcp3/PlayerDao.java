package edu.calvin.cs262.hcp3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlayerDao {

    @Insert
    void insertPlayer(Player... players);

    @Query("SELECT * FROM player_table")
    LiveData<List<Player>> getAllPlayers();

    @Query("DELETE FROM player_table")
    void deleteAllPlayers();
}