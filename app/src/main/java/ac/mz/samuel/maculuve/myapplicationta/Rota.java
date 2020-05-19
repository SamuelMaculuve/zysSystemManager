package ac.mz.samuel.maculuve.myapplicationta;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.getbase.floatingactionbutton.FloatingActionButton;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.ControllerRota;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class Rota extends Fragment implements AdapterView.OnItemSelectedListener {

    ListView list;
    private FloatingActionButton cadRota, editRota;
    String[] maintitle = {
            "Title 1", "Title 2",
            "Title 3", "Title 4",
            "Title 5",
    };

    String[] subtitle = {
            "Sub Title 1", "Sub Title 2",
            "Sub Title 3", "Sub Title 4",
            "Sub Title 5",
    };

    Integer[] imgid = {
            R.drawable.ic_map_black_24dp, R.drawable.ic_map_black_24dp,
            R.drawable.ic_map_black_24dp, R.drawable.ic_map_black_24dp,
            R.drawable.ic_map_black_24dp,
    };
    String[] language = {"C", "C++", "Java", ".NET", "iPhone", "Android", "ASP.NET", "PHP"};
    @Nullable
    private MyListAdapter adapterList = null;
    private ArrayAdapter<String> adapter = null;
    private AutoCompleteTextView actv;

    public void pegaNomes() {
        String nome[] = new String[DataBase.getListaLigadaRota().tamanho()];
        RotaModelo rotaModelo;
        for (int i = 0; i < DataBase.getListaLigadaRota().tamanho(); i++) {
            rotaModelo = (RotaModelo) DataBase.getListaLigadaRota().pega(i);
            nome[i] = rotaModelo.getTerminal1() + "/" + rotaModelo.getTerminal2();
        }
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, nome);
    }
    public  void pegaRota(String item){
        adapterList=null;
        String nome[]=new String[1];
        String via[]=new String[1];
        RotaModelo rotaModelo;
        for (int i = 0; i < DataBase.getListaLigadaRota().tamanho(); i++) {
            rotaModelo = (RotaModelo) DataBase.getListaLigadaRota().pega(i);
            if((rotaModelo.getTerminal1()+"/"+rotaModelo.getTerminal2()).equals(item)) {
                nome[0] = rotaModelo.getTerminal1()+"/"+rotaModelo.getTerminal2();
                via[0] = rotaModelo.getVia();
            }
        }
        adapterList=new MyListAdapter(getActivity(), nome, via,imgid);
    }

    public void carregarDados() {
        adapterList = null;
        String nomes[] = new String[DataBase.getListaLigadaRota().tamanho()];
        String vias[] = new String[DataBase.getListaLigadaRota().tamanho()];
        RotaModelo rotaModelo;
        for (int i = 0; i < DataBase.getListaLigadaRota().tamanho(); i++) {
            rotaModelo = (RotaModelo) DataBase.getListaLigadaRota().pega(i);
            nomes[i] = rotaModelo.getTerminal1() + "/" + rotaModelo.getTerminal2();
            vias[i] = rotaModelo.getVia();
        }
        adapterList = new MyListAdapter(getActivity(), nomes, vias, imgid);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rota, container, false);
        cadRota = view.findViewById(R.id.cadRota);
        editRota = view.findViewById(R.id.editRota);


        cadRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CadRota()).commit();
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
                pegaRota(item);
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
                                ControllerRota controllerRota = new ControllerRota();
                                controllerRota.apagarRota(position + 1);
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
                                ControllerRota controllerRota = new ControllerRota();
                                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                        new EditRota(controllerRota.popularRota(position + 1))).commit();

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


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
