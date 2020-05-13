package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeParser {

  public static List<Employee> parse(String fileName) throws IOException {
    List<Employee> employees = new ArrayList<>();

    BufferedReader in = new BufferedReader(new FileReader(fileName));
    String str = "";
    str = in.readLine(); // skip header
    while ((str = in.readLine()) != null) {
      employees.add(parseEmployee(str));
    }

    return employees;
  }

  private static Employee parseEmployee(String str) {
    String[] employeeData = str.split(", ");
    return new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
  }
}
