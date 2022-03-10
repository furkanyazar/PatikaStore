import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BrandManager {
    private List<Brand> brands = new ArrayList<>();

    public BrandManager() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        brands.sort(new Comparator<Brand>() {
            @Override
            public int compare(Brand o1, Brand o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public Brand getBrandById(int id) {
        return brands.get(id - 1);
    }
}
