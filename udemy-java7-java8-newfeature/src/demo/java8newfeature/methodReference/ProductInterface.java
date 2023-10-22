package demo.java8newfeature.methodReference;

@FunctionalInterface
public interface ProductInterface {
  Product getProduct(String name, int price);
}
