package demo.java8newfeature.lambda;

public class LambdaExamples {
  public static void main(String[] args) {
    voidMethodWithNoParams();
    System.out.println("----------------");
    voidMethodWithOneParam();
    System.out.println("----------------");
    voidMethodWithTwoParam();
    System.out.println("----------------");
    returnMethodWithTwoParams();
  }

  private static void voidMethodWithNoParams() {
    VoidMethodWithNoParams method = () -> {
      System.out.println("Method with no return and input params");
    };
    VoidMethodWithNoParams method1 = () -> System.out.println("Ignoring {} since we have only 1 line");

    method.printHello();
    method1.printHello();
  }

  private static void voidMethodWithOneParam() {
    VoidMethodWithOneParam method = (input -> {
      System.out.println(input);
    });
    VoidMethodWithOneParam method1 = (input -> System.out.println(input));

    VoidMethodWithOneParam method2 = input -> System.out.println(input);

    method.printInput("Hello");
    method1.printInput("Eazy Bytes");
    method2.printInput("Welcome");
  }

  private static void voidMethodWithTwoParam() {
    VoidMethodWithTwoParams addition = (a, b) -> {
      System.out.println(a + b);
    };
    VoidMethodWithTwoParams mutltiplication = (a, b) -> System.out.println(a * b);

    addition.calculateAndPrint(1, 2);
    mutltiplication.calculateAndPrint(2, 3);
  }

  private static void returnMethodWithTwoParams() {
    ReturnMethodWithTwoParams addition = (a, b) -> {
      return (a + b);
    };
    System.out.println(addition.calculateAndReturn(5, 2));

    ReturnMethodWithTwoParams mutiply = (a, b) -> {
      return (a * b);
    };
    System.out.println(mutiply.calculateAndReturn(4, 4));

    ReturnMethodWithTwoParams division = (a, b) -> {
      return (a / b);
    };
    System.out.println(division.calculateAndReturn(6, 3));
  }
}
