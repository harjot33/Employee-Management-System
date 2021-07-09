package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.ProjectDefinition;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.client.ProjectDatabaseInteraction;

import java.util.Date;
import java.util.Scanner;

public class Project {

    public boolean defineproject(){
        ProjectDatabaseInteraction projectDatabaseInteraction = new ProjectDatabaseInteraction();
        ProjectDefinition projectDefinition = new ProjectDefinition();
        Scanner s = new Scanner(System.in);
        Project projectobj = new Project();
        boolean done = false;
        System.out.println();
        System.out.println("Welcome to the project definition module");
        while (!done){
            System.out.print("Enter the project name : ");
            String projectname = s.nextLine();
            if (Validations.isStringvalid(projectname)) {
                if (projectDatabaseInteraction.projectexistscheck(projectname)) {
                    done = true;
                } else {
                    System.out.println("This project already exists, change the project name to continue.");
                }
            }
        }
        System.out.println();
        System.out.println("Now, you will need to enter the programming languages for the project.");
        System.out.println("Enter 'DONE' when you have finished entering the languages.");
        done = false;
        Date start_date = new Date();
        Date end_date = new Date();
        boolean startvalid = false;
        while(!done){
            Scanner scanner = new Scanner(System.in);
            System.out.println();

            if(!startvalid) {
                System.out.print("Enter the project's start date : ");
                String project_start_date = scanner.nextLine();
                start_date = projectDefinition.datesetter(project_start_date);
                if(start_date!=null) {
                    startvalid = true;
                }else{
                    System.out.println("Invalid Date format - Follow dd-MM-YYYY Format.");
                }
            }
            System.out.print("Enter the project's end date : ");
            String project_end_date = scanner.nextLine();
            end_date = projectDefinition.datesetter(project_end_date);
            if(end_date != null) {
                if(Validations.datecomparison(start_date,end_date)) {
                    done = true;
                }else{
                    System.out.println("Project's end date cannot be before the start date.");
                }
            }
        }
        return true;
    }


}
