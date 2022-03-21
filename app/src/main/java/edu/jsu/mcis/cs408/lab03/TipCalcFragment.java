package edu.jsu.mcis.cs408.lab03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import edu.jsu.mcis.cs408.lab03.databinding.TabFragmentBinding;
import edu.jsu.mcis.cs408.lab03.databinding.TipCalcFragmentBinding;

public class TipCalcFragment extends Fragment {

    private TipCalcFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TipCalcFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                submitParams();
            }
        });
    }

    private void submitParams() {
        String totalBillString = binding.totalBillInput.getText().toString();
        String numPeopleString = binding.numPeopleInput.getText().toString();
        String percentString = binding.percentInput.getText().toString();

        if ( !( totalBillString.equals("") || numPeopleString.equals("") || percentString.equals("") ) ) {
            double totalBill = Double.parseDouble(totalBillString);
            int numPeople = Integer.parseInt(numPeopleString);
            double percentage = Integer.parseInt(percentString);
            percentage /= 100;

            if (!(totalBill == 0 || percentage == 0 || numPeople == 0)) {
                double totalPerPerson = (totalBill + totalBill * percentage) / numPeople;
                NumberFormat formatter = new DecimalFormat("#0.00");
                binding.totalText.setText('$' + formatter.format(totalPerPerson) + " per person");

            } else {
                binding.totalText.setText("ERROR: Input zero or missing");
            }

        }
        else {
            binding.totalText.setText("ERROR: Input zero or missing");
        }

    }
}
