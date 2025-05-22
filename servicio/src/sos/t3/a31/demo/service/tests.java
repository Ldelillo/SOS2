package sos.t3.a31.demo.service;

import java.util.HashMap;

public class tests {
    public static void main(String[] args) {

         
     UPMAuthenticationAuthorizationWSSkeletonSkeleton skeleton = new UPMAuthenticationAuthorizationWSSkeletonSkeleton();



        System.out.println("Testing addUser");

        es.upm.fi.sos.t3.backend.AddUser addUser = new es.upm.fi.sos.t3.backend.AddUser();
        addUser.setUser(new es.upm.fi.sos.t3.backend.xsd.UserBackEnd());
        addUser.getUser().setName("test1");
        es.upm.fi.sos.t3.backend.AddUserResponse response0 = skeleton.addUser(addUser);

        System.out.println("Usuario 'test1' añadido (esperado = true):\t" + response0.get_return().getResult());
        System.out.println("Contraseña generada:\t" + response0.get_return().getPassword());

        response0 = skeleton.addUser(addUser);

        System.out.println("Usuario 'test1' añadido de nuevo (esperado = false):\t" + response0.get_return().getResult());

        addUser.getUser().setName("test2");
        response0 = skeleton.addUser(addUser);

        System.out.println("Usuario 'test2' añadido (esperado = true):\t" + response0.get_return().getResult());

        System.out.println("Contraseña generada:\t" + response0.get_return().getPassword());



        addUser.getUser().setName("test3");
        response0 = skeleton.addUser(addUser);

        System.out.println("Usuario 'test3' añadido (esperado = true):\t" + response0.get_return().getResult());

        System.out.println("Contraseña generada:\t" + response0.get_return().getPassword());



        System.out.println("\nTesting ExistUser");

        es.upm.fi.sos.t3.backend.ExistUser existUser = new es.upm.fi.sos.t3.backend.ExistUser();
        existUser.setUsername(new es.upm.fi.sos.t3.backend.xsd.Username());
        existUser.getUsername().setName("test");
        es.upm.fi.sos.t3.backend.ExistUserResponse response1 = skeleton.existUser(existUser);

        System.out.println("Existe usuario 'test' (esperado = false):\t" + response1.get_return().getResult());

        existUser.getUsername().setName("test1");
        response1 = skeleton.existUser(existUser);

        System.out.println("Existe usuario 'test1' (esperado = true):\t" + response1.get_return().getResult());

        existUser.getUsername().setName("test3");
        response1 = skeleton.existUser(existUser);

        System.out.println("Existe usuario 'test3' (esperado = true):\t" + response1.get_return().getResult());



        System.out.println("\nTesting removeUser");

        es.upm.fi.sos.t3.backend.RemoveUser removeUser = new es.upm.fi.sos.t3.backend.RemoveUser();
        removeUser.setRemoveUser(new es.upm.fi.sos.t3.backend.xsd.RemoveUser());
        removeUser.getRemoveUser().setName("test1");
        es.upm.fi.sos.t3.backend.RemoveUserResponse response2 = skeleton.removeUser(removeUser);

        System.out.println("Usuario 'test1' eliminado (esperado = true):\t" + response2.get_return().getResult());

        removeUser.getRemoveUser().setName("test");
        response2 = skeleton.removeUser(removeUser);

        System.out.println("Usuario 'test' eliminado (esperado = false):\t" + response2.get_return().getResult());

        


        System.out.println("\nTesting ChangePassword");
        es.upm.fi.sos.t3.backend.ChangePassword changepassword = new es.upm.fi.sos.t3.backend.ChangePassword();
        changepassword.setChangePassword(new es.upm.fi.sos.t3.backend.xsd.ChangePasswordBackEnd());
        changepassword.getChangePassword().setName("test2");
        changepassword.getChangePassword().setOldpwd("patata");
        changepassword.getChangePassword().setNewpwd("Coliflor");
        es.upm.fi.sos.t3.backend.ChangePasswordResponse response3 = skeleton.changePassword(changepassword);

        System.out.println("Usuario 'test2' cambia oldpwd 'patata' por nweped 'Coliflor' (esperado = true)" + response3.get_return().getResult());

        response3 = skeleton.changePassword(changepassword);

        System.out.println("Usuario 'test2' cambia oldpwd 'patata' por nweped 'Coliflor' (esperado = false):\t" + response3.get_return().getResult());


        changepassword.getChangePassword().setName("test");
        changepassword.getChangePassword().setOldpwd("patata");
        changepassword.getChangePassword().setNewpwd("Coliflor");
        response3 = skeleton.changePassword(changepassword);


        System.out.println("Usuario 'test' cambia oldpwd 'patata' por nweped 'Coliflor' (esperado = false):\t" + response3.get_return().getResult());


        changepassword.getChangePassword().setName("test2");
        changepassword.getChangePassword().setOldpwd("Coliflor");
        changepassword.getChangePassword().setNewpwd("Coliflor");
        response3 = skeleton.changePassword(changepassword);


        System.out.println("Usuario 'test2' cambia oldpwd 'Coliflor' por nweped 'Coliflor' (esperado = true):\t" + response3.get_return().getResult());




        System.out.println("\nTesting login");
        es.upm.fi.sos.t3.backend.Login login = new es.upm.fi.sos.t3.backend.Login();

        login.setLogin(new es.upm.fi.sos.t3.backend.xsd.LoginBackEnd());
        login.getLogin().setName("test3");
        login.getLogin().setPassword("patata");

        es.upm.fi.sos.t3.backend.LoginResponse response4 = skeleton.login(login);

        System.out.println("Login con user 'test3' y pwd 'patata' (esperado = true):\t" + response4.get_return().getResult());

        login.getLogin().setName("test");
        response4 = skeleton.login(login);
        System.out.println("Login con user 'test' y pwd 'patata' (esperado = false):\t" + response4.get_return().getResult());


        login.getLogin().setName("test2");
        response4 = skeleton.login(login);
        System.out.println("Login con user 'test2' y pwd 'patata' (esperado = false):\t" + response4.get_return().getResult());

        login.getLogin().setName("test2");
        response4 = skeleton.login(login);
        System.out.println("Login con user 'test2' y pwd 'Coliflor' (esperado = true):\t" + response4.get_return().getResult());

        
        login.getLogin().setName("test");
        response4 = skeleton.login(login);
        System.out.println("Login con user 'test' y pwd 'brotato' (esperado = false):\t" + response4.get_return().getResult());

        }
}
