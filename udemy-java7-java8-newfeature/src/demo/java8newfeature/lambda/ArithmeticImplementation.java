package demo.java8newfeature.lambda;

public class ArithmeticImplementation {
  public static void main(String[] args) {
    int firstInt = 10, secondInt = 6;

    ArithmeticOperation oldsum = (a, b) -> a + b;
    ArithmeticOperation multi = (a, b) -> a * b;
    ArithmeticOperation sub = (a, b) -> a / b;

    System.out.println("The sum of two input integers with out lambda is : " + oldsum.performOperation(firstInt, secondInt));
    System.out.println("The multi of two input integers with out lambda is : " + multi.performOperation(firstInt, secondInt));
    System.out.println("The sub of two input integers with out lambda is : " + sub.performOperation(firstInt, secondInt));
  }
}
