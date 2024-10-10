package nl.bertriksikken.samenmeten.dto;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Sensor {

	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;

	@SuppressWarnings("UnusedVariable")
	@JsonProperty("encodingType")
	private String encodingType;

	@SuppressWarnings("UnusedVariable")
	@JsonProperty("metadata")
	private String metaData;
	
	@Override
	public String toString() {
		return String.format(Locale.ROOT, "[name=%s,desc=%s]", name, description);
	}
	
}
