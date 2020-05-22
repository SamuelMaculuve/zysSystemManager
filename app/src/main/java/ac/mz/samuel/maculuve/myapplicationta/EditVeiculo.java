package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.ControllerVeiculo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.VeiculoModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditVeiculo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditVeiculo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    static VeiculoModelo veiculoModelo=null;
    public EditVeiculo(VeiculoModelo veiculo) {
        veiculoModelo=veiculo;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditVeiculo.
     */
    // TODO: Rename and change types and number of parameters
    public static EditVeiculo newInstance(String param1, String param2) {
        EditVeiculo fragment = new EditVeiculo(veiculoModelo);
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

    private TextView txtMatricula,txtLotacao,txtNrPassageiros,txtNome;
    private Button btnCadastrar;
    private Spinner spRota;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit_rota, container, false);
        txtMatricula=view.findViewById(R.id.txtMatricula);
        txtLotacao=view.findViewById(R.id.txtLotacao);
        btnCadastrar=view.findViewById(R.id.saveVeiculo);
        txtNrPassageiros=view.findViewById(R.id.txtNrPassageiros);
        txtNome=view.findViewById(R.id.txtNome);
        spRota = view.findViewById(R.id.spRota);

       // txtNome.setText(veiculoModelo.getNome());
        txtLotacao.setText(veiculoModelo.getLotacao());
        txtMatricula.setText(veiculoModelo.getMatricula());
        txtNrPassageiros.setText(veiculoModelo.getNrPassageiros());

        String rotas[]=new String[1+ DataBase.getListaLigadaRota().tamanho()];
        rotas[0]="-Escolha a rota-";
        RotaModelo rotaModelo;
        for (int i=0;i<DataBase.getListaLigadaRota().tamanho();i++){
            rotaModelo=(RotaModelo)DataBase.getListaLigadaRota().pega(i);
            rotas[i]=rotaModelo.getTerminal1()+"/"+rotaModelo.getTerminal2();
        }
        ArrayAdapter<String> adapterRota = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,rotas);
        adapterRota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRota.setAdapter(adapterRota);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nome = txtNome.getText().toString();
                    String matricula = txtMatricula.getText().toString();
                    String rota = spRota.getSelectedItem().toString();
                    int lotacao = Integer.parseInt(txtLotacao.getText().toString());
                    int nPassageiros = Integer.parseInt(txtNrPassageiros.getText().toString());
                    ControllerVeiculo controllerVeiculo = new ControllerVeiculo();
                    controllerVeiculo.actualizarVeiculo(veiculoModelo.getId(),nome, matricula, rota, lotacao, nPassageiros);
                    Toast.makeText(getContext(), "Veiculo actualizado com sucesso", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getContext(),"Erro "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

        });





        return view;


    }
}
