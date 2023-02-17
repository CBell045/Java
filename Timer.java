// Project: Java Timer
// Author: Chad Bell
// Date: 2/16/23
// Purpose: Create a basic timer in Java to track my projects. 

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Timer{

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    System.out.println(new SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis()));


    JFrame f = new JFrame("My Java Timer");
    f.setSize(250, 250);
    f.setLocation(0,0);
    final JTextArea textArea = new JTextArea(10, 40);
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    final JButton button = new JButton("Start Timer");
    f.getContentPane().add(BorderLayout.SOUTH, button);
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(hours);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.HOURS.toMinutes(hours) - TimeUnit.MINUTES.toMillis(minutes);

            String formattedElapsedTime = String.format("%d hr, %d min, %d sec", 
                hours,
                minutes,
                seconds
            );

            System.out.println(formattedElapsedTime);
            textArea.setText("Timer\n" + formattedElapsedTime);
        }
    });

    f.setVisible(true);

  }

}

// Beginning Code:
// https://stackoverflow.com/questions/5118701/how-to-create-a-gui-in-java
// https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java

// todo
// Create a timer
// Add price and billing
// Export results to pdf
// Add multiple timers

