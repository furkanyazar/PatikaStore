import java.util.ArrayList;
import java.util.List;

public class ProductManager<T extends Product> {

    private List<T> products = new ArrayList<>();

    public List<T> getProducts() {
        return products;
    }

    public T getProductById(int id) {
        T product = null;

        for (T t : products)
            if (t.getId() == id)
                product = t;

        return product;
    }

    public List<T> getProductsByBrand(Brand brand) {
        List<T> productsByBrand = null;

        for (T t : products)
            if (t.getBrand() == brand) {
                if (productsByBrand == null)
                    productsByBrand = new ArrayList<>();

                productsByBrand.add(t);
            }

        return productsByBrand;
    }

    public boolean addProduct(T t) {
        return products.add(t);
    }

    public boolean removeProduct(int id) throws Exception {
        if (getProductById(id) == null)
            throw new Exception("Phone not found");

        products.remove(getProductById(id));

        return true;
    }

}
