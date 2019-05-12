import java.io.IOException;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitMin {

	final static String API_KEY="2d4c222e7204d579867b4068c0094d67";
	
	public static void main(String[] args) {		

		OkHttpClient client=new OkHttpClient();
		Request req=new Request.Builder()
				.url("https://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=2d4c222e7204d579867b4068c0094d67")
				.build();
		Call call= client.newCall(req);
		call.enqueue(new Callback() {

			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				
			}

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
			
		});
	}

}
