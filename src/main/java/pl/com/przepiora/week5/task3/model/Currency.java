package pl.com.przepiora.week5.task3.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Currency{

	@JsonProperty("no")
	private String no;

	@JsonProperty("rates")
	private List<RatesItem> rates;

	@JsonProperty("table")
	private String table;

	@JsonProperty("effectiveDate")
	private String effectiveDate;

	public void setNo(String no){
		this.no = no;
	}

	public String getNo(){
		return no;
	}

	public void setRates(List<RatesItem> rates){
		this.rates = rates;
	}

	public List<RatesItem> getRates(){
		return rates;
	}

	public void setTable(String table){
		this.table = table;
	}

	public String getTable(){
		return table;
	}

	public void setEffectiveDate(String effectiveDate){
		this.effectiveDate = effectiveDate;
	}

	public String getEffectiveDate(){
		return effectiveDate;
	}

	@Override
 	public String toString(){
		return 
			"Currency{" + 
			"no = '" + no + '\'' + 
			",rates = '" + rates + '\'' + 
			",table = '" + table + '\'' + 
			",effectiveDate = '" + effectiveDate + '\'' + 
			"}";
		}
}