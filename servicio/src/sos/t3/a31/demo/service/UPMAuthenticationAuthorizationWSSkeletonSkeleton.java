
/**
 * UPMAuthenticationAuthorizationWSSkeletonSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package sos.t3.a31.demo.service;

import java.util.HashMap;

import es.upm.fi.sos.t3.backend.AddUserResponse;
import es.upm.fi.sos.t3.backend.ChangePasswordResponse;
import es.upm.fi.sos.t3.backend.LoginResponse;
import es.upm.fi.sos.t3.backend.RemoveUserResponse;
import es.upm.fi.sos.t3.backend.xsd.AddUserResponseBackEnd;
import es.upm.fi.sos.t3.backend.xsd.ExistUserResponse;
import es.upm.fi.sos.t3.backend.xsd.LoginResponseBackEnd;

/**
 * UPMAuthenticationAuthorizationWSSkeletonSkeleton java skeleton for the
 * axisService
 */
public class UPMAuthenticationAuthorizationWSSkeletonSkeleton {
    /**
     * La key es el name y el value es el password
     */
    private HashMap<String, String> users = new HashMap<>();

    /**
     * Auto generated method signature
     * 
     * @param removeUser
     * @return removeUserResponse
     */

    public es.upm.fi.sos.t3.backend.RemoveUserResponse removeUser(es.upm.fi.sos.t3.backend.RemoveUser removeUser) {
        RemoveUserResponse response = new RemoveUserResponse();
        String name = removeUser.getRemoveUser().getName();
        es.upm.fi.sos.t3.backend.xsd.RemoveUserResponse resAux = new es.upm.fi.sos.t3.backend.xsd.RemoveUserResponse();
        resAux.setResult(false);
        if (users.containsKey(name)) {
            users.remove(name);
            resAux.setResult(true);
        }
        response.set_return(resAux);
        return response;
        /*
         * throw new java.lang.UnsupportedOperationException(
         * "Please implement " + this.getClass().getName() + "#removeUser");
         */
    }

    /**
     * Auto generated method signature
     * 
     * @param addUser
     * @return addUserResponse
     */

    public es.upm.fi.sos.t3.backend.AddUserResponse addUser(es.upm.fi.sos.t3.backend.AddUser addUser) {
        AddUserResponse response = new AddUserResponse();
        String name = addUser.getUser().getName();
        AddUserResponseBackEnd auxRes = new AddUserResponseBackEnd();
        auxRes.setResult(false);
        if (!users.containsKey(name)) {
            String PSWDaux = genPSWD(name);
            System.out.println(PSWDaux);
            users.put(name, PSWDaux);
            auxRes.setResult(true);
            auxRes.setPassword(PSWDaux);
        }
        response.set_return(auxRes);
        return response;
        /*
         * throw new java.lang.UnsupportedOperationException("Please implement " +
         * this.getClass().getName() + "#addUser");
         */
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
        auxRes.setResult(users.containsKey(existUser.getUsername().getName()));
        response.set_return(auxRes);
        return response;
        /*
         * throw new java.lang.UnsupportedOperationException(
         * "Please implement " + this.getClass().getName() + "#existUser");
         */
    }

    /**
     * Auto generated method signature
     * 
     * @param login
     * @return loginResponse
     */

    public es.upm.fi.sos.t3.backend.LoginResponse login(es.upm.fi.sos.t3.backend.Login login) {
        LoginResponse response = new LoginResponse();
        String name = login.getLogin().getName();
        String PSWDaux = login.getLogin().getPassword();
        LoginResponseBackEnd resAux = new LoginResponseBackEnd();
        resAux.setResult(false);
        if (users.containsKey(name) && users.get(name).equals(PSWDaux)) {
            resAux.setResult(true);
        }
        response.set_return(resAux);
        return response;
        /*
         * throw new java.lang.UnsupportedOperationException("Please implement " +
         * this.getClass().getName() + "#login");
         */
    }

    /**
     * Auto generated method signature
     * 
     * @param changePassword
     * @return changePasswordResponse
     */

    public es.upm.fi.sos.t3.backend.ChangePasswordResponse changePassword(
            es.upm.fi.sos.t3.backend.ChangePassword changePassword) {
        ChangePasswordResponse response = new ChangePasswordResponse();
        String name = changePassword.getChangePassword().getName();
        String PSWDold = changePassword.getChangePassword().getOldpwd();
        String PSWDnew = changePassword.getChangePassword().getNewpwd();
        es.upm.fi.sos.t3.backend.xsd.ChangePasswordResponse resAux = new es.upm.fi.sos.t3.backend.xsd.ChangePasswordResponse();
        resAux.setResult(false);
        if (users.containsKey(name) && users.get(name).equals(PSWDold)) {
            resAux.setResult(users.replace(name, PSWDold, PSWDnew));
        }
        response.set_return(resAux);
        return response;
        /*
         * throw new java.lang.UnsupportedOperationException(
         * "Please implement " + this.getClass().getName() + "#changePassword");
         */
    }

    // TODO:
    private String genPSWD(String name) {
        String res = "";
        name = name.toUpperCase();
        for (int i = 0; i < name.length(); i++) {
            int caracterActual = (int) name.charAt(i);
            if (caracterActual >= 48 && caracterActual <= 57) {
                caracterActual = caracterActual - 47 % 10;
            } else if (caracterActual >= 65 && caracterActual <= 90) {
                caracterActual = caracterActual - 64 % 25;
            } else {
                caracterActual = 64;
            }
            res += (char) caracterActual;
        }
        return res;
    }
}
