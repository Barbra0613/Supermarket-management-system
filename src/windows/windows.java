package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

import windows.clothes;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;


public class windows {

	private JFrame Market;
	JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windows window = new windows();
					window.Market.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public windows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Market = new JFrame();
		Market.setBackground(SystemColor.window);
		Market.getContentPane().setBackground(SystemColor.window);
		Market.setTitle("\u8D85\u5E02\u8FDB\u9500\u5B58\u7CFB\u7EDF");
		Market.setBounds(100, 100, 600, 450);
		Market.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(150, 221, 87, 29);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select window = new select();
				window.frame.setVisible(true);
			}

		});
		Market.getContentPane().setLayout(null);
		Market.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FDB\u8D27");
		button_1.setBounds(369, 221, 87, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buy window = new buy();
				window.frame.setVisible(true);
			}
		});
		Market.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u51FA\u552E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sale window = new sale();
				window.frame.setVisible(true);
				
			}
		});
		button_2.setBounds(150, 286, 87, 29);
		Market.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u4E0B\u67B6");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				undercarriage window = new undercarriage();
				window.frame.setVisible(true);
				
			}
		});
		button_3.setBounds(369, 286, 87, 29);
		Market.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("销售统计");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count window = new count();
				window.frame.setVisible(true);
			}
		});
		button_4.setBounds(150, 352, 87, 29);
		Market.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("商品列表");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsRecord window;
				try {
					window = new goodsRecord();
					window.frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_5.setBounds(369, 352, 87, 29);
		Market.getContentPane().add(button_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/a/Downloads/wxb搜索推广-4.png"));
		lblNewLabel.setBounds(107, 221, 61, 29);
		Market.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("欢迎使用超市进销存系统");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(150, 57, 303, 49);
		Market.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" 请选择所需功能");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setBounds(215, 118, 164, 37);
		Market.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/a/Downloads/wxb明星店铺.png"));
		lblNewLabel_1.setBounds(107, 286, 61, 29);
		Market.getContentPane().add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/a/Downloads/wxb报表.png"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(107, 352, 61, 29);
		Market.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("/Users/a/Downloads/wxb主页.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(327, 221, 61, 29);
		Market.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/Users/a/Downloads/down.png"));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(327, 286, 61, 29);
		Market.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("/Users/a/Downloads/text.png"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(327, 352, 61, 29);
		Market.getContentPane().add(label_5);
	}
}
