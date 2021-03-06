package org.activiti.rest.conf;

import org.springframework.context.annotation.*;

/**
 * Created by Nurgali.Yesmukhamedo on 13.02.2018.
 */
@Configuration
@PropertySources({@PropertySource(value = "classpath:db.properties", ignoreResourceNotFound = true), @PropertySource(value = "classpath:engine.properties", ignoreResourceNotFound = true)})
@ComponentScan(basePackages = {"org.activiti.rest.conf"})
@ImportResource({"classpath:activiti-custom-context.xml"})
public class ApplicationConfiguration {

}
