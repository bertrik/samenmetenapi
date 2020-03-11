package nl.bertriksikken.samenmeten.api;

import nl.bertriksikken.samenmeten.dto.Things;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ISamenMetenRestApi {
	
    @GET("/v1.0/Things")
    Call<Things> getThings(@Query("$top") int top, @Query("$skip") int skip);

}
