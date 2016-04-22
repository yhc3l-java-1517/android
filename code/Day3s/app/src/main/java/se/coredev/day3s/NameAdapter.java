package se.coredev.day3s;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public final class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    private final Context context;
    private final List<NameData> data;

    public NameAdapter(Context context, List<NameData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position) {

        holder.nameView.setText(data.get(position).name);
        holder.descriptionView.setText(data.get(position).description);

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static final class NameViewHolder extends RecyclerView.ViewHolder {

        public final TextView nameView;
        public final TextView descriptionView;

        public NameViewHolder(View view) {
            super(view);
            this.nameView = (TextView) view.findViewById(R.id.name_text);
            this.descriptionView = (TextView) view.findViewById(R.id.description_text);
        }
    }
}
