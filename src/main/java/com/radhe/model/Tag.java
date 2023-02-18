package com.radhe.model;

public class Tag {
    private final Integer tagId;
    private final String name;
    private final TagType type;

    public Tag(Integer tagId, String name, TagType type) {
        this.tagId = tagId;
        this.name = name;
        this.type = type;
    }
}
