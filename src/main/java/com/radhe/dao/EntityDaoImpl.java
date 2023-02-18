package com.radhe.dao;

import com.radhe.model.Entity;
import com.radhe.model.Tag;
import com.radhe.model.TrackingStatus;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityDaoImpl implements EntityDao {

    private HashMap<Integer, Entity> entityIdToEntities;
    private static final Logger logger = LoggerFactory.getLogger(EntityDaoImpl.class);

    public EntityDaoImpl() {
        this.entityIdToEntities = new HashMap<>();
    }

    @Override
    public void startTracking(@NonNull Integer entityId, @NonNull List<Tag> hierarchicalTags) {
        Entity entity = new Entity(entityId, hierarchicalTags);
        if (entityIdToEntities.containsKey(entityId)) {
            logger.info("Entity with id=" + entityId + " already exists");
            entity = entityIdToEntities.get(entityId);
        }
        entity.setTrackingStatus(TrackingStatus.ACTIVE);
        entityIdToEntities.put(entityId, entity);
    }

    @Override
    public void startTracking(@NonNull Integer entityId) {
        if (!entityIdToEntities.containsKey(entityId)) {
            logger.info("Unable to restart tracking. Entity with id=" + entityId + " not found");
            return;
        }
        Entity entity = entityIdToEntities.get(entityId);
        entity.setTrackingStatus(TrackingStatus.ACTIVE);
        entityIdToEntities.put(entityId, entity);
    }

    @Override
    public void stopTracking(@NonNull Integer entityId) {
        if (!entityIdToEntities.containsKey(entityId)) {
            logger.info("Unable to Stop Tracking. Entity with id=" + entityId + " not found.");
            return;
        }
        Entity entity = entityIdToEntities.get(entityId);
        entity.setTrackingStatus(TrackingStatus.INACTIVE);
        entityIdToEntities.put(entityId, entity);
    }

    @Override
    public List<Entity> getEntities() {
        return new ArrayList<>(entityIdToEntities.values());
    }
}
