package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.InsertCalendarEventE;
import com.dalhousie.group14.Presentation.Common.UserInput;


public class CalendarScreen4 implements CalendarScreen{

    @Override
    public void displayScreen() {
        String event_name;
        String event_desc;
        String eventDate;
        String empID;
        try {
            System.out.println("---------------ADD AN EVENT--------------");
            System.out.println("Enter the event name: ");
            event_name = UserInput.takeString();
            System.out.println("Enter the event description: ");
            event_desc = UserInput.takeString();
            System.out.println("Enter the event date: ");
            System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08]");
            eventDate = UserInput.takeString();
            System.out.println("Enter your employee ID: ");
            empID = UserInput.takeString();
            CalendarEvent calendarEvent = new CalendarEvent(event_name, event_desc, eventDate, empID);
            InsertCalendarEventE.insertEvent(calendarEvent);
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Event added successfully to your calendar");
        CalendarScreen1 cs1 = new CalendarScreen1();
        cs1.displayScreen();
    }
}
