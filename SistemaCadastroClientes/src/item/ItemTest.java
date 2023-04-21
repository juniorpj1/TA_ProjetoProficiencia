package item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    void testGetNome() {
        Item item = new Item("Arroz", 10.0);
        assertEquals("Arroz", item.getNome());
    }

    @Test
    void testSetNome() {
        Item item = new Item("Arroz", 10.0);
        item.setNome("Feijão");
        assertEquals("Feijão", item.getNome());
    }

    @Test
    void testGetPreco() {
        Item item = new Item("Arroz", 10.0);
        assertEquals(10.0, item.getPreco());
    }

    @Test
    void testSetPreco() {
        Item item = new Item("Arroz", 10.0);
        item.setPreco(15.0);
        assertEquals(15.0, item.getPreco());
    }

    @Test
    void testIsPago() {
        Item item = new Item("Arroz", 10.0);
        assertFalse(item.isPago());
        item.setPago(true);
        assertTrue(item.isPago());
    }

}

