package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player initiator = new Player();
        Player receiver = new Player();
        Scanner input = new Scanner(System.in);

        int counter = 1;
        do {
            System.out.print("Please enter your " + counter + ". message: ");
            String message = input.nextLine();
            initiator.sendMessage(receiver, message);
            String reply = receiver.getNextReceivedMessage();
            System.out.println("Message received: " + reply);
            counter++;
            int leftMessages = 11 - counter;
            if (leftMessages == 0) {
                System.out.println("You cannot send more messages. The program is shutting down. See you soon!");
            } else {
                System.out.println("You can still send " + leftMessages + " more messages.");
            }
        } while (counter <= 10);

        input.close();
    }
}
