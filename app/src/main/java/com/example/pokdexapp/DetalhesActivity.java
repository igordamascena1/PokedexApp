package com.example.pokdexapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Tela de detalhes do Pokémon.
 * Exibe: imagem (recurso local ou URL), nome, tipo (com badges) e descrição.
 * Dados recebidos via Intent: nome, tipo, descricao, imagem.
 */
public class DetalhesActivity extends AppCompatActivity {

    private ImageView imgItem;
    private TextView txtNome;
    private TextView txtNomeHeader;
    private TextView txtTipo;
    private TextView txtTipoHeader1;
    private TextView txtTipoHeader2;
    private TextView txtDescricao;
    private ImageButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        // Vincula as views
        imgItem        = findViewById(R.id.imgItem);
        txtNome        = findViewById(R.id.txtNome);
        txtNomeHeader  = findViewById(R.id.txtNomeHeader);
        txtTipo        = findViewById(R.id.txtTipo);
        txtTipoHeader1 = findViewById(R.id.txtTipoHeader1);
        txtTipoHeader2 = findViewById(R.id.txtTipoHeader2);
        txtDescricao   = findViewById(R.id.txtDescricao);
        btnVoltar      = findViewById(R.id.btnVoltar);

        // Recupera os dados da Intent (campos: nome, tipo, descricao, imagem)
        String nome      = getIntent().getStringExtra("nome");
        String tipo      = getIntent().getStringExtra("tipo");
        String descricao = getIntent().getStringExtra("descricao");

        int imagemResId  = getIntent().getIntExtra("imagemResId", 0);
        String imagemUrl = getIntent().getStringExtra("imagemUrl");

        if (imagemResId == 0 && getIntent().hasExtra("imagem")) {
            Object extra = getIntent().getExtras().get("imagem");
            if (extra instanceof Integer) {
                imagemResId = (Integer) extra;
            } else if (extra instanceof String) {
                imagemUrl = (String) extra;
            }
        }

        // Fallback: objeto Pokémon serializado
        if (getIntent().hasExtra("pokemon")) {
            Pokemon p;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                p = getIntent().getSerializableExtra("pokemon", Pokemon.class);
            } else {
                p = (Pokemon) getIntent().getSerializableExtra("pokemon");
            }

            if (p != null) {
                if (nome == null) nome = p.getNome();
                if (tipo == null) tipo = p.getTipo();
                if (descricao == null) descricao = p.getDescricao();
                if (imagemResId == 0 && p.getImagem() != 0) imagemResId = p.getImagem();
                if (imagemUrl == null && p.getImagemUrl() != null) imagemUrl = p.getImagemUrl();
            }
        }

        // Preenche nome (header + card)
        if (nome != null) {
            txtNome.setText(nome);
            txtNomeHeader.setText(nome);
        }

        // Preenche tipo no card e badges no header
        if (tipo != null) {
            txtTipo.setText("Tipo: " + tipo);

            String[] tipos = tipo.split("/");
            if (tipos.length >= 1) {
                txtTipoHeader1.setText(tipos[0].trim());
                txtTipoHeader1.setVisibility(View.VISIBLE);
            }
            if (tipos.length >= 2) {
                txtTipoHeader2.setText(tipos[1].trim());
                txtTipoHeader2.setVisibility(View.VISIBLE);
            } else {
                txtTipoHeader2.setVisibility(View.GONE);
            }
        }

        // Preenche descrição
        if (descricao != null) {
            txtDescricao.setText(descricao);
        }

        // Carrega imagem via Glide (recurso local ou URL)
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(400, 400);

        if (imagemResId != 0) {
            Glide.with(this)
                    .load(imagemResId)
                    .apply(requestOptions)
                    .into(imgItem);
        } else if (imagemUrl != null && !imagemUrl.isEmpty()) {
            Glide.with(this)
                    .load(imagemUrl)
                    .apply(requestOptions)
                    .into(imgItem);
        }

        // Botão voltar
        btnVoltar.setOnClickListener(v -> finish());
    }
}
