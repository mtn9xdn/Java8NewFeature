package demo.java7newfeature;

@SuppressWarnings("serial")
public class RethrowExceptions {
  public static void main(String[] args) throws Exception {
    beforeJava7("First");
    withJava7("First");
  }

  /**
   * Sample implement before Java7
   * Chỉ throws được Exception
   *
   * @param first
   * @throws Exception
   */
  private static void beforeJava7(String first) throws Exception {
    try {
      if (first.equals("First")) {
        throw new FirstException();
      } else {
        throw new SecondException();
      }
    } catch (Exception e) {
      throw e;
    }
  }

  /**
   * Sample implement from Java7
   * Throws được 2 class Exception
   *
   * @param first
   * @throws Exception
   */
  private static void withJava7(String first) throws SecondException, FirstException {
    try {
      if (first.equals("First")) {
        throw new FirstException();
      } else {
        throw new SecondException();
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public static class FirstException extends Exception {
  }


  public static class SecondException extends Exception {
  }
}
