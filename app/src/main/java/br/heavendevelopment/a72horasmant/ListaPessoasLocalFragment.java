package br.heavendevelopment.a72horasmant;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaPessoasLocalFragment extends Fragment {


    public ListaPessoasLocalFragment() {
        // Required empty public constructor
    }

    private ListaPessoasAdapter adaptarPessoas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_pessoas_local, container, false);

        final ChildService childService = new ChildService();

        final ListView lv_pessoas_local = (ListView) view.findViewById(R.id.lv_pessoas_local);

        adaptarPessoas = new ListaPessoasAdapter(getActivity(),childService.getAllChildren());
        lv_pessoas_local.setAdapter(adaptarPessoas);

        lv_pessoas_local.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvId = (TextView) view.findViewById(R.id.tv_id);
                long id_pessoa = Long.parseLong(tvId.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putLong("id_pessoa", id_pessoa);

                Intent intent = new Intent(getContext(), VisualizarDadosPessoaActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
    });

        lv_pessoas_local.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, int position, final long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Deletar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //deleta o objeto
                        childService.deleteChildById(id);
                        Snackbar.make(view, "Pessoa excluída da lista", Snackbar.LENGTH_SHORT).show();

                        //atualiza o listview
                        adaptarPessoas = new ListaPessoasAdapter(getActivity(), childService.getAllChildren());
                        lv_pessoas_local.setAdapter(adaptarPessoas);

                        adaptarPessoas.notifyDataSetChanged();
                    }
                });

                builder.setTitle("Deletar essa pessoa");
                builder.setMessage("Quer mesmo deletar essa pessoa da lista?");

                builder.create().show();

                return false;
            }
        });


        return view;

    }

}
