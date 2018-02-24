package org.activiti.spring;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Astana on 25.02.2018.
 */
public class ProcessEngineFactoryBean  implements FactoryBean<ProcessEngine>, DisposableBean, ApplicationContextAware {

    protected ProcessEngineConfigurationImpl processEngineConfiguration;

    protected ApplicationContext applicationContext;
    protected ProcessEngine processEngine;

    public void destroy() throws Exception {
        if(processEngine != null){
            processEngine.close();
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ProcessEngine getObject() throws Exception {
        configureExpressionManager();
        configureExternallyManagedTransactions();

        return null;
    }

    protected void configureExpressionManager(){
        if(processEngineConfiguration.getExpressionManager() == null && applicationContext != null){
            processEngineConfiguration.setExpressionManager(new SpringExpressionManager(applicationContext, processEngineConfiguration.getBeans()));
        }
    }

    protected void configureExternallyManagedTransactions() {
        if (processEngineConfiguration instanceof SpringProcessEngineConfiguration) { // remark: any config can be injected, so we cannot have SpringConfiguration as member
            SpringProcessEngineConfiguration engineConfiguration = (SpringProcessEngineConfiguration) processEngineConfiguration;
            if (engineConfiguration.getTransactionManager() != null) {
                processEngineConfiguration.setTransactionsExternallyManaged(true);
            }
        }
    }

    public Class<?> getObjectType() {
        return ProcessEngine.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        return processEngineConfiguration;
    }

    public void setProcessEngineConfiguration(ProcessEngineConfigurationImpl processEngineConfiguration) {
        this.processEngineConfiguration = processEngineConfiguration;
    }
}
