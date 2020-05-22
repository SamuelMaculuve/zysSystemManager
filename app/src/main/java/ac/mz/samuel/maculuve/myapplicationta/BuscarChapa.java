package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.VeiculoModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuscarChapa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuscarChapa extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BuscarChapa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuscarChapa.
     */
    // TODO: Rename and change types and number of parameters
    public static BuscarChapa newInstance(String param1, String param2) {
        BuscarChapa fragment = new BuscarChapa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    Integer[] imgid={
            R.drawable.ic_local_car_wash_black_24dp,R.drawable.ic_local_car_wash_black_24dp,
            R.drawable.ic_local_car_wash_black_24dp,R.drawable.ic_local_car_wash_black_24dp,
            R.drawable.ic_local_car_wash_black_24dp,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Spinner spRota,spVeiculo;
    private ListView list;
    MyListAdapter adapterList=null;
    ArrayAdapter<String> adapter=null;

    public  void carregaDados(){
        DataBase.lerVeiculos(getContext());
        adapterList=null;
        String veiculo[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        String outros[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        VeiculoModelo veiculoModelo;
        System.out.println(DataBase.getListaLigadaVeiculo().tamanho()+" T");
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            veiculo[i] = veiculoModelo.getNome();
            outros[i] = "Rota: "+veiculoModelo.getRota()+ " | Matricula: "+veiculoModelo.getMatricula()
                    +" Lugares: "+(veiculoModelo.getLotacao()-veiculoModelo.getNrPassageiros());
        }
        adapterList=new MyListAdapter(getActivity(), veiculo, outros,imgid);
    }

    public void carregarRota(String rota){
        DataBase.lerVeiculos(getContext());
        adapterList=null;
        String veiculo[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        String outros[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        VeiculoModelo veiculoModelo;
        System.out.println(DataBase.getListaLigadaVeiculo().tamanho()+" T");
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            if (veiculoModelo.getRota().equals(rota)) {
                veiculo[i] = veiculoModelo.getNome();
                outros[i] = "Rota: " + veiculoModelo.getRota() + " | Matricula: " + veiculoModelo.getMatricula()
                        + " Lugares: " + (veiculoModelo.getLotacao() - veiculoModelo.getNrPassageiros());
            }
        }
        System.out.println(veiculo.length+" Tmaanhp");
        adapterList=new MyListAdapter(getActivity(), veiculo, outros,imgid);

    }

    public void carregarNome(String nome){
        DataBase.lerVeiculos(getContext());
        adapterList=null;
        String veiculo[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        String outros[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        VeiculoModelo veiculoModelo;
        System.out.println(DataBase.getListaLigadaVeiculo().tamanho()+" T");
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            if (veiculoModelo.getNome().equals(nome)) {
                veiculo[i] = veiculoModelo.getNome();
                outros[i] = "Rota: " + veiculoModelo.getRota() + " | Matricula: " + veiculoModelo.getMatricula()
                        + " Lugares: " + (veiculoModelo.getLotacao() - veiculoModelo.getNrPassageiros());
            }
        }
        System.out.println(veiculo.length+" Tmaanhp");
        adapterList=new MyListAdapter(getActivity(), veiculo, outros,imgid);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_buscar_chapa, container, false);
        spRota = view.findViewById(R.id.spRota);
        spVeiculo = view.findViewById(R.id.spVeiculo);
        list = (ListView) view.findViewById(R.id.list);

        DataBase.lerRotas(getContext());
        String rotas[]=new String[DataBase.getListaLigadaRota().tamanho()];
        RotaModelo rotaModelo;
        for (int i=0;i<DataBase.getListaLigadaRota().tamanho();i++){
            rotaModelo=(RotaModelo) DataBase.getListaLigadaRota().pega(i);
            rotas[i]=rotaModelo.getTerminal1()+"/"+rotaModelo.getTerminal2();
        }

        DataBase.lerVeiculos(getContext());
        String veiculos[]=new String[DataBase.getListaLigadaVeiculo().tamanho()];
        VeiculoModelo veiculoModelo;
        for (int i=0;i<DataBase.getListaLigadaVeiculo().tamanho();i++){
            veiculoModelo=(VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            veiculos[i]=veiculoModelo.getNome();
        }
        ArrayAdapter<String> adapterRota = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,rotas);
        adapterRota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRota.setAdapter(adapterRota);

        ArrayAdapter<String> adapterVeiculo = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,veiculos);
        adapterRota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spVeiculo.setAdapter(adapterVeiculo);

        carregaDados();
        list.setAdapter(adapterList);


        spRota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                list.setAdapter(null);
                carregarRota(spRota.getSelectedItem().toString());
                list.setAdapter(adapterList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spVeiculo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                list.setAdapter(null);
                carregarNome(spVeiculo.getSelectedItem().toString());
                list.setAdapter(adapterList);
                showToast(spVeiculo.getSelectedItem().toString()+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        return  view;
    }

    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
