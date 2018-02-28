package org.activiti.rest.exception;

import org.activiti.engine.ActivitiException;

/**
 * Created by Nurgali.Yesmukhamedo on 28.02.2018.
 */
public class ActivitiContentNotSupportedException extends ActivitiException{

    private static final long serialVersionUID = 1L;

    public ActivitiContentNotSupportedException(String message) {
        super(message);
    }
}
