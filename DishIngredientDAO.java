import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DishIngredientDAO {

    public static void insertDishIngredient(
            int dishId,
            int ingredientId,
            double quantity,
            String unit) throws SQLException {

        String sql = """
            INSERT INTO DishIngredient (id_dish, id_ingredient, quantity_required, unit)
            VALUES (?, ?, ?, ?::unit_type)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dishId);
            ps.setInt(2, ingredientId);
            ps.setDouble(3, quantity);
            ps.setString(4, unit);

            ps.executeUpdate();
        }
    }
}
