package nl.bertriksikken.samenmeten;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.bertriksikken.samenmeten.api.ISamenMetenRestApi;
import nl.bertriksikken.samenmeten.dto.Observation;
import nl.bertriksikken.samenmeten.dto.Observations;
import nl.bertriksikken.samenmeten.dto.Sensor;
import nl.bertriksikken.samenmeten.dto.Sensors;
import nl.bertriksikken.samenmeten.dto.Thing;
import nl.bertriksikken.samenmeten.dto.Things;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class SamenMetenApi {
	
    private static final Logger LOG = LoggerFactory.getLogger(SamenMetenApi.class);

    private final ISamenMetenRestApi api;

    public SamenMetenApi(ISamenMetenRestApi api) {
    	this.api = api;
    }
    
    /**
     * Creates a REST interface.
     * 
     * @param url the base URL
     * @param timeout timeout (ms)
     * @return REST interface
     */
    public static ISamenMetenRestApi newRestClient(String url, Duration timeout) {
        LOG.info("Creating new REST client for URL '{}' with timeout {}", url, timeout);
        OkHttpClient client = new OkHttpClient().newBuilder().callTimeout(timeout).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(JacksonConverterFactory.create())
                .client(client).build();
        return retrofit.create(ISamenMetenRestApi.class);
    }

    public List<Thing> getThings() throws IOException {
    	List<Thing> allThings = new ArrayList<>();
    	int top = 100;
    	int skip = 0;
    	while (true) {
    		Response<Things> response = api.getThings(top, skip).execute();
    		if (!response.isSuccessful()) {
    			throw new IOException("Unsuccessful response!");
    		}
			Things things = response.body();
			List<Thing> thingList = things.getThings();
			allThings.addAll(thingList);
			skip += thingList.size();
			if (thingList.size() < top) {
				break;
    		}
		}
    	return allThings;
    }
    
    public List<Sensor> getSensors() throws IOException {
		Response<Sensors> response = api.getSensors().execute();
		if (!response.isSuccessful()) {
			throw new IOException("Unsuccessful response!");
		}
		Sensors sensors = response.body();
    	return sensors.getSensors();
    }
    
    public List<Observation> getObservations(int id) throws IOException {
    	List<Observation> allObservations = new ArrayList<>();
    	int top = 100;
    	int skip = 0;
    	while (true) {
    		Response<Observations> response = api.getObservations(id, top, skip).execute();
    		if (!response.isSuccessful()) {
    			throw new IOException("Unsuccessful response!");
    		}
    		Observations observations = response.body();
			List<Observation> observationList = observations.getObservations();
			allObservations.addAll(observationList);
			skip += observationList.size();
			if (observationList.size() < top) {
				break;
    		}
		}
    	return allObservations;
    }
    
}
