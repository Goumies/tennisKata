package dev.goumies.domain.scoring;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameScore {
    private final List<Call> playersGameScores;

    private GameScore(List<Points> playersPoints) {
        playersGameScores = GameScore.Call.from(playersPoints);
    }

    public static GameScore valueOf(List<Points> playersPoints) {
        return new GameScore(playersPoints);
    }

    public String player1() {
        Call player1GameScore = playersGameScores.get(0);
        return player1GameScore.call;
    }

    public String player2() {
        Call player1GameScore = playersGameScores.get(1);
        return player1GameScore.call;
    }

    private enum Call {
        LOVE(Points.valueOf(0), "0"),
        FIFTEEN(Points.valueOf(1), "15"),
        THIRTY(Points.valueOf(2), "30"),
        FORTY(Points.valueOf(3), "40"),
        WIN(Points.valueOf(4), "0");

        private final Points pointsWon;
        private final String call;

        Call(Points pointsWon, String call) {

            this.pointsWon = pointsWon;
            this.call = call;
        }

        public static List<Call> from(List<Points> playersPoints) {
            List<Call> calls = playersPoints.stream()
                    .map(Call::valueOf)
                    .collect(Collectors.toList());
            return calls;
        }

        private static Call valueOf(Points points) {
            Call call = Arrays.stream(Call.values())
                    .filter(currentCall -> currentCall.pointsWon.equals(points))
                    .findFirst().get();
            return call;
        }
    }
}
