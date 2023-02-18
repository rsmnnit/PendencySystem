package com.radhe.dao;

import com.radhe.model.Tag;
import com.radhe.model.TagType;
import com.radhe.service.TagService;
import com.radhe.service.TagServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EntityDaoImplTest {
    private EntityDao entityDao;
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
        entityDao = new EntityDaoImpl();
        tagService = new TagServiceImpl();
        upiTag = tagService.createTag("UPI", TagType.INSTRUMENT);
        karnatakaTag = tagService.createTag("Karnataka", TagType.STATE);
        bangaloreTag = tagService.createTag("Bangalore", TagType.CITY);
        mysoreTag = tagService.createTag("Mysore", TagType.CITY);
        rajasthanTag = tagService.createTag("Rajasthan", TagType.STATE);
        jaipurTag = tagService.createTag("Jaipur", TagType.CITY);
        walletTag = tagService.createTag("Wallet", TagType.INSTRUMENT);
    }

    @Test
    void getEntities() {
        entityDao.startTracking(1112, Arrays.asList(upiTag, karnatakaTag, bangaloreTag));
        entityDao.startTracking(2451, Arrays.asList(upiTag, karnatakaTag, mysoreTag));
        entityDao.startTracking(3421, Arrays.asList(upiTag, rajasthanTag, jaipurTag));
        entityDao.startTracking(1221, Arrays.asList(walletTag, karnatakaTag, bangaloreTag));
        Assertions.assertEquals(entityDao.getEntities().size(), 4L);

    }
}