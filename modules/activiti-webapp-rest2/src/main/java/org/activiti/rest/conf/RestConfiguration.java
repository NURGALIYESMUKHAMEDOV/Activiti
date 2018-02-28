package org.activiti.rest.conf;

import org.activiti.rest.common.application.ContentTypeResolver;
import org.activiti.rest.common.application.DefaultContentTypeResolver;
import org.activiti.rest.service.api.RestResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Astana on 25.02.2018.
 */
@Configuration
public class RestConfiguration {

    @Bean()
    public RestResponseFactory restResponseFactory(){
        RestResponseFactory restResponseFactory = new RestResponseFactory();
        return restResponseFactory;
    }

    @Bean()
    public ContentTypeResolver contentTypeResolver(){
        ContentTypeResolver resolver = new DefaultContentTypeResolver();
        return resolver;
    }

}
