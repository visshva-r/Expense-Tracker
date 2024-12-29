import java.sql.*;
public class ExpenseTracker {
    // Database connection
    static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/expense_tracker","root","visshva@2005");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace();
            return null;
        }
    }

    // Adding transaction
    public static void addTransaction(String category,double amount) {
        String query = "insert into transactions (category,amount,transaction_date) values (?, ?, curdate())";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            if (conn != null) {
                stmt.setString(1,category);
                stmt.setDouble(2,amount);
                stmt.executeUpdate();
                System.out.println("Transaction added successfully!");
            } else {
                System.out.println("Database connection failed!");
            }
        } catch (SQLException e) {
            System.out.println("Error adding transaction!");
            e.printStackTrace();
        }
    }

    // Main function
    public static void main(String[] args) {
    	//Sample transactions
        addTransaction("Mobile phone",79980.50);
        addTransaction("Smart TV",45999);
        addTransaction("CCTV Camera",36750);
    }
}