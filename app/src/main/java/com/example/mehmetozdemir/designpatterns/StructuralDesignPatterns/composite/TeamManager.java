package com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.composite;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetozdemir on 28/11/16.
 */

public class TeamManager implements Employee{

    private List<Employee> employeeList = new ArrayList<>();

    private String managerName;

    public TeamManager(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerName() {
        return managerName;
    }

    @Override
    public void printData() {
        Log.d("Composite => ", "+ Team Manager: " + managerName);
        for (Employee employee : employeeList){
            employee.printData();
        }
    }

    public void addMember(Employee employee){
        employeeList.add(employee);
    }

    public void removeMember(Employee employee){
        employeeList.remove(employee);
    }
}
