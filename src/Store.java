import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Store {

    Scanner scanner = new Scanner(System.in);
    BrandManager brandManager = new BrandManager();
    ProductManager<Phone> phoneManager = new ProductManager<>();
    ProductManager<Notebook> notebookManager = new ProductManager<>();

    public void start() {
        int selectedOption = -1;

        while (true) {
            System.out.println();
            System.out.println("PatikaStore Product Management Panel");
            System.out.println("1 -> Notebook Operations");
            System.out.println("2 -> Phone Operations");
            System.out.println("3 -> List Brands");
            System.out.println("0 -> Exit");
            System.out.print("Your choice: ");

            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }

            switch (selectedOption) {
                case 1:
                    notebookOperations();
                    continue;
                case 2:
                    phoneOperations();
                    continue;
                case 3:
                    listBrands();
                    continue;
                case 0:
                    System.exit(0);
                default:
                    continue;
            }
        }
    }

    public void listBrands() {
        System.out.println();
        System.out.println("Brands");
        System.out.println("------------");

        for (Brand brand : brandManager.getBrands())
            System.out.println("- " + brand.getName());

        System.out.println();
        System.out.print("Press enter to continue");
        scanner.nextLine();
    }

    public Brand listBrandsForAddProduct() {
        int selectedOption = -1;

        while (true) {
            System.out.println();
            System.out.println("Select brand");
            System.out.println("------------------------");

            List<Brand> brands = brandManager.getBrands();
            brands.sort(new Comparator<Brand>() {
                @Override
                public int compare(Brand o1, Brand o2) {
                    return o1.getId() - o2.getId();
                }
            });

            for (Brand brand : brands)
                System.out.println(brand.getId() + " -> " + brand.getName());

            System.out.println("0 -> Go to back");
            System.out.print("Your choice: ");

            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }

            if (selectedOption < 0 || selectedOption > brandManager.getBrands().size())
                continue;

            break;
        }

        if (selectedOption == 0)
            return null;

        return brandManager.getBrandById(selectedOption);
    }

    public void phoneOperations() {
        int selectedOption = -1;

        while (true) {
            System.out.println();
            System.out.println("Phone Operations");
            System.out.println("--------------------------------");
            System.out.println("1 -> Add new phone");
            System.out.println("2 -> Delete phone by Id");
            System.out.println("3 -> List phones");
            System.out.println("4 -> List phones by brand");
            System.out.println("5 -> Get phone by Id");
            System.out.println("0 -> Go to back");
            System.out.print("Your choice: ");

            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }

            switch (selectedOption) {
                case 1:
                    Brand brand = listBrandsForAddProduct();

                    if (brand != null)
                        enterPhoneInfo(brand);

                    continue;
                case 2:
                    Phone phone = listPhonesForDelete();

                    if (phone != null) {
                        try {
                            phoneManager.removeProduct(phone.getId());
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }

                    continue;
                case 3:
                    listPhones();
                    continue;
                case 4:
                    listPhonesByBrand();
                    continue;
                case 5:
                    getPhoneById();
                    continue;
                case 0:
                    return;
                default:
                    continue;
            }
        }
    }

    public void notebookOperations() {

    }

    public void getPhoneById() {
        Phone phone = listPhonesForDelete();

        System.out.println();
        System.out.println("- " + phone.getName() + " | " + phone.getUnitPrice() + " TL | "
                + phone.getBrand().getName() + " | " + phone.getMemorySize() + " GB | " + phone.getScreenSize()
                + "\" | " + phone.getBatteryPower() + " mAh | " + phone.getRamCapacity() + " GB | "
                + phone.getColor());

        System.out.println();
        System.out.print("Press enter to continue");
        scanner.nextLine();
    }

    public void listPhonesByBrand() {
        Brand brand = listBrandsForAddProduct();

        System.out.println();
        System.out.println("Phones by " + brand.getName());
        System.out.println("---------------------------");

        for (Phone phone : phoneManager.getProductsByBrand(brand))
            System.out.println("- " + phone.getName() + " | " + phone.getUnitPrice() + " TL | "
                    + phone.getBrand().getName() + " | " + phone.getMemorySize() + " GB | " + phone.getScreenSize()
                    + "\" | " + phone.getBatteryPower() + " mAh | " + phone.getRamCapacity() + " GB | "
                    + phone.getColor());

        System.out.println();
        System.out.print("Press enter to continue");
        scanner.nextLine();
    }

    public void listPhones() {
        System.out.println();
        System.out.println("Phones");
        System.out.println("------------");

        for (Phone phone : phoneManager.getProducts())
            System.out.println("- " + phone.getName() + " | " + phone.getUnitPrice() + " TL | "
                    + phone.getBrand().getName() + " | " + phone.getMemorySize() + " GB | " + phone.getScreenSize()
                    + "\" | " + phone.getBatteryPower() + " mAh | " + phone.getRamCapacity() + " GB | "
                    + phone.getColor());

        System.out.println();
        System.out.print("Press enter to continue");
        scanner.nextLine();
    }

    public Phone listPhonesForDelete() {
        int selectedOption = -1;

        while (true) {
            System.out.println();
            System.out.println("Select phone");
            System.out.println("------------------------");

            for (Phone phone : phoneManager.getProducts())
                System.out.println(phone.getId() + " -> " + phone.getName() + " | " + phone.getUnitPrice() + " TL | "
                        + phone.getBrand().getName() + " | " + phone.getMemorySize() + " GB | " + phone.getScreenSize()
                        + "\" | " + phone.getBatteryPower() + " mAh | " + phone.getRamCapacity() + " GB | "
                        + phone.getColor());

            System.out.println("0 -> Go to back");
            System.out.print("Your choice: ");

            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }

            if (selectedOption < 0 || selectedOption > phoneManager.getProducts().size())
                continue;

            break;
        }

        if (selectedOption == 0)
            return null;

        return phoneManager.getProductById(selectedOption);
    }

    public void enterPhoneInfo(Brand brand) {
        double unitPrice = 0.0;
        int discountRate = -1;
        int unitsInStock = 0;
        String name = "";
        int memorySize = 0;
        double screenSize = 0.0;
        int ramCapacity = 0;
        int batteryPower = 0;
        String color = "";

        System.out.println();
        System.out.println("Phone Informations");
        System.out.println("------------------------------------");

        unitPrice = scanNextDouble("Unit price", unitPrice);

        while (true) {
            System.out.print("Discount rate: ");

            try {
                if (discountRate < 0) {
                    discountRate = Integer.parseInt(scanner.nextLine());
                    if (discountRate >= 0)
                        break;
                }
            } catch (Exception e) {
                continue;
            }
        }

        unitsInStock = scanNextInt("Units in stock", unitsInStock);
        name = scanNextString("Name", name);
        memorySize = scanNextInt("Memory size", memorySize);
        screenSize = scanNextDouble("Screen size", screenSize);
        ramCapacity = scanNextInt("Ram capacity", ramCapacity);
        batteryPower = scanNextInt("Battery power", batteryPower);
        color = scanNextString("Color", color);

        phoneManager.addProduct(
                new Phone(phoneManager.getProducts().size() + 1, unitPrice, discountRate, unitsInStock, name, brand,
                        memorySize, screenSize, ramCapacity, batteryPower, color));
    }

    public int scanNextInt(String property, int value) {
        while (true) {
            System.out.print(property + ": ");

            try {
                if (value <= 0) {
                    value = Integer.parseInt(scanner.nextLine());
                    if (value > 0)
                        break;
                } else {
                    System.out.println();
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }

        return value;
    }

    public String scanNextString(String property, String value) {
        while (true) {
            System.out.print(property + ": ");

            try {
                if (value.length() <= 0) {
                    value = scanner.nextLine();
                    if (value.length() > 0)
                        break;
                } else {
                    System.out.println();
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }

        return value;
    }

    public Double scanNextDouble(String property, Double value) {
        while (true) {
            System.out.print(property + ": ");

            try {
                if (value <= 0) {
                    value = Double.parseDouble(scanner.nextLine());
                    if (value > 0)
                        break;
                } else {
                    System.out.println();
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }

        return value;
    }

}
