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

  
  public Student findStudentByName(String name) throws IOException {
    List<Student> students = getStudents();
    for (Student student : students) {
      if (student.GetName().equalsIgnoreCase(name)) {
        return student;
      }
    }
    return null;
  }

  
  public boolean removeStudentByNameAndSurname(String name, String surname) throws IOException {
    List<Student> students = getStudents();
    boolean found = false;
    List<Student> updatedList = new ArrayList<>();

    
    for (Student student : students) {
      if (student.GetName().equalsIgnoreCase(name) && student.GetSurname().equalsIgnoreCase(surname)) {
        found = true;
      } else {
        updatedList.add(student);
      }
    }

    
    if (found) {
      FileWriter f = new FileWriter("db.txt");
      BufferedWriter writer = new BufferedWriter(f);
      for (Student student : updatedList) {
        writer.write(student.GetName() + " " + student.GetSurname() + " " + student.GetAge() + " " + student.GetBirthDate());
        writer.newLine();
      }
      writer.close();
    }

    return found;
  }
}
