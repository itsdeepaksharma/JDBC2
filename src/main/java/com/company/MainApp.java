package com.company;

import com.company.dao.*;
import com.company.model.Employee;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();

        while(true){

            System.out.println("\n1 Add");
            System.out.println("2 View");
            System.out.println("3 Delete");
            System.out.println("4 Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    dao.addEmployee(
                            new Employee("Deepak",10000,"IT"));
                    break;

                case 2:
                    dao.getAllEmployees()
                            .forEach(e ->
                                    System.out.println(
                                            e.getId()+" "+
                                                    e.getName()+" "+
                                                    e.getSalary()+" "+
                                                    e.getDepartment()));
                    break;

                case 3:
                    System.out.print("ID:");
                    dao.deleteEmployee(sc.nextInt());
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}