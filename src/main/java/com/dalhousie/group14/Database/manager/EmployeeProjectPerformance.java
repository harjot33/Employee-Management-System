package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;

public class EmployeeProjectPerformance {
    public static ResultSet projectperformanceall() {
        ResultSet resultSet = null;
        String query = "";
        resultSet = QueryExecutor.readData(query);
        return resultSet;
    }

    public static ResultSet employeeprojectperformance(String username) {
        ResultSet resultSet = null;
        String query = "";
        resultSet = QueryExecutor.readData(query);
        return resultSet;
    }

    public static ResultSet EmpProjectMilestones(String project_id){
        String query = "";
        ResultSet resultSet= QueryExecutor.readData(query);
        return  resultSet;
    }

    public static void EmployeeofMonth(String username, Float rating){
        String query = "";
        QueryExecutor.writeData(query);
    }

    public static ResultSet DisplayEoM(){
        String query = "";
        ResultSet resultSet = QueryExecutor.readData(query);
        return resultSet;
    }
}