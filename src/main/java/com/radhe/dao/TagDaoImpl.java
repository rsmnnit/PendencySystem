package com.radhe.dao;

import com.radhe.model.Tag;
import com.radhe.model.TagType;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TagDaoImpl implements TagDao {
    private HashMap<Integer, Tag> tagsMap;
    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static final Logger logger = LoggerFactory.getLogger(TagDaoImpl.class);

    public TagDaoImpl() {
        tagsMap = new HashMap<>();
    }

    @Override
    public Tag createTag(@NonNull String name, @NonNull TagType type) {
        Integer tagId = generateTagId();
        Tag tag = new Tag(tagId, name, type);
        tagsMap.put(tagId, tag);
        return tag;
    }

    @Override
    public Tag getTagById(@NonNull Integer tagId) {
        return tagsMap.get(tagId);
    }


    private static Integer generateTagId() {
        return atomicInteger.getAndIncrement();
    }
}
