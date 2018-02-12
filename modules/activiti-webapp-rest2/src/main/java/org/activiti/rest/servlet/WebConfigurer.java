package org.activiti.rest.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Astana on 12.02.2018.
 */
public class WebConfigurer implements ServletContextListener {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.debug("Configuring Spring root application context");

        log.debug("Web application fully configured");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("Configuring Spring Web application context");

        log.debug("Registering Spring MVC Servlet");

    }
}
