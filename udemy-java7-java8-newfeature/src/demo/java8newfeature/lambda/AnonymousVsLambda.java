package demo.java8newfeature.lambda;

public class AnonymousVsLambda {
  public static void main(String[] args) {
    AnonymousVsLambda lambda = new AnonymousVsLambda();
    lambda.sum();
  }

  int sum = 0;

  public void sum() {
    int tempSum = 0;
    ArithmeticOperation arithmeticOperation = (a, b) -> {
      int sum = 0;
      // tempSum = 0; // Compilation error.
      this.sum = a + b;
      System.out.println("The value of sum inside lambda is: " + sum);
      return this.sum;
    };
    System.out.println("The sum of given 2 numbers is : " + arithmeticOperation.performOperation(10, 20));
  }
}
