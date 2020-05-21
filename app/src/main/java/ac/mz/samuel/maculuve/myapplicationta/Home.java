package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class Home extends Fragment {
    private ImageView funcionario,rota,veiculo,sobre;
    public Home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        funcionario = view.findViewById(R.id.funcionario);
        rota = view.findViewById(R.id.rota);
        veiculo = view.findViewById(R.id.veiculo);
        sobre = view.findViewById(R.id.sobre);
        funcionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  getSupportFragmentManager()
            }
        });
        rota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        veiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
