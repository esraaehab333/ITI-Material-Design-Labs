package com.example.materialdesignlab2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import com.google.android.material.textfield.TextInputEditText;
import androidx.navigation.Navigation;
import java.util.ArrayList;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        TextInputEditText etUsername = view.findViewById(R.id.etUsername);
        TextInputEditText etPassword = view.findViewById(R.id.etPassword);
        RadioGroup rgGender = view.findViewById(R.id.rgGender);
        CheckBox cbC = view.findViewById(R.id.cbC);
        CheckBox cbCpp = view.findViewById(R.id.cbCpp);
        CheckBox cbJava = view.findViewById(R.id.cbJava);
        Button btn = view.findViewById(R.id.btnToFragment2);

        btn.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            int selectedId = rgGender.getCheckedRadioButtonId();
            String gender = (selectedId == R.id.rbMale) ? "Male" : "Female";

            ArrayList<String> languagesList = new ArrayList<>();
            if (cbC.isChecked()) languagesList.add("C");
            if (cbCpp.isChecked()) languagesList.add("C++");
            if (cbJava.isChecked()) languagesList.add("Java");
            String[] languages = languagesList.toArray(new String[0]);

            User user = new User(username, password, gender, languages);

            Fragment1Directions.ActionFragment1ToFragment2 action =
                    Fragment1Directions.actionFragment1ToFragment2(user);

            Navigation.findNavController(v).navigate(action);
        });

        return view;
    }
}