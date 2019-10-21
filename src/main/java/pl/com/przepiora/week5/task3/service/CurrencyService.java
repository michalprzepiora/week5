package pl.com.przepiora.week5.task3.service;

import org.springframework.web.client.RestTemplate;
import pl.com.przepiora.week5.task3.model.Currency;

public class CurrencyService {
    private final static String URL_NBP_CURRENCY = "http://api.nbp.pl/api/exchangerates/tables/A";
    RestTemplate restTemplate;

    public CurrencyService() {
        restTemplate = new RestTemplate();
    }

    public Currency getCurrency(){
        Currency[] currency = restTemplate.getForObject(URL_NBP_CURRENCY, Currency[].class);
        return currency[0];
    }
}
