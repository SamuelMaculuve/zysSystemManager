package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.ControllerRota;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadRota#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadRota extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadRota() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadRota.
     */
    // TODO: Rename and change types and number of parameters
    public static CadRota newInstance(String param1, String param2) {
        CadRota fragment = new CadRota();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private TextView txtTerminal1,txtTerminal2,txtVia,txtTempo;
    private Button btnCadastrar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_cad_rota, container, false);
        btnCadastrar=view.findViewById(R.id.saveRota);
        txtTerminal1=view.findViewById(R.id.txtTerminal1);
        txtTerminal2=view.findViewById(R.id.txtTerminal2);
        txtVia=view.findViewById(R.id.txtVia);
        txtTempo=view.findViewById(R.id.txtTempo);



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String terminal1 = txtTerminal1.getText().toString();
                    String terminal2 = txtTerminal2.getText().toString();
                    String via = txtVia.getText().toString();
                    double tempo = Double.parseDouble(txtTempo.getText().toString());

                    ControllerRota controllerRota = new ControllerRota();
                    controllerRota.registarRota(terminal1, terminal2, via, tempo,getContext());
                    Toast.makeText(getContext(), "Rota Cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                    txtVia.setText(null);
                    txtTerminal1.setText(null);
                    txtTerminal2.setText(null);
                    txtTempo.setText(null);
                }catch (Exception e){
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        return view;
    }
}
