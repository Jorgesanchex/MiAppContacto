package com.miapp.contacto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    private TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnEditar = findViewById(R.id.btnEditar);

        // Mostrar los datos
        Intent intent = getIntent();
        tvNombre.setText("Nombre: " + intent.getStringExtra("nombre"));
        tvFecha.setText("Fecha de nacimiento: " + intent.getStringExtra("fecha"));
        tvTelefono.setText("Teléfono: " + intent.getStringExtra("telefono"));
        tvEmail.setText("Email: " + intent.getStringExtra("email"));
        tvDescripcion.setText("Descripción: " + intent.getStringExtra("descripcion"));

        // Editar datos
        btnEditar.setOnClickListener(v -> {
            Intent editarIntent = new Intent(ConfirmActivity.this, MainActivity.class);
            editarIntent.putExtra("nombre", intent.getStringExtra("nombre"));
            editarIntent.putExtra("fecha", intent.getStringExtra("fecha"));
            editarIntent.putExtra("telefono", intent.getStringExtra("telefono"));
            editarIntent.putExtra("email", intent.getStringExtra("email"));
            editarIntent.putExtra("descripcion", intent.getStringExtra("descripcion"));
            startActivity(editarIntent);
            finish();
        });
    }
}
