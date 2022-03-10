public class Phone extends Product {

    private int batteryPower;
    private String color;

    public Phone(int id, double unitPrice, int discountRate, int unitsInStock, String name, Brand brand, int memorySize,
            double screenSize, int ramCapacity, int batteryPower, String color) {
        super(id, unitPrice, discountRate, unitsInStock, name, brand, memorySize, screenSize, ramCapacity);
        this.batteryPower = batteryPower;
        this.color = color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
