package org.activiti.rest.service.api;

/**
 * Created by Nurgali.Yesmukhamedo on 28.02.2018.
 */
public final class RestUrls {

    public static final String SEGMENT_IDENTITY_RESOURCES = "identity";

    public static final String SEGMENT_USERS = "users";
    public static final String SEGMENT_PICTURE = "picture";
    public static final String SEGMENT_INFO = "info";

    public static final String[] URL_USER_COLLECTION = {SEGMENT_IDENTITY_RESOURCES, SEGMENT_USERS};
    public static final String[] URL_USER = {SEGMENT_IDENTITY_RESOURCES, SEGMENT_USERS, "{0}"};
    public static final String[] URL_USER_PICTURE = {SEGMENT_IDENTITY_RESOURCES, SEGMENT_USERS, "{0}", SEGMENT_PICTURE};
    public static final String[] URL_USER_INFO = {SEGMENT_IDENTITY_RESOURCES, SEGMENT_USERS, "{0}", SEGMENT_INFO, "{1}"};
    public static final String[] URL_USER_INFO_COLLECTION = {SEGMENT_IDENTITY_RESOURCES, SEGMENT_USERS, "{0}", SEGMENT_INFO};

}
