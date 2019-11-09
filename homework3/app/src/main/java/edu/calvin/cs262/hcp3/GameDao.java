package edu.calvin.cs262.hcp3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameDao {

    @Insert
    void insertGame(Game... games);

    @Query("SELECT * FROM Game")
    LiveData<List<Game>> getAllGames();
}