package by.romanovich.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Double math;
    char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        Button equals = findViewById(R.id.button_equally);
        equals.setOnClickListener(view-> {
            switch (operation){
                case '+':
                    math += Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(math));
                    break;
                case '-':
                    math -= Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(math));
                    break;
                case '/':
                    math /= Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(math));
                    break;
                case '*':
                    math *= Double.parseDouble(display.getText().toString());
                    display.setText(String.valueOf(math));
                    break;
            }
        });
        Log.d("Is it","work");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Is it","pause work");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Is it","destroy work");
    }

    public void displaySings(View view){
        math = Double.parseDouble(display.getText().toString());
        Button button = (Button) view;
        operation = button.getText().charAt(0);
        display.setText("");
    }

    public void displayText(View view){
        Button button = (Button) view;
        display.setText(display.getText().toString() + button.getText().toString());
    }
}