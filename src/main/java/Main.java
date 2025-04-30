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
        System.out.println("3 – Znajdź studenta po imieniu");
        System.out.println("4 – Usuń studenta");
        System.out.println("5 – Zakończ program");
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

            System.out.println("Podaj datę urodzenia:");

            System.out.print("Rok (1–3000): ");
            int year = Integer.parseInt(scanner.nextLine());
            if (year < 1 || year > 3000) {
              System.out.println("Nieprawidłowy rok. Przerwano dodawanie.");
              break;
            }

            System.out.print("Miesiąc (1–12): ");
            int month = Integer.parseInt(scanner.nextLine());
            if (month < 1 || month > 12) {
              System.out.println("Nieprawidłowy miesiąc. Przerwano dodawanie.");
              break;
            }

            System.out.print("Dzień (1–30): ");
            int day = Integer.parseInt(scanner.nextLine());
            if (day < 1 || day > 30) {
              System.out.println("Nieprawidłowy dzień. Przerwano dodawanie.");
              break;
            }

            String birthDate = String.format("%04d-%02d-%02d", year, month, day);

            Student newStudent = new Student(name, surname, age, birthDate);
            s.addStudent(newStudent);

            System.out.println("Dodano studenta:");
            System.out.println(newStudent.ToString());
            break;

          case "2":
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentów.");
            } else {
              System.out.println("\nLista studentów:");
              int i = 1;
              for (Student student : students) {
                System.out.println(i + ". " + student.ToString());
                i++;
              }
            }
            break;

          case "3":
            System.out.print("Podaj imię studenta do wyszukania: ");
            String searchName = scanner.nextLine();

            Student foundStudent = s.findStudentByName(searchName);
            if (foundStudent != null) {
              System.out.println("Znaleziono studenta: " + foundStudent.ToString());
            } else {
              System.out.println("Student o podanym imieniu nie został znaleziony.");
            }
            break;

          case "4":
            System.out.print("Podaj imię studenta do usunięcia: ");
            String deleteName = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta do usunięcia: ");
            String deleteSurname = scanner.nextLine();

            boolean removed = s.removeStudentByNameAndSurname(deleteName, deleteSurname);
            if (removed) {
              System.out.println("Usunięto studenta: " + deleteName + " " + deleteSurname);
            } else {
              System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
            }
            break;

          case "5":
            System.out.println("Zakończono program.");
            running = false;
            break;

          default:
            System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
        }
      }

      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      System.out.println("Błąd: nieprawidłowy format liczbowy.");
    }
  }
}