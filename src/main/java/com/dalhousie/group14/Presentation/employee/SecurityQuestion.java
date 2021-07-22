package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.GiveSecurityQuestionAnswer;
import com.dalhousie.group14.BusinessLogic.employee.SetSecurityQuestion;

import java.util.Scanner;

public class SecurityQuestion {

  public void securityQuestion() {

    SetSecurityQuestion securityQuestion = new SetSecurityQuestion();
    GiveSecurityQuestionAnswer giveSecurityQuestionAnswer =
        new GiveSecurityQuestionAnswer();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    String userName;
    System.out.println("Enter your UserName:");
    userName = scanner1.nextLine();
    System.out.println("Your UserName is:" + userName);
    System.out.println("Press 1 for create Security Question Answer (For First time User): \n" +
        "Press 2 for give the answer of security question.");

    int select;
    int counter = 0;
    try {
      do {
        select = scanner.nextInt();
        switch (select) {
          case 1:
            securityQuestion.setSecurityQuestion(userName);
            break;
          case 2:
            giveSecurityQuestionAnswer.giveSecurityQuestionAnswer(userName);
            break;
          default:
            System.out.println("Enter Only 1 and 2 as per your Requirements.");
            counter = counter + 1;
        }
        if (counter == 3) {
          System.out.println("Sorry, EMS System not allow to enter wrong choice more then 3 times.");
          break;
        }
      } while (true);
    } catch (NumberFormatException formatException) {
      System.out.println("NumberFormat Exception:" + formatException);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
