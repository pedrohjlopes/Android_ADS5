package br.com.faculdade.my_trainning;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BoxAdapter adapter;
    private ArrayList<ItemData> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        dataArrayList = new ArrayList<>();

        // Adicionando itens à lista
        int[] imageList = {R.drawable.peito, R.drawable.costas, R.drawable.perna, R.drawable.ombro, R.drawable.corrida};
        String[] nameList = {"Peito e Tríceps", "Costa", "Perna", "Ombro", "Aeróbico"};
        String[] descList = {"Exercícios para peito e tríceps", "Exercícios para costas", "Exercícios para pernas", "Exercícios para ombros", "Atividades aeróbicas"};

        for (int i = 0; i < nameList.length; i++) {
            dataArrayList.add(new ItemData(nameList[i], descList[i], imageList[i]));
        }

        // Configurando o adapter
        adapter = new BoxAdapter(this, dataArrayList, item -> {
            // Abrir a atividade de detalhes
            Intent intent = new Intent(Home.this, DetailActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("image", item.getImageResource());
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
