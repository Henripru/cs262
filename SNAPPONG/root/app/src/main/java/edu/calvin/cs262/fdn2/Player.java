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

    Player(int id, @NonNull String name, double elo, @NonNull String location)
    {
        this.myId = id;
        this.myName = name;
        this.myELO = elo;
        this.myLocation = location;
    }

    public int getMyId(){return this.myId;}
    public String getName(){return this.myName;}
    public double getELO(){return this.myELO;}
    public String getLocation(){return this.myLocation;}
}
