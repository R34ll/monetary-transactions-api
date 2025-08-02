package finance.api.domain.services;

import finance.api.domain.valueobjects.EntityId;

public interface IdGenerator {
    EntityId generateId();
}
