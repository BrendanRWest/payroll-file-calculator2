package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollFileCalculator {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the name of the file to process: ");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(scan.nextLine()));
            bufferedReader.readLine();

            System.out.print("Enter the name of the payroll file to create: ");
            String fileName = scan.nextLine();
            BufferedWriter bufferedWriter =  new BufferedWriter(new FileWriter(fileName));



            String csvLine;
            while ((csvLine = bufferedReader.readLine()) != null) {
                String[] tokens = csvLine.split("\\|");
                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                String text = String.format("%s|%s|$%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                bufferedWriter.write(text);
            }


            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception ex) {
            System.out.println("Something went wrong!");
        }
    }
}
