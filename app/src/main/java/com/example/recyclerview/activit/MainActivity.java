package com.example.recyclerview.activit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Configurar adapter
        Adapter adapter = new Adapter( listaFilmes );
        //Listagem filmes
        this.criarFilmes();
        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );
        //click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener(){
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }

                            public void onItemClick(View view, int position){
                                Filme filme = listaFilmes.get( position );
                                Toast.makeText(
                                  getApplicationContext(),
                                  "Item pressionado: " + filme.getTituloFilme(),
                                  Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get( position );
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        }
                )
        );
    }
    public void criarFilmes(){
      Filme filme = new Filme("titulo", "microondas", "2017");
      this.listaFilmes.add( filme );

        filme = new Filme("titulo", "microondas", "2018");
        this.listaFilmes.add( filme );

        filme = new Filme("titulo", "microondas", "2019");
        this.listaFilmes.add( filme );

        filme = new Filme("titulo", "microondas", "2020");
        this.listaFilmes.add( filme );

        filme = new Filme("titulo", "microondas", "2021");
        this.listaFilmes.add( filme );

        filme = new Filme("titulo", "microondas", "2022");
        this.listaFilmes.add( filme );
    }
}