package sg.edu.np.mad.madpractical4;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> mainTitle;
    private final ArrayList<String> description;


    public UserAdapter(Activity context, ArrayList<String> mainTitle, ArrayList<String> description) {
        super(context, R.layout.custom_activity_list, mainTitle);
        this.context = context;
        this.mainTitle = mainTitle;
        this.description = description;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        // Find the layout that is used to insert data
        View rowView = inflater.inflate(R.layout.custom_activity_list, null, true);

        TextView titleText = rowView.findViewById(R.id.title);
        TextView desc = rowView.findViewById(R.id.description);
        ImageView image = rowView.findViewById(R.id.image);



        // Set data inside
        titleText.setText(mainTitle.get(position));
        desc.setText(description.get(position));

        return rowView;
    }
}
