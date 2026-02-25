package com.company.dao;

import com.company.config.DBConnection;
import com.company.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {

        try(Connection con = DBConnection.getConnection()){
            String sql =
                    "INSERT INTO employee(name,salary,department) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, employee.getName());
            ps.setDouble(2, employee.getSalary());
            ps.setString(3, employee.getDepartment());
            ps.executeUpdate();
            System.out.println("Employee added successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> list = new ArrayList<>();

        try(Connection con = DBConnection.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()){
                list.add(new Employee(
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("department")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void updateEmployee(Employee emp) {

        try(Connection con = DBConnection.getConnection()) {

            String sql =
                    "UPDATE employee SET name=?,salary=?,department=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setString(3, emp.getDepartment());
            ps.setInt(4, emp.getId());

            ps.executeUpdate();

            System.out.println("Employee Updated");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void deleteEmployee(int id) {

        try(Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id = ?");

            ps.setInt(1,id);

            ps.executeUpdate();

            System.out.println("Employee deleted successfully");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
