package com.example.recepinanc.listviewapp;

/**
 * Created by Recepinanc on 28.08.2015.
 */
public class Game {

    public String gameTitle;

    //Will be a list of added people
    public String gameParticipants;

    //will be gathered as resource ID
    public int gameIcon;

    public Game(String gameName, int gameIconID) {
        this.gameTitle = gameName;
        this.gameIcon = gameIconID;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public int getGameIcon() {
        return gameIcon;
    }
}
