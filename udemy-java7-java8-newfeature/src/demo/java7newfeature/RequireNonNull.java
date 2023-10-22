package demo.java7newfeature;

import java.util.Objects;

public class RequireNonNull {
  public static void main(String[] args) {
    Person person = null;
    processPersonDetail(person);
  }

  private static void processPersonDetail(Person person) {
    Objects.requireNonNull(person, "Person can't be null");
    System.out.println(person.firstName);
    System.out.println(person.lastName);
  }

  public class Person {
    private String firstName;
    private String lastName;

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
  }
}
