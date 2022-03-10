public class Product {

    private int id;
    private double unitPrice;
    private int discountRate;
    private int unitsInStock;
    private String name;
    private Brand brand;
    private int memorySize;
    private double screenSize;
    private int ramCapacity;

    public Product(int id, double unitPrice, int discountRate, int unitsInStock, String name, Brand brand,
            int memorySize, double screenSize, int ramCapacity) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.unitsInStock = unitsInStock;
        this.name = name;
        this.brand = brand;
        this.memorySize = memorySize;
        this.screenSize = screenSize;
        this.ramCapacity = ramCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

}
