package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class undercarriage {

	public JFrame frame;
	private JLabel label_3;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					undercarriage window = new undercarriage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public undercarriage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("下架");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_5 = new JLabel("下架原因");
		label_5.setBounds(157, 144, 61, 16);
		frame.getContentPane().add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 139, 94, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {  
			  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                // System.exit(0);  
            	String id = textField.getText();
            	String reason = textField_2.getText();
     
            	
            	connection con = new connection();
            try {
          
					con.undercarriageData( id ,reason );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                frame.dispose();  
            }  
        });  
		
		button.setBounds(315, 227, 117, 29);
		frame.getContentPane().add(button);
		
		label_3 = new JLabel("编号");
		label_3.setBounds(169, 84, 61, 16);
		frame.getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 79, 94, 26);
		frame.getContentPane().add(textField);
	}

}
