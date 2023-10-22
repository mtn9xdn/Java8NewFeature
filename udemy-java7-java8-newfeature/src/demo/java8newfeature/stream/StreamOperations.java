package demo.java8newfeature.stream;

import demo.java8newfeature.methodReference.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * nếu chúng ta có tình huống cần áp dụng logic nghiệp vụ hoặc chuyển đổi từng phần tử bên trong một tập hợp,
 * chúng ta có thể sử dụng phương thức map() bên trong Streams để xử lý chúng.
 * nói một cách đơn giản, map() được sử dụng để biến đổi một đối tượng này thành một đối tượng khác bằng cách áp dụng một function.
 */
public class StreamOperations {
  public static void main(String[] args) {
    mapInStreams();
    System.out.println("--------------");
    flatMapInStreams();
    System.out.println("--------------");
    filterInStream();
    System.out.println("--------------");
    limitInStream();
    System.out.println("--------------");
    skipInStream();
    System.out.println("--------------");
    traverseOnceInstreams();
    System.out.println("--------------");
    reduceInStreams();
    System.out.println("--------------");
    collectStreams();
    System.out.println("--------------");
    collectingAndThenStreams();
    System.out.println("--------------");
    groupingByStreams();
    System.out.println("--------------");
    partitioningByStreams();
    System.out.println("--------------");
    streamPipeLine();
    System.out.println("--------------");
    parallelStream();
    System.out.println("--------------");

    List<String> listString = new ArrayList<>();
    listString.add("1");
    listString.add("2");
    listString.add("3");
    listString.add("4");
    System.out.println("addString by String.join " + addString(listString));
    System.out.println("--------------");
    System.out.println("cutString by String.split " + cutString(addString(listString)));
    System.out.println("--------------");
    System.out.println("addStringBuilder by addStringBuilder.append " + addStringBuilder(listString));
    System.out.println("--------------");
    System.out.println("addStringJoiner by StringJoiner " + addStringJoiner(listString));
    System.out.println("--------------");
    System.out.println("addStringCollectorsJoining by Collectors.joining " + addStringCollectorsJoining(listString));
  }


  private static String addStringBuilder(List<String> name) {
    StringBuilder builder = new StringBuilder();
    String phay = ",";
    for (int i = 0; i < name.size(); i++) {
      builder.append(name.get(i));
      if (i < name.size() - 1) {
        builder.append(phay);
      }
    }
    return builder.toString();
  }

  private static String addStringJoiner(List<String> name) {
    StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
    for (String element : name) {
      stringJoiner.add(element);
    }
    return stringJoiner.toString();
  }

  private static String addStringCollectorsJoining(List<String> name) {
    String collectorsJoiningWithDelimiter = name.stream()
            .collect(Collectors.joining(","));
    return collectorsJoiningWithDelimiter;
  }

  private static String addString(List<String> name) {
    String result = null;
    String phay = ",";
    for (String element : name) {
      result = element.join(phay, name);
    }
    return result;
  }

  private static List<String> cutString(String name) {
    String[] arraySplit = name.split(",");
    List<String> result = Arrays.asList(arraySplit);
    return result;
  }

  /**
   * Stream map(Function mapper) là một thao tác trung gian và nó trả về một Stream mới dưới dạng giá trị trả về.
   * Các hoạt động Stream không làm thay đổi nguồn của chúng. Thay vào đó, chúng trả về các Stream mới giữ kết quả.
   */
  private static void mapInStreams() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Apple");
    mobileList.add("Samsung");
    mobileList.add("Oppo");
    mobileList.add("Sony");

    mobileList.stream()
            .map(word -> word.toUpperCase())
            .filter(word -> word.startsWith("S"))
            .forEach(System.out::println);
  }

  /**
   * Đôi khi, dựa trên các yếu tố đầu vào, chúng tôi có thể kết thúc bằng phương pháp multiple Streams post map method
   * và nếu chúng tôi cố gắng collect chúng, chúng tôi sẽ nhận được danh sách các Streams thay vì một Stream duy nhất.
   * đối với những trường hợp như vậy chúng ta có thể sử dụng flatMap.
   * Nó là sự kết hợp của một map và một flat operation, tức là nó áp dụng một chức năng cho các phần tử cũng như làm phẳng chúng.
   */
  private static void flatMapInStreams() {
    String[] arrayOfWords = {"Apple", "Samsung"};
    Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
    /**
     * streamOfWords.map(word -> word.split("")).flatmap(Arrays::stream).forEach(System.out::prinln);
     */
    Stream<String[]> streamOfLetters = streamOfWords.map(word -> word.split(""));
    streamOfLetters.flatMap(Arrays::stream).forEach(System.out::println);

    List<List<String>> list = Arrays.asList(
            Arrays.asList("Apple"),
            Arrays.asList("Samsung"),
            Arrays.asList("Samsung", "Oppo")
    );
    System.out.println(list);
    list.stream().map(Collection::stream).forEach(System.out::println);
    list.stream().flatMap(Collection::stream).forEach(System.out::println);
  }

  /**
   * nếu chúng ta có một tình huống mà chúng ta cần loại trừ các phần tử nhất định bên trong một bộ sưu tập dựa trên một điều kiện,
   * chúng ta có thể sử dụng phương thức filter() bên trong Stream để xử lý chúng.
   * Phương thức filter lấy Predicate làm đối số là một functional interface có thể hoạt động có boolean để lọc các phần tử dựa trên điều kiện được xác định.
   */
  private static void filterInStream() {
    List<String> language = new ArrayList<>();
    language.add("Java");
    language.add("JavaScript");
    language.add("Python");
    language.add("C");

    language.stream()
            .filter(l -> l.startsWith("J"))
            .forEach(System.out::println);
  }

  /**
   * nếu chúng ta có một kịch bản mà chúng ta cần giới hạn số lượng phần tử bên trong một Stream,
   * chúng ta có thể sử dụng phương thức limit(n) bên trong các Stream.
   */
  private static void limitInStream() {
    Stream.generate(new Random()::nextInt)
            .limit(10)
            .forEach(System.out::println);
  }

  /**
   * Stream hỗ trợ phương thức skip(n) để trả về một luồng loại bỏ n phần tử đầu tiên.
   */
  private static void skipInStream() {
    Stream.iterate(1, n -> n + 1)
            .skip(10)
            .limit(20)
            .forEach(System.out::println);
  }

  private static void traverseOnceInstreams() {
    try {
      List<String> mobileApp = new ArrayList<>();
      mobileApp.add("Apple");
      mobileApp.add("Samsung");
      mobileApp.add("Sony");
      mobileApp.add("LG");
      Stream<String> appStream = mobileApp.stream();
      appStream.forEach(System.out::println);
//      appStream.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * sử dụng phương thức reduce(), chúng tôi đã tính toán tổng của tất cả 20 số đầu tiên.
   * Ở đây, phương thức Reduce chấp nhận 2 tham số. Một là giá trị ban đầu của biến tổng là 0 và
   * biến thứ hai là phép toán mà chúng ta muốn sử dụng để kết hợp tất cả các phần tử trong danh sách này.
   */
  private static void reduceInStreams() {
    System.out.println(Stream.iterate(1, n -> n + 1).limit(20).reduce(0, (a, b) -> a + b));
  }

  /**
   * Stream.collect() cho phép chúng tôi đóng gói lại các phần tử vào một số cấu trúc dữ liệu và áp dụng một số logic bổ sung, v.v.
   * trên các phần tử dữ liệu được giữ trong một cá thể Stream.
   * Ở đây trong ví dụ của chúng tôi, lần đầu tiên chúng tôi sử dụng phương thức filter() để xác định các phần tử bắt đầu bằng "S",
   * chúng tôi sử dụng phương thức collect() để chuyển Stream thành danh sách các đối tượng.
   * <p>
   * toSet() --> Convert stream into a set
   * toCollection() --> Convert stream into a collection
   * toMap() --> Convert stream into a Map after applying key/ value determination function
   * counting() --> Counting number of stream elements
   * joining() --> For concatenation of stream elements into a single String
   * minBy() --> To find minimum of all stream elements based on given Comparator
   * maxBy() --> To find maximum of all stream elements based on given Comparator
   * reducing() --> Reducing elements of stream based on BinaryOperator function provided
   */
  private static void collectStreams() {
    List<String> deviceList = new ArrayList<>();
    deviceList.add("Apple");
    deviceList.add("Samsung");
    deviceList.add("Sony");
    deviceList.add("Oppo");

    Stream<String> streamList = deviceList.stream();
    List<String> newDeviceList = streamList
            .filter(str -> str.startsWith("S"))
            .collect(Collectors.toList());
    newDeviceList.forEach(System.out::println);
  }

  /**
   * CollectAndThen() sẽ được sử dụng trong các tình huống mà các phần tử Stream cần được collect và sau đó đối tượng được collect cần được chuyển đổi
   * bằng cách sử dụng một rule/function nhất định. Sử dụng CollectAndThen cả hai tác vụ collect và chuyển đổi này có thể được chỉ định và thực hiện cùng nhau.
   * Nó chấp nhận 2 tham số
   * - Tham số đầu vào đầu tiên ở phía dưới, là một instance của Collector <T, A, R>, tức là định nghĩa tiêu chuẩn của bộ sưu tập.
   * Nói cách khác, bất kỳ collector nào cũng có thể được sử dụng ở đây.
   * - Tham số đầu vào thứ 2 là finisher, cần phải là một instance của fucntional interface Function<R, RR>.
   */
  private static void collectingAndThenStreams() {
    List<Product> productList = Arrays.asList(
            new Product("Apple", 1200),
            new Product("Samsung", 1000),
            new Product("Oppo", 800),
            new Product("Blackbery", 1100),
            new Product("Xiaomi", 600));
    String maxPriceProduct = productList.stream()
            .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                    (Optional<Product> product) -> product.isPresent() ? product.get().getName() : "None"));
    System.out.println("The product with max price tag is : " + maxPriceProduct);
  }

  /**
   * phương thức groupingBy() của lớp Collectors trong java được sử dụng để nhóm các đối tượng theo một số thuộc tính
   * và lưu trữ kết quả trong một cá thể Map. Để sử dụng nó, chúng ta luôn cần chỉ định một property mà việc grouping sẽ được thực hiện.
   * Phương thức này cung cấp chức năng tương tự cho mệnh đề GROUP BY của SQL.
   */
  private static void groupingByStreams() {
    List<Product> productList = Arrays.asList(
            new Product("Apple", 1200),
            new Product("Samsung", 1000),
            new Product("Oppo", 800),
            new Product("Blackbery", 1100),
            new Product("Xiaomi", 600),
            new Product("Nokia", 600));
    Map<Integer, List<Product>> groupByPriceMap = productList.stream()
            .collect(Collectors.groupingBy(Product::getPrice));
    System.out.println("The list of products grouped by price is : " + groupByPriceMap);
  }

  /**
   * Phương thức Collector partitioningBy() được sử dụng để phân vùng một đối tượng stream (hoặc một tập hợp các phần tử) dựa trên một predicate đã cho.
   * Thực tế là partitioning function trả về một boolean có nghĩa là Map nhóm kết quả sẽ có Boolean làm kiểu khóa, và do đó,
   * có thể có nhiều nhất hai nhóm khác nhau - một cho true và một cho false.
   */
  private static void partitioningByStreams() {
    List<Product> productList = Arrays.asList(
            new Product("Apple", 1200),
            new Product("Samsung", 1000),
            new Product("Oppo", 800),
            new Product("Blackbery", 1100),
            new Product("Xiaomi", 600));
    Map<Boolean, List<Product>> costlyProducts = productList.stream()
            .collect(Collectors.partitioningBy(product -> product.getPrice() > 1000));
    System.out.println("The list of products partitioned by price is : " + costlyProducts);
  }

  /**
   * chúng ta có thể hình thành một chuỗi stream operations bằng cách sử dụng hoạt động trung gian và đầu cuối để đạt được đầu ra mong muốn.
   * Điều này chúng tôi cũng gọi là stream pipeline.
   */
  private static void streamPipeLine() {
    List<Integer> inputNums = new ArrayList<>();
    inputNums.add(4);
    inputNums.add(67);
    inputNums.add(10);
    inputNums.add(87);
    inputNums.add(38);
    inputNums.add(15);
    List<Integer> newNums = inputNums.stream()
            .filter(num -> num % 2 != 0)
            .map(num -> num * 2)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    newNums.forEach(System.out::println);
  }

  /**
   * Streams interface cho phép bạn xử lý song song các phần tử của nó theo cách thuận tiện: có thể biến một tập hợp thành một
   * luồng song song bằng cách gọi phương thức parallelStream() trên nguồn collection.
   * Luồng song song là luồng chia các phần tử của nó thành nhiều phần, xử lý mỗi phần bằng một luồng khác nhau.
   * Do đó, bạn có thể tự động phân vùng khối lượng công việc của một hoạt động nhất định trên tất cả các lõi của bộ xử lý đa lõi của bạn và giữ cho tất cả chúng bận rộn như nhau.
   * Nếu chúng ta muốn chuyển đổi một luồng tuần tự thành một luồng song song, chỉ cần gọi phương thức  parallel() trên stream.
   */
  private static void parallelStream() {
    List<String> deviceList = new ArrayList<>();
    deviceList.add("Apple");
    deviceList.add("Samsung");
    deviceList.add("Sony");
    deviceList.add("Oppo");
    deviceList.add("Huawei");

    deviceList.parallelStream().forEach(System.out::println);
  }
}
