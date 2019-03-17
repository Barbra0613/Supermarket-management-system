package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class count {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					count window = new count();
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
	public count() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("销售统计");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("导出总表");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel ex = new excel();
				ex.creatAllExcel();
			}
		});
		button.setBounds(99, 43, 94, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("导出年表");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel ex = new excel();
				ex.creatYearExcel();
			}
		});
		button_1.setBounds(263, 43, 94, 29);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("导出月表");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel ex = new excel();
				ex.creatMonthExcel();
				
			}
		});
		button_2.setBounds(263, 96, 94, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("导出季表");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel ex = new excel();
				ex.creatQuarterExcel();
			}
		});
		button_3.setBounds(99, 96, 94, 29);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("导出周表");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel ex = new excel();
				ex.creatWeekExcel();
			}
		});
		button_4.setBounds(99, 155, 94, 29);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("导出日表");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel ex = new excel();
				ex.creatDayExcel();
			}
		});
		button_5.setBounds(263, 155, 94, 29);
		frame.getContentPane().add(button_5);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); 
			}
		});
		btnNewButton.setBounds(345, 231, 87, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(53, 43, 61, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(53, 96, 61, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(53, 155, 61, 29);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(216, 43, 61, 29);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(216, 96, 61, 29);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(216, 155, 61, 29);
		frame.getContentPane().add(label_5);
	}
}
