package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class GameView extends VerticalLayout {

  public GameView() {
    this.add(new Label("gra walutowa"));
  }
}
