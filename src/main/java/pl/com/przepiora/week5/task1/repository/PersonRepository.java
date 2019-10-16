package pl.com.przepiora.week5.task1.repository;

import org.springframework.web.client.RestTemplate;
import pl.com.przepiora.week5.task1.model.Person;
import pl.com.przepiora.week5.task1.model.PersonApiResponse;

import java.util.List;

public class PersonRepository {

  private static final String URL = "https://randomuser.me/api/?inc=picture,name,location,email,cell&results=10";
  private List<Person> personList;

  public PersonRepository() {
    RestTemplate restTemplate = new RestTemplate();
    PersonApiResponse personApiResponse = restTemplate.getForObject(URL, PersonApiResponse.class);
    personList = personApiResponse.getResults();
  }

  public List<Person> getPersonList() {
    return personList;
  }
}
