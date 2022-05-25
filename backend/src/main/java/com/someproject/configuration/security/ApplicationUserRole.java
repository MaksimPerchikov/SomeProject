package com.someproject.configuration.security;

import java.util.Set;

import static com.someproject.configuration.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    ADMIN(Set.of(ADD_PRODUCT,FIND_PRODUCT_BY_ID, FIND_ALL_PRODUCTS,DELETE_PRODUCT_BY_ID,GREETING)),
    COOK(Set.of(ADD_PRODUCT,GREETING,FIND_ALL_PRODUCTS,FIND_PRODUCT_BY_ID)),
    CUSTOMER(Set.of(GREETING));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
