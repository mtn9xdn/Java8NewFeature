package demo.java8newfeature.lambda;

public class HondaExMethodDefaultAndStatic implements VehiclesExMethodDefaultAndStatic {
  @Override
  public int getSpeed() {
    return 100;
  }

  @Override
  public void applyBreak() {
    System.out.println("Breaks applied");
  }

  public static void main(String[] args) {
    HondaExMethodDefaultAndStatic hondaExMethodDefaultAndStatic = new HondaExMethodDefaultAndStatic();
    hondaExMethodDefaultAndStatic.applyBreak();
    VehiclesExMethodDefaultAndStatic.sayHello();
    HondaExMethodDefaultAndStatic.sayHello();
  }

  private static void sayHello() {
    System.out.println("Hello");
  }
}
