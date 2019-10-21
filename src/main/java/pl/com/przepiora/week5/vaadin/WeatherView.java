package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.com.przepiora.week5.task2.model.Location;
import pl.com.przepiora.week5.task2.service.LocationManager;


public class WeatherView extends VerticalLayout {

    private Location selectedLocation;

    public WeatherView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        LocationManager locationManager = new LocationManager();

        Button selectCityButton = new Button("Zmień miasto");
        Label cityLabel = new Label("Wybierz miasto");
        HorizontalLayout headerLayout = new HorizontalLayout(selectCityButton, cityLabel);
        headerLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        selectCityButton.addClickListener(event -> {
            ChooseCityDialog dialog = new ChooseCityDialog();
            dialog.open();
            dialog.addDetachListener(detachEvent -> {
                selectedLocation = dialog.getSelectedLocation();
                if (selectedLocation != null) {
                    cityLabel.setText(selectedLocation.getTitle());
                }
            });
        });

        add(headerLayout);

// -------------------
        Button button = new Button("click");
        this.add(button);
        button.addClickListener(e -> {
            System.out.println("click");
            System.out.println(locationManager.getLocationsList("warsdsdsd"));
        });

    }
}
