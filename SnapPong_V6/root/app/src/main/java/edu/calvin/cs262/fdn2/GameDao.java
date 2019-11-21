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

    @Query("DELETE FROM game_table")
    void deleteAllGames();

    @Query("SELECT * from game_table")
    LiveData<List<Game>> getAllGames();
}
