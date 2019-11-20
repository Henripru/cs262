package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;

@Entity(tableName = "game_table")
public class Game {
    @PrimaryKey
    @ColumnInfo(name = "gameID")
    private int myId;

    @NonNull
    @ColumnInfo(name = "P1")
    private String myP1;

    @NonNull
    @ColumnInfo(name = "P2")
    private String myP2;

    @ColumnInfo(name = "P1Score")
    private int myP1Score;

    @ColumnInfo(name = "P2Score")
    private int myP2Score;

    //Turn into a SQL Time object later
    @NonNull
    @ColumnInfo(name = "Timestamp")
    private String myTimestamp;

    Game(int id, @NonNull String p1, @NonNull String p2, int p1Score, int p2Score, @NonNull String timestamp)
    {
        this.myId = id;
        this.myP1 = p1;
        this.myP2 = p2;
        this.myP1Score = p1Score;
        this.myP2Score = p2Score;
        this.myTimestamp = timestamp;
    }

    public int getMyID(){ return this.myId; }
    public String getP1Name(){return this.myP1;}
    public String getP2Name(){return this.myP2;}
}
