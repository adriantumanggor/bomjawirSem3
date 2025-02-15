package domain.bomb;

import java.util.Objects;
import java.util.UUID;

public abstract class Bomb {
    private final String id;
    private String name;
    private String location;
    private boolean active;
    private final BombType type;

    protected Bomb(String name, String location, BombType type) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setLocation(location);
        this.type = Objects.requireNonNull(type);
        this.active = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public boolean isActive() {
        return active;
    }

    public BombType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void setLocation(String location) {
        this.location = Objects.requireNonNull(location, "location cannot be null");
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public String getCurrentState() {
        // Example of what the current state could include:
        return String.format(
                "Bomb Name: %s " +
                        "Location: %s " +
                        "Type: %s " +
                        "Activated: %s",
                getName(), // Bomb name
                getLocation(), // Location of the bomb (inherited from Bomb class)
                getType(), // Bomb type (should be TIMED for this class)
                isActive() ? "Yes" : "No" // Check if the bomb is active or not
        );
    }

    public abstract String explode();
}
