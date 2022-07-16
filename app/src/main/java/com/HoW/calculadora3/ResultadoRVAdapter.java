package com.HoW.calculadora3;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


public class ResultadoRVAdapter extends ListAdapter<ResultadoModel, ResultadoRVAdapter.ViewHolder>{


        // criando variavel para o itemClickListener
        private OnItemClickListener listener;

        // criando construtor para o adapter
        public ResultadoRVAdapter() {
            super(DIFF_CALLBACK);
        }

        // criando callback para o Recycler View
        private static final DiffUtil.ItemCallback<ResultadoModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<ResultadoModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull ResultadoModel oldItem, @NonNull ResultadoModel newItem) {
                return oldItem.getCoResultado() == newItem.getCoResultado();
            }

            @Override
            public boolean areContentsTheSame(@NonNull ResultadoModel oldItem, @NonNull ResultadoModel newItem) {
                // exibe os atributos na lista
                return oldItem.getDeResultado().equals(newItem.getDeResultado());
            }
        };

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // preenche o layout com os itens da lista
            View item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.resultado_rv_item, parent, false);
            return new ViewHolder(item);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // define os atributos dos itens exibidos na lista
            ResultadoModel model = getResultadoAt(position);
            holder.deResultadoTV.setText(model.getDeResultado());
        }

        // criando metodo get para selecionar item da lista
        public ResultadoModel getResultadoAt(int position) {
            return getItem(position);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView deResultadoTV;

            //TextView dtNascResultadoTV;

            ViewHolder(@NonNull View itemView) {
                super(itemView);
                // inicializando cada View do Recycler View
                deResultadoTV = itemView.findViewById(R.id.idTVDeResultado);

                // adicionando evento on click listener para cada item do Recycler View
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // dentro do click listener passa a posicao do item do Recycler View
                        int position = getAdapterPosition();
                        if (listener != null && position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(getItem(position));
                        }
                    }
                });
            }
        }

        public interface OnItemClickListener {
            void onItemClick(ResultadoModel model);
        }

        public void setOnClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

    
}
