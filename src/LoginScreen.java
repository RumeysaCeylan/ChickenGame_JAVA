
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rumeysa's Monster
 */
public class LoginScreen extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userName = new JLabel("NICK NAME");
    JLabel label = new JLabel("FLYING CHICKEN");
   JLabel head = new JLabel("~~~~~~~~RULES~~~~~~~~~~");
           
    JLabel rule1 = new JLabel("1) Use keys A and D to move");
    JLabel rule2 = new JLabel("2) <-- is left fire and --> is right fire");
    JLabel rule3 = new JLabel("3)SPACE is double fire");
    JLabel rule4 = new JLabel("4)You have to hit more targets and get more points to pass the hard level.  ");
    JTextField userText = new JTextField();
    
    JButton resetButton = new JButton("EXIT GAME");
    JButton r1 = new JButton("EASY");
    JButton r2 = new JButton("HARD");
    
 
       
      
    
    
    LoginScreen() throws IOException {
     
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer(); 
        addActionEvent();
        
    }

        
        
    
        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("label1");
        label1.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            
            userText.setText("");
            System.exit(0);
        }

        if (e.getSource() == r1) {

            Screen screen = new Screen("CHICKEN GAME");
            screen.setResizable(false);
            screen.setFocusable(false);
            ImageIcon image = new ImageIcon("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\icon.jpg");
            screen.setSize(800, 800);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String userTexts;
            userTexts = userText.getText();

            JOptionPane.showMessageDialog(this, "Hello  " + userTexts);
            GamePanel gpanel = new GamePanel();
            gpanel.requestFocus();
            gpanel.addKeyListener(gpanel);
            gpanel.setFocusable(true);
            gpanel.setFocusTraversalKeysEnabled(false);
            gpanel.setBounds(0, 0, 900, 800);
            screen.setIconImage(image.getImage()); //change icon of this

            screen.add(gpanel);
            screen.setVisible(true);

        }
        if (e.getSource() == r2) {
            Screen screen = new Screen("CHICKEN GAME");
            screen.setResizable(false);
            screen.setFocusable(false);
            ImageIcon image = new ImageIcon("C:\\Users\\Rumeysa\\Desktop\\desk\\ChickenGame\\src\\icon.jpg");
            screen.setSize(800, 800);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String userTexts;
            userTexts = userText.getText();
            JOptionPane.showMessageDialog(this, "Hello  " + userTexts);
            HardGame gpanel = new HardGame();
            gpanel.requestFocus();
            gpanel.addKeyListener(gpanel);
            gpanel.setFocusable(true);
            gpanel.setFocusTraversalKeysEnabled(false);
            gpanel.setBounds(0, 0, 900, 800);
            screen.setIconImage(image.getImage()); //change icon of this
            screen.add(gpanel);
            screen.setVisible(true);

        }
    }

    public void setLayoutManager() {
         
        container.setLayout(null);

    }

    public void setLocationAndSize() {
        head.setBounds(100, 250, 300, 50);
        label.setBounds(200,40,300,30);
        rule1.setBounds(100,300,300,50);
        rule2.setBounds(100,330,300,50);
        rule3.setBounds(100,360,300,50);
        rule4.setBounds(100,390,500,50);
        userName.setBounds(80, 100, 100, 30);
        userText.setBounds(170, 100, 150, 30);
        
        resetButton.setBounds(340, 150, 100, 30);
        r1.setBounds(50, 150, 100, 30);
        r2.setBounds(200, 150, 100, 30);
    }

    public void addComponentsToContainer() {

        container.add(userName);
        container.add(userText);
        container.add(label);
        container.add(head);
        container.add(rule1);
        container.add(rule2);
        container.add(rule3);
        container.add(rule4);
        container.add(resetButton);
        container.add(r1);
        container.add(r2);
        
        
    }

    public void addActionEvent() throws FileNotFoundException, IOException {
        
       
        resetButton.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);
       
       
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables

}
