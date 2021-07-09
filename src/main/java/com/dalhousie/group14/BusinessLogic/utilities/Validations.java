package com.dalhousie.group14.BusinessLogic.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static boolean isStringvalid(String input){
        if(input==null || input.isEmpty()){
            return false;
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        boolean b = m.find();
        return !b;
    }

    public static boolean datecomparison(Date start_date, Date end_date){
        return end_date.after(start_date);
    }

    public static Date addDaystoDate(Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date); // Using today's date
        c.add(Calendar.DATE, days); // Adding 5 days
        Date updatedate = c.getTime();
        return updatedate;
    }

}
