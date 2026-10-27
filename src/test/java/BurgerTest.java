import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import praktikum.Bun;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    Burger burger = new Burger();
    @Test
    void testSetBuns() {
        Bun bun = new Bun("Булочка верхняя",25);
        burger.setBuns(bun);
        assertSame(burger.bun,bun);
    }
    @Test
    void testAddIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.get(burger.ingredients.size() - 1),ingredient);
    }
    @Test
    void testRemoveIngredientIfListEmpty(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
       burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    void testRemoveIngredientIfListIsNotEmpty(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }
    @Test
    void testMoveIngredient(){
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25);
        burger.addIngredient(ingredient);
        Ingredient ingredient1 = new Ingredient(SAUCE,"сырный",35);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        assertEquals(ingredient1, burger.ingredients.get(0));
        assertEquals(ingredient, burger.ingredients.get(1));
    }
    @Mock Bun bun;
    @Test
    @ExtendWith(MockitoExtension.class)
    void testGetPrice() {
        when(bun.getPrice()).thenReturn(100F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(SAUCE,"кетчуп",25F);
        burger.addIngredient(ingredient);
        Ingredient ingredient1 = new Ingredient(SAUCE,"сырный",35F);
        burger.addIngredient(ingredient1);
        assertEquals(260F,burger.getPrice());

    }
    @ParameterizedTest
    @CsvSource({
            "Булочка, 50, 100",
            "Булочка другая, 100, 200"
    })
    void testGetPriceWithParams(String bunName, float bunPrice, float expected) {
        Burger burger = new Burger();
        burger.setBuns(new Bun(bunName, bunPrice));
        assertEquals(expected, burger.getPrice());
    }
    @Test
    void testGetReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("Булочка", 50);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(SAUCE, "кетчуп", 25);
        burger.addIngredient(ingredient);
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Булочка"));
        assertTrue(receipt.contains("sauce кетчуп"));
        assertTrue(receipt.contains("Price:"));
    }
}

