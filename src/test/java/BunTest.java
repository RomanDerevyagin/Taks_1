import praktikum.Bun;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BunTest {
    @Test
    void testGetName(){
        Bun bun = new Bun("Булочка-тестик",25);
        String name = bun.getName();
        assertEquals("Булочка-тестик",name);
    }
    @Test
    void testGetPrice(){
        Bun bun = new Bun("Булочка-тестик",25);
        float  price = bun.getPrice();
        assertEquals(25,price);
    }
}

