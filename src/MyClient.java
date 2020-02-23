/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Target01
 */
import java.util.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient{
    public static void main(String args[])throws Exception{
        
        System.setProperty("java.security.policy","file:///C:/Users/Target01/Documents/NetBeansProjects/RMI_GUI/java.policy.applet");
                
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
/*        
        Bank b=(Bank)Naming.lookup("rmi://192.168.43.8:6666/RMI_GUI");

        List<Customer> list=b.getCustomers();
        for(Customer c:list){
            System.out.println(c.getAcc_no()+" "+c.getFirstname()+" "+c.getLastname()+" "+c.getEmail()+" "+c.getAmount());
        }
*/
        String name = "RMI_GUI";
        String serverIP = "192.168.43.8";
        int serverPort = 6666;
        Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
        Bank b = (Bank) registry.lookup(name);
        
        List<Customer> list=b.getCustomers();
        for(Customer c:list){
            System.out.println(c.getAcc_no()+" "+c.getFirstname()+" "+c.getLastname()+" "+c.getEmail()+" "+c.getAmount());
        }
    }
}
