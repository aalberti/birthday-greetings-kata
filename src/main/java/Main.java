import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
  public static void main(String[] args) throws IOException {
    Files.lines(Path.of("employee_data.txt"))
        .skip(1)
        .map(line -> line.split(", "))
        .map(
            splitLine -> {
              try {
                return new Employee(
                    splitLine[0],
                    splitLine[1],
                    splitLine[3],
                    new SimpleDateFormat("yyyy/MM/dd").parse(splitLine[2]));
              } catch (ParseException e) {
                throw new RuntimeException(e);
              }
            })
        .forEach(
            employee ->
                System.out.println(
                    "Subject: Happy birthday!\n"
                        + "\n"
                        + "Happy birthday, dear "
                        + employee.getFirstName()
                        + "!"));
  }
}
