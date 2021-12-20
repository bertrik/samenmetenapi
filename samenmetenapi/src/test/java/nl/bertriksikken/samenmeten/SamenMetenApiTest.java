package nl.bertriksikken.samenmeten;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.bertriksikken.samenmeten.api.ISamenMetenRestApi;
import nl.bertriksikken.samenmeten.dto.Location;
import nl.bertriksikken.samenmeten.dto.Observation;
import nl.bertriksikken.samenmeten.dto.Sensor;
import nl.bertriksikken.samenmeten.dto.Thing;

public final class SamenMetenApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(SamenMetenApiTest.class);

    private SamenMetenApi api;
    
    public static void main(String[] args) throws IOException {
        SamenMetenApiTest test = new SamenMetenApiTest();
        List<Thing> things = test.getThings();
        List<Sensor> sensors = test.getSensors();
        List<Observation> observations = test.getObservations(0);
        List<Location> locations = test.getLocations(0);
    }
    
    private SamenMetenApiTest() {
		ISamenMetenRestApi restApi = SamenMetenApi.newRestClient("https://api-samenmeten.rivm.nl", Duration.ofSeconds(10));
		api = new SamenMetenApi(restApi);
    }
    
	private List<Thing> getThings() throws IOException {
		List<Thing> things = api.getThings();
		LOG.info("Retrieved {} things", things.size());
		return things;
	}
	
	private List<Sensor> getSensors() throws IOException {
		List<Sensor> sensors = api.getSensors();
		LOG.info("Retrieved {} sensors: {}", sensors.size(), sensors);
		return sensors;
	}
	
	private List<Observation> getObservations(int id) throws IOException {
		List<Observation> observations = api.getObservations(id);
		LOG.info("Retrieved {} observations: {}", observations.size());
		return observations;
	}

	private List<Location> getLocations(int id) throws IOException {
		List<Location> locations = api.getLocations(id);
        LOG.info("Retrieved {} locations: {}", locations.size());
		return locations;
	}
	
}
