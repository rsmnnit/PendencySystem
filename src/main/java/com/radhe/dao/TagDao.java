package com.radhe.dao;

import com.radhe.model.Tag;
import com.radhe.model.TagType;
import lombok.NonNull;

public interface TagDao {
    Tag createTag(@NonNull String name, @NonNull TagType type);

    Tag getTagById(@NonNull Integer tagId);
}
