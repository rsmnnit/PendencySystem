package com.radhe.service;

import com.radhe.model.Tag;
import lombok.NonNull;

import java.util.List;

public interface EntityService {
    /**
     * Method to start tracking a given entity.
     * @param entityId - Entity Id to track
     * @param hierarchicalTags - Ordered Hierarchical Tags associated with the entity.
     */
    void startTracking(@NonNull Integer entityId, @NonNull List<Tag> hierarchicalTags);

    /**
     * Method to start tracking an existing entity again.
     * @param entityId - Entity id to track
     */
    void startTracking(@NonNull Integer entityId);

    /**
     * Method to stop tracking a given entity
     * @param entityId - Entity id to stop tracking.
     */
    void stopTracking(@NonNull Integer entityId);

    /**
     * Method to get the tracked entity counts.
     * @param tags - Hierarchical tags associated with the entities.
     * @return Count of entities being tracked.
     */
    Long getCounts(@NonNull List<Tag> tags);
}
