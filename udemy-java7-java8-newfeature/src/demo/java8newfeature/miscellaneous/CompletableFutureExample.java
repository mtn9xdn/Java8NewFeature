package demo.java8newfeature.miscellaneous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
  /**
   * runAsysnc () -> chạy không đồng bộ trong nền và sẽ không trả về bất kỳ thứ gì từ tác vụ
   * supplyAsync () -> chạy không đồng bộ trong nền và sẽ trả về các giá trị từ tác vụ
   * get () -> nó chặn việc thực thi vì tương lai được hoàn thành.
   * thenApply () / thenAccept () -> để đính kèm một lệnh gọi lại vào CompleTableFuture
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    runAsync();
    suppleAsync();
    thenAplly();
    thenAccept();
    System.out.println("Main Thread");
  }

  private static void runAsync() throws InterruptedException, ExecutionException {
    CompletableFuture<Void> async = CompletableFuture.runAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
    });
    System.out.println("runAsync Blocking 1");
    async.get();
    System.out.println("runAsync Blocking 2");
  }

  private static void suppleAsync() throws InterruptedException, ExecutionException {
    CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return "Eazy Bytes";
    });
    System.out.println("supplyAsync Blocking 1");
    String result = async.get();
    System.out.println(result);
    System.out.println("supplyAsync Blocking 2");
  }

  private static void thenAplly() throws InterruptedException, ExecutionException {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return "Eazy";
    });
    System.out.println("thenApply middle block");

    CompletableFuture<String> finalFuture = future.thenApply(name -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return name + " Bytes";
    });

    System.out.println("thenApply before final block");
    System.out.println(finalFuture.get());
    System.out.println("thenApply Blocking");
  }

  private static void thenAccept() throws InterruptedException, ExecutionException {
    CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return "Accept";
    }).thenAccept(result -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      System.out.println("Received the value " + result);
    });
    System.out.println("thenAccept non-blocking");
    future.get();
  }
}
