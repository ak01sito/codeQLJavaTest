import java.sql.*;

public class VulnerableCode {
    public static void main(String[] args) {
        String input = args[0]; // Simulating user input
        String url = "jdbc:mysql://localhost:3306/database";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, 
username, password);
            Statement statement = connection.createStatement();
            
            // Vulnerable SQL query
            String query = "SELECT * FROM users WHERE username = '" + 
input + "'";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                // Process the result set
                String result = resultSet.getString("username");
                System.out.println(result);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

