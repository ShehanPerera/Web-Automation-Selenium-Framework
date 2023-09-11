package utillities;

import org.testng.asserts.SoftAssert;

public class SharedData {
    private static SharedData instance = new SharedData();
    private String itemName;
    private String itemPrice;
    private int quantity;
    private SoftAssert softAssert = new SoftAssert();

    public static SharedData getInstance() {
        return instance;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SoftAssert getSoftAssert(){
        return softAssert;
    }


}
