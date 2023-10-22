package demo.java7newfeature;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchingMultipleExceptions {
  private final static Logger LOGGER = Logger.getLogger(CatchingMultipleExceptions.class.getName());

  public static void main(String[] args) {
    beforeJava7();
    withJava7();
  }

  /**
   * Sample implement before java7
   */
  private static void beforeJava7() {
    int arr[] = {1, 2, 3};
    try {
      for (int i = 0; i < arr.length + 1; i++) {
        System.out.println(arr[i]);
      }
    } catch (NullPointerException nex) {
      LOGGER.log(Level.SEVERE, nex.toString());
    } catch (ArrayIndexOutOfBoundsException aioex) {
      LOGGER.log(Level.SEVERE, aioex.toString());
    }
  }

  /**
   * Sample implement from java7
   * Khối lệnh catch có thể chứa nhiều exception.
   */
  private static void withJava7() {
    int arr[] = {1, 2, 3};
    try {
      for (int i = 0; i < arr.length + 1; i++) {
        System.out.println(arr[i]);
      }
    } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
      LOGGER.log(Level.SEVERE, ex.toString());
    }
  }
}
