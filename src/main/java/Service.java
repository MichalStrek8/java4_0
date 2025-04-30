import java.io.*;
import java.util.*;

public class Service {

  public void addStudent(Student student) throws IOException {
    FileWriter f = new FileWriter("db.txt", true);
    BufferedWriter b = new BufferedWriter(f);
    b.append(student.GetName() + " " + student.GetSurname() + " " + student.GetAge() + " " + student.GetBirthDate());
    b.newLine();
    b.close();
  }

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
}