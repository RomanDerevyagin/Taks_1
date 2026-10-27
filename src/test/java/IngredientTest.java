import org.junit.jupiter.api.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    @Test
    void testGetNameIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
        String name = ingredient.getName();
        assertEquals("кетчуп",name);
    }
    @Test
    void testGetPriceIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
        float  price = ingredient.getPrice();
        assertEquals(25,price);
    }
    @Test
    void testGetIngredientType(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
        IngredientType type = ingredient.getType();
        assertEquals(SAUCE, type);
    }
}

