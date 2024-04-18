package pt.ipbeja.po2.vendingmachine.app.model;

public class Dispenser {

    private int insertedMoney;
    private int productPrice;
    private int salesMoney;
    private int change;
    private int nProducts;
    private int absentMoney;

    public void setnProducts(int newProductQuantity) {
        this.nProducts = newProductQuantity;
    }
    public int getnProducts() {
        return nProducts;
    }
    public int getSalesMoney() {
        return salesMoney;
    }

    public void setProductPrice(int newProductPrice) {
        this.productPrice = newProductPrice;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public Dispenser(int productPrice, int nProducts) {
        this.nProducts = nProducts;
        this.insertedMoney = 0;
        this.productPrice = productPrice;
        this.salesMoney = 0;
    }

    public int insertCoin(int coin) {
        this.insertedMoney += coin;
        return insertedMoney;
    }

    public int cancel() {
        change = insertedMoney;
        insertedMoney = 0;
        return change;
    }

    public int buyProduct() {
        if(insertedMoney >= productPrice && nProducts != 0) {
            change = insertedMoney - productPrice;
            nProducts--;
            this.salesMoney += productPrice;
            insertedMoney = 0;
        }
        return change;
    }

    public int buyProductFailed() {
        this.absentMoney = insertedMoney - productPrice;
        return absentMoney;
    }
}
