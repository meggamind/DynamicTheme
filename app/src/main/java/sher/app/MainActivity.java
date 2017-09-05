package sher.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spThemeSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeChanger.setTheme(this);

        setContentView(R.layout.activity_main);
        setupThemeSelection();
    }

    private void setupThemeSelection(){
        spThemeSelect = (Spinner) findViewById(R.id.spThemes);
        spThemeSelect.setSelection(ThemeApplication.currentPosition);

        ThemeApplication.currentPosition = spThemeSelect.getSelectedItemPosition();

        spThemeSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(ThemeApplication.currentPosition != position){
                    ThemeChanger.changeThemeTo(MainActivity.this, position);
                }
                ThemeApplication.currentPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}