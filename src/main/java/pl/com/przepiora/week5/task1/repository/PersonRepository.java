package pl.com.przepiora.week5.task1.repository;

import org.springframework.web.client.RestTemplate;
import pl.com.przepiora.week5.task1.model.PersonRepo;
import pl.com.przepiora.week5.task1.model.Result;

import java.util.List;

public class PersonRepository {

  private static final String URL = "https://randomuser.me/api/?inc=picture,name,location,email,cell&results=10";
  private List<Result> personList;

  public List<Result> getPersonList() {
    return personList;
  }

  public PersonRepository() {
    RestTemplate restTemplate = new RestTemplate();
    PersonRepo personRepo = restTemplate.getForObject(URL, PersonRepo.class);
    personList = personRepo.getResults();
  }
}
