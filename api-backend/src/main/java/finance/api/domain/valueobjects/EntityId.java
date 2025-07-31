package finance.api.domain.valueobjects;

import java.util.UUID;

public final class EntityId{
    private final UUID value;

    public EntityId(UUID value) {
        if (value == null) {
            throw new IllegalArgumentException("Entity ID cannot be null");
        }
        this.value = value;
    }

    // public UUID generate() {
    //     return UUID.randomUUID();
    // }

    public UUID getValue() {
        return value;
    };
}