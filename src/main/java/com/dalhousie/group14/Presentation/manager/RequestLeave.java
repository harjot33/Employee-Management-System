package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.employee.DBRequestForLeave;

import java.util.HashMap;
import java.util.Scanner;

public class RequestLeave implements IRequestLeave {



  @Override
    public void requestLeave(){

    DBRequestForLeave dbRequestForLeave = new DBRequestForLeave();
    HashMap<Integer, HashMap<String, String>> hashMap;
    hashMap = dbRequestForLeave.getAllLeaveInfo();

    int key, RemainingLeaves;
    String username, status, days;
    Scanner scanner = new Scanner(System.in);
    System.out.println("All are Pending Request:");
    System.out.println("Pending Requests:" + hashMap);

    try {
      do {
        System.out.println("Enter Username of the employee:");
        username = scanner.nextLine();
        System.out.println("Write Cancel or Approve:");
        status = scanner.nextLine();
        if (status.equalsIgnoreCase("Cancel")) {
          dbRequestForLeave.cancelLeaveRequest(username, status);
        } else {
          System.out.println("How many days of leaves you want to approved?");
          days = scanner.nextLine();
          System.out.println("Write How many leaves are available for " +
              "Employee:");
          RemainingLeaves = scanner.nextInt();
          dbRequestForLeave.updateLeaveRequest(username, status, days, RemainingLeaves);
        }
        System.out.println("Press 5 for Exit.");
        int br = scanner.nextInt();
        if (br == 5) {
          break;
        }
      } while (true);
    } catch (Exception e) {
      System.out.println("Exception" + e);
    }
  }
}

