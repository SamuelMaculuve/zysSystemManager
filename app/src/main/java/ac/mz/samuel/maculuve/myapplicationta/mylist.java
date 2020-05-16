package ac.mz.samuel.maculuve.myapplicationta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class mylist extends AppCompatActivity {
    private ImageView imgDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);

      imgDelete = findViewById(R.id.imgDelete);

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"sss",Toast.LENGTH_LONG).show();
            }
        });

    }

}
