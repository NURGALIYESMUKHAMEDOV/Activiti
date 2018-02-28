package org.activiti.rest.common.application;

/**
 * Created by Nurgali.Yesmukhamedo on 28.02.2018.
 */
public class DefaultContentTypeResolver implements ContentTypeResolver{
    @Override
    public String resolveContentType(String resourceName) {
        String contentType = null;
        if(resourceName != null && !resourceName.isEmpty()){
            String lowerResourceName = resourceName.toLowerCase();

            if(lowerResourceName.endsWith("png")){
                contentType = "image/png";
            }else if(lowerResourceName.endsWith("xml") || lowerResourceName.endsWith("bpmn")){
                contentType = "text/xml";
            }
        }
        return contentType;
    }
}
