import java.io.IOException;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitMin {

	final static String API_KEY="2d4c222e7204d579867b4068c0094d67";
	
	public static void main(String[] args) {		
		
        RestApiInterface apiService =
                APIClient.getClient().create(RestApiInterface.class);
 
        apiService.getWeatherForecast("524901",API_KEY)
        	.subscribeWith(new SingleObserver<POJOresponse>() {
            
        		@Override
        		public void onError(Throwable e) {
        			e.printStackTrace();
        		}

        		@Override
        		public void onSuccess(POJOresponse t) {
        			System.out.println("success");
        			System.out.println(t.getCity().getName());
        		}

				@Override
				public void onSubscribe(Disposable d) {
					System.out.println("subscription made");
					
				}
        });
	}

}
