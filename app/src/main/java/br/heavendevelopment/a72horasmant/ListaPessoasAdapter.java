package br.heavendevelopment.a72horasmant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuri on 07/12/17.
 */

public class ListaPessoasAdapter extends BaseAdapter {

    private Context context;
    private List<Child> listaChild;

    public ListaPessoasAdapter(){}

    public ListaPessoasAdapter(Context context, List<Child> listaChild){
        this.context = context;
        this.listaChild = listaChild;
    }


    @Override
    public int getCount() {
        return listaChild.size();
    }

    @Override
    public Child getItem(int position) {
        return listaChild.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaChild.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null) {

            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_lv_pessoas, parent, false);

            holder = new ViewHolder();

            holder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            holder.tvNome = (TextView) convertView.findViewById(R.id.tv_ver_nome);
            holder.tvTenda = (TextView) convertView.findViewById(R.id.tv_tenda);
            holder.tvGenero = (TextView) convertView.findViewById(R.id.tv_ver_genero);
            holder.tvIdade = (TextView) convertView.findViewById(R.id.tv_ver_idade);

            convertView.setTag(holder);
        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        Child child = listaChild.get(position);

        holder.tvId.setText(child.getId()+"");
        holder.tvNome.setText(child.getName());
        holder.tvTenda.setText("Tenda: " + child.getTent());
        holder.tvGenero.setText(child.getGenre());
        holder.tvIdade.setText("Idade: " + child.getAge());

        return convertView;

    }

    private static class ViewHolder{

        TextView tvId;
        TextView tvNome;
        TextView tvTenda;
        TextView tvGenero;
        TextView tvIdade;

    }
}
