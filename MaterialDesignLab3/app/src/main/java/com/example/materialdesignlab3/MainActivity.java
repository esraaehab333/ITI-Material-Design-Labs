package com.example.materialdesignlab3;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mainFab, fabAdd, fabEdit, fabDelete;
    View overlay;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFab = findViewById(R.id.main_fab);
        fabEdit = findViewById(R.id.fab_edit);
        fabDelete = findViewById(R.id.fab_delete);
        fabAdd = findViewById(R.id.fab_add);
        overlay = findViewById(R.id.overlay);

        mainFab.setOnClickListener(v -> toggleFab());
        overlay.setOnClickListener(v -> toggleFab());
    }

    private void toggleFab() {
        if (isOpen) {
            fabEdit.setVisibility(View.GONE);
            fabAdd.setVisibility(View.GONE);
            fabDelete.setVisibility(View.GONE);
            overlay.setVisibility(View.GONE);
        } else {
            fabEdit.setVisibility(View.VISIBLE);
            fabAdd.setVisibility(View.VISIBLE);
            fabDelete.setVisibility(View.VISIBLE);
            overlay.setVisibility(View.VISIBLE);
        }
        isOpen = !isOpen;
    }
}
