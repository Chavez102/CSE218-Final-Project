package Data_Management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock {
	@JsonProperty("0. date")
	String Stringdate;
	@JsonProperty("1. open")
	String Stringopen;
	@JsonProperty("2. high")
	String Stringhigh;
	@JsonProperty("3. low")
	String Stringlow;
	@JsonProperty("4. close")
	String Stringclose;
	@JsonProperty("5. volume")
	String Stringvolume;
	
	//@JsonIgnoreProperties
	Date date;
	double open;
	double high;
	double low;
	double close;
	int volume;
	public Stock() {}
	
	public Stock(String stringdate,String stringopen, String stringhigh,String stringlow,String stringclose,String stringvolume) {
		this.Stringdate=stringdate;
		
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	
	            this.date = dateformat.parse(stringdate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        
		this.open=Double.valueOf(stringopen);
		this.high=Double.valueOf(stringhigh);
		this.low=Double.valueOf(stringlow);
		this.close=Double.valueOf(stringclose);
		this.volume=Integer.valueOf(stringvolume);
		
	}
	
	
	
	@Override
	public String toString() {
		return "Stock [date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
				+ ", volume=" + volume + "]";
	}
	
	
	
	
	public String getStringdate() {
		
		return Stringdate;
	}
	public void setStringdate(String stringdate) {
		Stringdate = stringdate;
		// Convert string to date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            this.date = dateformat.parse(stringdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	public String getStringopen() {
		return Stringopen;
	}
	public void setStringopen(String stringopen) {
		Stringopen = stringopen;
	}
	public String getStringhigh() {
		return Stringhigh;
	}
	public void setStringhigh(String stringhigh) {
		Stringhigh = stringhigh;
	}
	public String getStringlow() {
		return Stringlow;
	}
	public void setStringlow(String stringlow) {
		Stringlow = stringlow;
	}
	public String getStringclose() {
		return Stringclose;
	}
	public void setStringclose(String stringclose) {
		Stringclose = stringclose;
	}
	public String getStringvolume() {
		return Stringvolume;
	}
	public void setStringvolume(String stringvolume) {
		Stringvolume = stringvolume;
	}
	


	public String getDate() {
		SimpleDateFormat format=new SimpleDateFormat("EEEE-yyyy-MM-dd");
		
		return format.format(date);
	}
	
	
	public String getWeekDay() {
		SimpleDateFormat format=new SimpleDateFormat("EEEE");
		
		return format.format(date);
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	


}
