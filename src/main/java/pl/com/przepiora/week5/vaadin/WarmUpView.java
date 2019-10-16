package pl.com.przepiora.week5.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import pl.com.przepiora.week5.task1.model.Person;
import pl.com.przepiora.week5.task1.repository.PersonRepository;

public class WarmUpView extends VerticalLayout {

  public WarmUpView() {
        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        this.add(new Label("Losowe dane 10 fikcyjnych osób. (API: randomuser.me)"));
        PersonRepository personRepository = new PersonRepository();

    Grid<Person> personGrid = new Grid<>();
        personGrid.setHeightByRows(true);
        personGrid.setItems(personRepository.getPersonList());
        personGrid.addComponentColumn(this::getPersonImage).setWidth("1px");
        personGrid.addComponentColumn(this::getFullName).setHeader("Imię i nazwisko");
        personGrid.addComponentColumn(this::getPersonCityAndCountry).setHeader("Miasto - kraj");
        personGrid.addColumn(Person::getEmail).setHeader("E-mail");
        personGrid.addColumn(Person::getCell).setHeader("Numer telefonu");

        add(personGrid);
    }

    private Label getFullName(Person person) {
        String text = person.getName().getFirst() + " " + person.getName().getLast();
        return new Label(text);
    }

    private Component getPersonImage(Person person) {
        Image image = new Image(person.getPicture().getThumbnail(), "image");
        Div div = new Div(image);
        div.setMinHeight("55px");
        return div;
    }

    private Label getPersonCityAndCountry(Person person) {
        String text = person.getLocation().getCity() + " - " + person.getLocation().getCountry();
        return new Label(text);
    }
}
