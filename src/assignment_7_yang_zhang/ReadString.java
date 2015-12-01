package assignment_7_yang_zhang;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 2.Based on problem 1, create a button and textarea on the same layout. Each time you click the button, 
 * it will read a string from ArrayList in order and show it in the textarea. 
 * When number of clicks beyond the ArrayList, pop up an alert menu.
 */

@SuppressWarnings("serial")
public class ReadString extends JFrame{
    private JButton button;
    private TextArea text;
    private ArrayList<String> list;
    private int currentIndex;
    
    public ReadString(File file) throws Exception {
        setTitle("Read String from File");
        create();
        add();
        addListeners();
        setSize(500, 500);
        setVisible(true);
        
        list = AddLineToList(file);
        currentIndex = 0;
        
    }
    
    public void create() {
        button = new JButton("show next line");
        text = new TextArea();
    }
    
    public void add() {
        FlowLayout fl = new FlowLayout();
        Container con = getContentPane();
        con.setLayout(fl);
        con.add(text);
        con.add(button);  
    }
    
    private void addListeners() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex == list.size()) {
                    JOptionPane.showMessageDialog(null, "Already reach the end of the file..");
                } else {
                    text.append(list.get(currentIndex));
                    currentIndex++;
                }
            }
        });
    }
    
    private static ArrayList<String> AddLineToList(File file) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String  thisLine = null;
        while ((thisLine = br.readLine()) != null) {
            result.add(thisLine);
        } 
        br.close();
        return result;
    }
    
    public static void main(String args[]) throws Exception {
        File file = new File("/Users/gotta/Documents/workspace/Assignment_7/src/assignment_7_yang_zhang/TestFile.txt");
        new ReadString(file);
    }    
}
