import java.util.Scanner;
import java.util.Random;

class Conversation {

  public static void main(String[] arguments) {
    Scanner sc = new Scanner(System.in);

    int input_num = 0;
    int round_num = -1;
    int transcript_ind = 1;
    Random random_num = new Random();
    String input_str = "test";
    String reply = "";
    String transcript[];
    String cannedPhrases[];

    cannedPhrases = new String[]{"Oh wow!", "Uh ok.", "For real?", "Sure sure", "Hmmm"};

    System.out.println("How many rounds?");
    input_num = sc.nextInt();
    System.out.println("Hello there! What's on your mind?");

    // initiallizing the number of values in the array 
    transcript = new String[(input_num * 2) + 2];
    transcript[0] = "TRANSCRIPT: ";
    transcript[1] = "Hello there! What's on your mind?";

    while (round_num != input_num) {
      
      input_str = sc.nextLine();
      reply = input_str;

      if (round_num != -1){
        transcript[round_num + transcript_ind] = input_str;
      }
      
      if (round_num != -1){
        if (input_str.contains("you are") || input_str.contains("You are")){
          reply = reply.replaceAll("you are", "I am");
          reply = reply.replaceAll("You are", "I am");;
        }
        else if (input_str.contains("you") || input_str.contains("You")){
          reply = reply.replaceAll("\\byou\\b", "I");
          reply = reply.replaceAll("\\bYou\\b", "I");
        }
        else if (input_str.contains("I am")){
          reply = reply.replaceAll("I am", "you are");
        }
        else if (input_str.contains("I ")){
          reply = reply.replaceAll("\\bI\\b", "you");
        }
        else if (input_str.contains("your") || input_str.contains("Your")){
          reply = reply.replaceAll("\\byour\\b", "my");
          reply = reply.replaceAll("\\bYour\\b", "My");
        }
        else if (input_str.contains("my") || input_str.contains("My")){
          reply = reply.replaceAll("\\bmy\\b", "your");
          reply = reply.replaceAll("\\bMy\\b", "your");
        }
        // else if (input_str.contains(".")){
        //   reply = input_str.replaceAll("\\.", "?");
        // }
        else {
          reply = cannedPhrases[random_num.nextInt(transcript.length)];
        }
      }
    
      System.out.println(reply);

      if (round_num != -1){
        transcript[round_num + transcript_ind + 1] = reply;
      }

      round_num += 1;
      transcript_ind += 1;


    }
    sc.close();

    for (int i = 0; i < transcript.length; i++)
      System.out.println(transcript[i]);
  }
}
