import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DishDAO {

    public static void insertDish(String name, String type, Double price) throws SQLException {
        String sql = "INSERT INTO Dish (name, dish_type, selling_price) VALUES (?, ?::dish_type, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, type);
            if (price != null) {
                ps.setDouble(3, price);
            } else {
                ps.setNull(3, java.sql.Types.NUMERIC);
            }

            ps.executeUpdate();
        }
    }
}