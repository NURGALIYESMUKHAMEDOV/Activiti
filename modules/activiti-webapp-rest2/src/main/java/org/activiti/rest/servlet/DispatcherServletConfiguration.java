package org.activiti.rest.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by Nurgali.Yesmukhamedo on 13.02.2018.
 */
@Configuration
@ComponentScan({"org.activiti.rest.exception", "org.activiti.rest.service.api"})
@EnableAsync
public class DispatcherServletConfiguration {
}
