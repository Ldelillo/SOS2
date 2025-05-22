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

        System.out.println("Usuario test1 añadido (esperado = true):\t" + response0.get_return().getResult());

        response0 = skeleton.addUser(addUser);

        System.out.println("Usuario test1 añadido de nuevo (esperado = false):\t" + response0.get_return().getResult());

        addUser.getUser().setName("test2");
        response0 = skeleton.addUser(addUser);

        System.out.println("Usuario test2 añadido (esperado = true):\t" + response0.get_return().getResult());

        System.out.println("Testing addUser");

        es.upm.fi.sos.t3.backend.ExistUser existUser = new es.upm.fi.sos.t3.backend.ExistUser();
        existUser.setUsername(new es.upm.fi.sos.t3.backend.xsd.Username());
        existUser.getUsername().setName("test");
        es.upm.fi.sos.t3.backend.ExistUserResponse response1 = skeleton.existUser(existUser);

        System.out.println("Existe usuario 'test' (esperado = false):\t" + response1.get_return().getResult());

        existUser.getUsername().setName("test1");
        response1 = skeleton.existUser(existUser);

        System.out.println("Existe usuario 'test1' (esperado = true):\t" + response1.get_return().getResult());


        }
}
