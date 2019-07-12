package dev.goumies.domain;

import dev.goumies.domain.scoring.ConsoleScoreBoard;
import dev.goumies.domain.sequence.TennisGame;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ScoreBoardTest {
    @Test
    public void with_a_game_and_no_game_score_should_return_empty_string() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        Assertions.assertThat(scoreBoard.gameScore()).isEqualTo(new String[]{""});
    }

    @Test
    public void with_a_starting_game_should_return_game_score_title_players_IDs_players_scores() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        game.start();
        Assertions.assertThat(scoreBoard.gameScore()).isEqualTo(new String[]{"GAME SCORE", "Player1", "0", "Player2", "0"});
    }

    @Test
    public void with_player1_scoring_1_point_should_return_15_0_as_both_players_scores() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        game.start();
        game.player1scorePoint();
        Assertions.assertThat(scoreBoard.gameScore()).isEqualTo(new String[]{"15", "0"});
    }

    @Test
    public void with_player1_scoring_2_points_should_return_30_0_as_both_players_scores() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        game.start();
        game.player1scorePoint();
        game.player1scorePoint();
        Assertions.assertThat(scoreBoard.gameScore()).isEqualTo(new String[]{"30", "0"});
    }

    @Test
    public void with_player1_scoring_3_points_should_return_40_0_as_both_players_scores() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        game.start();
        game.player1scorePoint();
        game.player1scorePoint();
        game.player1scorePoint();
        Assertions.assertThat(scoreBoard.gameScore()).isEqualTo(new String[]{"40", "0"});
    }
}
