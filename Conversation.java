import java.util.Scanner;
import java.util.Random;
import java.lang.String;

class Conversation {

  public static void main(String[] arguments) {

    Scanner sc = new Scanner(System.in);
    int input_num = 0;
    int round_num = -1;
    int transcript_ind = 1;
    Random random_num = new Random();
    String input_str = "test";
    String replyString = "";
    String reply[];
    String transcript[];
    String cannedPhrases[];

    cannedPhrases = new String[] { "Oh wow!", "Uh ok.", "For real?", "Sure sure", "Hmmm" };

    System.out.println("How many rounds?");
    input_num = sc.nextInt();
    System.out.println("Hello there! What's on your mind?");

    // initiallizing the number of values in the array
    transcript = new String[(input_num * 2) + 2];
    transcript[0] = "TRANSCRIPT: ";
    transcript[1] = "Hello there! What's on your mind?";

    while (round_num != input_num) {

      input_str = sc.nextLine();
      String[] split = input_str.split("\\s+");
      reply = split.clone();

      if (round_num != -1) {
        transcript[round_num + transcript_ind] = input_str;
      }

      if (round_num != -1) {
        for (int i = 0; i < split.length; i++) {
          if ((split[i].contains("you") || split[i].contains("You")) && split[i + 1].contains("are")) {
            reply[i] = "I";
            reply[i + 1] = "am";
          } else if (split[i].contains("you") || split[i].contains("You")) {
            reply[i] = "I";
          } else if ((split[i].contains("I")) && split[i + 1].contains("am")) {
            reply[i] = "you";
            reply[i + 1] = "are";
          } else if (split[i].contains("I") || split[i].contains("me")) {
            reply[i] = "you";
          } else if (split[i].contains("Me")) {
            reply[i] = "You";
          } else if (split[i].contains("your") || split[i].contains("Your")) {
            reply[i] = "my";
          } else if (split[i].contains("Your")) {
            reply[i] = "My";
          } else if (split[i].contains("my")) {
            reply[i] = "your";
          } else if (split[i].contains("My")) {
            reply[i] = "Your";
          } else if ((split[i].contains("am")) && split[i + 1].contains("I")) {
            reply[i] = "are";
            reply[i + 1] = "you";
          } else if ((split[i].contains("are")) && split[i + 1].contains("you")) {
            reply[i] = "am";
            reply[i + 1] = "I";
          }
        }
      }

      replyString = String.join(" ", reply);

      if (input_str.equals(replyString) && round_num != -1) {
        replyString = cannedPhrases[random_num.nextInt(transcript.length)];
      }

      System.out.println(replyString);

      if (round_num != -1) {
        transcript[round_num + transcript_ind + 1] = replyString;
      }

      round_num += 1;
      transcript_ind += 1;

    }
    sc.close();

    for (int i = 0; i < transcript.length; i++)
      System.out.println(transcript[i]);
  }
}
