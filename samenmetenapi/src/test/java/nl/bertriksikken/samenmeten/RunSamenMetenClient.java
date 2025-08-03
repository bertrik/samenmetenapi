package nl.bertriksikken.samenmeten;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.bertriksikken.samenmeten.dto.Location;
import nl.bertriksikken.samenmeten.dto.Observation;
import nl.bertriksikken.samenmeten.dto.Sensor;
import nl.bertriksikken.samenmeten.dto.Thing;

public final class RunSamenMetenClient {

    private static final Logger LOG = LoggerFactory.getLogger(RunSamenMetenClient.class);

    private SamenMetenClient client;
    
    public static void main(String[] args) throws IOException {
        RunSamenMetenClient runner = new RunSamenMetenClient();
        List<Thing> things = runner.getThings();
		Assertions.assertFalse(things.isEmpty());
        List<Sensor> sensors = runner.getSensors();
		Assertions.assertFalse(sensors.isEmpty());
        List<Observation> observations = runner.getObservations(0);
		Assertions.assertFalse(observations.isEmpty());
        List<Location> locations = runner.getLocations(0);
		Assertions.assertFalse(locations.isEmpty());
    }
    
    private RunSamenMetenClient() {
		client = SamenMetenClient.create("https://api-samenmeten.rivm.nl", Duration.ofSeconds(10));
    }
    
	private List<Thing> getThings() throws IOException {
		List<Thing> things = client.getThings();
		LOG.info("Retrieved {} things", things.size());
		return things;
	}
	
	private List<Sensor> getSensors() throws IOException {
		List<Sensor> sensors = client.getSensors();
		LOG.info("Retrieved {} sensors: {}", sensors.size(), sensors);
		return sensors;
	}
	
	private List<Observation> getObservations(int id) throws IOException {
		List<Observation> observations = client.getObservations(id);
		LOG.info("Retrieved {} observations", observations.size());
		return observations;
	}

	private List<Location> getLocations(int id) throws IOException {
		List<Location> locations = client.getLocations(id);
        LOG.info("Retrieved {} locations", locations.size());
		return locations;
	}
	
}
