package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

import sg.edu.np.mad.madpractical4.MainActivity;

public class ListActivity extends AppCompatActivity {
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        // Create 20 Random Objects ----------------------------------------------------------------
        // Data Source - Array [Title, Description, Image]
        ArrayList<String> mainTitle = new ArrayList<String>();
        ArrayList<String> description = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            String title = "Name " + random.nextInt(99999999);
            mainTitle.add(title);
        }

        for (int i = 0; i < 20; i++) {
            String desc = "Description " + random.nextInt(99999999);
            description.add(desc);
        }
        // Create 20 Random Objects ---------------------------------------------------------------

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        ImageView triggerImg = findViewById(R.id.image);
        UserAdapter userAdapter = new UserAdapter(this, mainTitle, description);
        triggerImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");

                builder.setCancelable(false);

                Random random = new Random();
                ListView listView = findViewById(R.id.ListView);


                builder.setPositiveButton("View", (DialogInterface.OnClickListener) (dialog, which) -> {
                    String randomNumber = Integer.toString(random.nextInt(999999999));

                    // Launch MainActivity Page
                    Intent intent = new Intent (ListActivity.this, MainActivity.class);
                    intent.putExtra("randomNumber", randomNumber);
                    startActivity(intent);
                });

                builder.setNegativeButton("Close", (DialogInterface.OnClickListener) (dialog, which) -> {
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