package com.radhe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Entity {
    private Integer entityId;
    private List<Tag> hierarchicalTags;

    private TrackingStatus trackingStatus;

    public Entity(Integer entityId, List<Tag> hierarchicalTags) {
        this.entityId = entityId;
        this.hierarchicalTags = hierarchicalTags;
    }
}
