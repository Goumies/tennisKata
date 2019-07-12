package dev.goumies.domain;

import dev.goumies.domain.scoring.ConsoleScoreBoard;
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
}
