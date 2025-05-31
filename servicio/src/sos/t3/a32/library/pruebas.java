package sos.t3.a32.library;

import es.upm.etsiinf.sos.*;
import es.upm.etsiinf.sos.model.xsd.*;

public class pruebas {
    public static void main(String[] args) {
        ETSIINFLibrarySkeleton stubAdmin = new ETSIINFLibrarySkeleton();
        ETSIINFLibrarySkeleton stub1 = new ETSIINFLibrarySkeleton();
        ETSIINFLibrarySkeleton stub1_1 = new ETSIINFLibrarySkeleton();
        ETSIINFLibrarySkeleton stub2 = new ETSIINFLibrarySkeleton();
        ETSIINFLibrarySkeleton stub3 = new ETSIINFLibrarySkeleton();

        System.out.println("INICIANDO SESION ADMIN");

        Login login = new Login();
        login.setArgs0(new User());
        login.getArgs0().setName("admin");
        login.getArgs0().setPwd("admin");

        LoginResponse responseLogin = stubAdmin.login(login);

        System.out.println("Inicio sesion admin:\t" + responseLogin.get_return().getResponse());

        
        
        System.out.println("\n\nCREANDO USUARIOS");        
        String pwd1 = "";
        String pwd2 = "";
        String pwd3 = "";

        AddUser adduser = new AddUser();
        adduser.setArgs0(new Username());
        adduser.getArgs0().setUsername("Usuario1");
        es.upm.etsiinf.sos.AddUserResponse responseAdduser = stubAdmin.addUser(adduser);
        Boolean exito = responseAdduser.get_return().getResponse();
        System.out.println("Creado 'Usuario1':\t" + exito);
        if(exito){
            pwd1 = responseAdduser.get_return().getPwd();
            System.out.println("Contraseña generada:\t" + pwd1);
        }

        adduser.getArgs0().setUsername("Usuario2");
        responseAdduser = stubAdmin.addUser(adduser);
        exito = responseAdduser.get_return().getResponse();
        System.out.println("Creado 'Usuario2':\t" + exito);
        if(exito){
            pwd2 = responseAdduser.get_return().getPwd();
            System.out.println("Contraseña generada:\t" + pwd2);
        }

        adduser.getArgs0().setUsername("Usuario3");
        responseAdduser = stubAdmin.addUser(adduser);
        exito = responseAdduser.get_return().getResponse();
        System.out.println("Creado 'Usuario3':\t" + exito);
        if(exito){
            pwd3 = responseAdduser.get_return().getPwd();
            System.out.println("Contraseña generada:\t" + pwd3);
        }


        adduser.getArgs0().setUsername("admin");
        responseAdduser = stubAdmin.addUser(adduser);
        System.out.println("Intentando crear usuario 'admin' (false):\t" + responseAdduser.get_return().getResponse());

        adduser.getArgs0().setUsername("Usuario1");
        responseAdduser = stubAdmin.addUser(adduser);
        System.out.println("Intentando crear usuario 'Usuario1' (false):\t" + responseAdduser.get_return().getResponse());



        System.out.println("\n\nINICIANDO SESIONES");

        login.getArgs0().setName("Usuario1");
        login.getArgs0().setPwd(pwd1);
        responseLogin = stub1.login(login);
        System.out.println("Iniciado sesion 'Usuario1', "+pwd1+":\t"+responseLogin.get_return().getResponse());

        responseLogin = stub1.login(login);
        System.out.println("Iniciado sesion (de nuevo, misma instancia)'Usuario1', "+pwd1+":\t"+responseLogin.get_return().getResponse());

        login.getArgs0().setPwd(pwd2);
        responseLogin = stub1.login(login);
        System.out.println("Iniciado sesion (misma instancia contraseña incorrecta)'Usuario1', "+pwd2+":\t"+responseLogin.get_return().getResponse());

        login.getArgs0().setPwd(pwd1);
        responseLogin = stub1_1.login(login);
        System.out.println("Iniciado sesion (distinta instancia)'Usuario1', "+pwd1+":\t"+responseLogin.get_return().getResponse());

        login.getArgs0().setName("Usuario2");
        login.getArgs0().setPwd(pwd2);
        responseLogin = stub1.login(login);
        System.out.println("Iniciado sesion (instancia logeada con Usuario 1)'Usuario2', "+pwd2+" (false):\t"+responseLogin.get_return().getResponse());



        login.getArgs0().setName("Usuario2");
        login.getArgs0().setPwd(pwd2);
        responseLogin = stub2.login(login);
        System.out.println("Iniciado sesion 'Usuario2', "+pwd2+":\t"+responseLogin.get_return().getResponse());

        login.getArgs0().setName("Usuario3");
        login.getArgs0().setPwd(pwd3);
        responseLogin = stub3.login(login);
        System.out.println("Iniciado sesion 'Usuario3', "+pwd3+":\t"+responseLogin.get_return().getResponse());
    




        System.out.println("\n\nCERRRANDO SESIONES");

        Logout logout = new Logout();
        LogoutResponse responseLogout = stub1.logout(logout);
        System.out.println("Cierre sesion 'Usuario1':\t" + responseLogout.get_return().getResponse());

        responseLogout = stub1.logout(logout);
        System.out.println("Cierre sesion 'Usuario1' en la misma instancia (false):\t" + responseLogout.get_return().getResponse());

        responseLogout = stub1_1.logout(logout);
        System.out.println("Cierre sesion 'Usuario1' en otra instancia:\t" + responseLogout.get_return().getResponse());

        responseLogout = stub1_1.logout(logout);
        System.out.println("Cierre sesion 'Usuario1' en la misma otra instancia:\t" + responseLogout.get_return().getResponse());

        responseLogout = stubAdmin.logout(logout);
        System.out.println("Cierre sesion 'admin':\t" + responseLogout.get_return().getResponse());

        login.setArgs0(new User());
        login.getArgs0().setName("admin");
        login.getArgs0().setPwd("admin");

        responseLogin = stubAdmin.login(login);

        System.out.println("Inicio sesion admin:\t" + responseLogin.get_return().getResponse());





        System.out.println("\n\nCAMBIANDO CONTRASEÑAS");

        ChangePassword changePassword = new ChangePassword();

        changePassword.setArgs0(new PasswordPair());
        changePassword.getArgs0().setNewpwd("patata");
        changePassword.getArgs0().setOldpwd(pwd2);
        ChangePasswordResponse responseChangepwd = stub2.changePassword(changePassword);
        System.out.println("Cambiando pwd de 'User2' de:\t"+ pwd2 + "\ta\t'patata':\t" + responseChangepwd.get_return().getResponse());

        
        responseChangepwd = stub3.changePassword(changePassword);
        System.out.println("Cambiando pwd de 'User3' de:\t"+ pwd2 + "\ta\t'patata' (false)\t:" + responseChangepwd.get_return().getResponse());

        responseLogout = stub2.logout(logout);
        System.out.println("Cierre seison 'Usuario2':" + responseLogout.get_return().getResponse());
        login.getArgs0().setName("Usuario2");
        login.getArgs0().setPwd("patata");
        responseLogin = stub2.login(login);
        System.out.println("Iniciado sesion 'Usuario2' con nueva contraseña 'patata'\t" + responseLogin.get_return().getResponse());

        login.getArgs0().setPwd(pwd2);
        responseLogin = stub1.login(login);
        System.out.println("Iniciado sesion 'Usuario2' con antigua contraseña '"+ pwd2 + "':\t" + responseLogin.get_return().getResponse());




























        System.out.println("\n\nBORRANDO USUARIOS");
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario1");
        DeleteUserResponse responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario1':\t" + responseDeleteuser.get_return().getResponse());

        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario2");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario2':\t" + responseDeleteuser.get_return().getResponse());

        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario3");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario3':\t" + responseDeleteuser.get_return().getResponse());

        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario3");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario3' (false):\t" + responseDeleteuser.get_return().getResponse());

        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("admin");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'admin'(false):\t" + responseDeleteuser.get_return().getResponse());
    }
}
