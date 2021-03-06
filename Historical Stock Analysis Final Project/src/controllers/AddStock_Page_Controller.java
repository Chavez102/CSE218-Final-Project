package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Data_Management.Stock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddStock_Page_Controller implements Initializable {

	
  
    @FXML
    private DatePicker Date_DatePicker;
    @FXML
    private TextField OpenPrice_Textfield;
    @FXML
    private TextField HighPrice_Textfield;
    @FXML
    private TextField LowPrice_Textfield;
    @FXML
    private TextField Volume_Textfield;
    @FXML
    private TextField ClosePrice_Textfield;
    @FXML
    private Button Back_btn;
    @FXML
    private Button Add_btn;

    
    @FXML
    private Text OpenPriceWarning_Text;
    @FXML
    private Text HighPriceWarning_Text;
    @FXML
    private Text LowPriceWarning_Text;
    @FXML
    private Text VolumeWarning_Text;
    @FXML
    private Text CloseWarning_Text;
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LocalDate today=LocalDate.now();
		Date_DatePicker.setValue(today);
	}
    
    @FXML
    void Add_btn_Clicked(ActionEvent event) {
    	
    	LocalDate localdate=Date_DatePicker.getValue();
    	String datepickeranswer=localdate.toString();

    	
    	if(
	    	CheckforValidInput(OpenPrice_Textfield,OpenPriceWarning_Text)&&
	    	CheckforValidInput(HighPrice_Textfield,HighPriceWarning_Text)&&
	    	CheckforValidInput(LowPrice_Textfield,LowPriceWarning_Text)&&
	    	CheckforValidInput(Volume_Textfield,VolumeWarning_Text)&&
	    	CheckforValidInput(ClosePrice_Textfield,CloseWarning_Text)
    	)
    	{
    	 	
    	 	
    	 	Stock newStock=new Stock(
    	 			datepickeranswer,
    	 			OpenPrice_Textfield.getText(),
    	 			HighPrice_Textfield.getText(),
    	 			LowPrice_Textfield.getText(),
    	 			ClosePrice_Textfield.getText(),
    	 			Volume_Textfield.getText()
    	 			);
    	 	
    	 	
    	 	
    	 	
    	 	 Search_Result_Page_Controller.Gobackto="AddStock_Page.fxml";
    	 	Search_Page_Controller.DateString=datepickeranswer;
    	 	application.Main.map.put(datepickeranswer, newStock);
    	 	
    	 	
        	application.Main.SwitchPageto(event, "Search_Result_Page.fxml");
    	}
    	
    	
   
    	
    }
    
    
    
    
    
    
    public boolean CheckforValidInput(TextField textfield,Text warningtext)
    {
    	if (!isNumeric(textfield.getText()))
    	{
    		warningtext.setText("Invalid Answer");
    		warningtext.setVisible(true);
    		return false;
    		
    	}
    	else { 
    		warningtext.setVisible(false);
    		return true;
    	}
    }
    
 
    public static boolean isNumeric(String str) { 
    	  try {  
    	    Double.parseDouble(str);  
    	    return true;
    	  } catch(NumberFormatException e){  
    	    return false;  
    	  }  
    	}
    
    
    
    
    
    
    
    
    

    @FXML
    void Date_DatePicker_Clicked(ActionEvent event) {

    	System.out.println("date picker clicked");

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void Back_btn_Clicked(ActionEvent event) {
    	
    	application.Main.SwitchPageto(event, "Menu_Page.fxml");

    }





}
