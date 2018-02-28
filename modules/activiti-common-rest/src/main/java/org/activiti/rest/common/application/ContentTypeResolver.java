package org.activiti.rest.common.application;

/**
 * Created by Nurgali.Yesmukhamedo on 28.02.2018.
 */
/**
 * Interface describing a class that is capable of resolving the content type of a resource/file based on the resource name.
 *
 */
public interface ContentTypeResolver {

    /**
     * @return the content type resolved from the given resource name. Returns null if the content type cannot be resolved.
     */
    String resolveContentType(String resourceName);

}
