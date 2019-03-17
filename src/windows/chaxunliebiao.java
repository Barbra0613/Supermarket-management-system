package windows;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.mysql.jdbc.Statement;

public class chaxunliebiao {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chaxunliebiao window = new chaxunliebiao();
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
	public chaxunliebiao() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setTitle("查询结果");
		frame.setBounds(100, 100, 993, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 chaxun.sql = "select * from goods where ";
				 frame.dispose(); 
			}
		});
		btnNewButton.setBounds(866, 510, 93, 29);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtrWKW = new JTextArea();
		txtrWKW.setBackground(SystemColor.window);
		txtrWKW.setBounds(6, 6, 981, 545);
		frame.getContentPane().add(txtrWKW);
		txtrWKW.append("编号                 名称                  品牌                 颜色                 大小                 适合人群            单价                 数量                   保质日期               产地" +"\r\n");
		
		connection con = new connection(); 
		Connection conn = connection.getConn("market");
     	PreparedStatement ps = null; 
	    Statement stmt = (Statement) conn.createStatement();//创建一个Statement对象
        String sql = chaxun.sql;//生成一条sql语句
        ResultSet rs=stmt.executeQuery(sql);//执行查询，把查询结果赋值给结果集对象
        String id,name,brand,color,size,crowd,date,origin;
        int number,price;
         while(rs.next()){//遍历结果集
             id = rs.getString(1);
             name = rs.getString(2);
             brand = rs.getString(3);
             color = rs.getString(4);
             size = rs.getString(5);
             crowd = rs.getString(6);
             price = rs.getInt(7);
             number = rs.getInt(8);
             date = rs.getString(9);
             origin = rs.getString(10);
             txtrWKW.append(" "+id+"\t"+name+"\t"+brand+"\t"+color+"\t"+size+"\t"+crowd+"\t"+price+"\t"+number+"\t"+date+"\t"+"    "+origin+"\t" + "\r\n");
	}
	}
	

}
