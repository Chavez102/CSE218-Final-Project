package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

public class Range_Page_Controller {

    @FXML
    private Text Title_Texr;

    @FXML
    private DatePicker FROM_DatePicker;

    @FXML
    private DatePicker TO_Datepicker;

    @FXML
    private Button Search_btn;
    


    @FXML
    private Button Back_btn;

    @FXML
    void Back_btn_Clicked(ActionEvent event) 
    {
    	application.Main.SwitchPageto(event, "Menu_Page.fxml");

    }
    
    

    @FXML
    void Search_btn_Clicked(ActionEvent event) {

    }

    
    
    
    
    
    
    
    

}