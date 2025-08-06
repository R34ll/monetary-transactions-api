package finance.api.domain.valueobjects;
import java.util.Objects;


public final class EntityId implements Comparable<EntityId> {
    private final String value;

    public EntityId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Entity ID cannot be null or blank");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    };

    @Override
    public int compareTo(EntityId other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityId)) return false;
        EntityId entityId = (EntityId) o;
        return value.equals(entityId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}