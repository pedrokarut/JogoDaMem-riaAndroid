package pedro.ifsp.br.trabalhobimestral;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Fase2 extends AppCompatActivity {

    public int invisivel = 0;
    public int pontos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase2);
    }

    private void VerficaInvisiveis()
    {

        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
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



        if(ibCobreGato1.getVisibility() == View.INVISIBLE && ibCobreGato2.getVisibility() == View.INVISIBLE)
        {

            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }


        if(ibCobrePassaro1.getVisibility() == View.INVISIBLE && ibCobreBird2.getVisibility() == View.INVISIBLE)
        {

            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }


        if(ibCobrePig1.getVisibility() == View.INVISIBLE && ibCobrePig2.getVisibility() == View.INVISIBLE)
        {

            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }

        if(ibCobreLion1.getVisibility() == View.INVISIBLE && ibCobreLion2.getVisibility() == View.INVISIBLE)
        {

            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }

        if(ibCobreCow1.getVisibility() == View.INVISIBLE && ibCobreCow2.getVisibility() == View.INVISIBLE)
        {

            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }

        if(ibCobreDog1.getVisibility() == View.INVISIBLE && ibCobreDog2.getVisibility() == View.INVISIBLE)
        {

            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }

        else
        {
            Toast.makeText(this, "As cartas não correspondem! Tente novamente!", Toast.LENGTH_SHORT).show();

             ibCobreGato1.setVisibility(View.VISIBLE);
             ibCobreGato2.setVisibility(View.VISIBLE);
             ibCobrePassaro1.setVisibility(View.VISIBLE);
             ibCobreBird2.setVisibility(View.VISIBLE);
             ibCobrePig1.setVisibility(View.VISIBLE);
             ibCobrePig2.setVisibility(View.VISIBLE);
             ibCobreLion1.setVisibility(View.VISIBLE);
             ibCobreLion2.setVisibility(View.VISIBLE);
             ibCobreCow1.setVisibility(View.VISIBLE);
             ibCobreCow2.setVisibility(View.VISIBLE);
             ibCobreDog1.setVisibility(View.VISIBLE);
             ibCobreDog2.setVisibility(View.VISIBLE);
        }

        invisivel = 0;

    }


    public void clickCat1(View v)
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);

        if(invisivel<2)
        {
            ibCobreGato1.setVisibility(View.INVISIBLE);
            invisivel++;
        }

        if(invisivel==2)
        {
            VerficaInvisiveis();
        }
    }

    public void clickCat2(View v)
    {

    }

    public void clickBird1(View v)
    {

    }

    public void clickBird2(View v)
    {

    }

    public void clickPig1(View v)
    {

    }

    public void clickPig2(View v)
    {

    }

    public void clickLion1(View v)
    {

    }

    public void clickLion2(View v)
    {

    }

    public void clickDog1(View v)
    {

    }

    public void clickDog2(View v)
    {

    }

    public void clickCow1(View v)
    {

    }

    public void clickCow2(View v)
    {

    }

}
