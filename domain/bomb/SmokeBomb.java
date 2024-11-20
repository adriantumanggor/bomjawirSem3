
// domain/bomb/SmokeBomb.java
package domain.bomb;

import domain.value.Distance;
import java.awt.Color;
import java.util.Objects;

public class SmokeBomb extends Bomb {
    private Distance radius;

    public SmokeBomb(String name, Color color, Distance radius) {
        super(name, color, BombType.SMOKE);
        setRadius(radius);
    }

    public Distance getRadius() {
        return radius;
    }

    public void setRadius(Distance radius) {
        this.radius = Objects.requireNonNull(radius, "Radius cannot be null");
    }

    @Override
    public String explode() {
        return String.format("%s created smoke covering %d meters!", getName(), radius.meters());
    }
}
