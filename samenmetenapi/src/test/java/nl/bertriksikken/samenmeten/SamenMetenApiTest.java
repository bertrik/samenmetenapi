package nl.bertriksikken.samenmeten;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.bertriksikken.samenmeten.api.ISamenMetenRestApi;
import nl.bertriksikken.samenmeten.dto.Location;
import nl.bertriksikken.samenmeten.dto.Observation;
import nl.bertriksikken.samenmeten.dto.Sensor;
import nl.bertriksikken.samenmeten.dto.Thing;

public final class SamenMetenApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(SamenMetenApi.class);

    private SamenMetenApi api;
    
    @Before
    public void before() {
		ISamenMetenRestApi restApi = SamenMetenApi.newRestClient("https://api-samenmeten.rivm.nl", Duration.ofSeconds(10));
		api = new SamenMetenApi(restApi);
    }
    
	@Test
	public void testGetThings() throws IOException {
		List<Thing> things = api.getThings();
		Assert.assertTrue(things.size() > 0);
		LOG.info("Retrieved {} things", things.size());
	}
	
	@Test
	public void testGetSensors() throws IOException {
		List<Sensor> sensors = api.getSensors();
		Assert.assertTrue(sensors.size() > 0);
		LOG.info("Retrieved {} sensors: {}", sensors.size(), sensors);
	}
	
	@Test
	public void testObservations() throws IOException {
		List<Observation> observations = api.getObservations(98122);
		Assert.assertTrue(observations.size() > 0);
		LOG.info("Retrieved {} observations: {}", observations.size());
	}

	@Test
	public void testLocations() throws IOException {
		List<Location> locations = api.getLocations(30408);
		Assert.assertTrue(locations.size() > 0);
	}
	
}
