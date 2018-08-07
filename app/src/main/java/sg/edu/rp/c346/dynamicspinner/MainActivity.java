package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    Button bUpdate;
    Spinner spinner2;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        bUpdate = findViewById(R.id.buttonUpdate);
        spinner2 = findViewById(R.id.spinner2);

        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.number_types));
        spinnerArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner1.setAdapter(spinnerArrayAdapter1);

        // Initialise the ArrayList
        alNumbers = new ArrayList<>();

        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // Bind the ArrayAdapter to the Spinner
        spinner2.setAdapter(aaNumbers);
        spinner1.setSelection(0);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Your code for item 1 selected
                        final String[] strNumbersEven = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbersEven));
                        spinner2.setSelection(2);
                        aaNumbers.notifyDataSetChanged();
                        break;
                    case 1:
                        //Your code for item 2 selected
                        final String[] strNumbersOdd = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.clear();
                        alNumbers.addAll(Arrays.asList(strNumbersOdd));
                        spinner2.setSelection(1);
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> AdapterView) {

            }
        });


    };
}
