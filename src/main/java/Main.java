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

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean running = true;

      while (running) {
        System.out.println("\nWybierz opcję:");
        System.out.println("1 – Dodaj studenta");
        System.out.println("2 – Wyświetl listę studentów");
        System.out.println("3 – Zakończ program");
        System.out.print("Twój wybór: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
          case "1":
            System.out.print("Podaj imię studenta: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String surname = scanner.nextLine();

            System.out.print("Podaj wiek studenta: ");
            int age = Integer.parseInt(scanner.nextLine());

            Student newStudent = new Student(name, surname, age);
            s.addStudent(newStudent);

            System.out.println("Dodano studenta:");
            System.out.println(newStudent.ToString());
            break;

          case "2":
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentów.");
            } else {
              System.out.println("Lista studentów:");
              int i = 1;
              for (Student student : students) {
                System.out.println(i + ". " + student.ToString());
                i++;
              }
            }
            break;

          case "3":
            System.out.println("Zakończono program.");
            running = false;
            break;

          default:
            System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
        }
      }

      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}