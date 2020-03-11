package nl.bertriksikken.samenmeten.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Things {

	@JsonProperty("@iot.nextLink")
	private String nextLink;
	
	@JsonProperty("value")
	private List<Thing> things;
	
	public List<Thing> getThings() {
		return things;
	}
	
}
