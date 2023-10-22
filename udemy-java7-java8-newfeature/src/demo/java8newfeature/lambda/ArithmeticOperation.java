package demo.java8newfeature.lambda;

@FunctionalInterface
public interface ArithmeticOperation extends ArithmeticOperation2{
// Phải chứa 1 abstract method or phải exends 1 functional interface khác có chứa 1 abtract method.
// Nếu có chứa abstract method và extends 1 functional interface khác cũng chứa abstract method thì abstract method đó phải giống nhau.
  int performOperation(int a, int b);

  default void performAdd(int a, int b) {
    int res = addTwoNum(a, b);
    printTheInput(res);
  }

  private int addTwoNum(int a, int b) {
    return a + b;
  }
  static void printTheInput(int res) {
    System.out.println(res);
  }
}
