package nl.bertriksikken.samenmeten.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Locations {

	@JsonProperty("value")
	private List<Location> locations;
	
	public List<Location> getLocations() {
		return locations;
	}
	
}
