package tn.enis.smsapplication;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnvoieSms extends Activity
{ public void onCreate(Bundle savedInstanceState)
{ super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//On récupère le bouton créé en XML grâce à son id
    Button btnEnvoie = (Button)findViewById(R.id.btn);
//On récupère les deux EditText correspondant aux champs pour entrer le numéro et le message
    final EditText numero =(EditText)findViewById(R.id.numero);
    final EditText message = (EditText)findViewById(R.id.message);
    //On affecte un écouteur d'évènement au bouton
    btnEnvoie.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            //On récupère ce qui a été entré dans les EditText
            String num = numero.getText().toString();
            String msg = message.getText().toString();
//Si le numéro est supérieur à 4 caractères et que le message n'est pas vide on lance la procédure d'envoi
            if(num.length()>= 4 && msg.length() > 0)
            {
//Grâce à l'objet de gestion de SMS (SmsManager) que l'on récupère via la méthode static getDefault()
//On envoie le SMS à l'aide de la méthode sendTextMessage
                SmsManager.getDefault().sendTextMessage(num, null, msg, null, null);
//On efface les deux Edit
                numero.setText("");
                message.setText("");
            }else{
//On affiche un petit message d'erreur dans un Toast
                Toast.makeText(EnvoieSms.this, "Enter le numero et/ou le message", Toast.LENGTH_SHORT).show(); } } }); } }

