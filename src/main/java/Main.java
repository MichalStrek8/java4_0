/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      Service s = new Service();
      s.addStudent(new Student("Krzysztof", 20));
      s.addStudent(new Student("Janusz", 40));

      System.out.print("Podaj imię nowego studenta: ");
      String name = scanner.nextLine();

      System.out.print("Podaj wiek nowego studenta: ");
      int age = Integer.parseInt(scanner.nextLine());

      s.addStudent(new Student(name, age));

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Wystąpił błąd: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Wiek musi być liczbą całkowitą.");
    }
  }
}