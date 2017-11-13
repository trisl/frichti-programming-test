package animals.com.frichti.Web;

import animals.com.frichti.Model.JSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tristan on 13/11/2017.
 */

public interface ParisEventService {
    String BASEURL = "https://opendata.paris.fr/";

    @GET("/api/records/1.0/search/?dataset=evenements-a-paris")
    Call<JSONResponse> getEvents();
}
