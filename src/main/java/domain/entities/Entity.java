package domain.entities;

import java.util.List;
import java.util.UUID;

public abstract class Entity {
    protected String id;

    public Entity() {
        id = UUID.randomUUID().toString();
    }

}
