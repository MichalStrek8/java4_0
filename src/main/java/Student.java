public class Student {
  private String name;
  private String surname;
  private int age;

  public Student(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public String GetName() { return name; }
  public String GetSurname() { return surname; }
  public int GetAge() { return age; }

  public String ToString() {
    return name + " " + surname + " " + age;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 3)
      return new Student("Parse", "Error", -1);
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}