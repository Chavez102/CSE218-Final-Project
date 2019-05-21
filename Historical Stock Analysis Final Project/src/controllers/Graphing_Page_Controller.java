package controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class Graphing_Page_Controller implements Initializable {
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@FXML
	private LineChart<String, Number> Chart_LineChart;
    @FXML
    private NumberAxis Y_axis;
    
    @FXML
    private Button back_btn;

    @FXML
    private Button Home_btn;
    @FXML
    void Home_btn_Clicked(ActionEvent event) {
    	
    	application.Main.SwitchPageto(event, "Menu_Page.fxml");

    }

    @FXML
    void back_btn_Clicked(ActionEvent event) {
    	
    	
    	application.Main.SwitchPageto(event, "Range_Page.fxml");
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Chart_LineChart.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		// stringdate
		
		
		ArrayList<Date> dateRangelist = controllers.Range_Result_Page_Controller
				.getDates(controllers.Range_Page_Controller.begin_date, controllers.Range_Page_Controller.End_date);

		
		
		double lowest=100000;
		double highest=0;
		
		for (Date date : dateRangelist) {
			String datestr = dateFormat.format(date);
			if (application.Main.map.containsKey(datestr)) {
			
				  if(lowest>application.Main.map.get(datestr).getLow())
				  {
					  lowest=application.Main.map.get(datestr).getLow();
				  }
				  
				  if(highest<application.Main.map.get(datestr).getHigh())
				  {
					  highest=application.Main.map.get(datestr).getHigh();
				  }
				double avgPrice= (application.Main.map.get(datestr).getHigh()+application.Main.map.get(datestr).getLow())/2;

				series.getData().add(new XYChart.Data<String,Number>(application.Main.map.get(datestr).getDate(),avgPrice));

			}
		}
		series.setName("Date");
		
		Y_axis.setAutoRanging(false);
		
		
		Y_axis.setLowerBound(lowest);
		Y_axis.setUpperBound(highest);
		Y_axis.setTickUnit((int)(highest-lowest)/15);
	
		Chart_LineChart.getData().add(series);

	}

}
