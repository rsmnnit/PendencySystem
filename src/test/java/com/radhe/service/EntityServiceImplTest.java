package com.radhe.service;

import com.radhe.model.Tag;
import com.radhe.model.TagType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EntityServiceImplTest {
    private EntityService entityService;
    private TagService tagService;
    private Tag upiTag;
    private Tag karnatakaTag;
    private Tag bangaloreTag;
    private Tag mysoreTag;
    private Tag rajasthanTag;
    private Tag jaipurTag;
    private Tag walletTag;

    @BeforeEach
    void setUp() {
        entityService = new EntityServiceImpl();
        tagService = new TagServiceImpl();
        upiTag = tagService.createTag("UPI", TagType.INSTRUMENT);
        karnatakaTag = tagService.createTag("Karnataka", TagType.STATE);
        bangaloreTag = tagService.createTag("Bangalore", TagType.CITY);
        mysoreTag = tagService.createTag("Mysore", TagType.CITY);
        rajasthanTag = tagService.createTag("Rajasthan", TagType.STATE);
        jaipurTag = tagService.createTag("Jaipur", TagType.CITY);
        walletTag = tagService.createTag("Wallet", TagType.INSTRUMENT);
    }

    private void startTrackingEntities() {
        entityService.startTracking(1112, Arrays.asList(upiTag, karnatakaTag, bangaloreTag));
        entityService.startTracking(2451, Arrays.asList(upiTag, karnatakaTag, mysoreTag));
        entityService.startTracking(3421, Arrays.asList(upiTag, rajasthanTag, jaipurTag));
        entityService.startTracking(1221, Arrays.asList(walletTag, karnatakaTag, bangaloreTag));
    }


    @Test
    void testStartTracking() {
        startTrackingEntities();
        Assertions.assertEquals(entityService.getCounts(Arrays.asList(upiTag)), 3L);
        Assertions.assertEquals(entityService.getCounts(Arrays.asList(upiTag, karnatakaTag)), 2L);
    }

    @Test
    void testStopTracking() {
        startTrackingEntities();
        entityService.stopTracking(1112);
        Assertions.assertEquals(entityService.getCounts(Arrays.asList(upiTag)), 2L);
    }

    @Test
    void testStartExistingEntitiesTracking() {
        startTrackingEntities();
        entityService.stopTracking(1112);
        Assertions.assertEquals(entityService.getCounts(Arrays.asList(upiTag)), 2L);
        entityService.startTracking(1112);
        Assertions.assertEquals(entityService.getCounts(Arrays.asList(upiTag)), 3L);
    }
}