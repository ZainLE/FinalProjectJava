package decentralisedfinance;
public class Trade {
    private String source;
    private String side;
    private int size;
    private double price;
    private String productID;

    public Trade(String source, String side, int size, double price, String productID) {
        this.source = source;
        this.side = side;
        this.size = size;
        this.price = price;
        this.productID = productID;
    }

    public String getSource() {
        return source;
    }

    public String getSide() {
        return side;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getProductID() {
        return productID;
    }
