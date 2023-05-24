package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class ConnectionDB{
        public Connection connectBD(){
            Connection connection = null;
            try {
                String url = "jdbc:mysql://localhost:3306/ClinicaMedicauser=root&password=1235";
                connection = DriverManager.getConnection(url);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO" +  erro.getMessage());
            }
            return connection;
        }
}
