package pt.ipbeja.po2.vendingmachine.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispenserTest {

    @Test
    void testInsertCoin() {
        Dispenser dispenser =  new Dispenser(40, 40);
        int balance = dispenser.insertCoin(20);
        assertEquals(20, balance);
        balance = dispenser.insertCoin(10);
        assertEquals(30, balance);
    }

    @Test
    void testCancel() {
        Dispenser dispenser = new Dispenser(40, 40);
        dispenser.insertCoin(50);
        int productQuantity = dispenser.getnProducts();
        assertEquals(40, productQuantity);
        int balance = dispenser.cancel();
        assertEquals(50, balance);
        productQuantity = dispenser.getnProducts();
        assertEquals(40, productQuantity);
    }

    @Test
    void testBuyProduct() {
        Dispenser dispenser = new Dispenser(40, 40);
        dispenser.insertCoin(90);
        int productQuantity = dispenser.getnProducts();
        assertEquals(40, productQuantity);
        int change = dispenser.buyProduct();
        assertEquals(50, change);
        productQuantity = dispenser.getnProducts();
        assertEquals(39, productQuantity);
        int salesmoney = dispenser.getSalesMoney();
        assertEquals(40, salesmoney);
        dispenser.insertCoin(200);
        change = dispenser.buyProduct();
        assertEquals(160, change);
        salesmoney = dispenser.getSalesMoney();
        assertEquals(80, salesmoney);
    }

    @Test
    void testBuyProductFailed() {
    Dispenser dispenser = new Dispenser(40, 40);
    dispenser.insertCoin(30);
    int absentMoney = dispenser.buyProductFailed();
    assertEquals(-10, absentMoney);
    int ProductQuantity = dispenser.getnProducts();
    assertEquals(40, ProductQuantity);
    int SalesMoney = dispenser.getSalesMoney();
    assertEquals(0, SalesMoney);
    }

    @Test
    void testSetProductPrice() {
        Dispenser dispenser = new Dispenser(40, 40);
        dispenser.setProductPrice(50);
        int NewProductPrice = dispenser.getProductPrice();
        assertEquals(50, NewProductPrice);
    }

    @Test
    void testSetProductQuantity() {
        Dispenser dispenser = new Dispenser(40, 40);
        dispenser.setnProducts(30);
        int newProductQuantity = dispenser.getnProducts();
        assertEquals(30, newProductQuantity);

    }
}