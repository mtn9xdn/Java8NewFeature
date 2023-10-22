package demo.java7newfeature;

import demo.java7newfeature.sp.CustomDirtyResource;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SupressedExceptions {
  private final static Logger LOGGER = Logger.getLogger(SupressedExceptions.class.getName());

  public static void main(String[] args) {
    try {
      beforeJava7();
    } catch (Exception ex) {
      LOGGER.log(Level.SEVERE, ex.getMessage());
    }

    try {
      withJava7();
    } catch (Exception ex) {
      LOGGER.log(Level.SEVERE, ex.getMessage());
      final Throwable[] suppressedExceptions = ex.getSuppressed();
      final int numSuppressed = suppressedExceptions.length;
      if (numSuppressed > 0) {
        for (final Throwable exception : suppressedExceptions) {
          LOGGER.log(Level.SEVERE, exception.getMessage());
        }
      }
    }
  }

  /**
   * Sample implements before java7
   *
   * @throws Exception
   */
  private static void beforeJava7() throws Exception {
    CustomDirtyResource cr = null;
    try {
      cr = new CustomDirtyResource();
      cr.readFromResource();
    } finally {
      cr.close();
    }
  }

  /**
   * Sample implements from java7
   * Nó tự gọi method close() khi implements AutoCloseable
   *
   * @throws Exception
   */
  private static void withJava7() throws Exception {
    try (CustomDirtyResource cr = new CustomDirtyResource();) {
      cr.readFromResource();
    }
  }
}
