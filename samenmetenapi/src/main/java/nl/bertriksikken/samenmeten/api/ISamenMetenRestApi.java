package nl.bertriksikken.samenmeten.api;

import nl.bertriksikken.samenmeten.dto.Locations;
import nl.bertriksikken.samenmeten.dto.Observations;
import nl.bertriksikken.samenmeten.dto.Sensors;
import nl.bertriksikken.samenmeten.dto.Things;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ISamenMetenRestApi {
	
    @GET("/v1.0/Things")
    Call<Things> getThings(@Query("$top") int top, @Query("$skip") int skip);

    @GET("/v1.0/Sensors")
	Call<Sensors> getSensors();

    @GET("/v1.0/Datastreams({id})/Observations")
	Call<Observations> getObservations(@Path("id") int id, @Query("$top") int top, @Query("$skip") int skip);

    @GET("/v1.0/Things({id})/Locations")
	Call<Locations> getLocations(@Path("id") int id);

}
