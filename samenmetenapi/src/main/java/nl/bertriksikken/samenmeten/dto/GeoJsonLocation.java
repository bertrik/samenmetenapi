package nl.bertriksikken.samenmeten.dto;

import java.util.Arrays;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class GeoJsonLocation {

	@JsonProperty("type")
	private String type;
	
	@JsonProperty("coordinates")
	private double[] coordinates;
	
	@Override
	public String toString() {
		return String.format(Locale.ROOT, "[type=%s,coords=%s]", type, Arrays.toString(coordinates));
	}
	
}


