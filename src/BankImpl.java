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
import java.rmi.server.*;
import java.sql.*;
import java.util.*;
class BankImpl implements Bank {
    BankImpl() throws RemoteException {
    }

    public List<Customer> getCustomers() {
        List<Customer> list = new ArrayList<Customer>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/bank_rmi?characterEncoding=latin1&useConfigs=maxPerformance","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from customer");
            //PreparedStatement ps=con.prepareStatement("select * from customer");
            //ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Customer c=new Customer();
                c.setAcc_no(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAmount(rs.getFloat(5));
                list.add(c);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
}
