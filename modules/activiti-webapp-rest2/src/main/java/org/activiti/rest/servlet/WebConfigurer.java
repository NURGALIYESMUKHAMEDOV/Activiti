package org.activiti.rest.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Astana on 12.02.2018.
 */
public class WebConfigurer implements ServletContextListener {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    public AnnotationConfigWebApplicationContext context;

    public void setContext(AnnotationConfigWebApplicationContext context){
        this.context = context;
    }

    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        log.debug("Configuring Spring root application context");

        AnnotationConfigWebApplicationContext rootContext = null;

        if(context == null){
            rootContext = new AnnotationConfigWebApplicationContext();
            rootContext.refresh();
        }else{
            rootContext = context;
        }


        log.debug("Web application fully configured");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("Configuring Spring Web application context");

        log.debug("Registering Spring MVC Servlet");

    }
}
