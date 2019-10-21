package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import pl.com.przepiora.week5.task2.model.Location;
import pl.com.przepiora.week5.task2.service.LocationManager;


public class ChooseCityDialog extends Dialog {

    private Location selectedLocation;

    public ChooseCityDialog() {
        VerticalLayout mainView = new VerticalLayout();
        mainView.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
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

        Button okButton = new Button("OK");
        okButton.setEnabled(false);
        Button cancelButton = new Button("Anuluj");
        HorizontalLayout buttonsLayout = new HorizontalLayout(okButton, cancelButton);
        buttonsLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        locationListBox.addValueChangeListener(event -> {
            okButton.setEnabled(true);
            selectedLocation = locationListBox.getValue();
        });

        okButton.addClickListener(event -> this.close());
        cancelButton.addClickListener(event -> {
            selectedLocation = null;
            this.close();
        });

        mainView.add(locationTextField, locationListBox, buttonsLayout);
        this.add(mainView);
    }

    public Location getSelectedLocation() {
        return selectedLocation;
    }
}
