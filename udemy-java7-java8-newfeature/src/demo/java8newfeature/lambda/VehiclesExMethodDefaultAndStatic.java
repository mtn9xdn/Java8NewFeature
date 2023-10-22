package demo.java8newfeature.lambda;

public interface VehiclesExMethodDefaultAndStatic {
  int getSpeed();

  void applyBreak();

//  Ko bắt buộc phải override method default của interface
  default void autoPilot() {
    System.out.println("I will help in driving with out manual support");
  }

//  Có thêm method static
  static void sayHello(){
    System.out.println("Hi, This is your favorite car");
  }
}
