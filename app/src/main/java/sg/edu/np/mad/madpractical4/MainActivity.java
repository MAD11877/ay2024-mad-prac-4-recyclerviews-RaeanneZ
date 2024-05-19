package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            String title = "Name " + random.nextInt(99999999);
            mainTitle.add(title);
        }

        for (int i = 0; i < 20; i++) {
            String desc = "Description " + random.nextInt(99999999);
            description.add(desc);
        }

        // Adapter - Custom Adapter
        UserAdapter listAdapter = new UserAdapter(this, mainTitle, description);
        listView.setAdapter(listAdapter);
    }
}