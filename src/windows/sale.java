package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class sale {

	JFrame frame;
	private JLabel label_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sale window = new sale();
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
	public sale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u51FA\u552E");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7");
		label_4.setBounds(147, 112, 61, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u6570\u91CF");
		label_5.setBounds(147, 160, 61, 16);
		frame.getContentPane().add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 107, 94, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 155, 94, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {  
			  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
                // System.exit(0);  
            	String id = textField.getText();
            	int sprice = Integer.parseInt( textField_1.getText() );
            	int snumber = Integer.parseInt( textField_2.getText() );
            	
            	connection con = new connection();
            try {
            	System.out.println(snumber);
					con.outsertData( id,sprice,snumber);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                frame.dispose();  
            }  
        });  
		
		button.setBounds(330, 227, 102, 29);
		frame.getContentPane().add(button);
		
		label_3 = new JLabel("编号");
		label_3.setBounds(147, 60, 61, 16);
		frame.getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 55, 94, 26);
		frame.getContentPane().add(textField);
	}

}
