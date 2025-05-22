package sos.t3.a31.demo.service;

import java.util.HashMap;

public class tests {
    public static void main(String[] args) {

         
     UPMAuthenticationAuthorizationWSSkeletonSkeleton skeleton = new UPMAuthenticationAuthorizationWSSkeletonSkeleton();

        System.out.println("TEST DE UPM AUTHENTICATION AUTHORIZATION");

        System.out.println("\nTesting addUser");

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
        login.getLogin().setPassword("Coliflor");
        response4 = skeleton.login(login);
        System.out.println("Login con user 'test2' y pwd 'Coliflor' (esperado = true):\t" + response4.get_return().getResult());


        login.getLogin().setName("test");
        login.getLogin().setPassword("brotato");

        response4 = skeleton.login(login);
        System.out.println("Login con user 'test' y pwd 'brotato' (esperado = false):\t" + response4.get_return().getResult());




        System.out.println("\n\nTEST DE ETSIINFLibrary");
        ETSIINFLibrarySkeleton etsiinf = new ETSIINFLibrarySkeleton();


        System.out.println("\nTesting addUser");
        
        es.upm.etsiinf.sos.AddUser addUser2 = new es.upm.etsiinf.sos.AddUser();
        addUser2.setArgs0(new es.upm.etsiinf.sos.model.xsd.Username());
        addUser2.getArgs0().setUsername("user");
        es.upm.etsiinf.sos.AddUserResponse response5 = etsiinf.addUser(addUser2);

        System.out.println("Añadiendo usuario de nombre 'user' (esperado = true):\t" + response5.get_return().getResponse());
        System.out.println("Contraseña generada:\t" + response5.get_return().getPwd());
        response5 = etsiinf.addUser(addUser2);

        System.out.println("Añadiendo usuario de nombre 'user' (esperado = false):\t" + response5.get_return().getResponse());
        
        addUser2.getArgs0().setUsername("user0");
        response5 = etsiinf.addUser(addUser2);
        System.out.println("Añadiendo usuario de nombre 'user0' (esperado = true):\t" + response5.get_return().getResponse());
        System.out.println("Contraseña generada:\t" + response5.get_return().getPwd());




        System.out.println("\nTesting login");

        es.upm.etsiinf.sos.Login login2 = new es.upm.etsiinf.sos.Login();
        login2.setArgs0(new es.upm.etsiinf.sos.model.xsd.User());
        login2.getArgs0().setName("user");
        login2.getArgs0().setPwd("patata");
        es.upm.etsiinf.sos.LoginResponse response6 = etsiinf.login(login2);

        System.out.println("Login con usuario 'user' y contraseña 'patata' (esperado = true):\t" + response6.get_return().getResponse());

        response6 = etsiinf.login(login2);

        System.out.println("Login con usuario 'user' y contraseña 'patata' (esperado = true):\t" + response6.get_return().getResponse());

        login2.getArgs0().setName("usuario");
        login2.getArgs0().setPwd("patata");

        response6 = etsiinf.login(login2);

        System.out.println("Login con usuario 'usuario' y contraseña 'patata' (esperado = false):\t" + response6.get_return().getResponse());
        
        login2.getArgs0().setName("user");
        login2.getArgs0().setPwd("mala");

        response6 = etsiinf.login(login2);

        System.out.println("Login con usuario 'user' y contraseña 'mala' (esperado = false):\t" + response6.get_return().getResponse());




        System.out.println("\nTesting logout");
        System.out.println("TODO");
        es.upm.etsiinf.sos.LogoutResponse response7;





        System.out.println("\nTesting deleteUser");
        es.upm.etsiinf.sos.DeleteUser deleteUser = new es.upm.etsiinf.sos.DeleteUser();
        deleteUser.setArgs0(new es.upm.etsiinf.sos.model.xsd.Username());
        deleteUser.getArgs0().setUsername("user0");
        es.upm.etsiinf.sos.DeleteUserResponse response8 = etsiinf.deleteUser(deleteUser);

        System.out.println("Eliminado 'user0' (esperado = true):\t" + response8.get_return().getResponse());
        response8 = etsiinf.deleteUser(deleteUser);
        System.out.println("Eliminado 'user0' (esperado = false):\t" + response8.get_return().getResponse());


        deleteUser.getArgs0().setUsername("user999");
        response8 = etsiinf.deleteUser(deleteUser);
        System.out.println("Eliminado 'user999' (esperado = false):\t" + response8.get_return().getResponse());





        System.out.println("\nTesting changePassword");
        es.upm.etsiinf.sos.ChangePassword changePassword2 = new es.upm.etsiinf.sos.ChangePassword();
        changePassword2.setArgs0(new es.upm.etsiinf.sos.model.xsd.PasswordPair());
        changePassword2.getArgs0().setOldpwd(null);
        changePassword2.getArgs0().setNewpwd(null);
        es.upm.etsiinf.sos.ChangePasswordResponse response9 = etsiinf.changePassword(changePassword2);

        System.out.println("TODO");





        System.out.println("\nTesting addBook");

        es.upm.etsiinf.sos.AddBook addBook = new es.upm.etsiinf.sos.AddBook();
        addBook.setArgs0(new es.upm.etsiinf.sos.model.xsd.Book());
        String[] authors = {"autor1", "autor2"};
        addBook.getArgs0().setAuthors(authors);
        addBook.getArgs0().setISSN("123456");
        addBook.getArgs0().setName("libro");

        es.upm.etsiinf.sos.AddBookResponse response10 = etsiinf.addBook(addBook);
        System.out.println("Libro añadido: 'libro', '123456', [autor1, autor2] (esperado = true):\t" + response10.get_return().getResponse());
        response10 = etsiinf.addBook(addBook);
        System.out.println("Libro añadido: 'libro', '123456', [autor1, autor2] (esperado = true):\t" + response10.get_return().getResponse());

        addBook.getArgs0().setAuthors(null);
        response10 = etsiinf.addBook(addBook);
        System.out.println("Libro añadido: 'libro', '123456', null (esperado = false):\t" + response10.get_return().getResponse());

        String[] author = {"autor1"};
        addBook.getArgs0().setAuthors(author);
        addBook.getArgs0().setISSN("789012");
        addBook.getArgs0().setName("libro2");
        response10 = etsiinf.addBook(addBook);

        System.out.println("Libro añadido: 'libro2', '789012', [autor1] (esperado = true):\t" + response10.get_return().getResponse());







        System.out.println("\nTesting removeBook");

        es.upm.etsiinf.sos.RemoveBook removeBook = new es.upm.etsiinf.sos.RemoveBook();
        removeBook.setArgs0("123456");
        es.upm.etsiinf.sos.RemoveBookResponse response11 = etsiinf.removeBook(removeBook);
        
        System.out.println("Eliminado libro con ISSN: '123456' (esperado = true):\t" + response11.get_return().getResponse());

        removeBook.setArgs0("111111");
        response11 = etsiinf.removeBook(removeBook);

        System.out.println("Eliminado libro con ISSN: '111111' (esperado = false):\t" + response11.get_return().getResponse());




        System.out.println("\nTesting getBook");

        es.upm.etsiinf.sos.GetBook getBook = new es.upm.etsiinf.sos.GetBook();
        getBook.setArgs0("123456");
        es.upm.etsiinf.sos.GetBookResponse response12 = etsiinf.getBook(getBook);
        System.out.println("Peticion libro con ISSN: '123456':\t");
        System.out.println("nombre esperado = libro:\t" + response12.get_return().getName());
        System.out.println("ISSN esperado = 123456:\t" + response12.get_return().getISSN());
        System.out.println("autor esperado = [autor1, autor2]:\t" + response12.get_return().getAuthors());

        getBook.setArgs0("111111");
        response12 = etsiinf.getBook(getBook);
        System.out.println("Peticion libro con ISSN: '111111': (esprado = null)\t" + response12.get_return());
      
        



        System.out.println("\nTesting listBooks");







        System.out.println("\nTesting getBooksFromAuthor");






        System.out.println("\nTesting borrowBook");







        System.out.println("\nTesting returnBook");







        System.out.println("\nTesting listBorrowedBooks");

        }
}
