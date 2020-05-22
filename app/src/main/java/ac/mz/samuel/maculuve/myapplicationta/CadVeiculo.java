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

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.ControllerVeiculo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadVeiculo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadVeiculo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Button btnSaveVeiculo;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadVeiculo() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CadVeiculo newInstance(String param1, String param2) {
        CadVeiculo fragment = new CadVeiculo();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_cad_veiculo, container, false);
        txtMatricula=view.findViewById(R.id.txtMatricula);
        txtLotacao=view.findViewById(R.id.txtLotacao);
        btnCadastrar=view.findViewById(R.id.saveVeiculo);
        txtNrPassageiros=view.findViewById(R.id.txtNrPassageiros);
        txtNome=view.findViewById(R.id.txtNome);
        spRota = view.findViewById(R.id.spRota);


        DataBase.lerRotas(getContext());
        String rotas[]=new String[DataBase.getListaLigadaRota().tamanho()];
        RotaModelo rotaModelo;
        for (int i=0;i<DataBase.getListaLigadaRota().tamanho();i++){
                rotaModelo = (RotaModelo) DataBase.getListaLigadaRota().pega(i);
                rotas[i] = rotaModelo.getTerminal1() + "/" + rotaModelo.getTerminal2();
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
                    controllerVeiculo.registarVeiculo(nome, matricula, rota, lotacao, nPassageiros,getContext());
                    Toast.makeText(getContext(), "Veiculo adicionado com sucesso", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getContext(),"Erro "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });







        return view;
    }
}
