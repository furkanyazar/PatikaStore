import java.util.Scanner;

public class Store {

    Scanner scanner = new Scanner(System.in);

    public void start() {
        int selectedOption = -1;

        while (true) {
            System.out.println();
            System.out.println("PatikaStore Product Management Panel");
            System.out.println("1 -> Notebook operations");
            System.out.println("2 -> Mobile phone operations");
            System.out.println("3 -> List brands");
            System.out.println("0 -> Exit");
            System.out.print("Your choice: ");

            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }

            switch (selectedOption) {
                case 1:
                    continue;
                case 2:
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
        BrandManager brandManager = new BrandManager();

        System.out.println();
        System.out.println("Brands");
        System.out.println("------------");

        for (Brand brand : brandManager.getBrands())
            System.out.println("- " + brand.getName());
        
            System.out.println();
            System.out.print("Press enter to continue");
            scanner.nextLine();
    }

}
