package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class select {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select window = new select();
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
	public select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("查询记录");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("销售记录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleRecord window;
				try {
					window = new saleRecord();
					window.frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		button.setBounds(178, 59, 107, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("进货记录");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyRecord window;
				try {
					window = new buyRecord();
					window.frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_1.setBounds(178, 113, 107, 29);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); 
			}
		});
		btnNewButton.setBounds(328, 230, 89, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/a/Downloads/wxb明星店铺.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(121, 59, 61, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/Users/a/Downloads/wxb主页.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(121, 113, 61, 29);
		frame.getContentPane().add(label_1);
		
		JButton button_2 = new JButton("商品明细");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chaxun window = new chaxun();
				window.frame.setVisible(true);
				frame.dispose(); 
			}
		});
		button_2.setBounds(178, 171, 107, 29);
		frame.getContentPane().add(button_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/a/Downloads/wxb搜索推广-4.png"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(121, 171, 61, 29);
		frame.getContentPane().add(label_2);
	}
}
