package dev.goumies.domain;

import dev.goumies.domain.scoring.ConsoleScoreBoard;
import dev.goumies.domain.scoring.ScoreBoardFormat;
import dev.goumies.domain.sequence.TennisGame;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ScoreBoardFormatTest {
    @Test
    public void with_a_game_and_no_game_score_should_return_empty_string() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        Assertions.assertThat(scoreBoard.format(scoreBoard.gameScore())).isEqualTo("");
    }

    @Test
    public void with_a_starting_game_should_return_game_score_title_players_IDs_players_scores() {
        TennisGame game = new TennisGame();
        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(game);
        game.start();
        Assertions.assertThat(ScoreBoardFormat.forThis(scoreBoard.gameScore())).isEqualTo("                                             GAME SCORE                                             \n" +
                "|                      |    Start the game    |\n" +
                "|----------------------|----------------------|\n" +
                "| Player 1             |          0           |\n" +
                "| Player 2             |          0           |\n" +
                "|----------------------|----------------------|\n" +
                "|                      |                      |\n"
        );
    }
}
