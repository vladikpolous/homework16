package ua.com.alevel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
public class Product {
     String name;
     BigDecimal price;
     Category category;

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
    public Product(String name, BigDecimal  price, Category category){
       this.name = name;
       this.price = price;
       this.category = category;
   }


    public static class Category{
         String name;
         long categoryId;
        @Override
        public String toString() {
            return "Category{" +
                    "name='" + name + '\'' +
                    ", categoryId=" + categoryId +
                    '}';
        }
        public Category(String name, long categoryId){
            this.name = name;
            this.categoryId = categoryId;
        }
    }


    public static void main(String[] args) {
        ArrayList<Category> listOfCategory = new ArrayList<>();

        Category beverages = new Category("Beverages",4);
        Category fruits = new Category("Fruit",2);
        Category vegetables = new Category("vegetables",3);
        Category others = new Category("Others",1);

        listOfCategory.add(beverages);
        listOfCategory.add(fruits);
        listOfCategory.add(vegetables);
        listOfCategory.add(others);

        /*Comparator<Product> ProductComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getCategory().categoryId - o2.getCategory().categoryId);
            }
        };
*/
        ArrayList<Product> listOfProduct = new ArrayList<>();
        Product apple = new Product("Apple",new BigDecimal("100.00"),fruits);//3
        Product cola = new Product("Cola",new BigDecimal("50.50"),beverages);//6
        Product tea = new Product("Tea",new BigDecimal("60.40"),beverages);//5
        Product tomato = new Product("tomato",new BigDecimal("70.45"),vegetables);//4
        Product meat = new Product("Meat",new BigDecimal("10"),others);//2
        Product sugar = new Product("Sugar", new BigDecimal("30.35"), others);//1
        listOfProduct.add(apple);
        listOfProduct.add(cola);
        listOfProduct.add(tea);
        listOfProduct.add(tomato);
        listOfProduct.add(meat);
        listOfProduct.add(sugar);
        System.out.println(listOfProduct);
        ProductComparator comparator = new ProductComparator();
        listOfProduct.sort(comparator);
       /* bubbleSort(listOfProduct);*/
        System.out.println(listOfProduct);

    }
    /*public static void bubbleSort(ArrayList<Product> products) {
        int size = products.size();
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (comparator (products.get(j) , products.get(j+1))) {
                    Product temp = products.get(j);
                    products.set(j, products.get(j+1));
                    products.set(j+1, temp);
                }
            }
            }
        }

    private static boolean comparator(Product leftproduct, Product rightProduct) {
        return leftproduct.getCategory().categoryId > rightProduct.getCategory().categoryId;
    }*/
    public static class ProductComparator implements Comparator<Product> {
        @Override
        public int compare(Product leftProduct, Product rightProduct) {
            if (leftProduct.getCategory().categoryId - rightProduct.getCategory().categoryId == 0){
                return rightProduct.getPrice().compareTo(leftProduct.price);
            }else {
            return (int) (leftProduct.getCategory().categoryId - rightProduct.getCategory().categoryId);
            }
        }
    }

}

