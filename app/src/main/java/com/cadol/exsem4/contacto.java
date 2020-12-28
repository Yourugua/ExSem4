package com.cadol.exsem4;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class contacto  extends AppCompatActivity  {

    // Declaro la Variables a usar
    String correo;
    String contraseña;

    TextInputEditText nombre;
    TextInputEditText email;
    EditText mensaje;

    Session session;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        // Levanto objetos
        nombre = (TextInputEditText) findViewById(R.id.txtNombre);
        email = (TextInputEditText) findViewById(R.id.txtemail);
        mensaje = (EditText) findViewById(R.id.txtDescr);

        //Cargo parametros para seccion
        correo = "xxx@gmail.com";
        contraseña =  "1234";

        AppCompatButton btnSiguiente = (AppCompatButton) findViewById(R.id.btnEnviar);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties propiedades = new Properties();
                propiedades.put("mail.smtp.host","smtp.googlemail.com");
                propiedades.put("mail.smtp.socketFactory.port","465");
                propiedades.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                propiedades.put("mail.smtp.auth","true");
                propiedades.put("mail.smtp.port","465");

                try {
                    session = Session.getDefaultInstance(propiedades, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }

                    });

                    if (session != null) {
                        String tmpNombre = String.valueOf(nombre.getText());
                        String tmpEmail = String.valueOf(email.getText());
                        String tmpMensaje = String.valueOf(mensaje.getText());

                        Log.e("Nombre: ", tmpNombre);
                        Log.e("Correo Destino: ", tmpEmail);
                        Log.e("Mensaje: ",tmpMensaje );

                        javax.mail.Message message = new MimeMessage(session);
                        //Correo remitente
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Enviado por: " + tmpNombre);
                        // A donde Enviamos
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(tmpEmail));
                        message.setContent( tmpMensaje,"text/html; charset=utf-8");
                        Transport.send(message);
                        Toast.makeText(contacto.this, "Correo Enviado a " + tmpNombre, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
