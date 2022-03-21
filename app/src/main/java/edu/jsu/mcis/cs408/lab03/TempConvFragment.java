package edu.jsu.mcis.cs408.lab03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.lab03.databinding.TabFragmentBinding;
import edu.jsu.mcis.cs408.lab03.databinding.TempConvFragmentBinding;

public class TempConvFragment extends Fragment {

    private TempConvFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TempConvFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                convert();
            }
        });

    }

    private void convert() {
        String farString = binding.farInput.getText().toString();
        String celString = binding.celInput.getText().toString();

        double total;
        double far;
        double cel;
        if (!farString.equals("")) {
            far = Double.parseDouble(farString);
            total = (far - 32) * 5 / 9;
            binding.celInput.setText(String.valueOf(total));

        } else if (farString.equals("") && !celString.equals("")) {
            cel = Double.parseDouble(celString);
            total = (cel * 9) / 5 + 32;
            binding.farInput.setText(String.valueOf(total));

        }

    }
}
