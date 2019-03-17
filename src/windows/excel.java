package windows;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import windows.connection;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class excel {

    public void creatAllExcel () {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(dateTime);
            
               String fileName = "/Users/a/Desktop/"+time+"_总表.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<exleneity> list= connection.getAllByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTime = new Label(0, 0, "时间(time)");//表示第
               Label labelId = new Label(1, 0, "编号(id)");
               Label labelNumber = new Label(2, 0, "数量(number)");
               Label labelPrice = new Label(3, 0, "单价(price)");
               Label labelTotal_price = new Label(4, 0, "总价(total_price)");
               
               ws.addCell(labelTime);
               ws.addCell(labelId);
               ws.addCell(labelNumber );
               ws.addCell(labelPrice);
               ws.addCell(labelTotal_price);
               
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelTime_i = new Label(0, i+1, list.get(i).getTime());
                   Label labelId_i = new Label(1, i+1, list.get(i).getId());
                   Label labelNumbe_i = new Label(2, i+1, list.get(i).getNumber()+"");
                   Label labelPrice_i = new Label(3, i+1, list.get(i).getPrice()+"");
                   Label labelTotal_price_i= new Label(4, i+1, list.get(i).getTotal_price()+"");
                   ws.addCell(labelTime_i);
                   ws.addCell(labelId_i);
                   ws.addCell(labelNumbe_i);
                   ws.addCell(labelPrice_i);
                   ws.addCell(labelTotal_price_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    
    public void creatYearExcel () {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(dateTime);
            
               String fileName = "/Users/a/Desktop/"+time+"_年表.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<exleneity> list= connection.getYearByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTime = new Label(0, 0, "时间(time)");//表示第
               Label labelId = new Label(1, 0, "编号(id)");
               Label labelNumber = new Label(2, 0, "数量(number)");
               Label labelPrice = new Label(3, 0, "单价(price)");
               Label labelTotal_price = new Label(4, 0, "总价(total_price)");
               
               ws.addCell(labelTime);
               ws.addCell(labelId);
               ws.addCell(labelNumber );
               ws.addCell(labelPrice);
               ws.addCell(labelTotal_price);
               
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelTime_i = new Label(0, i+1, list.get(i).getTime());
                   Label labelId_i = new Label(1, i+1, list.get(i).getId());
                   Label labelNumbe_i = new Label(2, i+1, list.get(i).getNumber()+"");
                   Label labelPrice_i = new Label(3, i+1, list.get(i).getPrice()+"");
                   Label labelTotal_price_i= new Label(4, i+1, list.get(i).getTotal_price()+"");
                   ws.addCell(labelTime_i);
                   ws.addCell(labelId_i);
                   ws.addCell(labelNumbe_i);
                   ws.addCell(labelPrice_i);
                   ws.addCell(labelTotal_price_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    public void creatQuarterExcel () {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(dateTime);
            
               String fileName = "/Users/a/Desktop/"+time+"_季表.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<exleneity> list= connection.getQuarterByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTime = new Label(0, 0, "时间(time)");//表示第
               Label labelId = new Label(1, 0, "编号(id)");
               Label labelNumber = new Label(2, 0, "数量(number)");
               Label labelPrice = new Label(3, 0, "单价(price)");
               Label labelTotal_price = new Label(4, 0, "总价(total_price)");
               
               ws.addCell(labelTime);
               ws.addCell(labelId);
               ws.addCell(labelNumber );
               ws.addCell(labelPrice);
               ws.addCell(labelTotal_price);
               
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelTime_i = new Label(0, i+1, list.get(i).getTime());
                   Label labelId_i = new Label(1, i+1, list.get(i).getId());
                   Label labelNumbe_i = new Label(2, i+1, list.get(i).getNumber()+"");
                   Label labelPrice_i = new Label(3, i+1, list.get(i).getPrice()+"");
                   Label labelTotal_price_i= new Label(4, i+1, list.get(i).getTotal_price()+"");
                   ws.addCell(labelTime_i);
                   ws.addCell(labelId_i);
                   ws.addCell(labelNumbe_i);
                   ws.addCell(labelPrice_i);
                   ws.addCell(labelTotal_price_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    public void creatMonthExcel () {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(dateTime);
            
               String fileName = "/Users/a/Desktop/"+time+"_月表.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<exleneity> list= connection.getMonthByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTime = new Label(0, 0, "时间(time)");//表示第
               Label labelId = new Label(1, 0, "编号(id)");
               Label labelNumber = new Label(2, 0, "数量(number)");
               Label labelPrice = new Label(3, 0, "单价(price)");
               Label labelTotal_price = new Label(4, 0, "总价(total_price)");
               
               ws.addCell(labelTime);
               ws.addCell(labelId);
               ws.addCell(labelNumber );
               ws.addCell(labelPrice);
               ws.addCell(labelTotal_price);
               
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelTime_i = new Label(0, i+1, list.get(i).getTime());
                   Label labelId_i = new Label(1, i+1, list.get(i).getId());
                   Label labelNumbe_i = new Label(2, i+1, list.get(i).getNumber()+"");
                   Label labelPrice_i = new Label(3, i+1, list.get(i).getPrice()+"");
                   Label labelTotal_price_i= new Label(4, i+1, list.get(i).getTotal_price()+"");
                   ws.addCell(labelTime_i);
                   ws.addCell(labelId_i);
                   ws.addCell(labelNumbe_i);
                   ws.addCell(labelPrice_i);
                   ws.addCell(labelTotal_price_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    public void creatWeekExcel () {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(dateTime);
            
               String fileName = "/Users/a/Desktop/"+time+"_周表.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<exleneity> list= connection.getWeekByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTime = new Label(0, 0, "时间(time)");//表示第
               Label labelId = new Label(1, 0, "编号(id)");
               Label labelNumber = new Label(2, 0, "数量(number)");
               Label labelPrice = new Label(3, 0, "单价(price)");
               Label labelTotal_price = new Label(4, 0, "总价(total_price)");
               
               ws.addCell(labelTime);
               ws.addCell(labelId);
               ws.addCell(labelNumber );
               ws.addCell(labelPrice);
               ws.addCell(labelTotal_price);
               
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelTime_i = new Label(0, i+1, list.get(i).getTime());
                   Label labelId_i = new Label(1, i+1, list.get(i).getId());
                   Label labelNumbe_i = new Label(2, i+1, list.get(i).getNumber()+"");
                   Label labelPrice_i = new Label(3, i+1, list.get(i).getPrice()+"");
                   Label labelTotal_price_i= new Label(4, i+1, list.get(i).getTotal_price()+"");
                   ws.addCell(labelTime_i);
                   ws.addCell(labelId_i);
                   ws.addCell(labelNumbe_i);
                   ws.addCell(labelPrice_i);
                   ws.addCell(labelTotal_price_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    public void creatDayExcel () {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
            long l = System.currentTimeMillis();
            //new日期对象
            Date dateTime = new Date(l);
            //转换提日期输出格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(dateTime);
            
               String fileName = "/Users/a/Desktop/"+time+"_日表.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<exleneity> list= connection.getDayByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTime = new Label(0, 0, "时间(time)");//表示第
               Label labelId = new Label(1, 0, "编号(id)");
               Label labelNumber = new Label(2, 0, "数量(number)");
               Label labelPrice = new Label(3, 0, "单价(price)");
               Label labelTotal_price = new Label(4, 0, "总价(total_price)");
               
               ws.addCell(labelTime);
               ws.addCell(labelId);
               ws.addCell(labelNumber );
               ws.addCell(labelPrice);
               ws.addCell(labelTotal_price);
               
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelTime_i = new Label(0, i+1, list.get(i).getTime());
                   Label labelId_i = new Label(1, i+1, list.get(i).getId());
                   Label labelNumbe_i = new Label(2, i+1, list.get(i).getNumber()+"");
                   Label labelPrice_i = new Label(3, i+1, list.get(i).getPrice()+"");
                   Label labelTotal_price_i= new Label(4, i+1, list.get(i).getTotal_price()+"");
                   ws.addCell(labelTime_i);
                   ws.addCell(labelId_i);
                   ws.addCell(labelNumbe_i);
                   ws.addCell(labelPrice_i);
                   ws.addCell(labelTotal_price_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}