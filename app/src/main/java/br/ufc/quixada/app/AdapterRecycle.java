package br.ufc.quixada.app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.ViewHolder>{
    private List<Model> listaUsuarios;
    public AdapterRecycle(List<Model>listaUsuarios){
        this.listaUsuarios =  listaUsuarios;
    }

    @NonNull
    @Override
    public AdapterRecycle.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitens, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycle.ViewHolder holder, int position) {
        int resource = listaUsuarios.get(position).getImageview();
        String nomeFruta = listaUsuarios.get(position).getText1();
        String descricao = listaUsuarios.get(position).getText2();
        holder.setData(resource, nomeFruta, descricao);

    }


    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgview1);
            textView1 = itemView.findViewById(R.id.txt1);
            textView2 = itemView.findViewById(R.id.txt2);
        }

        public void setData(int resource, String nomeFruta, String descricao) {
            imageView.setImageResource(resource);
            textView1.setText(nomeFruta);
            textView2.setText(descricao);


        }
    }
}


