package dev.goumies.domain.scoring;

import org.apache.commons.lang3.StringUtils;

public interface ScoreBoardFormat {

    String SEPARATOR = "----------------------";
    String TABLE_HORIZONTAL_SEPARATOR_INIT = String.format("|%-20s|", SEPARATOR);
    String TABLE_HORIZONTAL_SEPARATOR_CONTINUE = String.format("%-20s|", SEPARATOR);

    static String forThis(String[] gameScoreValues) {
        String TABLE_TITLE = String.format("%s", StringUtils.center(gameScoreValues[0], 100));
        String TABLE_HEADER = String.format("%n| %-20s | %s |%n", "", StringUtils.center(gameScoreValues[1], 20));
        String TABLE_PLAYER1_LINE = String.format("%n| %-20s | %s |", gameScoreValues[2], StringUtils.center(gameScoreValues[3], 20));
        String TABLE_PLAYER2_LINE = String.format("%n| %-20s | %s |%n", gameScoreValues[4], StringUtils.center(gameScoreValues[5], 20));
        String TABLE_FOOTER = String.format("%n| %-20s |", "");
        String TABLE_FOOTER_CONTINUE = String.format(" %-20s |%n", "");

        return new StringBuilder(TABLE_TITLE)
                .append(TABLE_HEADER)
                .append(TABLE_HORIZONTAL_SEPARATOR_INIT)
                .append(TABLE_HORIZONTAL_SEPARATOR_CONTINUE)
                .append(TABLE_PLAYER1_LINE)
                .append(TABLE_PLAYER2_LINE)
                .append(TABLE_HORIZONTAL_SEPARATOR_INIT)
                .append(TABLE_HORIZONTAL_SEPARATOR_CONTINUE)
                .append(TABLE_FOOTER)
                .append(TABLE_FOOTER_CONTINUE)
                .toString();
    }

    String format(String[] gameScoreValues);
}
