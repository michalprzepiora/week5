package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.com.przepiora.week5.task1.model.Person;
import pl.com.przepiora.week5.task1.repository.PersonRepository;

import java.util.List;

public class WarmUpView extends VerticalLayout {

  public WarmUpView() {
    this.add(new Label("na rogrzewke"));
    PersonRepository personRepository = new PersonRepository();
    List<Person> personList = personRepository.getPersonList();

    Person person = personList.get(0);

    System.out.println(person.getName().getFirst()+" "+person.getLocation().getCity()+" "+person.getEmail()+" "+person.getCell());






    Button button = new Button("click me");
    add(button);

    button.addClickListener(event ->{
      System.out.println("Click!!!!");



    });
  }
}
