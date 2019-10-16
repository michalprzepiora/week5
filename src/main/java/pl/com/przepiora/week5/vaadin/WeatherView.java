package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import pl.com.przepiora.week5.task2.model.Location;
import pl.com.przepiora.week5.task2.service.LocationManager;


public class WeatherView extends VerticalLayout {

    public WeatherView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        TextField filterTextField = new TextField("Filtruj");

      ComboBox<Location> locationComboBox = new ComboBox<>("Wybierz miasto");

        add(filterTextField, locationComboBox);

// -------------------
        Button button = new Button("click");
        this.add(new Label("pogodynka"), button);
        button.addClickListener(e -> {
            System.out.println("click");
            LocationManager locationManager = new LocationManager();
            System.out.println(locationManager.getLocationsList("warsdsdsd"));
        });

    }
}
