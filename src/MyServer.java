/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Target01
 */
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class MyServer{
    public static void main(String args[])throws Exception{
        
/*        System.setProperty("java.security.policy","file:///C:/Users/Target01/Documents/NetBeansProjects/RMI_GUI/java.policy.applet");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        Remote r=new BankImpl();
        Naming.rebind("rmi://192.168.43.8:6666/RMI_GUI",r);
 */
        
        System.setProperty("java.security.policy","file:///C:/Users/Target01/Documents/NetBeansProjects/RMI_GUI/java.policy.applet");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        String name = "RMI_GUI";
        Bank engine=new BankImpl();
        Bank stub = (Bank) UnicastRemoteObject.exportObject(engine, 0);
        Registry registry = LocateRegistry.getRegistry(6666);
        System.out.println("Registering Bank Object");
        registry.rebind(name, stub);
        
        
        
    }}
