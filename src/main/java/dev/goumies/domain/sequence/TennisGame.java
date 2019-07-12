package dev.goumies.domain.sequence;

import dev.goumies.domain.scoring.GameScore;
import dev.goumies.domain.scoring.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TennisGame {

    private ArrayList<TennisGameState> state;
    private Points player1Points;
    private GameScore gameScore;
    private Points player2Points;

    public TennisGame() {
        this.state = new ArrayList<>(Collections.singletonList(TennisGameState.SETTING_UP));
        this.player1Points = Points.valueOf(0);
        this.player2Points = Points.valueOf(0);
    }

    public void start() {
        state.replaceAll(tennisGameState -> TennisGameState.STARTED);
    }

    public TennisGameState currentState() {
        return state.get(0);
    }

    public void player1scorePoint() {
        player1Points.increment();
        saveGameScore();
    }

    private void saveGameScore() {
        gameScore = GameScore.valueOf(Arrays.asList(player1Points, player2Points));
        state.replaceAll(tennisGameState -> TennisGameState.ON_GOING);

        if(gameScore.contains(GameScore.Call.WIN))
            state.replaceAll(tennisGameState -> TennisGameState.WON);
    }

    public String player1GameScore() {
        return gameScore.player1();
    }

    public String player2GameScore() {
        return gameScore.player2();
    }
}
