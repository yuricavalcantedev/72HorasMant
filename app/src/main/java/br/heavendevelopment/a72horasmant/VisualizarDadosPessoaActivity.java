package br.heavendevelopment.a72horasmant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class VisualizarDadosPessoaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_dados_pessoa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Detalhes da Pessoa");
        toolbar.setSubtitle("72 Horas Mant-Ce");

        toolbar.setTitleTextColor(getResources().getColor(R.color.textColorToolbar));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.textColorToolbar));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        long idPessoa = bundle.getLong("id_pessoa");

        ChildService childService = new ChildService();
        Child child = childService.getChildById(idPessoa);

        TextView tv_Nome = (TextView) findViewById(R.id.tv_ver_nome);
        TextView tv_Genero = (TextView) findViewById(R.id.tv_ver_genero);
        TextView tv_Idade = (TextView) findViewById(R.id.tv_ver_idade);
        TextView tv_Nascimento = (TextView) findViewById(R.id.tv_ver_nascimento);
        TextView tv_Tenda = (TextView) findViewById(R.id.tv_ver_tenda);
        TextView tv_Pedido_Oracao = (TextView) findViewById(R.id.tv_ver_pedido_oracao);
        TextView tv_Data = (TextView) findViewById(R.id.tv_ver_data);
        TextView tv_Hora = (TextView) findViewById(R.id.tv_ver_hora);

        tv_Nome.setText(child.getName());
        tv_Genero.setText(child.getGenre());
        tv_Idade.setText(child.getAge()+"");
        tv_Nascimento.setText(child.getBirth());
        tv_Tenda.setText(child.getTent());
        tv_Pedido_Oracao.setText(child.getPrayer_request());
        tv_Data.setText(child.getDate());
        tv_Hora.setText(child.getHour());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
