package com.example.materialdesignlab2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.navigation.Navigation;

public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        User user = Fragment2Args.fromBundle(getArguments()).getUser();

        TextView tv = view.findViewById(R.id.tvResult);
        Button btnBack = view.findViewById(R.id.btnToFragment1);
        String languages = (user.getLanguages().length > 0)
                ? String.join(", ", user.getLanguages())
                : "no languages";

        tv.setText(String.format("Hello %s, you are a great %s because you prefer %s.",
                user.getUsername(),
                user.getGender(),
                languages));

        btnBack.setOnClickListener(v -> Navigation.findNavController(v).popBackStack());

        return view;
    }
}