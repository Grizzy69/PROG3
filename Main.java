public class Main {
    public static void main(String[] args) {

        try {
            // Dishes
            DishDAO.insertDish("Salade fraîche", "START", 3500.00);
            DishDAO.insertDish("Poulet grillé", "MAIN", 12000.00);
            DishDAO.insertDish("Riz aux légumes", "MAIN", null);

            // Ingredients
            IngredientDAO.insertIngredient("Laitue", 800.00, "VEGETABLE");
            IngredientDAO.insertIngredient("Tomate", 600.00, "VEGETABLE");
            IngredientDAO.insertIngredient("Poulet", 5000.00, "MEAT");

            // Relations Dish ↔ Ingredient
            DishIngredientDAO.insertDishIngredient(1, 1, 0.20, "KG");
            DishIngredientDAO.insertDishIngredient(1, 2, 0.15, "KG");
            DishIngredientDAO.insertDishIngredient(2, 3, 1.00, "KG");

            System.out.println("Insertion réussie ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}