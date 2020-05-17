package ac.mz.samuel.maculuve.myapplicationta;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.getbase.floatingactionbutton.FloatingActionButton;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class Funcionario extends Fragment implements AdapterView.OnItemSelectedListener {
    private ListView list;
    private ImageView imgPesquisar;
    private AutoCompleteTextView actv;
    private FloatingActionButton cadFuncionario,editFuncionario;
    private Spinner spCargo;

    Integer[] imgid={
            R.drawable.ic_account_circle_black_24dp,R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
    };
    String[] cargo ={"","Cobrador","Motorista"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    MyListAdapter adapterList=null;
    ArrayAdapter<String> adapter=null;

    public void   pegaNomes() {
        String nome[] = new String[DataBase.getListaLigadaFuncionario().tamanho()];
        FuncionarioModelo funcionario;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionario = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            nome[i] = funcionario.getNome();
        }
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.select_dialog_item,nome);
    }
    public  void carregarDados(){
        adapterList=null;
        String nomes[]=new String[DataBase.getListaLigadaFuncionario().tamanho()];
        String residencia[]=new String[DataBase.getListaLigadaFuncionario().tamanho()];
        FuncionarioModelo funcionarioModelo;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionarioModelo = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            nomes[i] = funcionarioModelo.getNome();
            residencia[i] = funcionarioModelo.getResidencia();
        }
        adapterList=new MyListAdapter(getActivity(), nomes, residencia,imgid);
    }
    public  void pegaFuncionario(String item){
        adapterList=null;
        String nome[]=new String[1];
        String residencia[]=new String[1];
        FuncionarioModelo funcionarioModelo;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionarioModelo = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            if(funcionarioModelo.getNome().equals(item)) {
                nome[0] = funcionarioModelo.getNome();
                residencia[0] = funcionarioModelo.getResidencia();
            }
        }
        adapterList=new MyListAdapter(getActivity(), nome, residencia,imgid);
    }
    public  void pegarCategoria(String categoria){
        adapterList=null;
        String nomes[]=new String[DataBase.getListaLigadaFuncionario().tamanho()];
        String residencia[]=new String[DataBase.getListaLigadaFuncionario().tamanho()];
        FuncionarioModelo funcionarioModelo;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionarioModelo = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            if (funcionarioModelo.getCategoria().equals(categoria)) {
                nomes[i] = funcionarioModelo.getNome();
                residencia[i] = funcionarioModelo.getResidencia();
            }
        }
        adapterList=new MyListAdapter(getActivity(), nomes, residencia,imgid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_funcionario, container, false);
        cadFuncionario = view.findViewById(R.id.cadFuncionario);
        imgPesquisar = view.findViewById(R.id.imgPesquisar);
        spCargo = view.findViewById(R.id.spCargo);
        editFuncionario = view.findViewById(R.id.editFuncionario);

        carregarDados();
        ControllerFuncionario controllerFuncionario=new ControllerFuncionario();
        controllerFuncionario.visualizarFuncionarios();
        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(adapterList);
        pegaNomes();
        actv =  (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);
        //autocomplete action
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                pegaFuncionario(item);
                list.setAdapter(null);
                list.setAdapter(adapterList);
            }
        });
       // actv.setOnItemSelectedListener(new View.OnFocusChangeListener());
        //open Register Funcionario
        cadFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CadFuncionario()).commit();
            }
        });
        //open edit
        editFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EditFuncionario()).commit();
            }
        });
        //Delete a Funcionario
        AdapterView.OnItemClickListener itemClickListener  = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                // Getting the Country TextView
                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Tem Certeza?")
                        .setContentText("Não será possível recuperar este arquivo\n!")
                        .setConfirmText("Sim Apagar!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                ControllerFuncionario controllerFuncionario=new ControllerFuncionario();
                                controllerFuncionario.apagarFuncionario(position+1);
                                showToast("Apagado com sucesso");
                                list.setAdapter(null);
                                carregarDados();
                                list.setAdapter(adapterList);
                                actv.setAdapter(null);
                                pegaNomes();
                                actv.setAdapter(adapter);

                            }
                        })
                        .setCancelButton("Cancelar", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                showToast("Cancelar");
                            }
                        })
                        .show();
            }
        };
        list.setOnItemClickListener(itemClickListener);
        //Spinner Cargo
        ArrayAdapter<String> adapterCargo = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,cargo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCargo.setAdapter(adapterCargo);
        spCargo.setOnItemSelectedListener(this);

        //Search for funcionrio
        imgPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(getContext());
                new SweetAlertDialog(getContext(), SweetAlertDialog.NORMAL_TYPE)
                        .setTitleText("Digite o que Deseja Pesquisar")
                        .setConfirmText("Ok")
                        .setCustomView(editText)
                        .show();
            }
        });

        return view;
    }
    public void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(),cargo[position] , Toast.LENGTH_LONG).show();
        pegarCategoria(cargo[position]);
        list.setAdapter(null);
        list.setAdapter(adapterList);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
