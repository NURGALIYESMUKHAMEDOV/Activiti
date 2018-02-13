package org.activiti.rest.servlet;

import org.activiti.rest.conf.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;

import java.util.EnumSet;

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
            rootContext.register(ApplicationConfiguration.class);
            rootContext.refresh();
        }else{
            rootContext = context;
        }

        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, rootContext);

        EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);

        //initSpring(servletContext, rootContext);

        log.debug("Web application fully configured");
    }

    /*private ServletRegistration.Dynamic initSpring(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext){
        log.debug("Configuring Spring Web application context");
        AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
        dispatcherServletConfiguration.setParent(rootContext);

    }*/

    public void contextDestroyed(ServletContextEvent sce) {
        log.debug("Configuring Spring Web application context");
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        AnnotationConfigWebApplicationContext gwac = (AnnotationConfigWebApplicationContext)ac;
        gwac.close();
        log.debug("Registering Spring MVC Servlet");

    }
}
