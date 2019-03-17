package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JTextPane;

import com.sun.glass.events.WindowEvent;

import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.*; 
import static javax.swing.JFrame.*;
import java.awt.*;
import java.awt.Frame; 
import javax.swing.JPanel;  

public class food {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel label_6;
	private JLabel label_3;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clothes window = new clothes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public food() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u98DF\u54C1\u7C7B\u5546\u54C1");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u54C1\u724C");
		label.setBounds(37, 85, 61, 16);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(110, 80, 94, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u540D\u79F0");
		label_1.setBounds(37, 38, 61, 16);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 33, 94, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4EA7\u5730");
		label_2.setBounds(37, 135, 61, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7");
		label_4.setBounds(262, 85, 61, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u6570\u91CF");
		label_5.setBounds(262, 135, 61, 16);
		frame.getContentPane().add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 130, 94, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 174, 94, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(309, 80, 94, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(309, 130, 94, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {  
			  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                // System.exit(0);  
            	   String id = textField_6.getText();  
                String name = textField_1.getText();
                String brand = textField.getText();
                int price = Integer.parseInt( textField_4.getText() );
                int number = Integer.parseInt( textField_5.getText() );
                String color = "";
                String size = "";
                String crowd = "";
                String date = textField_3.getText();;
                String origin = textField_2.getText();;
               
                
                connection con = new connection();
                try {
					con.insertData ( id,name,brand,color,size,crowd,price,number,date,origin);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                frame.dispose();  
            }  
        });  
		
		button.setBounds(341, 219, 85, 29);
		frame.getContentPane().add(button);
		
		label_6 = new JLabel("\u4FDD\u8D28\u671F\u622A\u6B62\u65E5\u671F");
		label_6.setBounds(6, 179, 105, 16);
		frame.getContentPane().add(label_6);
		
		label_3 = new JLabel("\u7F16\u53F7");
		label_3.setBounds(262, 38, 61, 16);
		frame.getContentPane().add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(309, 33, 94, 26);
		frame.getContentPane().add(textField_6);
	}
}
