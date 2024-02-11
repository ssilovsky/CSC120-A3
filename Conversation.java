import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    Scanner sc = new Scanner(System.in);

    int input_num = 0;
    int round_num = -1;
    String input_str = "test";

    System.out.println("How many rounds?");
    input_num = sc.nextInt();


    System.out.println("Hello there! What's on your mind?");

    while (round_num != input_num) {
      
      input_str = sc.nextLine();

      if (input_str.contains("you") || input_str.contains("You")){
        input_str = input_str.replace("you", "I");
        input_str = input_str.replace("You", "I");
        input_str = input_str.replace(".", "?");}

      System.out.println(input_str);


      round_num += 1;


    }
    sc.close();
  }
}
