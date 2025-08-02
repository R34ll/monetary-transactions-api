package finance.api.domain.services;

import finance.api.domain.valueobjects.EntityId;

public class UuidGenerator implements IdGenerator {

    @Override
    public EntityId generateId() {
        // Generate a random UUID and return it as an EntityId
        return new EntityId(java.util.UUID.randomUUID().toString());
    }

    
}
