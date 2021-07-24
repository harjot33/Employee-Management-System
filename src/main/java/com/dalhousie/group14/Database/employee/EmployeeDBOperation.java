package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDBOperation {
    Connection connection;
    public EmployeeDBOperation(){

        connection=DbConnection.connectDB();
    }
    public Boolean setEmployee(String username,String type,double value){
        try {
            Statement stmt = this.connection.createStatement();
            String sql="UPDATE Employee SET "+type+"="+value+"WHERE UserName='"+username+"';";
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public Map<String,String> getEmployeeInfo(String username){
        Map<String,String>information=new HashMap<String,String>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Employee WHERE UserName='"+username+"';");

            while (rs.next()){
                information.put("UserName",rs.getString("UserName"));
                information.put("ContactName",rs.getString("ContactName"));
                information.put("gender",rs.getString("gender"));
                information.put("DOB",rs.getString("DOB"));
                information.put("basic_salary",rs.getString("Basicsalary"));
                information.put("ctc",rs.getString("CTC"));
                information.put("epf",rs.getString("EPF"));
                information.put("bonus",rs.getString("bonus"));
                information.put("lastmonthsalary",rs.getString("lastmonthsalary"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return  information;

    }


  public List<List<String>> getALLEmployeeInfo() {
      Map<String,String>information=new HashMap<String,String>();
      List<List<String>>x=new ArrayList<>();
      try {
          Statement stmt = connection.createStatement();
          ResultSet rs=stmt.executeQuery("SELECT * FROM Employee;");

          while (rs.next()){
              ArrayList<String>info=new ArrayList<>();
              info.add(rs.getString("UserName"));
              info.add(rs.getString("ContactName"));
              x.add(info);
          }
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }


      return  x;
  }
}
