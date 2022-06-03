package navod.dev.android.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList <String> catoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        readAllStudents();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,catoList);
        listView.setAdapter( adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,UpdatePage.class);
                if(i == 0){
                    intent.putExtra("catoName","cato 1");
                }
                else if(i == 1){
                    intent.putExtra("catoName","cato 2");
                }
                else if(i == 2){
                    intent.putExtra("catoName","cato 3");
                }
                else if(i == 3){
                    intent.putExtra("catoName","cato 4");
                }
                startActivity(intent);
            }
        });

    }

    public void readAllStudents(){
        catoList = new ArrayList<String>();
        DatabaseHealper db = new DatabaseHealper(this);
        Cursor response = db.getAllStudent();
        if(response.getCount()> 0){
            while(response.moveToNext()){
                String name = response.getString(0);
                String amount = response.getString(1);
                catoList.add(name+"\t\t\t\t\t\t"+amount);
            }

        }
    }

}