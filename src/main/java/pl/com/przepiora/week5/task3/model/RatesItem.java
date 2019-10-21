package pl.com.przepiora.week5.task3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class RatesItem{

	@JsonProperty("code")
	private String code;

	@JsonProperty("mid")
	private double mid;

	@JsonProperty("currency")
	private String currency;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setMid(double mid){
		this.mid = mid;
	}

	public double getMid(){
		return mid;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	@Override
 	public String toString(){
		return 
			"RatesItem{" + 
			"code = '" + code + '\'' + 
			",mid = '" + mid + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}