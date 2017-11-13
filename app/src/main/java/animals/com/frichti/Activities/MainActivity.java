package animals.com.frichti.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import animals.com.frichti.Model.Event;
import animals.com.frichti.Model.JSONResponse;
import animals.com.frichti.Model.Record;
import animals.com.frichti.R;
import animals.com.frichti.Tools.EventsAdapter;
import animals.com.frichti.Web.ParisEventService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new RetrieveEvents().execute();
    }

    private class RetrieveEvents extends AsyncTask<Void, Void, List<Record>> {
        @Override
        protected List<Record> doInBackground(Void... params) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            // Debug
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            // End debug

            ParisEventService parisEventService = new Retrofit.Builder()
                    .baseUrl(ParisEventService.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build()
                    .create(ParisEventService.class);

            try {
                JSONResponse response = parisEventService.getEvents().execute().body();
                if (response != null)
                    return response.getRecords();
                else
                    return null;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Error while retrieving the data", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Record> records) {
            super.onPostExecute(records);

            if (records != null)
                displayEvents(records);
            else
                Toast.makeText(MainActivity.this, "Response is null", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayEvents(List<Record> records) {
        List<Event> events = new ArrayList<>();
        for (int index = 0; index < records.size(); ++index)
            events.add(records.get(index).getFields());

        RecyclerView listEvents = (RecyclerView) findViewById(R.id.recycler_view_paris_events);

        listEvents.setHasFixedSize(false);
        listEvents.setAdapter(new EventsAdapter(this, events));
        listEvents.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
