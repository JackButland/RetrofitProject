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

		/*OkHttpClient client=new OkHttpClient();
		Request req=new Request.Builder()
				.url("https://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=2d4c222e7204d579867b4068c0094d67")
				.build();
		Call call= client.newCall(req);
		call.enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				try {
					JSONObject obj=new JSONObject(response.body().string());
					Iterator iter=obj.keys();
					iter.forEachRemaining((s)->{
						try {
							System.out.println(s+" : "+obj.getString((String) s));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
		});*/
	}

}
