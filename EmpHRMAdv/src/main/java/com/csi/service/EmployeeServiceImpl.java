package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public boolean signIn(String empEmailID, String empPassword)  {

       // Employee employee1 = employeeDaoImpl.getDataByEmpEmail(empEmailId).orElseThrow(() -> new RecordNotFoundException("## THE RECORD YOU TRY TO FETCH IS EITHER DELETED OR NOT PRESENT ##"));

        return employeeDaoImpl.signIn(empEmailID, empPassword);
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getDataByName(String empName) {
        return employeeDaoImpl.getDataByName(empName);
    }


    public Employee getDataByEmpEmail(String empEmailId) {
        return employeeDaoImpl.getDataByEmpEmail(empEmailId);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByAge() {
        return employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    public List<Employee> filterDataBYSalary(double empSalary) {
        return employeeDaoImpl.filterDataBYSalary();
    }

    public List<Employee> getDataByUsingAnyInput(String input) {
        return employeeDaoImpl.getDataByUsingAnyInput(input);
    }

    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId) {
        employeeDaoImpl.deleteDataById(empId);
    }

    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();
    }

    public boolean isEligibleForLoan(int empId) {
        return employeeDaoImpl.isEligibleForLoan(empId);
    }
}
