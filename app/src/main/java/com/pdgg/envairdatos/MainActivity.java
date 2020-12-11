package com.pdgg.envairdatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etTelefono,etEmail,etDescripcion;
    Button button;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle datos = getIntent().getExtras();

        if (datos!=null){
            String nombre= datos.getString("Nombre");
            String fecha= datos.getString("Fecha");
            String telefono= datos.getString("Telefono");
            String email= datos.getString("Email");
            String descripcipon= datos.getString("Descripcion");

            etNombre=(EditText) findViewById(R.id.etNombre);
            datePicker=(DatePicker) findViewById(R.id.dpFecha);
            etTelefono=(EditText) findViewById(R.id.etTelefono);
            etEmail=(EditText) findViewById(R.id.etEmail);
            etDescripcion=(EditText) findViewById(R.id.etDescripcion);

            etNombre.setText(nombre);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcipon);
        }

        etNombre=(EditText) findViewById(R.id.etNombre);
        datePicker=(DatePicker) findViewById(R.id.dpFecha);
        etTelefono=(EditText) findViewById(R.id.etTelefono);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etDescripcion=(EditText) findViewById(R.id.etDescripcion);

        button=(Button) findViewById(R.id.btnGuardar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String fecha = "Fecha:"+datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear();
                String telefono = etTelefono.getText().toString();
                String email = etEmail.getText().toString();
                String descripcion = etDescripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this, datos.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("fecha", fecha);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);

                startActivity(intent);
                finish();
            }
        });

    }
}
