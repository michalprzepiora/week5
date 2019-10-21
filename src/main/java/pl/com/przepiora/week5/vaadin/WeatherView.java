package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.com.przepiora.week5.task2.model.Location;
import pl.com.przepiora.week5.task2.model.Weather;
import pl.com.przepiora.week5.task2.service.LocationManager;


public class WeatherView extends VerticalLayout {

    private Location selectedLocation;
    private Weather selectedWeather;
    private Label cityLabel;
    private Label countryLabel;
    private LocationManager locationManager;
    private VerticalLayout weatherRowsLayout;
    private final static int WARSAW_ID = 523920;

    public WeatherView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        locationManager = new LocationManager();
        cityLabel = new Label("<- Wybierz miasto");
        countryLabel = new Label();
        Button selectCityButton = new Button("Miasto");

        HorizontalLayout headerLayout = new HorizontalLayout(selectCityButton, cityLabel, countryLabel);
        headerLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        selectCityButton.addClickListener(event -> {
            ChooseCityDialog dialog = new ChooseCityDialog();
            dialog.open();
            dialog.addDetachListener(detachEvent -> {
                selectedLocation = dialog.getSelectedLocation();
                if (selectedLocation != null) {
                    changeInformations();
                }
            });
        });

        weatherRowsLayout = new VerticalLayout();
        weatherRowsLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(headerLayout, weatherRowsLayout);
    }

    private void changeInformations() {
        selectedWeather = locationManager.getWeather(selectedLocation.getWoeid());
        cityLabel.setText(selectedLocation.getTitle());
        countryLabel.setText(selectedWeather.getParent().getTitle());
        WeatherRow today = new WeatherRow(selectedWeather.getConsolidatedWeather().get(0), "Dziś");
        WeatherRow tomorrow = new WeatherRow(selectedWeather.getConsolidatedWeather().get(1), "Jutro");
        WeatherRow afterTomorrow = new WeatherRow(selectedWeather.getConsolidatedWeather().get(2), "Pojutrze");
        weatherRowsLayout.removeAll();
        weatherRowsLayout.add(today, tomorrow, afterTomorrow);
    }
}
