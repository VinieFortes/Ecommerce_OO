package domain.entities;

import java.util.List;
import java.util.UUID;

public abstract class Entity {
    private UUID id;

    public Entity() {
        id = UUID.randomUUID();
    }

}
