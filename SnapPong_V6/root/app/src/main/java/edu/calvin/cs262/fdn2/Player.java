package edu.calvin.cs262.fdn2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "player_table")
public class Player {

    @PrimaryKey
    @ColumnInfo(name = "playerID")
    private int myId;

    @NonNull
    @ColumnInfo(name = "name")
    private String myName = "";

    @ColumnInfo(name = "ELO")
    private double myELO = 0;

    @NonNull
    @ColumnInfo(name = "location")
    private String myLocation;

    Player(int myId, @NonNull String myName, double myELO, @NonNull String myLocation)
    {
        this.myId = myId;
        this.myName = myName;
        this.myELO = myELO;
        this.myLocation = myLocation;
    }

    public int getMyId(){return this.myId;}
    public String getMyName(){return this.myName;}
    public double getMyELO(){return this.myELO;}
    public String getMyLocation(){return this.myLocation;}
}
