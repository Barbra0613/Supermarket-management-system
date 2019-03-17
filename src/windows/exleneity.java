package windows;

public class exleneity {
	

    private String time;
    private String id;
    private int number;
    private int price;
    private int total_price;
    
    
    
    public exleneity() {
    	
    }
    public exleneity( String time,String id,int number,int price,int total_price ) 
    {
        this.time = time;
        this.id = id;
        this.number = number;
        this.price = price;
        this.total_price = total_price;
    }
    
    @Override
    public String toString() {
        return "StuEntity [time=" + time + ", id=" + id + ", number=" + number
                + ", price=" + price +  ", total_price =" + total_price + "]";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
 
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getTotal_price() {
        return total_price;
    }
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
    
    
    
}