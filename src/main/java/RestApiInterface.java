import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApiInterface {
    @GET("forecast")
    Single<POJOresponse> getWeatherForecast(@Query("id") String id, @Query("APPID") String apiKey);
}