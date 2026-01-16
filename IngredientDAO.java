import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredientDAO {

    public static void insertIngredient(String name, double price, String category) throws SQLException {
        String sql = "INSERT INTO Ingredient (name, price, category) VALUES (?, ?, ?::ingredient_category)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, category);

            ps.executeUpdate();
        }
    }
}