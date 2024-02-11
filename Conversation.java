import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    Scanner sc = new Scanner(System.in);

    int input_num = 0;
    int round_num = 0;

    System.out.println("How many rounds?");
    input_num = sc.nextInt();
    sc.close();

    while (round_num != input_num) {

      System.out.println("yippee!");
      round_num += 1;


    }
  }
}
