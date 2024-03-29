package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Route
@UIScope
public class MainView extends VerticalLayout {

  static List<String> counter = new ArrayList<>();

  private VerticalLayout mainLayout;

  public MainView() {
    InetAddress addr;
    try {
      addr = InetAddress.getLocalHost();
      String hostname = addr.getHostName();
      counter.add(counter.size() + "     date: " + LocalDate.now() + "    time: " + LocalTime.now()
          .getHour() + ":" + LocalTime.now().getMinute() + "  " + hostname);
    } catch (UnknownHostException e) {
      System.err.println("Unknown host: " + e.getMessage());
    }

    this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    mainLayout = new VerticalLayout();
    mainLayout.setWidth("60%");

    //Initialize main views
    Component task1View = new WarmUpView();
    Component task2View = new WeatherView();
    Component task3View = new GameView();

    add(new Label("Praca domowa tydzień 5."));

    //Menu Bar
    Tab task1tab = new Tab("1. Na rozgrzewkę");
    Tab task2tab = new Tab("2. Pogodynka");
    Tab task3tab = new Tab("3. Gra walutowa");
    Tabs menuTabs = new Tabs(task1tab, task2tab, task3tab);
    menuTabs.setSelectedTab(task1tab);
    mainLayout.add(task1View);
    menuTabs.addSelectedChangeListener(event -> {
      mainLayout.removeAll();
      if (event.getSelectedTab().equals(task1tab)) {
        mainLayout.add(task1View);
      } else if (event.getSelectedTab().equals(task2tab)) {
        mainLayout.add(task2View);
      } else {
        mainLayout.add(task3View);
      }
    });

    add(menuTabs, mainLayout);
  }
}
