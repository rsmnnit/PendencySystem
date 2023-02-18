package com.radhe.service;

import com.radhe.dao.EntityDao;
import com.radhe.dao.EntityDaoImpl;
import com.radhe.model.Entity;
import com.radhe.model.Tag;
import com.radhe.model.TrackingStatus;
import lombok.NonNull;

import java.util.List;

public class EntityServiceImpl implements EntityService {
    private EntityDao entityDao;

    public EntityServiceImpl() {
        this.entityDao = new EntityDaoImpl();
    }

    @Override
    public void startTracking(@NonNull Integer entityId, @NonNull List<Tag> hierarchicalTags) {
        entityDao.startTracking(entityId, hierarchicalTags);
    }

    @Override
    public void startTracking(@NonNull Integer entityId) {
        entityDao.startTracking(entityId);
    }

    @Override
    public void stopTracking(@NonNull Integer entityId) {
        entityDao.stopTracking(entityId);
    }

    @Override
    public Long getCounts(@NonNull List<Tag> tags) {
        final List<Entity> entities = entityDao.getEntities();
        return entities.stream()
                .filter(entity -> TrackingStatus.ACTIVE.equals(entity.getTrackingStatus()))
                .filter(entity -> {
                    // Not enough tags
                    if (entity.getHierarchicalTags().size() < tags.size())
                        return false;
                    for (int i = 0; i < tags.size(); i++) {
                        // If tag didn't match, return false.
                        if (!tags.get(i).equals(entity.getHierarchicalTags().get(i))) {
                            return false;
                        }
                    }
                    return true;
                }).count();
    }
}
