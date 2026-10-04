package com.example.pokdexapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Pokemon> lista;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recyclerView);

        // Inicializa a lista de Pokémons
        lista = PokemonData.getPokemons();
        adapter = new PokemonAdapter(lista);

        // Configuração do RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        // Configuração dos eventos de clique
        adapter.setOnItemClickListener(new PokemonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position < 0 || position >= lista.size()) return;
                Pokemon p = lista.get(position);
                Intent intent = new Intent(ListaActivity.this, DetalhesActivity.class);
                intent.putExtra("nome", p.getNome());
                intent.putExtra("tipo", p.getTipo());
                intent.putExtra("descricao", p.getDescricao());
                if (p.getImagem() != 0) {
                    intent.putExtra("imagem", p.getImagem());
                    intent.putExtra("imagemResId", p.getImagem());
                } else if (p.getImagemUrl() != null) {
                    intent.putExtra("imagem", p.getImagemUrl());
                    intent.putExtra("imagemUrl", p.getImagemUrl());
                }
                intent.putExtra("pokemon", p);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position) {
                if (position < 0 || position >= lista.size()) return;
                Pokemon p = lista.get(position);

                // Confirmação com AlertDialog antes da remoção
                new AlertDialog.Builder(ListaActivity.this)
                        .setTitle("Deseja remover este item?")
                        .setMessage("Você tem certeza de que deseja remover " + p.getNome() + " da lista?")
                        .setPositiveButton("Remover", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                int pos = lista.indexOf(p);
                                if (pos != -1) {
                                    String nome = p.getNome();
                                    lista.remove(pos);
                                    adapter.notifyItemRemoved(pos);
                                    adapter.notifyItemRangeChanged(pos, lista.size() - pos);
                                    Toast.makeText(ListaActivity.this, nome + " foi removido da lista.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();
            }
        });
    }
}
