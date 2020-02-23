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
import java.util.*;

interface Bank extends Remote{
    public List<Customer> getCustomers()throws RemoteException;
}
