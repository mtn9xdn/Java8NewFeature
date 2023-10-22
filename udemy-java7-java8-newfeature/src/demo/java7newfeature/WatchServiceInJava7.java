package demo.java7newfeature;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceInJava7 {
  public static void main(String[] args) throws Exception {
    directoryWatchService();
  }

  private static void directoryWatchService() throws Exception {
    WatchService watchService = FileSystems.getDefault().newWatchService();
    Path path = Paths.get("C:\\Users\\NamMT\\Desktop\\java7");
    path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
    boolean poll = true;
    WatchKey key = watchService.take();
    while (poll) {
      for (WatchEvent<?> event : key.pollEvents()) {
        System.out.println("Event kind : " + event.kind() + "\n - For the title : " + event.context());
      }
      poll = key.reset();
    }
  }
}
