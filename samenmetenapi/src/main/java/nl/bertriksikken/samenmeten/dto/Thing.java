package nl.bertriksikken.samenmeten.dto;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Thing {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@Override
	public String toString() {
		return String.format(Locale.ROOT, "[name=%s,desc=%s]", name, description);
	}

}
