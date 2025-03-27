// 1) abstract class
import java.util.*;

abstract class Animal{
  abstract void makeSound();
  // concrete
  void sleep(){
    System.out.println("sleeping...");
  }
}
//inherit
class Dog extends Animal{
  void makeSound(){
    System.out.println("dog barks");
  }
}

public class Main{
  public static void main(String[] args){
    Dog d = new Dog();
    d.sleep();
    d.makeSound();
  }
}

// 2) all class constructor
import java.util.*;

class person{
  String name;
  int age;
  
  person(){
    name = "default constructor";
    age =0;
  }
  person(String n, int a){
    name = n;
    age = a;
  }
  person(person p){
    name = p.name;
    age = p.age;
  }
  void display(){
    System.out.println(name + "_" + age);
  }
  public static void main(String [] args){
    person p1 = new person();
    person p2 = new person("sahitya",22);
    person p3 = new person(p2);
    
    p1.display();
    p2.display();
    p3.display();
  }
}

// 3)TextFileViewer 


import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextFileViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Viewer");
        JTextArea textArea = new JTextArea(20, 50);
        JButton openButton = new JButton("Open File");

        openButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()))) {
                    textArea.read(br, null);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error!");
                }
            }
        });

        frame.add(openButton, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// 4) BorderLayoutExample

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setLayout(new BorderLayout());

        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("West"), BorderLayout.WEST);
        frame.add(new JButton("Center"), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// 5) ActionEventExample ActionEventExample ActionEventExample 

import javax.swing.*;
import java.awt.*;

public class ActionEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Action Event Example");
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Button Not Clicked", SwingConstants.CENTER);

        // Action Listener for Button
        button.addActionListener(e -> label.setText("Button Clicked!"));

        // Layout & Components
        frame.setLayout(new BorderLayout(10, 10)); // Add spacing
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        // Frame Settings
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}


