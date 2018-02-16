package org.activiti.rest.common.servlet;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Nurgali.Yesmukhamedo on 16.02.2018.
 */
public class ActivitiServletContextListener implements ServletContextListener {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ActivitiServletContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Booting Activiti Process Engine");
        ProcessEngine processEngine = null;
        try{
            processEngine = ProcessEngines.getDefaultProcessEngine();
        }catch (Exception e){
            LOGGER.error("Error starting the Activiti REST API", e);
        }
        if(processEngine == null){
            LOGGER.error("Could not start the Activiti REST API");
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Destroying Activiti Process Engine");
        ProcessEngines.destroy();
    }
}
