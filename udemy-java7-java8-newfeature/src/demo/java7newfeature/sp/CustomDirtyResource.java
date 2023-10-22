package demo.java7newfeature.sp;

public class CustomDirtyResource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    throw new NullPointerException("OOPS. It is very bad to have a Null Pointer Exxceltion !!");
  }

  public void readFromResource() {
    throw new RuntimeException("Sorry. I don't have data available right now due to network issue !!");
  }
}
