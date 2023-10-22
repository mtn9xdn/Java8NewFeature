package demo.java8newfeature.methodReference;

import demo.java8newfeature.lambda.ArithmeticOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * there are 4 types of method references introduced in java 8
 * Static method Reference(Class::staticMethod)
 * Reference to instance method from istance(objRef::instanceMethod)
 * Reference to instance method from class type (Class::instanceMethod)
 * Constructor Reference(Class::new)
 */
public class MethodReference {
  public static void main(String[] args) {
    ArithmeticOperation operation = (a, b) -> {
      int sum = a + b;
      System.out.println("The sum of given input values using lambda is : " + sum);
      return sum;
    };
    operation.performOperation(2, 3);
    System.out.println("----------------");

//  Class::staticMethod
    ArithmeticOperation methodRef = MethodReference::performAddition;
    methodRef.performOperation(2, 3);
    System.out.println("----------------");

//  objRef::instanceMethod
    MethodReference methodRef2 = new MethodReference();
    ArithmeticOperation instanceMethod = methodRef2::performAddition2;
    instanceMethod.performOperation(2, 3);
    System.out.println("----------------");

//   Class::instanceMethod
    List<String> departmentList = new ArrayList<>();
    departmentList.add("Supply");
    departmentList.add("HR");
    departmentList.add("Sales");
    departmentList.add("Marketing");
    departmentList.forEach(s -> System.out.println(s));
    departmentList.forEach(System.out::println);
    System.out.println("----------------");

//   Constructor Reference Class::new
    ProductInterface productInterface = Product::new;
    Product prod = productInterface.getProduct("Apply Iphone", 1500);
    System.out.println(prod.getName());
    System.out.println(prod.getPrice());
  }

  private static int performAddition(int a, int b) {
    int sum = a + b;
    System.out.println("The sum of given input values using static method reference is " + sum);
    return sum;
  }

  private int performAddition2(int a, int b) {
    int sum = a + b;
    System.out.println("The sum of given input values using instance method reference is " + sum);
    return sum;
  }
}
