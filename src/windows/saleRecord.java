package windows;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class saleRecord {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleRecord window = new saleRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public saleRecord() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setTitle("销售记录");
		frame.setBounds(100, 100, 549, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 frame.dispose(); 
			}
		});
		btnNewButton.setBounds(435, 390, 93, 29);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrWKW = new JTextArea();
		txtrWKW.setBackground(SystemColor.window);
		txtrWKW.setBounds(6, 6, 535, 425);
		frame.getContentPane().add(txtrWKW);
		txtrWKW.append("                时间                       编号                  数量                   单价                  总价" +"\r\n");
		
		connection con = new connection(); 
		Connection conn = connection.getConn("market");
     	PreparedStatement ps = null; 
	    Statement stmt = (Statement) conn.createStatement();//创建一个Statement对象
        String sql = "select * from sale";//生成一条sql语句
        ResultSet rs=stmt.executeQuery(sql);//执行查询，把查询结果赋值给结果集对象
        String time,id;
        int number,price,total_price;
         while(rs.next()){//遍历结果集
             time = rs.getString(1);
             id = rs.getString(2);
             number = rs.getInt(3);
             price = rs.getInt(4);
             total_price = rs.getInt(5);
             txtrWKW.append(time+"\t"+id+"\t"+number+"\t"+price+"\t"+total_price+"\t" + "\r\n");
	}
	}

}
