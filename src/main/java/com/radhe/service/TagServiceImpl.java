package com.radhe.service;

import com.radhe.dao.TagDao;
import com.radhe.dao.TagDaoImpl;
import com.radhe.model.Tag;
import com.radhe.model.TagType;
import lombok.NonNull;

public class TagServiceImpl implements TagService {
    private TagDao tagDao;

    public TagServiceImpl() {
        this.tagDao = new TagDaoImpl();
    }

    @Override
    public Tag createTag(@NonNull String name, @NonNull TagType type) {
        return tagDao.createTag(name, type);
    }

    @Override
    public Tag getTagById(@NonNull Integer tagId) {
        return tagDao.getTagById(tagId);
    }
}
