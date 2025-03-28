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


practical 1: overloding

public class Fruit {
    private double fprice;
    private String fname;

    // Default constructor
    Fruit() {
        System.out.println("This Is Default Constructor");
    }

    // Overloaded constructor
    Fruit(double fPrice, String fName) {
        this.fprice = fPrice;
        this.fname = fName;
    }

    // Copy constructor
    Fruit(Fruit fruit) {
        System.out.println("\nAfter invoking the Copy Constructor:\n");
        this.fprice = fruit.fprice;
        this.fname = fruit.fname;
    }

    // Method to show price
    double showPrice() {
        return fprice;
    }

    // Method to show name
    String showName() {
        return fname;
    }

    public static void main(String args[]) {
        // Default constructor
        Fruit f = new Fruit();

        // Overloaded constructor
        Fruit f1 = new Fruit(399, "Ruby Roman Grapes");
        System.out.println("You are in Constructor Overloading");
        System.out.println("Name of the first fruit: " + f1.showName());
        System.out.println("Price of the first fruit: " + f1.showPrice());

        // Copy constructor
        Fruit f2 = new Fruit(f1);
        System.out.println("Name of the second fruit: " + f2.showName());
        System.out.println("Price of the second fruit: " + f2.showPrice());
    }
}



practical 2: abstract class and method

abstract class Shape {
    // Abstract method for calculating area
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    // Constructor to initialize the radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of the area method
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class Pract2B {
    public static void main(String args[]) {
        // Create an instance of Circle and call the area method
        Circle c = new Circle(15.0);
        System.out.println("Area of circle is: " + c.area());
    }
}


practical 3:swing

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class FileChooserExample extends JFrame implements ActionListener {
    static JLabel label;

    // Constructor
    FileChooserExample() {
    }

    public static void main(String args[]) {
        // Create the JFrame
        JFrame frame = new JFrame("File Chooser Example");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Open");

        // Create instance of FileChooserExample to handle events
        FileChooserExample fileChooserExample = new FileChooserExample();
        saveButton.addActionListener(fileChooserExample);
        openButton.addActionListener(fileChooserExample);

        // Create JPanel and add components
        JPanel panel = new JPanel();
        panel.add(saveButton);
        panel.add(openButton);

        label = new JLabel("No file selected");
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();

        if (command.equals("Save")) {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                label.setText(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                label.setText("The user cancelled the operation.");
            }
        } else if (command.equals("Open")) {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                label.setText(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                label.setText("The user cancelled the operation.");
            }
        }
    }
}



practical 4: border layout


import java.awt.*; 
import javax.swing.*; 

class BorderDemo { 
    JFrame f; 

    // Constructor to set up the frame and layout
    BorderDemo() { 
        f = new JFrame("BorderLayout Demo"); 
        
        // Adding buttons to respective regions
        JButton b1 = new JButton("NORTH"); 
        JButton b2 = new JButton("SOUTH"); 
        JButton b3 = new JButton("EAST"); 
        JButton b4 = new JButton("WEST"); 
        JButton b5 = new JButton("CENTER"); 
        
        f.add(b1, BorderLayout.NORTH); 
        f.add(b2, BorderLayout.SOUTH); 
        f.add(b3, BorderLayout.EAST); 
        f.add(b4, BorderLayout.WEST); 
        f.add(b5, BorderLayout.CENTER); 
        
        // Frame properties
        f.setSize(300, 300); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true); 
    } 

    public static void main(String[] args) { 
        // Instantiate the BorderDemo to display the UI
        new BorderDemo(); 
    } 
}



practical 5: action event

import java.awt.*; 
import java.awt.event.*; 

class ActEvent extends Frame implements ActionListener { 
    TextField tf; 

    // Constructor
    ActEvent() { 
        tf = new TextField(); 
        tf.setBounds(60, 50, 170, 20); 
        
        Button b = new Button("Click Me"); 
        b.setBounds(100, 120, 80, 30); 
        b.addActionListener(this); 
        
        // Add components to frame
        add(b); 
        add(tf); 
        
        // Frame properties
        setSize(300, 300); 
        setLayout(null); 
        setVisible(true); 
    } 

    @Override
    public void actionPerformed(ActionEvent e) { 
        // Set text in TextField upon button click
        tf.setText("Welcome"); 
    } 

    public static void main(String args[]) { 
        // Create an instance of ActEvent to display the frame
        new ActEvent(); 
    } 
}









