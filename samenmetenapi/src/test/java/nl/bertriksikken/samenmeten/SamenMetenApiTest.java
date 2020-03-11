package nl.bertriksikken.samenmeten;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.bertriksikken.samenmeten.api.ISamenMetenRestApi;
import nl.bertriksikken.samenmeten.dto.Sensor;
import nl.bertriksikken.samenmeten.dto.Thing;

public final class SamenMetenApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(SamenMetenApi.class);

	@Test
	public void testGetThings() throws IOException {
		ISamenMetenRestApi restApi = SamenMetenApi.newRestClient("https://api-samenmeten.rivm.nl", Duration.ofSeconds(10));
		SamenMetenApi api = new SamenMetenApi(restApi);
		List<Thing> things = api.getThings();
		Assert.assertTrue(things.size() > 0);
		LOG.info("Retrieved {} things", things.size());
	}
	
	@Test
	public void testGetSensors() throws IOException {
		ISamenMetenRestApi restApi = SamenMetenApi.newRestClient("https://api-samenmeten.rivm.nl", Duration.ofSeconds(10));
		SamenMetenApi api = new SamenMetenApi(restApi);
		List<Sensor> sensors = api.getSensors();
		Assert.assertTrue(sensors.size() > 0);
		LOG.info("Retrieved {} sensors: {}", sensors.size(), sensors);
	}
	
}
