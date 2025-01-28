package interfaces;

public interface OnlineStore {
    public void goToSearchPage(String productName);
    public void searchProduct(String productName);
    public void clickSearchButton();
    public double getProductPrice();
    public String getProductUrl();
}