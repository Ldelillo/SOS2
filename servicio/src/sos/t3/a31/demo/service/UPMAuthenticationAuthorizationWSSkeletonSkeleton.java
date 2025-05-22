
/**
 * UPMAuthenticationAuthorizationWSSkeletonSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package sos.t3.a31.demo.service;

import java.util.HashMap;

import es.upm.fi.sos.t3.backend.xsd.ExistUserResponse;

/**
 * UPMAuthenticationAuthorizationWSSkeletonSkeleton java skeleton for the
 * axisService
 */
public class UPMAuthenticationAuthorizationWSSkeletonSkeleton {
    /**
     * La key es el name y el value es el password
     */
    private HashMap<String,String> users = new HashMap<>();

    /**
     * Auto generated method signature
     * 
     * @param removeUser
     * @return removeUserResponse
     */

    public es.upm.fi.sos.t3.backend.RemoveUserResponse removeUser(
            es.upm.fi.sos.t3.backend.RemoveUser removeUser) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#removeUser");
    }

    /**
     * Auto generated method signature
     * 
     * @param addUser
     * @return addUserResponse
     */

    public es.upm.fi.sos.t3.backend.AddUserResponse addUser(es.upm.fi.sos.t3.backend.AddUser addUser) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addUser");
    }

    /**
     * Auto generated method signature
     * 
     * @param existUser
     * @return existUserResponse
     */
    
    public es.upm.fi.sos.t3.backend.ExistUserResponse existUser(es.upm.fi.sos.t3.backend.ExistUser existUser) {
        es.upm.fi.sos.t3.backend.ExistUserResponse response = new es.upm.fi.sos.t3.backend.ExistUserResponse();
        ExistUserResponse auxRes = new ExistUserResponse();
        auxRes.setResult(false);
        response.set_return(auxRes);
        if(users.containsKey(existUser.getUsername().getName())){
            auxRes.setResult(true);
            response.set_return(auxRes);
        }
        return response;
        /*throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#existUser");
        */
    }

    /**
     * Auto generated method signature
     * 
     * @param login
     * @return loginResponse
     */

    public es.upm.fi.sos.t3.backend.LoginResponse login(
            es.upm.fi.sos.t3.backend.Login login) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#login");
    }

    /**
     * Auto generated method signature
     * 
     * @param changePassword
     * @return changePasswordResponse
     */

    public es.upm.fi.sos.t3.backend.ChangePasswordResponse changePassword(
            es.upm.fi.sos.t3.backend.ChangePassword changePassword) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#changePassword");
    }

}
