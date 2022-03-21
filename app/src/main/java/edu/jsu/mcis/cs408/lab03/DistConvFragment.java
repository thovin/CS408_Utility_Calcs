package edu.jsu.mcis.cs408.lab03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.lab03.databinding.DistConvFragmentBinding;
import edu.jsu.mcis.cs408.lab03.databinding.TipCalcFragmentBinding;

public class DistConvFragment extends Fragment {

    private DistConvFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistConvFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.distConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) { convert(); }
        });
    }

    private void convert() {
        String mileString = binding.mileInput.getText().toString();
        String kmString = binding.kmInput.getText().toString();

        double total;
        double miles;
        double kms;
        if (!mileString.equals("")) {
            miles = Double.parseDouble(mileString);
            total = miles * 1.609344;
            binding.kmInput.setText(String.valueOf(total));
        } else if (mileString.equals("") && !kmString.equals("")) {
            kms = Double.parseDouble(kmString);
            total = kms * 0.6213712;
            binding.mileInput.setText(String.valueOf(total));
        }
    }
}
