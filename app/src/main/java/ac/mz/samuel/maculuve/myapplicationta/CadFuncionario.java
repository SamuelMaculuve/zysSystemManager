package ac.mz.samuel.maculuve.myapplicationta;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.VeiculoModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;



public class CadFuncionario extends Fragment {
    private Button btnCadastrar;
    DatePickerDialog picker;
    private TextView txtData,txtCategoria,txtResidencia,txtTelefone,txtNome;
    private Spinner spCategoria,spVeiculo;
    String[] categoria ={"-Escolha a categoria-","Cobrador","Motorista"};
    String[] veiculo ={"","Cobrador","Mororista"};

    public CadFuncionario() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        spCategoria = view.findViewById(R.id.spRota);
        spVeiculo = view.findViewById(R.id.spVeiculo);
        txtNome=view.findViewById(R.id.txtNome);
        txtResidencia=view.findViewById(R.id.txtResidencia);
        txtTelefone=view.findViewById(R.id.txtTelefone);
        txtData=view.findViewById(R.id.txtData);

        //set category
        ArrayAdapter<String> adapterCargo = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,categoria);
        adapterCargo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategoria.setAdapter(adapterCargo);
       // veiculo

        DataBase.lerVeiculos(getContext());
        String veiculos[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        VeiculoModelo veiculoModelo;
        for (int i=0;i<DataBase.getListaLigadaVeiculo().tamanho();i++){
            veiculoModelo=(VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            veiculos[i]=veiculoModelo.getNome();
        }
        ArrayAdapter<String> adapterVeiculo = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,veiculos);
        adapterVeiculo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spVeiculo.setAdapter(adapterVeiculo);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String nome=  txtNome.getText().toString();
                    String residencia= txtResidencia.getText().toString();
                    String telefone=  txtTelefone.getText().toString();
                    String veiculo=spVeiculo.getSelectedItem().toString();
                    String categoria=spCategoria.getSelectedItem().toString();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataNascimento = formato.parse(txtData.getText().toString());
                    ControllerFuncionario funcionario=new ControllerFuncionario();
                    funcionario.registarFuncionario(nome,categoria,dataNascimento,residencia,telefone,veiculo,"",view.getContext());
                    Toast.makeText(getContext(),"Funcionario Cadastrado com sucesso",Toast.LENGTH_SHORT).show();
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

        //set datapiker
        txtData = view.findViewById(R.id.txtData);
        txtData.setInputType(InputType.TYPE_NULL);
        txtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txtData.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        return  view;
    }
}
