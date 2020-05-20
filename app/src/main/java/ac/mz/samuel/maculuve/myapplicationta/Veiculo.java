package ac.mz.samuel.maculuve.myapplicationta;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.getbase.floatingactionbutton.FloatingActionButton;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.ControllerRota;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.ControllerVeiculo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.VeiculoModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class Veiculo extends Fragment {
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    ListView list;
    private FloatingActionButton cadVeiculo,editVeiculo;

    String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };

    Integer[] imgid={
            R.drawable.ic_local_car_wash_black_24dp,R.drawable.ic_local_car_wash_black_24dp,
            R.drawable.ic_local_car_wash_black_24dp,R.drawable.ic_local_car_wash_black_24dp,
            R.drawable.ic_local_car_wash_black_24dp,
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private MyListAdapter adapterList = null;
    private ArrayAdapter<String> adapter = null;
    private AutoCompleteTextView actv;
    public void carregarDados() {
        adapterList = null;
        String nomes[] = new String[DataBase.getListaLigadaVeiculo().tamanho()];
        String matricula[] = new String[DataBase.getListaLigadaRota().tamanho()];
        VeiculoModelo veiculoModelo;
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            nomes[i] =veiculoModelo.getNome();
            matricula[i] = "Matricula: "+veiculoModelo.getMatricula()+" | Rota "+veiculoModelo.getRota()+" | Lt. "+veiculoModelo.getLotacao()+" lugares.";
            System.out.println(nomes[i]);
        }
        adapterList = new MyListAdapter(getActivity(), nomes, matricula, imgid);
    }

    public  void pegaVeiculo(String item){
        adapterList=null;
        String nome[]=new String[1];
        String matricula[]=new String[1];
        VeiculoModelo veiculoModelo;
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            if((veiculoModelo.getMatricula()).equals(item)) {
                nome[0] = veiculoModelo.getNome();
                matricula[0] = "Matricula: "+veiculoModelo.getMatricula()+" | Rota "+veiculoModelo.getRota()+" | Lt. "+veiculoModelo.getLotacao()+" lugares.";;
            }
        }
        adapterList=new MyListAdapter(getActivity(), nome, via,imgid);
    }


        public void pegaNomes() {
        String nome[] = new String[DataBase.getListaLigadaVeiculo().tamanho()];
        VeiculoModelo veiculoModelo;
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            nome[i] = veiculoModelo.getMatricula();
        }
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, nome);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_veiculo, container, false);
        cadVeiculo = view.findViewById(R.id.cadVeiculo);

        cadVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CadVeiculo()).commit();
            }
        });

        list = (ListView) view.findViewById(R.id.list);
        carregarDados();
        list.setAdapter(adapterList);
        pegaNomes();
        actv = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                pegaVeiculo(item);
                list.setAdapter(null);
                list.setAdapter(adapterList);
            }
        });

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                // Getting the Country TextView
                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Escolha a acção")
                        .setConfirmText("Apagar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                ControllerVeiculo controllerVeiculo = new ControllerVeiculo();
                                controllerVeiculo.apagarVeiculo(position + 1);
                                showToast("Apagado com sucesso");
                                list.setAdapter(null);
                                carregarDados();
                                list.setAdapter(adapterList);
                                actv.setAdapter(null);
                                pegaNomes();
                                actv.setAdapter(adapter);


                            }
                        })
                        .setCancelButton("Editar", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                ControllerVeiculo controllerVeiculo = new ControllerVeiculo();
                                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                        new EditVeiculo(controllerVeiculo.popularVeiculo(position + 1))).commit();

                            }
                        })
                        .show();
            }
        };
        list.setOnItemClickListener(itemClickListener);





        return view;
    }
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
