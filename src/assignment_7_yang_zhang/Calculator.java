package assignment_7_yang_zhang;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Calculator extends JFrame{
    public static final String[][] BUTTON_TEXTS = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"0", ".", "/", "="}
         };
    private JPanel mainPanel;
    private JTextField screen;
    private JButton[] buttons;
    private JPanel btnPanel;
    private String calculateString;
    
    public Calculator(){
        createInterface();
        calculateString = "";
    }
    
    public void createInterface() {
        screen = new JTextField(10);
        btnPanel = new JPanel(new GridLayout(BUTTON_TEXTS.length, BUTTON_TEXTS[0].length));
        buttons = new JButton[16];
        for (int i = 0; i < BUTTON_TEXTS.length; i++) {
            for (int j = 0; j < BUTTON_TEXTS[i].length; j++) {
               buttons[i*4 + j] = new JButton(BUTTON_TEXTS[i][j]);
               btnPanel.add(buttons[i*4 + j]);
            }
         }
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(screen, BorderLayout.PAGE_START);
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        
        Container con = getContentPane();
        con.add(mainPanel);
        setSize(200, 200);
        setVisible(true);
    }
    
    private void addListeners() {
        
    }
    
    class ButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == buttons[15]){
                
            } else {
                
            }
        }
    }
    
    public float calculate(float a, float b, int operation) {
        if (operation ==1) {
            return a + b;
        } else if (operation == 2) {
            return a - b;
        } else if (operation == 3) {
            return a * b;
        } else {
            return a / b;
        }
    }
    
    
    
    public static void main(String args[]) throws Exception {
        new Calculator();
    }     
}
