package pl.com.przepiora.week5.task1.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "location",
    "email",
    "cell",
    "picture"
})
public class Person {

  @JsonProperty("name")
  private Name name;
  @JsonProperty("location")
  private Location location;
  @JsonProperty("email")
  private String email;
  @JsonProperty("cell")
  private String cell;
  @JsonProperty("picture")
  private Picture picture;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("name")
  public Name getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(Name name) {
    this.name = name;
  }

  @JsonProperty("location")
  public Location getLocation() {
    return location;
  }

  @JsonProperty("location")
  public void setLocation(Location location) {
    this.location = location;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

  @JsonProperty("cell")
  public String getCell() {
    return cell;
  }

  @JsonProperty("cell")
  public void setCell(String cell) {
    this.cell = cell;
  }

  @JsonProperty("picture")
  public Picture getPicture() {
    return picture;
  }

  @JsonProperty("picture")
  public void setPicture(Picture picture) {
    this.picture = picture;
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
    return "Person{" +
        "name=" + name +
        ", location=" + location +
        ", email='" + email + '\'' +
        ", cell='" + cell + '\'' +
        ", picture=" + picture +
        ", additionalProperties=" + additionalProperties +
        '}';
  }
}