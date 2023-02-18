package com.radhe.dao;

import com.radhe.model.Entity;
import com.radhe.model.Tag;
import lombok.NonNull;

import java.util.List;

public interface EntityDao {
    void startTracking(@NonNull Integer id, @NonNull List<Tag> hierarchicalTags);

    void startTracking(@NonNull Integer id);

    void stopTracking(@NonNull Integer id);

     List<Entity> getEntities();

}
