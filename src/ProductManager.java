import java.util.ArrayList;
import java.util.List;

public class ProductManager<T> {

    private List<T> products = new ArrayList<>();

    public List<T> getProducts() {
        return products;
    }

    public T getProductById(int id) {
        return products.get(id - 1);
    }

    public T getProductByBrand(Brand brand) {
        return products.get(products.indexOf(brand));
    }

    public boolean addProduct(T t) {
        return products.add(t);
    }

    public boolean removeProduct(int id) throws Exception {
        if (getProductById(id) == null)
            throw new Exception("Wrong ID!");

        products.remove(id - 1);

        return true;
    }

}
