package demo.java7newfeature;

public class SwitchWithString {
  public static void main(String[] args) {
    displayTodayDetails("Monday");
    displayWeekDetails("Monday");
  }

  private static void displayTodayDetails(String dayInput) {
    switch (dayInput) {
      case "Monday":
        System.out.println("Today is monday");
        break;
      case "Tuesday":
        System.out.println("Today is Tuesday");
        break;
      case "Wednesday":
        System.out.println("Today is Wednesday");
        break;
      case "Thursday":
        System.out.println("Today is Thursday");
        break;
      case "Friday":
        System.out.println("Today is Friday");
        break;
      case "Saturday":
        System.out.println("Today is Saturday");
        break;
      case "Sunday":
        System.out.println("Today is Sunday");
        break;
      default:
        System.out.println("Not found this day");
    }
  }

  private static void displayWeekDetails(String dayInput) {
    switch (dayInput) {
      case "Monday":
      case "Tuesday":
      case "Wednesday":
      case "Thursday":
      case "Friday":
        System.out.println("Today is Working day");
        break;
      case "Saturday":
      case "Sunday":
        System.out.println("Today is Holiday");
        break;
      default:
        System.out.println("Not found this day");
    }
  }
}
