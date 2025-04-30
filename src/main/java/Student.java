    public class Student {
      private String name;
      private String surname;
      private int age;
      private String birthDate;

      public Student(String name, String surname, int age, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDate = birthDate;
      }

      public String GetName() {
        return name;
      }

      public String GetSurname() {
        return surname;
      }

      public int GetAge() {
        return age;
      }

      public String GetBirthDate() {
        return birthDate;
      }

      public String ToString() {
        return name + " " + surname + " " + age + " " + birthDate;
      }

      public static Student Parse(String str) {
        String[] data = str.split(" ");
        if (data.length != 4)
          return new Student("Parse", "Error", -1, "N/A");
        String name = data[0];
        String surname = data[1];
        int age = Integer.parseInt(data[2]);
        String birthDate = data[3];
        return new Student(name, surname, age, birthDate);
      }
    }