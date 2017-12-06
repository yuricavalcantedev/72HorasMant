package br.heavendevelopment.a72horasmant;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


public class AdicionarPessoaFragment extends Fragment {

    private String tent = "Paz";
    private String genre_text = "Masculino";

    private RadioButton rb_male;
    private RadioButton rb_female;
    private View view;

    public AdicionarPessoaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_adicionar_pessoa, container, false);


        final String array_tents [] = getResources().getStringArray(R.array.tents_name);

        //get the first text in array.
        tent = array_tents[0];

        //spinner
        Spinner spinner_tents = (Spinner) view.findViewById(R.id.spinner_tents);

        spinner_tents.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tent = array_tents[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //radiobuttons
        rb_male = (RadioButton) view.findViewById(R.id.rb_male);
        rb_female = (RadioButton) view.findViewById(R.id.rb_female);

        rb_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked){
                    genre_text = "Masculino";
                    rb_male.setChecked(true);
                    rb_female.setChecked(false);
                }else{
                    genre_text = "Feminino";
                    rb_female.setChecked(true);
                    rb_male.setChecked(false);
                }




            }
        });

        rb_female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                rb_female.setChecked(true);
                rb_male.setChecked(false);

                if(isChecked){
                    genre_text = "Feminino";
                    rb_female.setChecked(true);
                    rb_male.setChecked(false);
                }else{
                    genre_text = "Masculino";
                    rb_male.setChecked(true);
                    rb_female.setChecked(false);

                }

            }
        });

        //fab
        FloatingActionButton fab_save = (FloatingActionButton) view.findViewById(R.id.fab_save);
        fab_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_name = (EditText) view.findViewById(R.id.et_name);
                EditText et_birth = (EditText) view.findViewById(R.id.et_birth);
                EditText et_cellNumber = (EditText) view.findViewById(R.id.et_cellNumber);
                EditText et_prayer_request = (EditText) view.findViewById(R.id.et_prayer_request);

                String name = et_name.getText().toString();
                String birth = et_birth.getText().toString() + "" ;
                String cellNumber = et_cellNumber.getText().toString() + "";
                String prayer_request = et_prayer_request.getText().toString() + "";

                //creating and saving the object in database.
                Child believer = new Child(name,birth,cellNumber,genre_text,prayer_request,tent);

                ChildService childService = new ChildService();
                childService.addNewChild(believer);

                //esvazia os campos novamente
                et_name.setText("");
                et_cellNumber.setText("");
                et_birth.setText("");
                et_prayer_request.setText("");
                rb_male.setChecked(true);
                rb_female.setChecked(false);


                Snackbar.make(view, "Pessoa cadastrada com sucesso", Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
