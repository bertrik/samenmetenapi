package nl.bertriksikken.samenmeten.dto;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Observation {

	@JsonProperty("@iot.id")
	private String iotId;
	
	@JsonProperty("phenomenonTime")
	private String phenomenonTime;
	
	@JsonProperty("result")
	private double result;
	
	public String getIotId() {
		return iotId;
	}
	
	public double getResult() {
		return result;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ROOT, "[id=%s,time=%s,result=%f]", iotId, phenomenonTime, result);
	}
	
}
