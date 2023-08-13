package com.ale.minichat.entity;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum Role {
    @FieldNameConstants.Include ADMIN,
    @FieldNameConstants.Include CUSTOMER
}
