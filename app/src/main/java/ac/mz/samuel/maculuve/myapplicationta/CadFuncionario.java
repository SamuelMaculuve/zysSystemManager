package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ListaLigadaFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadFuncionario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadFuncionario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btnCadastrar;
    private TextView txtData,txtCategoria,txtResidencia,txtTelefone,txtNome;
    private void _instanciar(){
      //  p Button btnCadastrar = findViewById(R.id.btnCadastrar);
    }


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadFuncionario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadFuncionario.
     */
    // TODO: Rename and change types and number of parameters
    public static CadFuncionario newInstance(String param1, String param2) {
        CadFuncionario fragment = new CadFuncionario();
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

    FuncionarioModelo funcionario=new FuncionarioModelo();
    public FuncionarioModelo getFunc(){
        return funcionario;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cad_funcionario, container, false);
        View view=inflater.inflate(R.layout.fragment_cad_funcionario, container, false);
        btnCadastrar=view.findViewById(R.id.saveFun);
        txtData=view.findViewById(R.id.txtData);
        txtCategoria=view.findViewById(R.id.txtCategoria);
        txtNome=view.findViewById(R.id.txtNome);
        txtResidencia=view.findViewById(R.id.txtResidencia);
        txtTelefone=view.findViewById(R.id.txtTelefone);
        txtData=view.findViewById(R.id.txtData);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String nome=  txtNome.getText().toString();
                    String residencia= txtResidencia.getText().toString();
                    String telefone=  txtTelefone.getText().toString();
                    ControllerFuncionario funcionario=new ControllerFuncionario();
                    funcionario.registarFuncionario(nome,new Date(),residencia,telefone,new Veiculo());
                    Toast.makeText(getContext(),"Funcionario Cadastrado com sucesso",Toast.LENGTH_LONG).show();
                    txtNome.setText(null);
                    txtResidencia.setText(null);
                    txtTelefone.setText(null);
                    txtCategoria.setText(null);
                    txtData.setText(null);
                }catch (Exception ex) {
                    System.out.println("Erro" +ex.getMessage());
                }
            }
        });

        return  view;
    }
}
