package com.pdgg.envairdatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class datos extends AppCompatActivity {
    TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle datos = getIntent().getExtras();

        String Nombre= datos.getString("nombre");
        String fecha= datos.getString("fecha");
        String telefono= datos.getString("telefono");
        String email= datos.getString("email");
        String descripcion= datos.getString("descripcion");

        tvNombre=(TextView) findViewById(R.id.tvDatoNombre);
        tvNombre.setText(Nombre);
        tvFecha=(TextView) findViewById(R.id.tvDatoFecha);
        tvFecha.setText(fecha);
        tvTelefono=(TextView) findViewById(R.id.tvDatoTelefono);
        tvTelefono.setText(telefono);
        tvEmail=(TextView) findViewById(R.id.tvDatoEmail);
        tvEmail.setText(email);
        tvDescripcion=(TextView) findViewById(R.id.tvDatoDescripcion);
        tvDescripcion.setText(descripcion);

        button=(Button) findViewById(R.id.btnEditarDato);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NombreEdit = tvNombre.getText().toString();
                String FechaEdit = tvFecha.getText().toString();
                String TelefonoEdit = tvTelefono.getText().toString();
                String EmailEdit = tvEmail.getText().toString();
                String DescripcionEdit = tvDescripcion.getText().toString();

                Intent intent = new Intent(datos.this, MainActivity.class);

                intent.putExtra("Nombre", NombreEdit);
                intent.putExtra("Fecha", FechaEdit);
                intent.putExtra("Telefono", TelefonoEdit);
                intent.putExtra("Email", EmailEdit);
                intent.putExtra("Descripcion", DescripcionEdit);
                startActivity(intent);
                finish();
            }
        });
    }
}
