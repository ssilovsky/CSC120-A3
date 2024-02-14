import java.util.Scanner;
import java.util.Random;

class Conversation {

  public static void main(String[] arguments) {
    Scanner sc = new Scanner(System.in);

    int input_num = 0;
    int round_num = -1;
    int transcript_ind = 1;
    String input_str = "test";
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

      if (round_num != -1){
        transcript[round_num + transcript_ind] = input_str;
      }
      

      if (input_str.contains("you") || input_str.contains("You")){
        input_str = input_str.replaceAll("\\byou\\b", "I");
        input_str = input_str.replaceAll("\\bYou\\b", "I");
        input_str = input_str.replaceAll(".", "?");}

      System.out.println(input_str);

      // System.out.println(round_num);

      if (round_num != -1){
        transcript[round_num + transcript_ind + 1] = input_str;
      }





      round_num += 1;
      transcript_ind += 1;


    }
    sc.close();
    for (int i = 0; i < transcript.length; i++)
      System.out.println(transcript[i]);
  }
}
