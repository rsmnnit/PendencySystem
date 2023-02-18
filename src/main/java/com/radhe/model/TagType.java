package com.radhe.model;

public enum TagType {
    INSTRUMENT,
    STATE,
    CITY,
    // TODO(radhe) - We can actually introduce different tags for different entities and group tag types by different
    // entity types. e.g. PaymentType, RestaurantType, RentalType etc.
    RESTAURANT,
    CUISINE,
    TITLE
}
