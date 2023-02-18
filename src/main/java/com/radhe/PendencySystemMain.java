package com.radhe;

import com.radhe.model.Tag;
import com.radhe.model.TagType;
import com.radhe.service.EntityService;
import com.radhe.service.EntityServiceImpl;
import com.radhe.service.TagService;
import com.radhe.service.TagServiceImpl;

import java.util.Arrays;

public class PendencySystemMain {
    public static void main(String[] args) {
        EntityService entityService = new EntityServiceImpl();
        TagService tagService = new TagServiceImpl();
        Tag upiTag = tagService.createTag("UPI", TagType.INSTRUMENT);
        Tag karnatakaTag = tagService.createTag("Karnataka", TagType.STATE);
        Tag bangaloreTag = tagService.createTag("Bangalore", TagType.CITY);
        Tag mysoreTag = tagService.createTag("Mysore", TagType.CITY);
        Tag rajasthanTag = tagService.createTag("Rajasthan", TagType.STATE);
        Tag jaipurTag = tagService.createTag("Jaipur", TagType.CITY);
        Tag walletTag = tagService.createTag("Wallet", TagType.INSTRUMENT);
        entityService.startTracking(1112, Arrays.asList(upiTag, karnatakaTag, bangaloreTag));
        entityService.startTracking(2451, Arrays.asList(upiTag, karnatakaTag, mysoreTag));
        entityService.startTracking(3421, Arrays.asList(upiTag, rajasthanTag, jaipurTag));
        entityService.startTracking(1221, Arrays.asList(walletTag, karnatakaTag, bangaloreTag));

        Long counts = entityService.getCounts(Arrays.asList(upiTag));
        System.out.println("Number of entities being tracked: " + counts);
        counts = entityService.getCounts(Arrays.asList(upiTag, karnatakaTag));
        System.out.println("Number of entities being tracked: " + counts);
        counts = entityService.getCounts(Arrays.asList(upiTag, karnatakaTag, bangaloreTag));
        System.out.println("Number of entities being tracked: " + counts);
        counts = entityService.getCounts(Arrays.asList(bangaloreTag));
        System.out.println("Number of entities being tracked: " + counts);
        entityService.startTracking(4221, Arrays.asList(walletTag, karnatakaTag, bangaloreTag));
        entityService.stopTracking(1112);
        entityService.stopTracking(2451);
        counts = entityService.getCounts(Arrays.asList(upiTag));
        System.out.println("Number of entities being tracked: " + counts);
        counts = entityService.getCounts(Arrays.asList(walletTag));
        System.out.println("Number of entities being tracked: " + counts);
        counts = entityService.getCounts(Arrays.asList(upiTag, karnatakaTag, bangaloreTag));
        System.out.println("Number of entities being tracked: " + counts);

        // Re-track some of stopped entities.
        entityService.startTracking(1112);
        counts = entityService.getCounts(Arrays.asList(upiTag));
        System.out.println("Number of entities being tracked: " + counts);

        // Track a restaurant order.
        Tag restaurantTag = tagService.createTag("Udupi", TagType.RESTAURANT);
        Tag cuisineTag = tagService.createTag("Chinese", TagType.CUISINE);
        Tag titleTag = tagService.createTag("Noodles", TagType.TITLE);
        entityService.startTracking(21245, Arrays.asList(bangaloreTag, restaurantTag, cuisineTag, titleTag));
        counts = entityService.getCounts(Arrays.asList(bangaloreTag, restaurantTag));
        System.out.println("Number of entities being tracked: " + counts);
    }
}