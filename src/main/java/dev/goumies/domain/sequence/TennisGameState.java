package dev.goumies.domain.sequence;

public enum TennisGameState {
    SETTING_UP(""), STARTED("Start the game"), WON(""), ON_GOING("");

    public String action;

    TennisGameState(String action) {
        this.action = action;
    }
}
