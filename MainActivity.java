package com.miapp.contacto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etNombre, etFecha, etTelefono, etEmail, etDescripcion;
    private Button btnSiguiente;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etFecha = findViewById(R.id.etFecha);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        calendar = Calendar.getInstance();

        // Abrir DatePicker al tocar el campo fecha
        etFecha.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view, year1, month1, dayOfMonth) -> etFecha.setText(dayOfMonth + "/" + (month1+1) + "/" + year1),
                    year, month, day);
            datePickerDialog.show();
        });

        // Si hay datos precargados (cuando se edita)
        if(getIntent().hasExtra("nombre")) {
            etNombre.setText(getIntent().getStringExtra("nombre"));
            etFecha.setText(getIntent().getStringExtra("fecha"));
            etTelefono.setText(getIntent().getStringExtra("telefono"));
            etEmail.setText(getIntent().getStringExtra("email"));
            etDescripcion.setText(getIntent().getStringExtra("descripcion"));
        }

        btnSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
            intent.putExtra("nombre", etNombre.getText().toString());
            intent.putExtra("fecha", etFecha.getText().toString());
            intent.putExtra("telefono", etTelefono.getText().toString());
            intent.putExtra("email", etEmail.getText().toString());
            intent.putExtra("descripcion", etDescripcion.getText().toString());
            startActivity(intent);
        });
    }
}
