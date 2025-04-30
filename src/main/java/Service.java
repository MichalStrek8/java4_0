import java.io.*;
import java.util.*;

public class Service {

  // Metoda dodająca studenta do pliku
  public void addStudent(Student student) throws IOException {
    FileWriter f = new FileWriter("db.txt", true);
    BufferedWriter b = new BufferedWriter(f);
    b.append(student.GetName() + " " + student.GetSurname() + " " + student.GetAge() + " " + student.GetBirthDate());
    b.newLine();
    b.close();
  }

  // Metoda do pobierania listy studentów z pliku
  public List<Student> getStudents() throws IOException {
    List<Student> students = new ArrayList<>();
    FileReader f = new FileReader("db.txt");
    BufferedReader reader = new BufferedReader(f);
    String line;

    while ((line = reader.readLine()) != null) {
      Student student = Student.Parse(line);
      students.add(student);
    }

    reader.close();
    return students;
  }

  // Metoda do wyszukiwania studenta po imieniu
  public Student findStudentByName(String name) throws IOException {
    // Pobieramy listę studentów
    List<Student> students = getStudents();

    // Przechodzimy przez listę studentów
    for (Student student : students) {
      // Porównujemy imię studenta z podanym imieniem (ignorujemy wielkość liter)
      if (student.GetName().equalsIgnoreCase(name)) {
        return student; // Zwracamy pierwszego znalezionego studenta
      }
    }

    // Jeśli nie znaleziono studenta o podanym imieniu, zwracamy null
    return null;
  }
}