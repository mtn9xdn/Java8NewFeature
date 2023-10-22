package demo.java7newfeature.sp;

public class Employee {
  private String name;
  private float salary;
  private String gender; // "M", "F"

  public Employee(String name, float salary, String gender) {
    this.name = name;
    this.salary = salary;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public float getSalary() {
    return salary;
  }

  public String getGender() {
    return gender;
  }

  public boolean isFemale() {
    return "F".equals(this.getGender());
  }
}
