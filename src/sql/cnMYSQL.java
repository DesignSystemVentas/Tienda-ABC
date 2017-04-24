/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JOSHUA
 */
public class cnMYSQL {
      Connection connection= null;
    static cnMYSQL instance=null;

    public cnMYSQL() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda2","root","pelon1976");
    }
    public static cnMYSQL getIntance() throws Exception{
        if(instance==null){
            instance=new cnMYSQL();
        }
        return instance;
    }
    @Override
    public void finalize()throws Exception{
        if(connection.isClosed()){
            connection=null;
            connection.isClosed();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
}
