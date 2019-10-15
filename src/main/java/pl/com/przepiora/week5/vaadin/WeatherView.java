package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WeatherView extends VerticalLayout {

  public WeatherView() {
    this.add(new Label("pogodynka"));

  }
}
