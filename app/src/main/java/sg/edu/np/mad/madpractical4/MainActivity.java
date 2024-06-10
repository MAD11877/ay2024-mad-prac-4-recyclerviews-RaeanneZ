package sg.edu.np.mad.madpractical4;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

import sg.edu.np.mad.madpractical4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;

    String randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());    
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Random random = new Random();
        ListView listView = findViewById(R.id.ListView);

        // Data Source - Array [Title, Description, Image]
        ArrayList<String> mainTitle = new ArrayList<String>();
        ArrayList<String> description = new ArrayList<String>();

        for (int i = 0; i < 20; i++) {
            randomNumber = Integer.toString(random.nextInt(99999999));
            String title = "Name " + randomNumber;
            mainTitle.add(title);
            String desc = "Description " + randomNumber;
            description.add(desc);
        }

        // Adapter - Custom Adapter
        UserAdapter listAdapter = new UserAdapter(this, mainTitle, description);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);

        //ImageView triggerImg = findViewById(R.id.image);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MAINACTIVITY", "Clicked!");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");

                builder.setCancelable(false);

                builder.setPositiveButton("View", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // Launch Profile Page
                    Intent intent = new Intent (MainActivity.this, ProfilePage.class);
                    intent.putExtra("randomNumber", randomNumber);
                    startActivity(intent);
                });

                builder.setNegativeButton("Close", (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
    }
}