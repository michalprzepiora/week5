package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import pl.com.przepiora.week5.task2.model.Location;
import pl.com.przepiora.week5.task2.service.LocationManager;


public class ChooseCityDialog extends Dialog {

  public ChooseCityDialog() {
    VerticalLayout mainView = new VerticalLayout();
    LocationManager locationManager = new LocationManager();

    TextField locationTextField = new TextField("Wpisz nazwę miasta");
    locationTextField.setValueChangeMode(ValueChangeMode.EAGER);

    ListBox<Location> locationListBox = new ListBox<>();
    locationListBox.setRenderer(new TextRenderer<>(Location::getTitle));
    locationListBox.setHeight("150px");

    locationTextField.addInputListener(event -> {
      if (!locationTextField.isEmpty()) {
        locationListBox.setItems(locationManager.getLocationsList(locationTextField.getValue()));
      }
    });

    Button button = new Button("xxxx");
    button.addClickListener(e -> {
      locationListBox.setItems(locationManager.getLocationsList("war"));
    });

    mainView.add(locationTextField, locationListBox, button);
    this.add(mainView);
  }
}
