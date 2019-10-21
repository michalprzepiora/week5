package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import pl.com.przepiora.week5.task2.model.ConsolidatedWeatherItem;


public class WeatherRow extends HorizontalLayout {
    private final static String IMG_URL_BASE = "https://www.metaweather.com/static/img/weather/png/64/";
    private Label dayLabel;
    private Label tempLabel;
    private Label humLabel;

    public WeatherRow(ConsolidatedWeatherItem weatherItem, String day) {
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        dayLabel = new Label(day);
        Image icon = new Image(IMG_URL_BASE + weatherItem.getWeatherStateAbbr() + ".png", "Icon");
        tempLabel = new Label(weatherItem.getTheTemp()+ "°C");
        humLabel = new Label("Wilgotność: " + weatherItem.getHumidity() + "%");
        add(dayLabel, icon, tempLabel,humLabel);
    }

}
