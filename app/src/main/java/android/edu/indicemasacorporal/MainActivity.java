package android.edu.indicemasacorporal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import static basico.android.cftic.edu.indicemasacorporal.IMC.pruebaIMC;

public class MainActivity extends AppCompatActivity {

    private TextView peso, altura, texto3;
    private String PS, AL;
    private int PS0;
    private float AL1, AL0, IMC;
    private ImageView i1, i2, i3, i4, i5;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.............con import static basico.android.cftic.edu.indicemasacorporal.IMC.pruebaIMC;
        //  String rr=pruebaIMC();
        //  Log.d("JNG",rr);

        //.............sin import
        // IMC variable= new IMC();
        // variable.pruebaIMC();

        //Uso de clase persona
        Persona p = new Persona(68, 1.5f);//la 'f' es para indicar que es un float
        float f = p.getPeso();
        Log.d("JNG", "f-->" + f);


        peso = findViewById(R.id.pesoTxt);
        altura = findViewById(R.id.alturaTxt);
        texto3 = findViewById(R.id.textView3);
        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);
        i4 = findViewById(R.id.i4);
        i5 = findViewById(R.id.i5);
    }

    public void calcular(View view) {

        String textoSalida = "";
        int salida = 0;
        salida = imcFunction();

        i1.setImageResource(android.R.drawable.btn_star_big_off);
        i2.setImageResource(android.R.drawable.btn_star_big_off);
        i3.setImageResource(android.R.drawable.btn_star_big_off);
        i4.setImageResource(android.R.drawable.btn_star_big_off);
        i5.setImageResource(android.R.drawable.btn_star_big_off);

        escorderTeclado();

        if (salida == 0) {
            textoSalida = "Error al calcular el IRC";
        } else if (salida == 1) {
            textoSalida = "Desnutrido";
            i1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (salida == 2) {
            textoSalida = "Delgado";
            i1.setImageResource(android.R.drawable.btn_star_big_on);
            i2.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (salida == 3) {
            textoSalida = "Ideal";
            i1.setImageResource(android.R.drawable.btn_star_big_on);
            i2.setImageResource(android.R.drawable.btn_star_big_on);
            i3.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (salida == 4) {
            textoSalida = "Sobrepeso";
            i1.setImageResource(android.R.drawable.btn_star_big_on);
            i2.setImageResource(android.R.drawable.btn_star_big_on);
            i3.setImageResource(android.R.drawable.btn_star_big_on);
            i4.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (salida == 5) {
            textoSalida = "Obesidad";
            i1.setImageResource(android.R.drawable.btn_star_big_on);
            i2.setImageResource(android.R.drawable.btn_star_big_on);
            i3.setImageResource(android.R.drawable.btn_star_big_on);
            i4.setImageResource(android.R.drawable.btn_star_big_on);
            i5.setImageResource(android.R.drawable.btn_star_big_on);
        }

        texto3.setText(textoSalida);
    }

    private int imcFunction() {
        IMC = 0;
        PS = peso.getText().toString();
        AL = altura.getText().toString();

        try {
            PS0 = Integer.parseInt(PS);
            Log.d("JNG", "AL0: " + AL0);
            AL0 = Float.parseFloat(AL);
            AL1 = AL0 * AL0;
            Log.d("JNG", "AL1: " + AL1);
            IMC = PS0 / AL1;
            Log.d("JNG", "IMC: " + IMC);


            if (IMC < 16)
                return 1;
            else if (IMC < 18)
                return 2;
            else if (IMC < 25)
                return 3;
            else if (IMC < 31)
                return 4;
            else
                return 5;

        }
        //catch (NumberFormatException e) {
        catch (Exception e) {

            Log.d("JNG", "Error" + e.getMessage());

            Toast toast = Toast.makeText(this, "Error en el formato campo entrada", Toast.LENGTH_SHORT);
            //Toast toast = Toast.makeText(getApplicationContext(), "Error en el formato campo entrada", Toast.LENGTH_SHORT);
            toast.show();
        }
        return 0;
    }

    private void escorderTeclado() {
        View view = this.getCurrentFocus();
        view.clearFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
