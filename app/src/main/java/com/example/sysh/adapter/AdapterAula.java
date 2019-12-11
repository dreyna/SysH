package com.example.sysh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysh.R;
import com.example.sysh.entity.Aula;
import com.example.sysh.listener.OnDeleteClickListener;
import com.example.sysh.listener.OnUpdateClickListener;

import java.util.List;

public class AdapterAula extends RecyclerView.Adapter<AdapterAula.ViewHolderDatos> {

    private List<Aula> datos;
    private Context context;
    OnDeleteClickListener onDeleteClickListener;
    OnUpdateClickListener onUpdateClickListener;

    public AdapterAula(List<Aula> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }

    public void setOnDeleteClickListener(OnDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public void setOnUpdateClickListener(OnUpdateClickListener onUpdateClickListener) {
        this.onUpdateClickListener = onUpdateClickListener;
    }

    public void remove(int position) {
        if (position >= 0 && position < datos.size()) {
            datos.remove(position);
            notifyItemRemoved(position);
        }
    }
    public Aula getData(int position) {
        return datos.get(position);
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_aula,parent,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderDatos holder, final int position) {
        final Aula au = datos.get(position);
        holder.tv1.setText(au.getIdaula());
        holder.tv2.setText(au.getNombre());
        holder.tv3.setText(au.getCapacidad());
        holder.tv4.setText(au.getTipo());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public TextView tv4;
        public ImageButton btnEd;
        public ImageButton btnEl;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.tvid);
            tv2 = (TextView)itemView.findViewById(R.id.tvnombre);
            tv3 = (TextView)itemView.findViewById(R.id.tvcapacidad);
            tv4 = (TextView)itemView.findViewById(R.id.tvtipo);
            btnEd = (ImageButton) itemView.findViewById(R.id.btneditar);
            btnEl = (ImageButton) itemView.findViewById(R.id.btneliminar);
            btnEd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onUpdateClickListener.onUpdateClick(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            btnEl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteClickListener.onDeleteClick(getAdapterPosition());

                }
            });

        }
    }
}
