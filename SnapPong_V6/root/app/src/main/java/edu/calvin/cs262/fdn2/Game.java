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

    Game(int myId, @NonNull String myP1, @NonNull String myP2, int myP1Score, int myP2Score, @NonNull String myTimestamp)
    {
        this.myId = myId;
        this.myP1 = myP1;
        this.myP2 = myP2;
        this.myP1Score = myP1Score;
        this.myP2Score = myP2Score;
        this.myTimestamp = myTimestamp;
    }

    public int getMyId(){ return this.myId; }
    public String getMyP1(){return this.myP1;}
    public String getMyP2(){return this.myP2;}
    public int getMyP1Score() {return this.myP1Score;}
    public int getMyP2Score() {return this.myP2Score;}
    public String getMyTimestamp() {return this.myTimestamp;}
}
