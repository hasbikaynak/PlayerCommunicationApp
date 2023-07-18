package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Player initiator = new Player();
        final Player receiver = new Player();
        final Scanner input = new Scanner(System.in);

        int counter = 1;
        do {
            System.out.print("Please enter your " + counter + ". message: ");
            final String message = input.nextLine();
            initiator.sendMessage(receiver, message);
            final String reply = receiver.getNextReceivedMessage();
            System.out.println("Message received: " + reply);
            counter++;
            final int leftMessages = 11 - counter;
            if (leftMessages == 0) {
                System.out.println("You cannot send more messages. The program is shutting down. See you soon!");
            } else {
                System.out.println("You can still send " + leftMessages + " more messages.");
            }
        } while (counter <= 10);

        input.close();
    }
}
