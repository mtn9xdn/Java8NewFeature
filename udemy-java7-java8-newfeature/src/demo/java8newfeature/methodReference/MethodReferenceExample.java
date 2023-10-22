package demo.java8newfeature.methodReference;

import demo.java8newfeature.lambda.ArithmeticOperation;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceExample {
  public static void main(String[] args) {
    staticMethodReference();
    System.out.println("-------------");
    instanceMethodObjReference();
    System.out.println("-------------");
    instanceMethodWithClassName();
    System.out.println("-------------");
    constructorReference();
  }

  private static void staticMethodReference() {
    ArithmeticOperation operation = (a, b) -> {
      int sum = a + b;
      System.out.println("The sum of given input values using lambda is : " + sum);
      return sum;
    };
    operation.performOperation(10, 20);

    ArithmeticOperation methodRef = MethodReferenceExample::performAddition;
    methodRef.performOperation(10, 20);
  }

  private static void instanceMethodObjReference() {
    ArithmeticOperation operation = (a, b) -> {
      int sum = a + b;
      System.out.println("The sum of given input values using lambda is : " + sum);
      return sum;
    };
    operation.performOperation(20, 30);
    MethodReferenceExample methodRef = new MethodReferenceExample();
    ArithmeticOperation instanceMethod = methodRef::performAddition2;
    instanceMethod.performOperation(20, 30);
  }

  private static void instanceMethodWithClassName() {
    List<String> departmentList = new ArrayList<>();
    departmentList.add("Samsung");
    departmentList.add("Apply");
    departmentList.add("Nokia");
    departmentList.add("Sony");
    System.out.println("List mobile with lambda :");
    departmentList.forEach(s -> System.out.println(s));

    System.out.println("List mobile with instance method with Class name :");
    departmentList.forEach(System.out::println);
  }

  private static void constructorReference() {
    ProductInterface productUsingLambda = (name, price) -> new Product(name, price);
    Product prodSamsung = productUsingLambda.getProduct("Samsung Galaxy", 1000);
    System.out.println("Product Using Lambda : " + prodSamsung.toString());

    ProductInterface productUsingRef = Product::new;
    Product prodApple = productUsingRef.getProduct("Apple Iphone", 1500);
    System.out.println("Product Using Constructor Reference : " + prodApple.toString());
  }

  private static int performAddition(int a, int b) {
    int sum = a + b;
    System.out.println("The sum of given input values using static method reference is : " + sum);
    return sum;
  }

  private int performAddition2(int a, int b) {
    int sum = a + b;
    System.out.println("The sum of given input values using instance method reference is : " + sum);
    return sum;
  }
}
