package pl.com.przepiora.week5.task1.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results",
    "info"
})
public class PersonApiResponse {

  @JsonProperty("results")
  private List<Person> results = null;
  @JsonProperty("info")
  private Info info;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("results")
  public List<Person> getResults() {
    return results;
  }

  @JsonProperty("results")
  public void setResults(List<Person> results) {
    this.results = results;
  }

  @JsonProperty("info")
  public Info getInfo() {
    return info;
  }

  @JsonProperty("info")
  public void setInfo(Info info) {
    this.info = info;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "PersonApiResponse{" +
        "results=" + results +
        ", info=" + info +
        ", additionalProperties=" + additionalProperties +
        '}';
  }
}