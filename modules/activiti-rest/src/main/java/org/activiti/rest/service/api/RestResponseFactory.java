package org.activiti.rest.service.api;

import org.activiti.engine.identity.User;
import org.activiti.rest.service.api.identity.UserResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurgali.Yesmukhamedo on 28.02.2018.
 */
public class RestResponseFactory {

    public List<UserResponse> createUserResponseList(List<User> users, boolean includePassword){
        RestUrlBuilder urlBuilder = createUrlBuilder();
        List<UserResponse> responseList = new ArrayList<UserResponse>();
        for(User instance : users){
            responseList.add(createUserResponse(instance, includePassword, urlBuilder));
        }
        return responseList;
    }

    public UserResponse createUserResponse(User user, boolean includePassword){
        return createUserResponse(user, includePassword, createUrlBuilder());
    }

    public UserResponse createUserResponse(User user, boolean includePassword, RestUrlBuilder urlBuilder){
        UserResponse response = new UserResponse();
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPictureUrl(urlBuilder.buildUrl(RestUrls.URL_USER, user.getId()));

        if(includePassword){
            response.setPassWord(user.getPassword());
        }

        if(user.isPictureSet()){
            response.setPictureUrl(urlBuilder.buildUrl(RestUrls.URL_USER_PICTURE, user.getId()));
        }
        return response;
    }

    protected RestUrlBuilder createUrlBuilder(){
        return RestUrlBuilder.fromCurrentRequest();
    }

}
