// Project: Java Timer
// Author: Chad Bell
// Date: 2/16/23
// Purpose: Create a basic timer in Java to track my projects. 

// Imports
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;




// Timer Program Class
public class Timer_Program{

  // Keep track of the start time of the timer
  private static long startTime;

  public static void main(String[] args) {
    
    // initialize the GUI
    JFrame f = new JFrame("My Java Timer");
    // Set the size of the GUI window 
    f.setSize(250, 250);
    // Set the location onscreen of the GUI
    f.setLocation(0,0);
    JTextArea textArea = new JTextArea(10, 40);
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    // The start timer button
    JButton startButton = new JButton("Start Timer");
    // Add the start button to the bottom of the panel
    f.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, startButton);
    // The stop timer button
    JButton stopButton = new JButton("Stop Timer");
    // Add the start button to the bottom of the panel
    f.getContentPane().add(BorderLayout.SOUTH, stopButton);
    // Add the company name text field
    JTextField textField = new JTextField("Add company name here", 40);
    f.getContentPane().add(BorderLayout.NORTH, textField);


    // Timer to refresh the screen every second
    Timer timer = new Timer(1000, new ActionListener() {    
        @Override
        public void actionPerformed(ActionEvent e) {
          // Get the current time
          long elapsedTime = System.currentTimeMillis() - Timer_Program.startTime;
          // Convert the time to hours
          long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
          // Subtract the hours from the minutes
          long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) % 60;
          // Subtract the minutes from the seconds
          long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % 60;
        
          String formattedElapsedTime = String.format("%d hr, %d min, %d sec", 
            hours,
            minutes,
            seconds
        );

        System.out.println(formattedElapsedTime);

        // Set decimal format
        DecimalFormat dec = new DecimalFormat("###.##");
        // Show the timer, rate, and invoice details
        textArea.setText("Timer:\n" + 
                        formattedElapsedTime + "\n" +
                        "Rate:\n" + 
                        "$20/hr\n" +
                        "Invoice:\n" + 
                        "$" + dec.format(elapsedTime* 20.0/1000.0/60.0/60.0));
        }
    });

    // Start timer button
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Timer_Program.startTime = System.currentTimeMillis();
        // Print out details for error tracking
        System.out.print("Start Time ");
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis()));
        timer.start();
    }});

    stopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Print out details for error tracking
        System.out.print("Stop Time ");
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis()));
        timer.stop();
        Path filePath = Paths.get("invoice.txt");
        try {
          Files.writeString(filePath, "Hello World !!", StandardOpenOption.APPEND);
        } catch (IOException e1) {
          e1.printStackTrace();
        }


    }});

    // Show the GUI
    f.setVisible(true);

  }

}

// Beginning Code:
// https://stackoverflow.com/questions/5118701/how-to-create-a-gui-in-java
// https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java

// TODO
// Export results to text
// Add multiple timers
// Add pause feature
