package id.sch.smktelkom_mlg.tugas.xirpl5011.daftarekstrakurikuler;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nama;
    EditText absen;
    RadioButton r1, r2, r3, r4, r5;
    CheckBox osis, pustel, da, sub;
    Spinner sub1;
    TextView hasill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText) findViewById(R.id.nama);
        absen = (EditText) findViewById(R.id.absen);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        r5 = (RadioButton) findViewById(R.id.r5);
        osis = (CheckBox) findViewById(R.id.osis);
        pustel = (CheckBox) findViewById(R.id.pustel);
        da = (CheckBox) findViewById(R.id.da);
        sub = (CheckBox) findViewById(R.id.subor);
        hasill = (TextView) findViewById(R.id.hasil);
        sub1 = (Spinner) findViewById(R.id.sub1);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valid()) {
                    String finalee = "";
                    String name = nama.getText().toString();
                    String abs = absen.getText().toString();
                    String spin = sub1.getSelectedItem().toString();
                    String haha = null;


                    if (r1.isChecked()) {
                        haha = r1.getText().toString();
                    } else if (r2.isChecked()) {
                        haha = r2.getText().toString();
                    } else if (r3.isChecked()) {
                        haha = r3.getText().toString();
                    } else if (r4.isChecked()) {
                        haha = r4.getText().toString();
                    } else if (r5.isChecked()) {
                        haha = r5.getText().toString();
                    }

                    if (sub.isChecked()) {
                        finalee += sub.getText().toString() + "\n";
                    }
                    if (osis.isChecked()) {
                        finalee += osis.getText().toString() + "\n";
                    }
                    if (da.isChecked()) {
                        finalee += da.getText().toString() + "\n";
                    }
                    if (pustel.isChecked()) {
                        finalee += pustel.getText().toString() + "\n";
                    }

                    hasill.setText("Nama : " + name +
                            "\nKelas : " + haha +
                            "\nAbsen : " + abs +
                            "\nOrganisasi :" + finalee +
                            "Sub Organisasi : " + spin);
                }
            }


        });
    }

    private boolean valid() {
        boolean valid = true;

        String name = nama.getText().toString();
        String abs = absen.getText().toString();

        if(name.isEmpty()){
            nama.setError("Nama belum diisi");
            hasill.setText("");
            valid = false;
        }
        if(abs.isEmpty()){
            absen.setError("Absen belum diisi");
            hasill.setText("");
            valid = false;
        }

        return valid;
    }
}