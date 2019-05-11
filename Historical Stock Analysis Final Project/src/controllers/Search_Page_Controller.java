package controllers;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class Search_Page_Controller implements Initializable{
	
	public static String DateString="";
	
	
	  @FXML
	    private Button back_btn;
	
	  @FXML
	    private ChoiceBox<Integer> Day_ChoiceBox;

	    @FXML
	    private ChoiceBox<Integer> Month_ChoiceBox;

	    @FXML
	    private ChoiceBox<Integer> Year_ChoiceBox;

	    @FXML
	    private Button Search_btn;
	    		
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			
			fillChoicebox(1,32,Day_ChoiceBox);
			
			fillChoicebox(1,13,Month_ChoiceBox);
			
			fillChoicebox(1999,2020,Year_ChoiceBox);			//
			
			
		}
	    
	    @FXML
	    void Search_btn_Clicked(ActionEvent event) {
	    	 setDateString(Day_ChoiceBox.getSelectionModel().getSelectedItem(),
	    			 Month_ChoiceBox.getSelectionModel().getSelectedItem(),
	    			 Year_ChoiceBox.getSelectionModel().getSelectedItem());

	    	 
	    	 if (application.Main.map.containsKey(DateString)) {
	    	 Main.SwitchPageto(event, "Search_Result_Page.fxml");
	    	 } else {
	    	System.out.println("Market was close this day");
	    	 }
	    	 
	    	 
	    	 
	    	 
	    	 
//	    	 if(WeekDayChosen()) {
//	    	Main.SwitchPageto(event, "Search_Result_Page.fxml");
//	    	 } else {
//	    	System.out.println("Market was close this day");
//	    	 }
	    	 
	    }
	    
	    public boolean WeekDayChosen()
	    {
	    	  SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
	          String strdate2 = DateString;
	          Date newdate = null;
	          
	          try {
	        	  newdate  = dateformat2.parse(strdate2);
	          //    System.out.println(newdate);
	          } catch (ParseException e) {
	              e.printStackTrace();
	          }
	          
	          
	        SimpleDateFormat format=new SimpleDateFormat("EEEE");
	  		
	  		 String dayString=format.format(newdate);
	  		 
	    	if(dayString.equals("Saturday")||dayString.equals("Sunday"))
	    	return false;
	    	
	    	
	    	
	    	return true;
	    		
	    }
	
	
	    public void setDateString(int dayInt,int monthInt,int yearInt)	//sets Day Month and Year into string for Result page
	    {
	    	 String zeroDay="";
	    	 String zeroMonth="";
	    	
	    	 if (dayInt<10)
	    		 zeroDay="0";
	    	 if (monthInt<10)
	    		 zeroMonth="0";
	    	 
	    	
	    	 
	    	 DateString= yearInt+"-"+zeroMonth+monthInt+"-"+zeroDay+dayInt;     // format "2019-05-09"
	    	
	    }
	    
	    
	    
	    @FXML
	    void back_btn_Clicked(ActionEvent event) {
	    	Main.SwitchPageto(event, "Menu_Page.fxml");

	    }



		
		
		//fill integerchoicebox from firstnum to lastnum
		public void fillChoicebox(int firstnum,int lastnum,ChoiceBox<Integer> choicebox) {
			ObservableList<Integer> list = FXCollections.<Integer>observableArrayList();
		    for( int i=firstnum; i<lastnum; i++ ) 
		    {
		    	list.add(i);   
		    }
			choicebox.setValue(firstnum + (int)(Math.random() * ((lastnum - firstnum) + 1)));
			choicebox.setItems(list);
			
		}

}