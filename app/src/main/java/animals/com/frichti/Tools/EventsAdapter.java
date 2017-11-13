package animals.com.frichti.Tools;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import animals.com.frichti.Model.Event;
import animals.com.frichti.R;

/**
 * Created by Tristan on 13/11/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {
    private Context context;
    private List<Event> events;

    public EventsAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        return new EventViewHolder(inflater.inflate(R.layout.event, parent, false));
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, int position) {
        Event event = events.get(position);

        Picasso.with(context).load(event.getImage()).into(holder.image);
        holder.title.setText(event.getTitle());
        holder.address.setText(event.getAddress());

        String dateStart = event.getDateStart();
        String dateEnd = event.getDateEnd();
        if (dateStart.equals(dateEnd))
            holder.date.setText("le " + dateStart);
        else
            holder.date.setText("du : " + dateStart + ", au : " + dateEnd);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView address;
        TextView date;

        EventViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.picture);
            title = (TextView) itemView.findViewById(R.id.title);
            address = (TextView) itemView.findViewById(R.id.address);
            date = (TextView) itemView.findViewById(R.id.event_date);
        }
    }
}
