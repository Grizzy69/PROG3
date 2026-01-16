-- ENUMS
CREATE TYPE dish_type AS ENUM ('START', 'MAIN', 'DESSERT');
CREATE TYPE ingredient_category AS ENUM ('VEGETABLE', 'MEAT', 'FRUIT', 'OTHER');
CREATE TYPE unit_type AS ENUM ('PCS', 'KG', 'L');

-- TABLE Dish
CREATE TABLE Dish (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dish_type dish_type NOT NULL,
    selling_price NUMERIC(10,2)
);

-- TABLE Ingredient
CREATE TABLE Ingredient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    category ingredient_category NOT NULL
);

-- TABLE de jointure DishIngredient (ManyToMany)
CREATE TABLE DishIngredient (
    id SERIAL PRIMARY KEY,
    id_dish INT NOT NULL,
    id_ingredient INT NOT NULL,
    quantity_required NUMERIC(10,2) NOT NULL,
    unit unit_type NOT NULL,

    CONSTRAINT fk_dish FOREIGN KEY (id_dish) REFERENCES Dish(id),
    CONSTRAINT fk_ingredient FOREIGN KEY (id_ingredient) REFERENCES Ingredient(id),
    CONSTRAINT unique_dish_ingredient UNIQUE (id_dish, id_ingredient)
);