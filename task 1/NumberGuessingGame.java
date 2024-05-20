import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 5;
        int value = random.nextInt(50);
        System.out.println("You are given 5 attempts to guess the number correctly!!");
        while (count > 0) {
            System.out.println("Please Enter a number between 0 to 50:");
            int guess = sc.nextInt();
            if (guess == value) {
                System.out.println("Congratulations! you have guessed the number correctly !!");
                break;
            } else if (guess < value) {
                System.out.println("The guessed number is too low");
            } else if (guess > value) {
                System.out.println("The guessed number is too high");
            }
            count--;
            System.out.println("You have "+count+" attempts left!!");
            if(count==1){
                System.out.println("You have only"+count+" attempt left!!");
            }
        }
        if(count<0){
            System.out.println("Sorry!! You could not guess the number correctly!");
        }
        sc.close();
    }
}