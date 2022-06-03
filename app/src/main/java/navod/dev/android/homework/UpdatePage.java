package navod.dev.android.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpdatePage extends AppCompatActivity {

    TextView txtHeading;
    TextView txtCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);

        txtHeading = findViewById(R.id.txtHeading);
        txtCount = findViewById(R.id.txtCount);

        String pageNum = getIntent().getStringExtra("catoName");
        txtHeading.setText(pageNum);
        String pageValue = txtHeading.getText().toString();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if(pageNum.equals("cato 1")){

            item1 item1 = new item1();
            fragmentTransaction.replace(R.id.myView,item1);
        }
        else if(pageNum.equals("cato 2")){
            item2 item2 = new item2();
            fragmentTransaction.replace(R.id.myView,item2);
        }
        else if(pageNum.equals("cato 3")){
            item3 item3 = new item3();
            fragmentTransaction.replace(R.id.myView,item3);
        }
        else if(pageNum.equals("cato 4")){
            item4 item4 = new item4();
            fragmentTransaction.replace(R.id.myView,item4);
        }

        fragmentTransaction.commit();




    }
}