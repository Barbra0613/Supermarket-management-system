/**
 * 
 */
/**
 * @author a
 *
 */
package windows;
import windows.exleneity;
import java.sql.Connection;
import windows.clothes;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.mysql.jdbc.Statement;

public class connection {

    // 加载数据库驱动  com.mysql.jdbc.Driver
        private static String dbdriver = "com.mysql.jdbc.Driver";
        // 获取mysql连接地址
        private static String dburl = "jdbc:mysql://127.0.0.1:3306/cmxDatabaseName?&useSSL=false";
        // 数据名称
        private static String username = "root";
        // 数据库密码
        private static String userpassword = "0020";
        // 获取一个数据的连接
        public static Connection conn = null;
        // 获取连接的一个状态
        public static Statement stmt = null;
        
   

    /**
     * 获取数据库连接
     * 
     * @param myProjName
     * @return
     */
    public static Connection getConn(String myProjName) {
        Connection conn = null;
        try {
            Class.forName(dbdriver);            
            String myjdbcUrl = dburl.replace("cmxDatabaseName", myProjName);
            conn = DriverManager.getConnection(myjdbcUrl, username, userpassword);
            stmt = (Statement) conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭数据库连接
     * 
     * @param rs
     * @param ps
     * @param conn
     */
    private static void closeAll(ResultSet rs, PreparedStatement ps,
            Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn == null)
            return;
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查表，返回行的列表，每个列表中包含列的列表。
     * 
     * @param ProjName
     * @param sql
     * @return
     */
    public static List<List<Object>> getData(String ProjName, String sql) {
        Connection conn = getConn(ProjName);
        PreparedStatement ps = null;
        List<List<Object>> list = new ArrayList<List<Object>>();
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                List<Object> lst = new ArrayList<Object>();
                for (int i = 1; i <= columnCount; ++i) {
                    lst.add(rs.getObject(i) == null ? "" : rs.getObject(i));
                }
                list.add(lst);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return list;
    }
    
    public ResultSet  Search(String sql, String str[]) {
      	Connection conn = getConn("market");
      	ResultSet res = null;
        try {
            PreparedStatement pst =conn.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
    
    public static List<exleneity> getAllByDb(){
    	  List<exleneity> list = new ArrayList<exleneity>();
        try {
            connection db=new connection();
            String sql="select * from sale";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
            	    String time = rs.getString("stime");
                String id = rs.getString("id");
                int number = rs.getInt("snumber");
                int price =  rs.getInt("sprice");
                int total_price = rs.getInt("stotal_price");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new exleneity(time,id,number,price,total_price));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<exleneity> getYearByDb(){
  	  List<exleneity> list = new ArrayList<exleneity>();
      try {
    	      long l = System.currentTimeMillis();
          //new日期对象
          Date dateTime = new Date(l);
          //转换提日期输出格式
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
          String byear = dateFormat.format(dateTime);
          
          connection db=new connection();
          String sql="select * from sale where stime like '"+ byear + "%';";
          System.out.println(sql);
          ResultSet rs= db.Search(sql, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      return list;
  }
    
    public static List<exleneity> getQuarterByDb(){
    	  List<exleneity> list = new ArrayList<exleneity>();
        try {
      	      long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            String bmonth = dateFormat.format(dateTime);
            System.out.println(bmonth);
            
            connection db=new connection();
            int n = 2;
			String b = bmonth.substring( bmonth.length()-n,bmonth.length());
			System.out.println(b);
			int month = Integer.parseInt(b);
			int month1 = month-1;
			int month2 = month-2;
			String b1 = Integer.toString(month1);
			String b2 = Integer.toString(month2);
			String sub = bmonth.substring(0,5);
			System.out.println(sub); 
            String sql = "select * from sale where stime like '"+ sub + b + "%';";
            String sql1 = "select * from sale where stime like '"+ sub + b1 + "%';";
            String sql2 = "select * from sale where stime like '"+ sub + b2 + "%';";
            
            System.out.println(sql);
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
            	    String time = rs.getString("stime");
                String id = rs.getString("id");
                int number = rs.getInt("snumber");
                int price =  rs.getInt("sprice");
                int total_price = rs.getInt("stotal_price");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new exleneity(time,id,number,price,total_price));
            }
            rs= db.Search(sql1, null);
            while (rs.next()) {
            	    String time = rs.getString("stime");
                String id = rs.getString("id");
                int number = rs.getInt("snumber");
                int price =  rs.getInt("sprice");
                int total_price = rs.getInt("stotal_price");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new exleneity(time,id,number,price,total_price));
            }
            rs= db.Search(sql2, null);
            while (rs.next()) {
            	    String time = rs.getString("stime");
                String id = rs.getString("id");
                int number = rs.getInt("snumber");
                int price =  rs.getInt("sprice");
                int total_price = rs.getInt("stotal_price");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new exleneity(time,id,number,price,total_price));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<exleneity> getMonthByDb(){
  	  List<exleneity> list = new ArrayList<exleneity>();
      try {
    	      long l = System.currentTimeMillis();
          //new日期对象
          Date dateTime = new Date(l);
          //转换提日期输出格式
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
          String bmonth = dateFormat.format(dateTime);
          System.out.println(bmonth);
          
          connection db=new connection();
 
          String sql = "select * from sale where stime like '"+ bmonth + "%';";
          
          System.out.println(sql);
          ResultSet rs= db.Search(sql, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
         
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      return list;
  }
    public static List<exleneity> getWeekByDb(){
  	  List<exleneity> list = new ArrayList<exleneity>();
      try {
    	      long l = System.currentTimeMillis();
          //new日期对象
          Date dateTime = new Date(l);
          //转换提日期输出格式
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String bmonth = dateFormat.format(dateTime);
          System.out.println(bmonth);
          
          connection db=new connection();
          int n = 2;
			String b = bmonth.substring( bmonth.length()-n,bmonth.length());
			System.out.println(b);
			int day = Integer.parseInt(b);
			int day1 = day-1;
			int day2 = day-2;
			int day3 = day-3;
			int day4 = day-4;
			int day5 = day-5;
			int day6 = day-6;
			String b1 = Integer.toString(day1);
			String b2 = Integer.toString(day2);
			String b3 = Integer.toString(day3);
			String b4 = Integer.toString(day4);
			String b5 = Integer.toString(day5);
			String b6 = Integer.toString(day6);
			
			String sub = bmonth.substring(0,8);
			System.out.println(sub); 
          String sql = "select * from sale where stime like '"+ sub + b + "%';";
          String sql1 = "select * from sale where stime like '"+ sub + b1 + "%';";
          String sql2 = "select * from sale where stime like '"+ sub + b2 + "%';";
          String sql3 = "select * from sale where stime like '"+ sub + b3 + "%';";
          String sql4 = "select * from sale where stime like '"+ sub + b4 + "%';";
          String sql5 = "select * from sale where stime like '"+ sub + b5 + "%';";
          String sql6 = "select * from sale where stime like '"+ sub + b6 + "%';";
          
          
          System.out.println(sql);
          ResultSet rs= db.Search(sql, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          rs= db.Search(sql1, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          rs= db.Search(sql2, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          rs = db.Search(sql3, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          rs= db.Search(sql4, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          rs= db.Search(sql5, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          rs= db.Search(sql6, null);
          while (rs.next()) {
          	    String time = rs.getString("stime");
              String id = rs.getString("id");
              int number = rs.getInt("snumber");
              int price =  rs.getInt("sprice");
              int total_price = rs.getInt("stotal_price");
              
              //System.out.println(id+" "+name+" "+sex+ " "+num);
              list.add(new exleneity(time,id,number,price,total_price));
          }
          
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      return list;
  }
    public static List<exleneity> getDayByDb(){
    	  List<exleneity> list = new ArrayList<exleneity>();
        try {
      	      long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String bday = dateFormat.format(dateTime);
            
            connection db=new connection();
            String sql="select * from sale where stime like '"+ bday + "%';";
            System.out.println(sql);
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
            	    String time = rs.getString("stime");
                String id = rs.getString("id");
                int number = rs.getInt("snumber");
                int price =  rs.getInt("sprice");
                int total_price = rs.getInt("stotal_price");
                
                //System.out.println(id+" "+name+" "+sex+ " "+num);
                list.add(new exleneity(time,id,number,price,total_price));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public void insertData( String id,String name,String brand,String color,String size,String crowd,int price,int number,String date,String origin ) throws SQLException
	{  
        	Connection conn = getConn("market");
        	PreparedStatement ps = null; 
        try{ 
    
//        	    String sel = "Select name from goods where id = ' "+ id + "';"; //查询是否存在商品
//        	    PreparedStatement ins2 = conn.prepareStatement(sel);
        	    int total_price = price * number;
        	    
        	    long l = System.currentTimeMillis();
                //new日期对象
            Date dateTime = new Date(l);
                //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String btime = dateFormat.format(dateTime);
                
            String sql = "INSERT INTO goods (id,name,brand,color,size,crowd,price,number,date,origin)VALUES('"+id+"','"+name+"','"+brand+"','"+color+"','"+size+"','"+crowd+"',"+price+","+number+",'"+date+"','"+origin+"');";  
            String sql1 = "INSERT INTO buy (btime,id,bnumber,bprice,btotal_price)VALUES('"+btime+"','"+id+"',"+number+","+price+","+total_price+");";  
            System.out.println(sql);
            System.out.println(sql1);
            PreparedStatement ins = conn.prepareStatement(sql);  
            PreparedStatement ins1 = conn.prepareStatement(sql1);
            ins.executeUpdate(); 
            ins1.executeUpdate(); 
            
        }catch(Exception e1){  
        	    String sql = "select number from goods where id =" + id + ";";  
        	    System.out.println(sql);
        	    PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = 0;
            while(rs.next() )
            		{
            	      col = rs.getInt(1);
            		}
            
            System.out.println(col);
            col += number;
            
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String btime = dateFormat.format(dateTime);
            int total_price = price * number;
            
            String sql2 = "update goods set number =" + col + " where id = '" + id +"';" ;  
            String sql1 = "INSERT INTO buy (btime,id,bnumber,bprice,btotal_price)VALUES('"+btime+"','"+id+"',"+number+","+price+","+total_price+");";  
            System.out.println(sql2);
            System.out.println(sql1);
            PreparedStatement ins = conn.prepareStatement(sql2);  
            PreparedStatement ins1 = conn.prepareStatement(sql1);
            ins.executeUpdate(); 
            ins1.executeUpdate();   
        }  
    }   
    public void outsertData( String id,int sprice,int snumber) throws SQLException
	{  
        	Connection conn = getConn("market");
        	PreparedStatement ps = null; 
        	
           	String sql2 = "select number from goods where id =" + id + ";";  
    	        System.out.println(sql2);
    	        PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement(sql2);    
            ResultSet rs = pstmt.executeQuery();
            int col = 0;
            while( rs.next() )
            		{
            	      col = rs.getInt(1);
            		}
            System.out.println(col);
            int stotal_price = snumber*sprice;
            
            //得到long类型当前时间
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String stime = dateFormat.format(dateTime);
            
            if ( col < snumber ) //检查库存
            {
              	notEnough window = new notEnough();
				window.frame.setVisible(true);
            }
            else
            {
            	    col -= snumber;
            	    String sql = "update goods set number =" + col + " where id = '" + id +"';" ;  
            	    String sql1 = "INSERT INTO sale (stime,id,snumber,sprice,stotal_price)VALUES('"+stime+"','"+id+"',"+snumber+","+sprice+","+stotal_price+");";
            	    PreparedStatement ins = conn.prepareStatement(sql);  
                PreparedStatement ins1 = conn.prepareStatement(sql1);
                ins.executeUpdate(); 
                ins1.executeUpdate(); 
                if ( col < 5 )
                {
                  	needBuy window = new needBuy();
    				    window.frame.setVisible(true);
                }
                	
            }
    
	}
    
    public void undercarriageData( String id ,String reason) throws SQLException
   	{  
           	Connection conn = getConn("market");
           	PreparedStatement ps = null; 
           	
              	String sql2 = "select number from goods where id =" + id + ";";  
       	        System.out.println(sql2);
       	        PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement(sql2);    
               ResultSet rs = pstmt.executeQuery();
               int col = 0;
               while( rs.next() )
               		{
               	      col = rs.getInt(1);
               		}
               System.out.println(col);
               
               //得到long类型当前时间
               long l = System.currentTimeMillis();
               //new日期对象
               Date dateTime = new Date(l);
               //转换提日期输出格式
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String stime = dateFormat.format(dateTime);
               
               	    col = 0;
               	    String sql = "update goods set number =" + col + " where id = '" + id +"';" ;  
               	   
               	    PreparedStatement ins = conn.prepareStatement(sql);  
                   
                   ins.executeUpdate(); 
                  
                 String sql1 = "INSERT INTO undercarriage VALUES('"+ id + "','"+reason+"','"+stime+"');";
                 System.out.println(sql1);
                 PreparedStatement ins1 = conn.prepareStatement(sql1);  
                 
                 ins1.executeUpdate();  
               
       
   	}
    
    public void select ( String tableName ) throws SQLException
    {
         	Connection conn = getConn("market");
         	PreparedStatement ps = null; 
    	        Statement stmt = (Statement) conn.createStatement();//创建一个Statement对象
            String sql="select * from " + tableName;//生成一条sql语句
            ResultSet rs=stmt.executeQuery(sql);//执行查询，把查询结果赋值给结果集对象
            String time,id;
            int number,price,total_price;
            System.out.println("时间\t               编号\t数量 \t单价\t总价");//其中\t相当于8个空格
             while(rs.next()){//遍历结果集
                 time = rs.getString(1);
                 id = rs.getString(2);
                 number = rs.getInt(3);
                 price = rs.getInt(4);
                 total_price = rs.getInt(5);
                 System.out.println(time+"\t"+id+"\t "+number+"\t"+price+"\t"+total_price+"\t");
    	  
    }
    }
    
}