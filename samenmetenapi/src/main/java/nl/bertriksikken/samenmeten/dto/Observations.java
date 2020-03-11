package nl.bertriksikken.samenmeten.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Observations {

	@JsonProperty("@iot.nextLink")
	private String nextLink;
	
	@JsonProperty("value")
	private List<Observation> value;
	
	public List<Observation> getObservations() {
		return value;
	}
	
}
