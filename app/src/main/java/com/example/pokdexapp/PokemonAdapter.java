package com.example.pokdexapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Adapter para o RecyclerView da lista de Pokémon.
 * Carrega a imagem do Pokémon via Glide (recurso local ou URL).
 * Suporta clique simples (detalhes) e clique longo (remoção).
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {

    private ArrayList<Pokemon> list;
    private OnItemClickListener listener;

    // Mapa de tipo -> cor correspondente
    private static final Map<String, String> TYPE_COLORS = new HashMap<>();
    static {
        TYPE_COLORS.put("Normal",   "#A8A878");
        TYPE_COLORS.put("Fogo",     "#F08030");
        TYPE_COLORS.put("Água",     "#6890F0");
        TYPE_COLORS.put("Planta",   "#78C850");
        TYPE_COLORS.put("Elétrico", "#F8D030");
        TYPE_COLORS.put("Gelo",     "#98D8D8");
        TYPE_COLORS.put("Luta",     "#C03028");
        TYPE_COLORS.put("Veneno",   "#A040A0");
        TYPE_COLORS.put("Terra",    "#E0C068");
        TYPE_COLORS.put("Voador",   "#A890F0");
        TYPE_COLORS.put("Psíquico", "#F85888");
        TYPE_COLORS.put("Inseto",   "#A8B820");
        TYPE_COLORS.put("Pedra",    "#B8A038");
        TYPE_COLORS.put("Fantasma", "#705898");
        TYPE_COLORS.put("Dragão",   "#7038F8");
        TYPE_COLORS.put("Sombrio",  "#705848");
        TYPE_COLORS.put("Aço",      "#B8B8D0");
        TYPE_COLORS.put("Fada",     "#EE99AC");
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onItemLongClick(int position);
    }

    public PokemonAdapter(ArrayList<Pokemon> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon pokemon = list.get(position);

        // Nome
        holder.txtNome.setText(pokemon.getNome());

        // Tipo — exibe o primeiro tipo como badge colorido
        String tipoCompleto = pokemon.getTipo();
        String primeiraTipo = tipoCompleto.contains("/")
                ? tipoCompleto.split("/")[0].trim()
                : tipoCompleto.trim();

        holder.txtTipo.setText(primeiraTipo);

        // Aplica cor do tipo no badge
        String color = TYPE_COLORS.get(primeiraTipo);
        if (color != null && holder.txtTipo.getBackground() != null) {
            try {
                holder.txtTipo.getBackground().mutate().setTint(Color.parseColor(color));
            } catch (Exception ignored) { }
        }

        // Carrega imagem via Glide
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(200, 200);

        if (pokemon.getImagem() != 0) {
            Glide.with(holder.itemView.getContext())
                    .load(pokemon.getImagem())
                    .apply(requestOptions)
                    .into(holder.imgAvatar);
        } else if (pokemon.getImagemUrl() != null && !pokemon.getImagemUrl().isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(pokemon.getImagemUrl())
                    .apply(requestOptions)
                    .into(holder.imgAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNome;
        TextView txtTipo;
        ImageView imgAvatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome   = itemView.findViewById(R.id.txtNome);
            txtTipo   = itemView.findViewById(R.id.txtTipo);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);

            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });

            itemView.setOnLongClickListener(view -> {
                if (listener != null) {
                    int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemLongClick(position);
                        return true;
                    }
                }
                return false;
            });
        }
    }
}
