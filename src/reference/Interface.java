/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reference;


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */        
public class Interface{
     /**
     * @param frame
     */
    
    public static void _c_Frame(JFrame frame)
    {
        Rectangle rec = frame.getBounds();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation((dim.width - rec.width)/2, (dim.height - rec.height)/2);
    }

 
    public void setIconFrame(JFrame frame)
    {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/console.png")));
        frame.setTitle("Oasis Infobyte");
    }

    public static void _int_Only(KeyEvent evt){
        char _character = evt.getKeyChar();
        if (Character.isDigit(_character)
                || _character == KeyEvent.VK_SPACE
                || _character == KeyEvent.VK_DELETE
                || _character == KeyEvent.VK_SLASH) {
        }else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static void _msg(String message, int errorTye) {
        
        switch (errorTye) {
            case 0:
                JOptionPane.showMessageDialog(null, message, "MESSAGE", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, message, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, message, "WARNING", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                break;
        }
    }
    
    private static String F_BestScore = System.getProperty("user.dir") + "/src/Interface/best_Score.ini";
    
    public static int C_BestScore() {
        int bestScore;
        String line, newLine = "";
        try {
            BufferedReader buff= new BufferedReader(new FileReader(F_BestScore));
            while ((line = buff.readLine())  !=null) {
                newLine = line;
            }
        }catch (FileNotFoundException e) {
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        bestScore = Integer.parseInt(newLine.substring(newLine.indexOf("[") + 1, newLine.indexOf("]")));
        
        return bestScore;
    }
    
    public static void setNewBestScore(String newContent) {
        try {
            File fileToUpdate = new File(F_BestScore);
            try (FileWriter fileWrite = new FileWriter(fileToUpdate)){
                fileWrite.write(newContent);
                fileWrite.close();
            }
        } catch (Exception e) {
        }
    }
}