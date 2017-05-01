package pokr.util;

import java.util.regex.PatternSyntaxException;

/**
 * Format class for the Cubic4 4 in a row game. 
 * This class handles string formatting used in the TUI.
 * Programming project of M2
 * 
 * @author Arthur de Koning
 * @author Steen Kiezel
 *
 */
public class Format {
  // -- Instance Variables ------------------------------
  private static final String boxTop = "*==================================="
      + "===========================*\n"
      + "|                                                              |\n";
  private static final String boxBottom = "|                                  "
      + "                            |\n*============================="
      + "=================================*\n";
  private static final String boxBorder = "|";
  private static final String[] leaderboardHead = new String[3];
  private static int boxWidth = 64;
  private static final int boxMargin = 2;
  private static final int limit = boxWidth - (2 * boxMargin);
  
  
  // -- Commands ----------------------------------------
  //@ requires message != null;
  /**
   * prints the message after being formatted.
   * @param message string to be formatted
   */
  public static void print(String message) {
    System.out.println(formatString(message));
  }
  
  //@ requires message != null;
  //@ ensures \result != null && \result instanceof String;
  /**
   * Treats the string as being a single line in a message box.
   * Constructing its border and creating the filler between border and text
   * @param message, string to be formatted
   * @result formatted result String
   */
  private static String formatStringLine(String message) {
    String filler = "";
    String fillerLeft = "";
    String fillerRight = "";
    int limit = boxWidth - (2 * boxMargin);
    for (int i = 0; i < (limit - message.length()); i++) {
      filler += " ";
    }
    fillerLeft = filler.substring(0, filler.length() / 2);
    fillerRight = filler.substring((filler.length() / 2));
    String result = boxBorder + " " + fillerLeft + message + fillerRight + " " + boxBorder + "\n";
    return result;
  }
  
  //@ requires message != null;
  //@ ensures \result != null && \result instanceof String;
  /**
   * Processes the string through the various formatStringX methods.
   * @param message, string to be formatted
   * @result formatted result String
   */
  private static String formatString(String message) {
    String result = boxTop;

    if (message.contains("\n")) {
      result += formatNewlineString(message);
    } else if (message.length() > limit) {
      result += formatLongString(message);
    } else {
      result += formatStringLine(message);
    }
    result += boxBottom;
    return result;
  }
  
  //@ requires message != null;
  //@ ensures \result != null && \result instanceof String;
  /**
   * Processes the string if it contains a newline (\n) character.
   * @param message, string to be formatted
   * @result formatted result String
   */
  private static String formatNewlineString(String message) {
    String result = "";
    String[] splitArray = null;
    try {
      splitArray = message.split("\\\n");
    } catch (PatternSyntaxException exp) {
      exp.getLocalizedMessage();
    }
    int intI = 0;
    while (intI < splitArray.length) {
      if (splitArray[intI].length() > limit) {
        result += formatLongString(splitArray[intI]);
      } else {
        result += formatStringLine(splitArray[intI]);
      }
      intI++;
    }
    return result;
  }

  //@ requires message != null;
  //@ ensures \result != null && \result instanceof String;
  /**
   * Processes the string if its size is larger than the limit of the TUI boxes.
   * @param message, string to be formatted
   * @result formatted result String
   */
  private static String formatLongString(String message) {
    String temp = "";
    String result = "";
    String[] splitArray = null;
    try {
      splitArray = message.split("\\s+");
    } catch (PatternSyntaxException exp) {
      exp.getLocalizedMessage();
    }
    int intI = 0;
    while  (intI < splitArray.length)   {
      if (temp.length() + splitArray[intI].length() < limit) {
        temp += splitArray[intI] + " ";
      } else {
        result += formatStringLine(temp);
        intI--;
        temp = "";
      }
      intI++;
    }
    result += formatStringLine(temp);
    return result;
  }

  //@ requires lead != null;
  /**
   * Formats the leaderboard.
   * @param lead leaderboard
   */
  public static void printLeaderboard(String lead) {
    leaderboardHead[0] = "Playername:";
    leaderboardHead[1] = "win/lose:";
    leaderboardHead[2] = "Time:";
    //temp contains all entries
    String[] temp = lead.split(" ");
    String[] entry = new String[3];
    String result = boxTop + formatStringLine("Leaderboard:") + column3format(leaderboardHead);
    for (int i = 0; i < temp.length - 1; i += 3) {
      System.out.println(temp[i + 2]);
      entry[0] = temp[i];
      entry[1] = temp[i + 1];  
      entry[2] = temp[i + 2];
      result += leaderBoardline(entry);
    }
    result += boxBottom;
    System.out.println(result);
  }

  //@ requires string != null;
  //@ ensures \result != null && \result instanceof String;
  /**
   * Method to format the leaderboard.
   * @param string current leaderboard chopped into a String[]
   * @return formatted leaderboard string
   */
  private static String leaderBoardline(String[] string) {
    System.out.println("LB: " + string[1]);
    String[] fill = new String[3];
    String result = "";
    if (string[0].length() > (boxWidth - (2 * boxMargin)) / 3) {
      //name is too big to format
      result += fillLeft(string[0]);
      fill[0] = "";
      fill[1] = string[1];
      fill[2] = string[2];
      result += column3format(fill);
    } else {
      result += column3format(string);
      //3 columns 
      //2 + column1 + 2 + column2 + 2 + column3 + 2
      //columnspace = (64-8)/3
    }
    return result;
  }

  //@ requires string != null;
  //@ ensures \result != null && \result instanceof String; 
  /**
   * Format a string by padding it all the way to the left.
   * @param string message to be formatted
   * @return formatted result String
   */
  private static String fillLeft(String string) {
    String result = boxBorder + " " + string;
    String filler = "";
    for (int i = 0; i < boxWidth - (2 * boxMargin) - string.length(); i++) {
      filler += " ";
    }
    return result + filler + " " + boxBorder + "\n";
  }
  
  //@ requires string != null;
  //@ ensures \result != null && \result instanceof String;
  /**
   * Formats a string array into strings of 3 items.
   * @param string 3 items to be formatted into one line
   * @return formatted result string
   */
  private static String column3format(String[] string) {
    String[] copy = new String[string.length];
    copy = string;
    System.out.println("c3f: " + string[1]);
    int size = (boxWidth - (boxMargin * 4) + 4) / 3;
    String result = boxBorder + " " + format(copy[0], size) + "" + format(copy[1], size) 
        + "" + format(copy[2], size) + " " + boxBorder + "\n";
    return result;
  }

  //@ requires string != null && size >= string.length();
  //@ ensures \result != null && \result instanceof String;
  /**
   * Formats a string into a string with equal padding on either site based on 
   * size - string.length(). 
   * @param string nessage to be formatted
   * @param size amount of space to fit the string in
   * @return formatted result string
   */
  private static String format(String string, int size) {
    String filler = "";
    String fillerLeft = "";
    String fillerRight = "";
    for (int i = 0; i < (size - string.length()); i++) {
      filler += " ";
    }
    fillerLeft = filler.substring(0, filler.length() / 2);
    fillerRight = filler.substring((filler.length() / 2));
    return fillerLeft + string + fillerRight;
  }
}