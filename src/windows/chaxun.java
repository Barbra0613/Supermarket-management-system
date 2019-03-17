package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class chaxun {

	public JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label_7;
	private JTextField textField_8;
	private JLabel label_9;
	private JTextField textField_9;
	public static String sql = "select * from goods where ";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chaxun window = new chaxun();
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
	public chaxun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("属性查询");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u54C1\u724C");
		label.setBounds(36, 85, 61, 16);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 30, 94, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u540D\u79F0");
		label_1.setBounds(251, 35, 61, 16);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(86, 30, 94, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u989C\u8272");
		label_2.setBounds(251, 85, 61, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5927\u5C0F");
		label_3.setBounds(36, 129, 61, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7");
		label_4.setBounds(36, 170, 61, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u6570\u91CF");
		label_5.setBounds(251, 170, 61, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u9002\u5408\u4EBA\u7FA4");
		label_6.setBounds(239, 129, 61, 16);
		frame.getContentPane().add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 80, 94, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(86, 124, 94, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(309, 80, 94, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(309, 124, 94, 26);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(86, 165, 94, 26);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {  
			  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	    chaxunliebiao window;
					try {
						select();
						window = new chaxunliebiao();
						window.frame.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                frame.dispose();  
            }  
        });  
		
		button.setBounds(369, 247, 75, 29);
		frame.getContentPane().add(button);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(309, 165, 94, 26);
		frame.getContentPane().add(textField_7);
		
		label_7 = new JLabel("\u7F16\u53F7");
		label_7.setBounds(36, 35, 61, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("产地");
		label_8.setBounds(251, 214, 61, 16);
		frame.getContentPane().add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(86, 209, 94, 26);
		frame.getContentPane().add(textField_8);
		
		label_9 = new JLabel("保质期");
		label_9.setBounds(28, 214, 105, 16);
		frame.getContentPane().add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(309, 209, 94, 26);
		frame.getContentPane().add(textField_9);
		
		//if (!textField_1.getText().trim().isEmpty())
	}
	
	public void select ()
	{
		if (!textField.getText().trim().isEmpty())
		{
			sql += "id = '" + textField.getText() + "' and ";
		}
		if (!textField_1.getText().trim().isEmpty())
		{
			sql += "name = '" + textField_1.getText() + "' and ";
		}
		if (!textField_2.getText().trim().isEmpty())
		{
			sql += "brand = '" + textField_2.getText() + "' and ";
		}
		if (!textField_3.getText().trim().isEmpty())
		{
			sql += "color = '" + textField_3.getText() + "' and ";
		}
		if (!textField_4.getText().trim().isEmpty())
		{
			sql += "size = '" + textField_4.getText() + "' and ";
		}
		if (!textField_5.getText().trim().isEmpty())
		{
			sql += "crowd = '" + textField_5.getText() + "' and ";
		}
		if (!textField_6.getText().trim().isEmpty())
		{
			sql += "price = " + textField_6.getText() + " and ";
		}
		if (!textField_7.getText().trim().isEmpty())
		{
			sql += "number = " + textField_7.getText() + " and ";
		}
		if (!textField_8.getText().trim().isEmpty())
		{
			sql += "date = '" + textField_8.getText() + "' and ";
		}
		if (!textField_9.getText().trim().isEmpty())
		{
			sql += "origin = '" + textField_9.getText() + "' and ";
		}
		sql = sql.substring(0,sql.length()-4);

		
	}

	

}
