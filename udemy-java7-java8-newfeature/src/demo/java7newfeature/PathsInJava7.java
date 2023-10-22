package demo.java7newfeature;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsInJava7 {
  private static String HOME_DIR = "C:\\Users\\NamMT\\Desktop\\";

  public static void main(String[] args) {
    buildPath();
  }

  private static void buildPath() {
    Path path = Paths.get(HOME_DIR, "def.txt");
    Path fileName = path.getFileName();
    System.out.println("File name is :" + fileName.toString());
    System.out.println("File system is :" + path.getFileSystem().toString());
    System.out.println("File system separator is :" + path.getFileSystem().getSeparator());
    for (int i = 0; i < path.getNameCount(); i++) {
      Path subPath = path.getName(i);
      System.out.println("Path location at index :" + (i+1) + " is " + subPath.toString());
    };
    System.out.println("Sub path is " + path.subpath(0,2));
    System.out.println("Root path is " + path.getRoot());
    System.out.println("Parent path is " + path.getParent());

    Path redundantPath = Paths.get(HOME_DIR, "Desktop",".", "def.txt");
    System.out.println("Redundant path is " + redundantPath.toString());
    Path cleanPath = redundantPath.normalize();
    System.out.println("Clean path is "+cleanPath.toString());
    URI uri = cleanPath.toUri();
    System.out.println("URI Path is " + uri.toString());
    System.out.println("Absolute path is " + cleanPath.toAbsolutePath().toString());

    Path partipalPath = Paths.get(HOME_DIR, "Desktop");
    Path combinedPath = partipalPath.resolve("def.txt");
    System.out.println("Combined path is " + combinedPath.toString());

    if (!partipalPath.equals(combinedPath)){
      System.out.println("Path are not equal");
    }
  }
}
