package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;


    @PostMapping("/signUp")
    public Employee signUp(@RequestBody Employee employee) {
        return employeeServiceImpl.signUp(employee);
    }

    @GetMapping("/signIn/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, String empPassword) {
        //Employee employee = employeeServiceImpl.getDataByEmpEmail(empEmailId).orElseThrow(() -> new RecordNotFoundException("## THE RECORD YOU TRY TO FETCH IS EITHER DELETED OR NOT PRESENT ##"));
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId, empPassword));
    }

    @GetMapping("/getDataByContactNumber/{empContactNumber}")
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable long empContactNumber) throws RecordNotFoundException {

        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }

    @PutMapping("/updateData")
    public Employee updateData(@RequestBody Employee employee) {
        return employeeServiceImpl.updateData(employee);
    }

    @DeleteMapping("/deleteDataById/{empId}")
    public void deleteDataById(@PathVariable int empId) {
        employeeServiceImpl.deleteDataById(empId);
    }

    @DeleteMapping("/deleteAllData")
    public void deleteAllData() {
        employeeServiceImpl.deleteAllData();
    }

    @GetMapping("/getDataByEmpEmail/{empEmailId}")
    public Employee getDataByEmpEmail(@PathVariable String empEmailId) {
        return employeeServiceImpl.getDataByEmpEmail(empEmailId);
    }

    @GetMapping("/getAllData")
    public List<Employee> getAllData() {
        return employeeServiceImpl.getAllData();
    }

    @GetMapping("/sortByName")
    public List<Employee> sortByName() {
        return employeeServiceImpl.sortByName();
    }

    @GetMapping("/sortById")
    public List<Employee> sortById() {
        return employeeServiceImpl.sortById();
    }

    @GetMapping("/sortBySalary")
    public List<Employee> sortBySalary() {
        return employeeServiceImpl.sortBySalary();
    }

    @GetMapping("/sortByAge")
    public List<Employee> sortByAge() {
        return employeeServiceImpl.sortByAge();
    }

    @GetMapping("/sortByDOB")
    public List<Employee> sortByDOB() {
        return employeeServiceImpl.sortByDOB();
    }

    @GetMapping("/filterDataBYSalary/{empSalary}")
    public List<Employee> filterDataBYSalary(@PathVariable double empSalary) {
        return employeeServiceImpl.filterDataBYSalary(empSalary);
    }

    @GetMapping("/getDataByUsingAnyInput/{input}")
    public List<Employee> getDataByUsingAnyInput(@PathVariable String input) {
        return employeeServiceImpl.getDataByUsingAnyInput(input);
    }

    @GetMapping("/checkEligibility/{empId}")
    public ResponseEntity<String> checkEligibility(@PathVariable int empId) {
        String msg = null;
        if (employeeServiceImpl.isEligibleForLoan(empId)) {
            msg = " Yes You are eligible for loan";
        } else {
            msg = "NO you are not eligible";
        }
        return ResponseEntity.ok(msg);
    }
}
