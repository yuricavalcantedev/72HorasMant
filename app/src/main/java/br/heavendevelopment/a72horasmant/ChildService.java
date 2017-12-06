package br.heavendevelopment.a72horasmant;

import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by yuri on 07/12/17.
 */

public class ChildService {

    public static int calculaIdade(java.util.Date dataNasc) {

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dataNasc);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        return idade;
    }

    public boolean addNewChild(Child child){

        try {

            Calendar cal = Calendar.getInstance();
            int hours = cal.get(Calendar.HOUR_OF_DAY);
            int minutes = cal.get(Calendar.MINUTE);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH)+1;

            child.setDate(day + "/" + mes);
            child.setHour(hours+ ":" + minutes);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = sdf.parse(child.getBirth());
            int idade = calculaIdade(dataNascimento);

            child.setAge(idade);
            child.save();

        }catch (Exception ex){

            return false;
        }
        return true;
    }



    public List<Child> getAllChildren(){

        return new Select()
                .from(Child.class)
                .execute();
        }

    public Child getChildById(long id){

        Child child = new Select()
                .from(Child.class)
                .where("Id = ?", id)
                .executeSingle();

        return child;
    }

    public boolean deleteChildById(long id){

        Child child = new Select()
                .from(Child.class)
                .where("Id = ?", id)
                .executeSingle();

        try {

            child.delete();

        }catch (Exception ex){
            return false;
        }

        return true;
    }
}
