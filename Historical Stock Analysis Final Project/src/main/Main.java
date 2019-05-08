package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

	public static void main(String[] args) {
		Stockbag bag=new Stockbag();
		DoublyLinkedList Linklist=new DoublyLinkedList();
		try {
			String key="AJTUPL59H6NMOMYH";
			String symbol="TSLA";	//options Any stock's symbol 
			String outputsize="full";	//options 'compact','full'
			
//   https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=TSLA&interval=5min&apikey=AJTUPL59H6NMOMYH&outputsize=compact
			String url="https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+symbol+
			"&interval=5min&apikey="+key+ 
			"&outputsize="+outputsize;
			
			URL obj=new URL(url);
			HttpURLConnection con=(HttpURLConnection)obj.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			BufferedReader in= new BufferedReader(
					new InputStreamReader(con.getInputStream()));
					
			String inputLine;
			StringBuffer response=new StringBuffer();
			int datenum=0;
			
			String bracketTochange="    }";
			while ((inputLine=in.readLine())!=null) {
				
				
				if(isValidDate(inputLine.replaceAll("\"", ""))) {	//changes format from  "2019-04-22":{ -> "{ \n date":2018-11-29
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

			String str=response.toString();
			
			str=str.replace("\"Time Series (Daily)\": {", "\"Stockbag\": [");
		
//	
			System.out.println(str);
			ObjectMapper mapper=new ObjectMapper();
		
	
			bag = mapper.readValue(str.toString(), Stockbag.class);
		

		}catch(Exception e) {
		e.printStackTrace();
		}
		
		for(int i=0;i<bag.stocklist.size();i++) {
			Stock stock=new Stock(bag.stocklist.get(i).Stringdate,
								  bag.stocklist.get(i).Stringopen,
								  bag.stocklist.get(i).Stringhigh,
								  bag.stocklist.get(i).Stringlow,
								  bag.stocklist.get(i).Stringclose,
								  bag.stocklist.get(i).Stringvolume
								  );
			Linklist.insertLast(stock);
		}
		
		//Linklist.displayForward();
		
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