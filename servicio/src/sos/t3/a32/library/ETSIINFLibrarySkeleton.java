
/**
 * ETSIINFLibrarySkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package sos.t3.a32.library;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.regexp.recompile;

import es.upm.etsiinf.sos.*;
import es.upm.etsiinf.sos.ChangePasswordResponse;
import es.upm.etsiinf.sos.auth.*;
import es.upm.etsiinf.sos.auth.UPMAuthenticationAuthorizationWSSkeletonStub.*;
import es.upm.etsiinf.sos.model.xsd.*;

/**
 * ETSIINFLibrarySkeleton java skeleton for the axisService
 */
public class ETSIINFLibrarySkeleton {

    private static List<String> userslogged;

    private static User admin;

    private boolean loged;
    private String userNameLogged;

    /**
     * Constructor
     */
    public ETSIINFLibrarySkeleton() {
        loged = false;
        if (admin==null) {
            admin = new User();
            admin.setName("admin");
            admin.setPwd("admin");
        }
        if (userslogged==null)
            userslogged = new ArrayList<String>();
    }

    /**
     * Auto generated method signature
     * 
     * @param borrowBook
     * @return borrowBookResponse
     */

    public es.upm.etsiinf.sos.BorrowBookResponse borrowBook(es.upm.etsiinf.sos.BorrowBook borrowBook) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#borrowBook");
    }

    /**
     * Auto generated method signature
     * 
     * @param returnBook
     * @return returnBookResponse
     */

    public es.upm.etsiinf.sos.ReturnBookResponse returnBook(
            es.upm.etsiinf.sos.ReturnBook returnBook) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#returnBook");
    }

    /**
     * Auto generated method signature
     * 
     * @param logout
     * @return logoutResponse
     */

    public es.upm.etsiinf.sos.LogoutResponse logout(es.upm.etsiinf.sos.Logout logout) {
        LogoutResponse response = new LogoutResponse();
        Response response2 = new Response();
        if(!loged){
            response2.setResponse(loged);
        }
        else if(userNameLogged.equals("admin")){
            response2.setResponse(loged);
            userslogged.remove(userNameLogged);
            userNameLogged = null;
            loged = false;
        }
        else{
            response2.setResponse(loged);
            userslogged.remove(userNameLogged);
            userNameLogged = null;
            loged = false;
        }

        response.set_return(response2);
        return response;
    }

    /**
     * Auto generated method signature
     * 
     * @param removeBook
     * @return removeBookResponse
     */

    public es.upm.etsiinf.sos.RemoveBookResponse removeBook(
            es.upm.etsiinf.sos.RemoveBook removeBook) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#removeBook");
    }

    /**
     * Auto generated method signature
     * 
     * @param deleteUser
     * @return deleteUserResponse
     */

    public es.upm.etsiinf.sos.DeleteUserResponse deleteUser(es.upm.etsiinf.sos.DeleteUser deleteUser) {
        //TODO: hay que modificar muchas cosas, esto solo hace el borrado pero no confirma nada mas
        DeleteUserResponse response = new DeleteUserResponse();
        es.upm.etsiinf.sos.model.xsd.Response response3 = new es.upm.etsiinf.sos.model.xsd.Response();
        if(userNameLogged.equals(admin.getName()) && !deleteUser.getArgs0().getUsername().equals("admin")){
            try {
                UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();

                UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser deleteUser2 = new UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser(); 
                deleteUser2.setName(deleteUser.getArgs0().getUsername());
                RemoveUserE removeUserAux = new RemoveUserE();
                removeUserAux.setRemoveUser(deleteUser2);
                UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE response2 = stub.removeUser(removeUserAux);

                response3.setResponse(response2.get_return().getResult());
                response.set_return(response3);
            } catch (Exception e) {
                // TODO:ERRORES?
                e.printStackTrace();
            }
        }
        else{
            response3.setResponse(false);
            response.set_return(response3);
        }
        return response;
    }

    /**
     * Auto generated method signature
     * 
     * @param addUser
     * @return addUserResponse
     */

    public es.upm.etsiinf.sos.AddUserResponse addUser(es.upm.etsiinf.sos.AddUser addUser) {
        es.upm.etsiinf.sos.AddUserResponse response = new es.upm.etsiinf.sos.AddUserResponse();
        es.upm.etsiinf.sos.model.xsd.AddUserResponse response4 = new es.upm.etsiinf.sos.model.xsd.AddUserResponse();
        if(userNameLogged.equals(admin.getName()) && !addUser.getArgs0().getUsername().equals("admin")){
            try {
                UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();

                UPMAuthenticationAuthorizationWSSkeletonStub.AddUser addUser2 = new UPMAuthenticationAuthorizationWSSkeletonStub.AddUser(); 
                UserBackEnd userAux = new UserBackEnd();
                userAux.setName(addUser.getArgs0().getUsername());
                addUser2.setUser(userAux);

                UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponse response2 = stub.addUser(addUser2);
                AddUserResponseBackEnd response3 = response2.get_return();

                response4.setResponse(response3.getResult());
                //No registro la contraseña si el usuario ya existe
                if(response3.getResult())
                    response4.setPwd(response3.getPassword());
                response.set_return(response4);

            } catch (Exception e) {
                // TODO:ERRORES?
                e.printStackTrace();
            }
        }
        else{
            response4.setResponse(false);
            response.set_return(response4);
        }
        return response;
    }

    /**
     * Auto generated method signature
     * 
     * @param getBook
     * @return getBookResponse
     */

    public es.upm.etsiinf.sos.GetBookResponse getBook(
            es.upm.etsiinf.sos.GetBook getBook) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getBook");
    }

    /**
     * Auto generated method signature
     * 
     * @param listBooks
     * @return listBooksResponse
     */

    public es.upm.etsiinf.sos.ListBooksResponse listBooks(
            es.upm.etsiinf.sos.ListBooks listBooks) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#listBooks");
    }

    /**
     * Auto generated method signature
     * 
     * @param changePassword
     * @return changePasswordResponse
     */

    public es.upm.etsiinf.sos.ChangePasswordResponse changePassword(es.upm.etsiinf.sos.ChangePassword changePassword) {
        ChangePasswordResponse response = new ChangePasswordResponse();
        Response response4 = new Response();
        if(loged){
            if(userNameLogged.equals("admin")){
                if(changePassword.getArgs0().getOldpwd().equals(admin.getPwd())){
                    admin.setPwd(changePassword.getArgs0().getNewpwd());
                    response4.setResponse(true);
                }
                else{
                    response4.setResponse(false);
                }
            }
            else{
                try {
                    UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();
                    UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword changePassword2 = new 
                    UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword();

                    ChangePasswordBackEnd changePassword3 = new ChangePasswordBackEnd();
                    changePassword3.setName(userNameLogged);
                    changePassword3.setOldpwd(changePassword.getArgs0().getOldpwd());
                    changePassword3.setNewpwd(changePassword.getArgs0().getNewpwd());
                    changePassword2.setChangePassword(changePassword3);

                    ChangePasswordResponseE responseE = stub.changePassword(changePassword2);
                    response4.setResponse(responseE.get_return().getResult());
                    
                } catch (Exception e) {
                    // TODO: ERRORES??
                    e.printStackTrace();
                }

            }
        }
        else{
            response4.setResponse(false);
        }
        response.set_return(response4);
        return response;
    }

    /**
     * Auto generated method signature
     * 
     * @param login
     * @return loginResponse
     */

    public es.upm.etsiinf.sos.LoginResponse login(es.upm.etsiinf.sos.Login login) {
        es.upm.etsiinf.sos.LoginResponse response = new es.upm.etsiinf.sos.LoginResponse();
        // Si se llama a la funcion con el usuario ya iniciado da true
        // independientemente de la entrada.
        if (loged) {
            Response entradaRep = new Response();
            entradaRep.setResponse(userNameLogged.equals(login.getArgs0().getName()));
            response.set_return(entradaRep);
            return response;
        }
        // Entrada de admin
        if (login.getArgs0().getName().equals(admin.getName())) {
            Response entradaRep = new Response();
            if (login.getArgs0().getPwd().equals(admin.getPwd())) {
                userNameLogged = login.getArgs0().getName();
                userslogged.add(userNameLogged);
                entradaRep.setResponse(true);
                loged = true;
            } else {
                entradaRep.setResponse(false);
                loged = false;
            }
            response.set_return(entradaRep);
            return response;
        }

        try {
            UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();
            UPMAuthenticationAuthorizationWSSkeletonStub.Login loginAux = 
            new es.upm.etsiinf.sos.auth.UPMAuthenticationAuthorizationWSSkeletonStub.Login();
            
            LoginBackEnd loginAux2 = new LoginBackEnd();
            loginAux2.setName(login.getArgs0().getName());
            loginAux2.setPassword(login.getArgs0().getPwd());
            loginAux.setLogin(loginAux2);

            es.upm.etsiinf.sos.auth.UPMAuthenticationAuthorizationWSSkeletonStub.LoginResponse response2 = stub
                    .login(loginAux);

            LoginResponseBackEnd response3 = response2.get_return();
            Response response4 = new Response();
            response4.setResponse(response3.getResult());
            loged = response3.getResult();
            response.set_return(response4);
            userNameLogged = login.getArgs0().getName();
            userslogged.add(userNameLogged);
        } catch (Exception e) {
            // TODO ERRORES?
            e.printStackTrace();
        }

        return response;

    }

    /**
     * Auto generated method signature
     * 
     * @param addBook
     * @return addBookResponse
     */

    public es.upm.etsiinf.sos.AddBookResponse addBook(es.upm.etsiinf.sos.AddBook addBook) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addBook");
    }

    /**
     * Auto generated method signature
     * 
     * @param getBooksFromAuthor
     * @return getBooksFromAuthorResponse
     */

    public es.upm.etsiinf.sos.GetBooksFromAuthorResponse getBooksFromAuthor(
            es.upm.etsiinf.sos.GetBooksFromAuthor getBooksFromAuthor) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#getBooksFromAuthor");
    }

    /**
     * Auto generated method signature
     * 
     * @param listBorrowedBooks
     * @return listBorrowedBooksResponse
     */

    public es.upm.etsiinf.sos.ListBorrowedBooksResponse listBorrowedBooks(
            es.upm.etsiinf.sos.ListBorrowedBooks listBorrowedBooks) {
        // TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException(
                "Please implement " + this.getClass().getName() + "#listBorrowedBooks");
    }

}
