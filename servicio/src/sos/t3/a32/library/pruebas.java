package sos.t3.a32.library;

import java.util.Arrays;

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
        System.out.println("Cierre sesion 'Usuario1' en la misma otra instancia (false):\t" + responseLogout.get_return().getResponse());

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
        System.out.println("Cambiando pwd de 'User2' de: "+ pwd2 + "a 'patata':\t" + responseChangepwd.get_return().getResponse());

        
        responseChangepwd = stub3.changePassword(changePassword);
        System.out.println("Cambiando pwd de 'User3' de: "+ pwd2 + "a 'patata' (false):\t" + responseChangepwd.get_return().getResponse());

        responseLogout = stub2.logout(logout);
        System.out.println("Cierre seison 'Usuario2':\t" + responseLogout.get_return().getResponse());
        login.getArgs0().setName("Usuario2");
        login.getArgs0().setPwd("patata");
        responseLogin = stub2.login(login);
        System.out.println("Iniciado sesion 'Usuario2' con nueva contraseña 'patata':\t" + responseLogin.get_return().getResponse());

        login.getArgs0().setPwd(pwd2);
        responseLogin = stub1.login(login);
        System.out.println("Iniciado sesion 'Usuario2' con antigua contraseña '"+ pwd2 + "'(false):\t" + responseLogin.get_return().getResponse());



        System.out.println("\n\nAÑADIENDO LIBROS");
        AddBook addBook = new AddBook();
        addBook.setArgs0(new Book());
        AddBookResponse responseAddbook;

        String[] authors = {"Autor1", "Autor2"};
        String[] author1 = {"Autor1"};
        String[] author2 = {"Author2"};
        String[] author3 = {"Author3"};

        int i = 0;
        int j;

        while(i<3){

            addBook.getArgs0().setAuthors(author1);
            addBook.getArgs0().setISSN("0001");
            addBook.getArgs0().setName("Libro001");

            responseAddbook = stubAdmin.addBook(addBook);

            System.out.println("Añadiendo ejemplar "+ (i+1) +" de 'Libro001', ISSN = 0001, autores = " + Arrays.toString(author1) + ":\t" + responseAddbook.get_return().getResponse());

            i++;
        }

        i = 0;
        j = 2;
        while(i<3){

            addBook.getArgs0().setAuthors(author2);
            addBook.getArgs0().setISSN("000" + j);
            addBook.getArgs0().setName("Libro00" + j);

            responseAddbook = stubAdmin.addBook(addBook);

            System.out.println("Añadiendo ejemplar "+ (i+1) +" de 'Libro00'"+ j +", ISSN = 000"+ j +", autores = " + Arrays.toString(author2) + ":\t" + responseAddbook.get_return().getResponse());

            i++;
            j++;
        }


        addBook.getArgs0().setAuthors(author3);
        addBook.getArgs0().setISSN("000" + j);
        addBook.getArgs0().setName("Libro00" + j);
        j++;

        responseAddbook = stubAdmin.addBook(addBook);

        System.out.println("Añadiendo ejemplar 1 de 'Libro00'"+ j +", ISSN = 000"+ j +", autores = " + Arrays.toString(author3) + ":\t" + responseAddbook.get_return().getResponse());


        addBook.getArgs0().setAuthors(authors);
        addBook.getArgs0().setISSN("000" + j);
        addBook.getArgs0().setName("Libro00" + j);
        j++;

        responseAddbook = stubAdmin.addBook(addBook);

        System.out.println("Añadiendo ejemplar 1 de 'Libro00'"+ j +", ISSN = 000"+ j +", autores = " + Arrays.toString(authors) + ":\t" + responseAddbook.get_return().getResponse());














        System.out.println("\n\n OBTENIENDO LIBROS INDIVIDUALES");

        GetBook getbook = new GetBook();
        GetBookResponse responseGetbook = new GetBookResponse();
        i = 1;
        while(i<=j){
            getbook.setArgs0("000" + i);
            responseGetbook = stubAdmin.getBook(getbook);
            System.out.println(responseGetbook.get_return().getName() + ":\nISSN:\t" + responseGetbook.get_return().getISSN()+
            "\nAutores:\t" + Arrays.toString(responseGetbook.get_return().getAuthors()));
            i++;
        }




        System.out.println("\n\nOBTENIENDO LISTAS DE LIBROS");

        ListBooks listbooks = new ListBooks();
        ListBooksResponse responselistbooks = stub2.listBooks(listbooks);
        if(responselistbooks.get_return().getResult()){
            String[] nombres = responselistbooks.get_return().getBookNames();
            String[] issns = responselistbooks.get_return().getIssns();
            j = responselistbooks.get_return().getBookNames().length;
            i = 0;
            while(i<j){
                System.out.println(nombres[i] + "\t" + issns[i]);
                i++;
            }         
        }
        else{
            System.out.println("Error sesion no iniciada");
        }

        responselistbooks = stub1.listBooks(listbooks);
        System.out.println("Intentando pedir lista de libros sin iniciar sesion(false):\t" + responselistbooks.get_return().getResult());














        System.out.println("\n\nOBTENIENDO LIBROS DE AUTORES");
        GetBooksFromAuthor getBooksFromAuthor = new GetBooksFromAuthor();
        getBooksFromAuthor.setArgs0(new Author());
        getBooksFromAuthor.getArgs0().setName(author1[0]);
        GetBooksFromAuthorResponse responsebooksfromauthor = stub2.getBooksFromAuthor(getBooksFromAuthor);
        
        if(responsebooksfromauthor.get_return().getResult()){
            String[] nombres = responsebooksfromauthor.get_return().getBookNames();
            String[] issns = responsebooksfromauthor.get_return().getIssns();
            j = responsebooksfromauthor.get_return().getBookNames().length;
            i = 0;
            while(i<j){
                System.out.println(nombres[i] + "\t" + issns[i]);
                i++;
            }      
        }
        else{
            System.out.println("Error sesion no iniciada");
        }
        responsebooksfromauthor = stub1.getBooksFromAuthor(getBooksFromAuthor);
        System.out.println("Intentando pedir lista de libros sin iniciar sesion(false):\t" + responsebooksfromauthor.get_return().getResult());








        System.out.println("\n\nPRESTANDO LIBROS");
        BorrowBook borrowBook = new BorrowBook();
        BorrowBookResponse responseborrowbook;

        borrowBook.setArgs0("0001");
        responseborrowbook = stub1.borrowBook(borrowBook);
        System.out.println("Intentando pedir prestado sin iniciar sesion (false):\t" + responseborrowbook.get_return().getResponse());

        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Prestado libro ISSN: '0001':\t" + responseborrowbook.get_return().getResponse());

        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Intentando pedir prestado libro ISSN: '0001' de nuevo extistiendo mas ejemplares (false):\t" + responseborrowbook.get_return().getResponse());


        borrowBook.setArgs0("0002");
        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Prestado libro ISSN: '0002':\t" + responseborrowbook.get_return().getResponse());

        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Intentando pedir prestado libro ISSN: '0002' de nuevo sin existir mas ejemplares (false):\t" + responseborrowbook.get_return().getResponse());

        responseborrowbook = stub3.borrowBook(borrowBook);
        System.out.println("Intentando pedir prestado libro ISSN: '0002' de nuevo sin existir mas ejemplares desde otra instancia(false):\t" + responseborrowbook.get_return().getResponse());

        borrowBook.setArgs0("0003");
        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Prestado libro ISSN: '0003':\t" + responseborrowbook.get_return().getResponse());

        borrowBook.setArgs0("9999");
        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Intentando pedir prestado libro ISSN: '9999' de nuevo sin existir el libro (false):\t" + responseborrowbook.get_return().getResponse());








        System.out.println("\n\nOBTENIENDO LISTAS DE LIBROS PRESTADOS");
        ListBorrowedBooks listBorrowedBooks = new ListBorrowedBooks();
        ListBorrowedBooksResponse responselListBorrowedBooks;

        responselListBorrowedBooks = stub1.listBorrowedBooks(listBorrowedBooks);
        System.out.println("Intentando pedir lista de libros prestados sin iniciar sesion (false):\t" + responselListBorrowedBooks.get_return().getResult());

        responselListBorrowedBooks = stub3.listBorrowedBooks(listBorrowedBooks);
        System.out.println("Intentando pedir lista de libros prestados sin tener libros prestados:\t" + responselListBorrowedBooks.get_return().getResult());
        
        if(responselListBorrowedBooks.get_return().getResult()){
            String[] names = responselListBorrowedBooks.get_return().getBookNames();
            String[] issns = responselListBorrowedBooks.get_return().getIssns();
            i = 0;
            j = responselListBorrowedBooks.get_return().getBookNames().length;
            while(i<j){
            System.out.println(names[i] + "\t" + issns[i]);
            i++;
        }
        }
        
        responselListBorrowedBooks = stub1.listBorrowedBooks(listBorrowedBooks);
        //TODO: mirame esto que este bien @sersayen
        System.out.println("Pidiendo lista de libros prestados:\t" + responselListBorrowedBooks.get_return().getResult());
        
        if(responselListBorrowedBooks.get_return().getResult()){
            String[] names = responselListBorrowedBooks.get_return().getBookNames();
            String[] issns = responselListBorrowedBooks.get_return().getIssns();
            i = 0;
            j = responselListBorrowedBooks.get_return().getBookNames().length;
            while(i<j){
            System.out.println(names[i] + "\t" + issns[i]);
            i++;
        }
        }
        
        





        System.out.println("\n\nDEVOLVIENDO LIBROS");
        ReturnBook returnBook = new ReturnBook();
        ReturnBookResponse responseReturnBook;

        returnBook.setArgs0("0005");
        responseReturnBook = stub1.returnBook(returnBook);
        System.out.println("Intentando devolver libro sin iniciar sesion (false):\t" + responseReturnBook.get_return().getResponse());

        responseReturnBook = stub3.returnBook(returnBook);
        System.out.println("Intentando devolver libro que no tiene prestado (false):\t" + responseReturnBook.get_return().getResponse());

        returnBook.setArgs0("0002");
        responseReturnBook = stub2.returnBook(returnBook);
        System.out.println("Devuelto libro ISSN '0002':\t" + responseReturnBook.get_return().getResponse());

        returnBook.setArgs0("0002");
        responseReturnBook = stub1.returnBook(returnBook);
        System.out.println("Intentando devolver libro ISSN '0002' de nuevo (false):\t" + responseReturnBook.get_return().getResponse());


        returnBook.setArgs0("0001");
        responseReturnBook = stub2.returnBook(returnBook);
        System.out.println("Devuelto libro ISSN '0001':\t" + responseReturnBook.get_return().getResponse());








System.out.println("\n\nCOMPROBANDO PERMISOS DE ADMIN");

        adduser.getArgs0().setUsername("Usuario99");
        responseAdduser = stub2.addUser(adduser);
        System.out.println("Intentando crear usuario 'Usuario99' desde usuario no admin (false):\t" + responseAdduser.get_return().getResponse());

        responseAdduser = stubAdmin.addUser(adduser);
        System.out.println("Creado usuario 'Usuario99' desde instancia admin:\t" + responseAdduser.get_return().getResponse());

        DeleteUser deleteUser = new DeleteUser();
        deleteUser.setArgs0(new Username());
        DeleteUserResponse responseDeleteuser;

        deleteUser.getArgs0().setUsername("Usuario99");
        responseDeleteuser = stub2.deleteUser(deleteUser);
        System.out.println("Intentando borrar 'Usuario99' desde usuario no admin (false):\t" + responseDeleteuser.get_return().getResponse());

        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Intentando borrar 'Usuario99' desde usuario admin :\t" + responseDeleteuser.get_return().getResponse());



        addBook.getArgs0().setAuthors(author1);
        addBook.getArgs0().setISSN("0999");
        addBook.getArgs0().setName("Libro999");

        responseAddbook = stub2.addBook(addBook);
        System.out.println("Intentando añadir ejemplar de 'Libro999', ISSN = 0999, autores = " + author1 + ", (no admin) (false):\t" + responseAddbook.get_return().getResponse());

        responseAddbook = stubAdmin.addBook(addBook);
        System.out.println("Intentando añadir ejemplar de 'Libro999', ISSN = 0999, autores = " + author1 + ", (admin):\t" + responseAddbook.get_return().getResponse());


        RemoveBook removeBook = new RemoveBook();
        RemoveBookResponse responseRemovebook;

        removeBook.setArgs0("0999");
        responseRemovebook = stub2.removeBook(removeBook);
        System.out.println("Intentando borrar libro de ISSN: '0999' desde usuario no admin:(false)\t" + responseRemovebook.get_return().getResponse());

        responseRemovebook = stubAdmin.removeBook(removeBook);
        System.out.println("Intentando borrar libro de ISSN: '0999' desde usuario admin:\t" + responseRemovebook.get_return().getResponse());










        System.out.println("\n\nBORRANDO LIBROS");

        i = 0;
        removeBook.setArgs0("0001");
        while(i<3){
            responseRemovebook = stubAdmin.removeBook(removeBook);
            System.out.println("Borrado libro ISSN: '0001':\t" + responseRemovebook.get_return().getResponse());
            i++;
        }
        responseRemovebook = stubAdmin.removeBook(removeBook);
        System.out.println("Borrado libro ISSN: '0001':(false)\t" + responseRemovebook.get_return().getResponse());

        removeBook.setArgs0("9999");
        responseRemovebook = stubAdmin.removeBook(removeBook);
        System.out.println("Borrado libro ISSN: '9999':(false)\t" + responseRemovebook.get_return().getResponse());









        System.out.println("\n\nBORRANDO USUARIOS");
        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario1");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario1' con sesion cerrada:\t" + responseDeleteuser.get_return().getResponse());

        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario2");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario2' con sesion abierta y libros prestados(false):\t" + responseDeleteuser.get_return().getResponse());

        returnBook.setArgs0("0003");
        responseReturnBook = stub2.returnBook(returnBook);
        System.out.println("Devuelto libro ISSN '0003':\t" + responseReturnBook.get_return().getResponse());

        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario2' con sesion abierta:\t" + responseDeleteuser.get_return().getResponse());

        borrowBook.setArgs0("0002");
        responseborrowbook = stub2.borrowBook(borrowBook);
        System.out.println("Intentando pedir prestado libro ISSN: '0002 y usuario no existe (false)':\t" + responseborrowbook.get_return().getResponse());


        deleteUser.setArgs0(new Username());
        deleteUser.getArgs0().setUsername("Usuario3");
        responseDeleteuser = stubAdmin.deleteUser(deleteUser);
        System.out.println("Borrando 'Usuario3'sesion abierta:\t" + responseDeleteuser.get_return().getResponse());

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
