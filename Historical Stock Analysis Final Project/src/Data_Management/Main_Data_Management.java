package Data_Management;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main_Data_Management {
	//checking if git works
	static String key="AJTUPL59H6NMOMYH";
	
	
	
//	public static void main(String[] args) {
//		HashMap<String,Stock> map= getBagFor("TSLA");
//		
//		
//	}
	
	
	
	

	public static HashMap<String,Stock> getBagFor(String StockSymbol) {
		

		Stockbag bag=new Stockbag();
		//DoublyLinkedList Linklist=new DoublyLinkedList();
		String Jsonstr=GetJsonStringFrom(StockSymbol);
		
		try {
				ObjectMapper mapper=new ObjectMapper();
				bag = mapper.readValue(Jsonstr.toString(), Stockbag.class);
		} catch (Exception e) {e.printStackTrace();}
		
		
		HashMap<String,Stock> map=new HashMap<>(bag.stocklist.size()*2);		//array is 2 times bigger than actual size of data elements
		
		for(int i=0;i<bag.stocklist.size();i++) {
			Stock stock=new Stock(bag.stocklist.get(i).Stringdate,
								  bag.stocklist.get(i).Stringopen,
								  bag.stocklist.get(i).Stringhigh,
								  bag.stocklist.get(i).Stringlow,
								  bag.stocklist.get(i).Stringclose,
								  bag.stocklist.get(i).Stringvolume
								  );
			map.put(bag.stocklist.get(i).Stringdate,stock);				//key=date,value= stock
		}
		return map;
		
	}
	
	
	
	
	public static String GetJsonStringFrom(String Stocksymbol)
	{
		String str="JSonString Not found";
	
		try {
			String symbol=Stocksymbol;	//options Any stock's symbol 
//   https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=TSLA&interval=5min&apikey=AJTUPL59H6NMOMYH&outputsize=full
			String url="https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+symbol+
			"&interval=5min&apikey="+key+ 
			"&outputsize=full";
			
			URL obj=new URL(url);
			HttpURLConnection con=(HttpURLConnection)obj.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			BufferedReader in= new BufferedReader(new InputStreamReader(con.getInputStream()));
					
			String inputLine;
			StringBuffer response=new StringBuffer();

			
			String bracketTochange="    }";
			while ((inputLine=in.readLine())!=null) {
				
				
				if(isValidDate(inputLine.replaceAll("\"", ""))) {	
					inputLine=inputLine.replaceAll("\"", "");
					inputLine=inputLine.replaceAll("\\: \\{", "");
					inputLine=inputLine.replaceAll("\\s+", "");	
					inputLine= "        {\n            \"0. date\":"+"\""+inputLine+"\",";
					//2019-04-22": { -> {
					//2019-04-22"  -> date:	
				}
				
				if(inputLine.equals(bracketTochange))
				inputLine="    ]";
				
				response.append(inputLine+"\n");
			}
			in.close();

			str=response.toString();
			
			str=str.replace("\"Time Series (Daily)\": {", "\"Stockbag\": [");
		
		}catch(Exception e) {
		e.printStackTrace();
		}
		
		return str;
		
		
	}
	
	
	
	
	
	
	
	
	public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

}
