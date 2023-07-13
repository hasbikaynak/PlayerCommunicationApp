package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {
    private static final Logger logger = Logger.getLogger(Player.class.getName());
    private final BlockingQueue<String> receivedMessages = new LinkedBlockingQueue<>();
    private final BlockingQueue<String> sentMessages = new LinkedBlockingQueue<>();

    public void sendMessage(Player receiver, String message) {
        try {
            receiver.receiveMessage(message);
            sentMessages.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Error occurred while sending message", e);
        }
    }

    private void receiveMessage(String message) {
        try {
            receivedMessages.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Error occurred while sending message", e);
        }
    }

    public String getNextReceivedMessage() {
        try {
            return receivedMessages.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Error occurred while sending message", e);
            return null;
        }
    }
}
