package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.AppCompatImageButton;
import org.w3c.dom.Text;

public class Fase2 extends AppCompatActivity {

    int invisivel = 0;
    int acertos = 0;
    int erros = 0;
    boolean bird = false, pig = false, lion = false, cow = false, dog = false;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase2);

         // variável que vai armazenar os acertos
         acertos = 0;
    }

    public void VerficaInvisiveis()
    {
        //recupero todos os compoentes que vou utilizar
        ImageButton ibCobrePassaro1 = (ImageButton) findViewById(R.id.ibCobrePassaro1);
        ImageButton ibCobreBird2 = (ImageButton) findViewById(R.id.ibCobreBird2);
        ImageButton ibCobrePig1 = (ImageButton) findViewById(R.id.ibCobrepig1);
        ImageButton ibCobrePig2 = (ImageButton) findViewById(R.id.ibCobrePorco22);
        ImageButton ibCobreLion1= (ImageButton) findViewById(R.id.ibCobreLion1);
        ImageButton ibCobreLion2 = (ImageButton) findViewById(R.id.ibCobreLion2);
        ImageButton ibCobreCow1 = (ImageButton) findViewById(R.id.ibCobreCow1);
        ImageButton ibCobreCow2 = (ImageButton) findViewById(R.id.ibCobreCow2);
        ImageButton ibCobreDog1 = (ImageButton) findViewById(R.id.ibCobreDog1);
        ImageButton ibCobreDog2 = (ImageButton) findViewById(R.id.ibCobreCachorro2);
        TextView tvAcertos = (TextView) findViewById(R.id.tvAcertos);


        //aqui, para cada par de cartas checo se ele está invisivel ou não
        //caso esteja, marca 1 ponto, caso não esteja, esconde as cartas novamente
        //a váriavel é pra checar sejá contou os pontos 1 vez

        if(bird == false)
        {
            if(ibCobrePassaro1.getVisibility() == View.INVISIBLE && ibCobreBird2.getVisibility() == View.INVISIBLE)
            {
                acertos++;
                bird = true;
                tvAcertos.setText(String.valueOf(acertos));
            }
            else
            {
                ibCobrePassaro1.setVisibility(View.VISIBLE);
                ibCobreBird2.setVisibility(View.VISIBLE);

            }
        }

        else if(pig == false)
        {

                if(ibCobrePig1.getVisibility() == View.INVISIBLE && ibCobrePig2.getVisibility() == View.INVISIBLE)
                {

                    acertos++;
                    pig = true;
                    tvAcertos.setText(String.valueOf(acertos));

                }
                else
                {
                    ibCobrePig1.setVisibility(View.VISIBLE);
                    ibCobrePig2.setVisibility(View.VISIBLE);

                }
        }


        if(lion == false)
        {
                 if(ibCobreLion1.getVisibility() == View.INVISIBLE && ibCobreLion2.getVisibility() == View.INVISIBLE)
                {

                    acertos++;
                    lion = true;
                    tvAcertos.setText(String.valueOf(acertos));
                }
                 else
                 {
                     ibCobreLion1.setVisibility(View.VISIBLE);
                     ibCobreLion2.setVisibility(View.VISIBLE);
                 }
        }



        if(cow == false)
        {
            if(ibCobreCow1.getVisibility() == View.INVISIBLE && ibCobreCow2.getVisibility() == View.INVISIBLE)
            {

                acertos++;
                cow = true;
                tvAcertos.setText(String.valueOf(acertos));

            }
            else
            {
                ibCobreCow1.setVisibility(View.VISIBLE);
                ibCobreCow2.setVisibility(View.VISIBLE);

            }
        }




        if(dog == false)
        {
                 if(ibCobreDog1.getVisibility() == View.INVISIBLE && ibCobreDog2.getVisibility() == View.INVISIBLE)
                {

                    acertos++;
                    dog = true;
                    tvAcertos.setText(String.valueOf(acertos));

                }
                 else
                 {
                     ibCobreDog1.setVisibility(View.VISIBLE);
                     ibCobreDog2.setVisibility(View.VISIBLE);

                 }
        }


        //zero a varável que contabiliza os invisiveis
        invisivel = 0;

        if(acertos==5)
        {
            //caso o jogador tenha acertado todas, um botão para enviar sms é disponibilizado
            ImageButton sendSMS = (ImageButton) findViewById(R.id.imageButton);
            sendSMS.setVisibility(View.VISIBLE);

            // e então seu score é enviado por sms
            sendSMS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("sms:" ));
                    intent.putExtra("sms_body",  "Total de Acertos da primeira fase: " + String.valueOf(acertos));
                    startActivity(intent);

                }
            });


        }

    }

    //daqui para baixo, a cada click nas cartas, chama uma função para deixá-la invisivel e contabilizar.
    // Caso tenham dois invisieis, chama a função "VerificarInvisiveis", caso contrário o jogo segue normalmente





    public void clickBird1(View v)
    {

        ImageButton ibCobrePassaro1 =  (ImageButton) findViewById(R.id.ibCobrePassaro1);

        if(invisivel<2)
        {
            ibCobrePassaro1.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickBird2(View v)
    {
        ImageButton ibCobreBird2 = (ImageButton) findViewById(R.id.ibCobreBird2);

        if(invisivel<2)
        {
            ibCobreBird2.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickPig1(View v)
    {
        ImageButton ibCobrePig1 = (ImageButton) findViewById(R.id.ibCobrepig1);

        if(invisivel<2)
        {
            ibCobrePig1.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickPig2(View v)
    {
        ImageButton ibCobrePig2 = (ImageButton) findViewById(R.id.ibCobrePorco22);

        if(invisivel<2)
        {
            ibCobrePig2.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickLion1(View v)
    {
        ImageButton ibCobreLion1 = (ImageButton) findViewById(R.id.ibCobreLion1);

        if(invisivel<2)
        {
            ibCobreLion1.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickLion2(View v)
    {
        ImageButton ibCobreLion2 = (ImageButton) findViewById(R.id.ibCobreLion2);

        if(invisivel<2)
        {
            ibCobreLion2.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickDog1(View v)
    {
        ImageButton ibCobreDog1 = (ImageButton) findViewById(R.id.ibCobreDog1);

        if(invisivel<2)
        {
            ibCobreDog1.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickDog2(View v)
    {
        ImageButton ibCobreDog2 = (ImageButton) findViewById(R.id.ibCobreCachorro2);


        if(invisivel<2)
        {
            ibCobreDog2.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickCow1(View v)
    {
        ImageButton ibCobreCow1= (ImageButton) findViewById(R.id.ibCobreCow1);

        if(invisivel<2)
        {
            ibCobreCow1.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickCow2(View v)
    {
        ImageButton ibCobreCow2= (ImageButton) findViewById(R.id.ibCobreCow2);

        if(invisivel<2)
        {
            ibCobreCow2.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

}
