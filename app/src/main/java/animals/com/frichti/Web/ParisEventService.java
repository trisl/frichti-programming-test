package animals.com.frichti.Web;

import java.util.List;

import animals.com.frichti.Model.Event;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tristan on 13/11/2017.
 */

public interface ParisEventService {
    String BASEURL = "https://opendata.paris.fr/api";

    @GET("/records/1.0/search/?dataset=evenements-a-paris")
    Call<List<Event>> getEvents();
}
