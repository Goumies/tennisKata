package dev.goumies.domain.scoring;

import java.util.Objects;

public class Points {
    private int value;

    private Points(int value) {
        this.value = value;
    }

    public static Points valueOf(int value) {
        return new Points(value);
    }

    public void increment() {
        value++;
    }

    public boolean areGreaterThan(Points otherPoints) {
        return value > otherPoints.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return value == points.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
