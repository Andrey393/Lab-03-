package com.example.lab03393;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   Switch aSwitch;
    EditText []txt_sena=new EditText[4];
    EditText []txt=new EditText[4];
    CheckBox []chc=new CheckBox[4];
    int []pricer=new int[4];//Цена

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch=findViewById(R.id.switch1);


        txt_sena[0]=findViewById(R.id.edit_sena_apple);
        txt_sena[1]=findViewById(R.id.edit_sena_limon);
        txt_sena[2]=findViewById(R.id.edit_sena_mandarin);
        txt_sena[3]=findViewById(R.id.edit_sena_persiki);

        txt[0]=findViewById(R.id.editTextNumber);
        txt[1]=findViewById(R.id.editTextNumber2);
        txt[2]=findViewById(R.id.editTextNumber3);
        txt[3]=findViewById(R.id.editTextNumber4);

        chc[0]=findViewById(R.id.checkBox_1);
        chc[1]=findViewById(R.id.checkBox_2);
        chc[2]=findViewById(R.id.checkBox_3);
        chc[3]=findViewById(R.id.checkBox_4);


        Button button=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)//Подсчитать
            {
                int sum=0;
                for (int i=0;i<4;i++)
                {
                    if(chc[i].isChecked())
                    {
                        try
                        {
                            sum+=Integer.parseInt(txt[i].getText().toString())*pricer[i];
                        } catch (NumberFormatException e) {

                        }
                    }
                }
                if(aSwitch.isChecked())
                {
                    Dialog(sum);

                }
                else
                    {
                    String res=String.format("Итог=%d",sum);
                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
    int Dialog(int sum)//Диалоговое окно
    {
        String res=String.format("Итог=%d",sum);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dlg = builder.create();
        dlg.setIcon(R.drawable.kit2);
        dlg.setTitle(res);
        dlg.show();
        return sum;
    }

    public void  primanit(View v)//Принимает цену
    {
        for (int i=0;i<4;i++)
        {
            try
            {
                pricer[i]=Integer.parseInt(txt_sena[i].getText().toString());

            }
            catch (NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Пустые значение", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  void  check(View v)//Активирует текст при нажатии на флажок
    {
        for (int i=0;i<4;i++)
        {
            if(chc[i].isChecked())
            {
                txt[i].setEnabled(true);
            }
            else
            {
                txt[i].setEnabled(false);
            }
        }
    }

}