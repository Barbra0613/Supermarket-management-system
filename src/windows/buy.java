package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class buy {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buy window = new buy();
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
	public buy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5546\u54C1\u7C7B\u578B");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u670D\u88C5\u7C7B\u5546\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clothes window = new clothes();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(175, 67, 109, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u98DF\u54C1\u7C7B\u5546\u54C1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food window = new food();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(175, 140, 109, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/a/Downloads/iconfont-fuzhuangneiyi.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(125, 67, 61, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/Users/a/Downloads/iconfont-shipin.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(125, 140, 61, 29);
		frame.getContentPane().add(label_1);
	}
}
