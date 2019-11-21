package edu.calvin.cs262.fdn2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class RecordScore extends AppCompatActivity {
    private Button submitButton;
    private EditText myScoreEditText;
    private EditText theirScoreEditText;
    private int myScore;
    private int theirScore;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_score);

        submitButton = findViewById(R.id.submitScoreButton);
        myScoreEditText = findViewById(R.id.myScoreValue);
        theirScoreEditText = findViewById(R.id.theirScoreValue);

    }

    public void submitScore(View view)
    {
        if(myScoreEditText.getText().toString().length()<=0 || theirScoreEditText.toString().length()<=0)
        {
            toast = Toast.makeText(this, "Enter a score for both players", Toast.LENGTH_SHORT);
        }
        if(myScoreEditText.getText().toString().matches("^[0-9]") ||
           theirScoreEditText.getText().toString().matches("[0-9]"))
        {
            toast = Toast.makeText(this, "Invalid score. Make sure you are only using integers", Toast.LENGTH_SHORT);
        }
        else
        {
            myScore = Integer.parseInt(myScoreEditText.getText().toString());
            theirScore = Integer.parseInt(theirScoreEditText.getText().toString());

            addGameToDatabase();
        }
        toast.show();
    }

    public void addGameToDatabase()
    {

    }
}
