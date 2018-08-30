package com.example.tarrito.login_francisco_tiayna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import  com.example.tarrito.login_francisco_tiayna.R;
import com.example.tarrito.login_francisco_tiayna.Trabajador;
import java.util.List;

public class MyAdapter extends BaseAdapter{

    private List<Trabajador> list;
    private int layout;
    private Context context;

    public MyAdapter(List<Trabajador> list, int layout, Context context){
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Trabajador getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.nombre = (TextView) convertView.findViewById(R.id.textViewnombre);

            vh.rut = (TextView) convertView.findViewById(R.id.textViewrut);
            vh.edad = (TextView) convertView.findViewById(R.id.textViewedad);
            vh.direccion = (TextView) convertView.findViewById(R.id.textViewdireccion);
            vh.sueldo = (TextView) convertView.findViewById(R.id.textViewsueldo);
            vh.cargo = (TextView) convertView.findViewById(R.id.textViewcargo);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Trabajador p = list.get(position);
        vh.nombre.setText(p.getNombrebd());
        vh.rut.setText(p.getRutbd());
        vh.edad.setText(p.getEdadbd());
        vh.direccion.setText(p.getDireccionbd());
        vh.sueldo.setText(p.getSueldobd());
        vh.cargo.setText(p.getCargobd());

        return convertView;
    }
    public class ViewHolder {
        TextView nombre;
        TextView password;
        TextView rut;
        TextView edad;
        TextView direccion;
        TextView sueldo;
        TextView cargo;
    }

}
