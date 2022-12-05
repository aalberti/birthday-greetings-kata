import java.util.Date;

public class Employee {
  private String lastName, firstName, email;
  private Date dateOfBirth;

  public Employee(String lastName, String firstName, String email, Date dateOfBirth) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
