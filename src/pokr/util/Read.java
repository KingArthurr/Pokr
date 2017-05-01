package pokr.util;

import java.util.Scanner;

/**
 * Read class for the Cubic4 4 in a row game. This class handles string formatting used in the TUI.
 *  Programming project of M2
 * 
 * @author Arthur de Koning
 * @author Steen Kiezel
 *
 */
public class Read {
  // -- Instance Variables ------------------------------
  private static Scanner scanner = new Scanner(System.in);
  
  // -- Methods -----------------------------------------
  //@ requires prompt != null && yes != null && no != null;
  //@ ensures \result == true || \result == false;
  /**
   * Method to create a simple yes or no prompt.
   * @param prompt string to present the user
   * @param yes the true equivalent of the prompt
   * @param no the false equivalent of the prompt
   * @return boolean based on the answer from user input
   */
  public static boolean readBoolfromString(String prompt, String yes, String no) {
    String answer;
    do {
      Format.print(prompt);
      answer = scanner.hasNextLine() ? scanner.nextLine() : null;
    } 
    while (answer == null || (!answer.equals(yes) && !answer.equals(yes.substring(0, 1))
      && !answer.equals(no) && !answer.equals(no.substring(0, 1))));
    return (answer.equals(yes) || answer.equals(yes.substring(0, 1)));
  }
  
  
  //@ ensures \result == true || \result == false;
  /**
   * Method to 'convert' integer to a boolean.
   * Used in the server/client properties
   * @param arg int will only return true if 1
   * @return boolean, true if the arg is 1 or false if any other value (0 most likely)
   */
  public static Boolean readBoolfromInt(int arg) {
    Boolean result = false;
    if (arg == 1) {
      result = true;
    }
    return result;
  }
}
