/**
* This is a elementary ChatBot program that mirrors words responds back to the user. 
* 
*
* @author  Sophia Silovsky
* @version 1.0
* @since   2024-02-14
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.String;

class Conversation {

  public static void main(String[] arguments) {

    Scanner sc = new Scanner(System.in);
    // initiallizing all variables used
    int inputNum = 0;
    int roundNum = -1;
    int transcriptInd = 1;
    Random randomNum = new Random();
    String inputStr = "test";
    String replyString = "";
    String reply[];
    String transcript[];
    String cannedPhrases[];

    // array of canned phrases
    cannedPhrases = new String[] { "Oh wow!", "Uh ok.", "For real?", "Sure sure", "Hmmm" };

    // beginning of printed output
    System.out.println("How many rounds?");
    inputNum = sc.nextInt();
    System.out.println("Hello there! What's on your mind?");

    // initiallizing the number of values in the array
    transcript = new String[(inputNum * 2) + 2];
    transcript[0] = "TRANSCRIPT: ";
    transcript[1] = "Hello there! What's on your mind?";

    while (roundNum != inputNum) {

      inputStr = sc.nextLine();
      // split the inputed string into an array
      String[] split = inputStr.split("\\s+");
      // copy the array so that the split keeps the original array
      reply = split.clone();

      // add the user inputed string to the transcript
      if (roundNum != -1) {
        transcript[roundNum + transcriptInd] = inputStr;
      }

      if (roundNum != -1) {
        for (int i = 0; i < split.length; i++) {
          if ((split[i].matches("you") || split[i].matches("You"))) {
            reply[i] = "I";
          } else if (split[i].matches("you") || split[i].matches("You")) {
            reply[i] = "I";
          } else if (split[i].matches("I") || split[i].matches("me")) {
            reply[i] = "you";
          } else if (split[i].matches("are")) {
            reply[i] = "am";
          } else if (split[i].matches("am")) {
            reply[i] = "are";
          } else if (split[i].matches("Me")) {
            reply[i] = "You";
          } else if (split[i].matches("your")) {
            reply[i] = "my";
          } else if (split[i].matches("Your")) {
            reply[i] = "My";
          } else if (split[i].matches("my")) {
            reply[i] = "your";
          } else if (split[i].matches("My")) {
            reply[i] = "Your";
          } 
        }
      }

      // convert the reply array into a string
      replyString = String.join(" ", reply);

      // if no clone words were detected, the reply will be a random canned phrase
      if (inputStr.equals(replyString) && roundNum != -1) {
        replyString = cannedPhrases[randomNum.nextInt(cannedPhrases.length)];
      }

      System.out.println(replyString);

      // add the reply to the transcript
      if (roundNum != -1) {
        transcript[roundNum + transcriptInd + 1] = replyString;
      }

      // increase round number and the transcript index
      roundNum += 1;
      transcriptInd += 1;

    }
    sc.close();

    // print complete transcript
    for (int i = 0; i < transcript.length; i++)
      System.out.println(transcript[i]);
  }
}
