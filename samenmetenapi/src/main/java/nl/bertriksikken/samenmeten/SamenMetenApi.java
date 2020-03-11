package nl.bertriksikken.samenmeten;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.bertriksikken.samenmeten.api.ISamenMetenRestApi;
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
			if (things.getThings().isEmpty()) {
				break;
			} else {
				allThings.addAll(things.getThings());
				skip += top;
    		}
		}
    	return allThings;
    }
    
}
