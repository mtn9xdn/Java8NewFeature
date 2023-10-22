package demo.java7newfeature;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

// Ngoài ra có thể dùng File.mkdirs
public class FilesInJava7 {
  private static String HOME_DIR = "C:\\Users\\NamMT\\Desktop\\";

  public static void main(String[] args) throws IOException {
    workingWithFiles();
  }

  private static void workingWithFiles() throws IOException {
//    Đọc file txt có ký tự
    Path path = Paths.get(HOME_DIR, "before-java7.txt");
    byte[] bytes = Files.readAllBytes(path);
    String content = new String(bytes, StandardCharsets.UTF_8);
    System.out.println("Content of the file is : " + content);

    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    for (String line : lines) {
      System.out.println("Content of the line is : " + line);
    }
//    Create chuỗi insert vào file path
    String newLine = "\nHow are you? ";
    Files.write(path, newLine.getBytes(), StandardOpenOption.APPEND);

//    Tạo path mới vào create file java7.txt trong folder java7
    Path newPath = Paths.get(HOME_DIR, "java7");
    if (!Files.exists(newPath)) {
      Files.createDirectory(newPath);
    }
    Path filePath = Paths.get(HOME_DIR, "java7", "java7.txt");
    if (!Files.exists(filePath)) {
      Files.createFile(filePath);
    }
//    Copy data từ path vào filePath
//    InputStream in = Files.newInputStream(path);
//    Files.copy(in, filePath);
    Files.copy(path, filePath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
//    Delete filePath
    Files.delete(filePath);
    boolean deleted = Files.deleteIfExists(filePath);
    System.out.println(deleted);
  }
}
