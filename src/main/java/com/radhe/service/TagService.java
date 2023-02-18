package com.radhe.service;

import com.radhe.model.Tag;
import com.radhe.model.TagType;
import lombok.NonNull;

public interface TagService {
    Tag createTag(@NonNull String name, @NonNull TagType type);

    Tag getTagById(@NonNull Integer tagId);
}
