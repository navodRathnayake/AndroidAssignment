package navod.dev.android.homework;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class item4 extends Fragment {
    EditText txtCato1;
    Button btnUpdateCato1;

    public item4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item1, container, false);

        txtCato1 = view.findViewById(R.id.txtCato1);
        btnUpdateCato1 = view.findViewById(R.id.btnUpdateCato1);

        Context thiscontext;
        thiscontext = container.getContext();

        btnUpdateCato1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                DatabaseHealper db = new DatabaseHealper(thiscontext);
                Cursor response = db.selectStudent("cato 4");
                int amount = 10;

                if(response.getCount()>0){
                    while(response.moveToNext()){
                        if("cato 4".equals(response.getString(0)));{
                            String cato = response.getString(0);
                            amount = response.getInt(1);
                        }
                    }
                }

                int inputValue = Integer.parseInt(txtCato1.getText().toString());
                int updatedValue = amount + inputValue;

                Toast.makeText(thiscontext,
                        "amount : "+updatedValue,Toast.LENGTH_LONG).show();

                db.updateCato("cato 4",updatedValue);
                Toast.makeText(thiscontext,
                        "Records were updated "+updatedValue,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(thiscontext,MainActivity.class);
                startActivity(intent);

            }
        });



        return view;
    }
}