package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals(""))
        {
          String str = sharedPreferences.getString("username","");
          goToActivity2(str);
        }
        else
        {
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view) {
        EditText myTextField = (EditText) findViewById(R.id.usernameEditText);
        String str = myTextField.getText().toString();

        //Toast.makeText(MainActivity.this,myTextField.getText().toString(),Toast.LENGTH_LONG).show();
        //Log.i("Info", "Button Pressed");

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username",str).apply();

        goToActivity2(str);
    }

    public void goToActivity2(String s)
    {
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }
}
