/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import compressdecompress.CompressDecompress;
import compressdecompress.Decompress;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class View extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;
   View(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(null);
       compressButton = new JButton("Select a file to compress");
       compressButton.addActionListener(this);
       compressButton.setBounds(20, 100, 200, 30);
       
       decompressButton = new JButton("Select a file to Decompress");
       decompressButton.addActionListener(this);
       decompressButton.setBounds(250, 100, 200, 30);
       
       this.add(compressButton);
       this.add(decompressButton);
       this.setSize(500,200);
       this.getContentPane().setBackground(Color.black);
   }
   @Override
   public void actionPerformed(ActionEvent e){
         if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                
                try{
                    Decompress.method(file);
                    JOptionPane.showMessageDialog(null, "Decompression Successful");
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
       if(e.getSource() == compressButton){
           JFileChooser fileChooser = new JFileChooser();
           int response = fileChooser.showSaveDialog(null);
           
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               try {
                   CompressDecompress.method(file);
                      JOptionPane.showMessageDialog(null,"Compression Success");
               }
               catch(Exception ex){
                   JOptionPane.showMessageDialog(null,ex.toString());
               }
           }
       }
    
   }
   public static void main(String args[]){
       View frame = new View();
       frame.setVisible(true);
   }
    
}
