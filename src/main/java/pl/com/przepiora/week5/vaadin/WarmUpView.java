package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.com.przepiora.week5.task1.repository.PersonRepository;

public class WarmUpView extends VerticalLayout {

  public WarmUpView() {
    this.add(new Label("na rogrzewke"));
    Button button = new Button("click me");
    add(button);

    button.addClickListener(event ->{
      System.out.println("Click!!!!");
      PersonRepository personRepository = new PersonRepository();
      System.out.println(personRepository.getPersonList());

    });
  }
}
