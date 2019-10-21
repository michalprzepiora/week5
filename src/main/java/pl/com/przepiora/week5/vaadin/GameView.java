package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import pl.com.przepiora.week5.task3.model.RatesItem;
import pl.com.przepiora.week5.task3.service.CurrencyService;

import java.util.List;
import java.util.Random;

public class GameView extends VerticalLayout {

  private List<RatesItem> rates;
  private RatesItem selectedRate;
  private double priceCurrency;
  private TextField inputTextField;
  private Label infoLabel;
  private H1 points;
  private int counter;

  public GameView() {
    VerticalLayout mainView = new VerticalLayout();
    mainView.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    counter = 0;

    CurrencyService currencyService = new CurrencyService();
    rates = currencyService.getCurrency().getRates();
    selectedRate = getRandomRate();
    roundPriceCurrency();

    Button drawRateButton = new Button("Losuj inną walutę");
    mainView.add(drawRateButton);

    H3 header = new H3(selectedRate.getCode() + " - " + selectedRate.getCurrency());
    mainView.add(header);

    inputTextField = new TextField("Wprowadź kurs");
    inputTextField.setWidth("100px");
    mainView.add(inputTextField);

    infoLabel = new Label("Wprowadź pierwszą wartość i nasiśnij enter");
    mainView.add(infoLabel);

    points = new H1(counter + "  próba");
    mainView.add(points);

    add(mainView);

    drawRateButton.addClickListener(buttonClickEvent -> {
      selectedRate = getRandomRate();
      roundPriceCurrency();
      header.setText(selectedRate.getCode() + " - " + selectedRate.getCurrency());
      inputTextField.setEnabled(true);
      infoLabel.setText("Wprowadź pierwszą wartość i nasiśnij enter");
      counter = 0;
      points.setText(counter + "  próba");
      inputTextField.setValue("");
    });

    inputTextField.addValueChangeListener(event -> {
      if (event.getValue().equals("")) {
        return;
      }
      try {
        String value = event.getValue().replace(",", ".");
        double price = Double.parseDouble(value);
        if (price > priceCurrency) {
          infoLabel.setText("Za dużo");
          increasePoints();
        } else if (price < priceCurrency) {
          infoLabel.setText("Za mało");
          increasePoints();
        } else {
          infoLabel.setText("Gratki! Udało się za " + counter + " razem!");
          inputTextField.setEnabled(false);
        }

      } catch (Exception e) {
        Notification.show("Wprowadzono nieprawidłową wartość.", 3000, Notification.Position.MIDDLE);
      }
    });

  }

  private void increasePoints() {
    counter++;
    points.setText(counter + " próba");
  }

  private void roundPriceCurrency() {
    priceCurrency = Math.round(selectedRate.getMid() * 100);
    priceCurrency /= 100;
  }

  private RatesItem getRandomRate() {
    Random random = new Random();
    int index = random.nextInt(rates.size());
    return rates.get(index);
  }
}
