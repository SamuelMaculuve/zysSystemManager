package ac.mz.samuel.maculuve.myapplicationta;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ListaLigadaFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;


/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class Funcionario extends Fragment {
    ListView list;

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
            R.drawable.download_1,R.drawable.download_2,
            R.drawable.download_3,R.drawable.download_4,
            R.drawable.download_5,
    };
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};

    private ListView mListView;
    private ArrayAdapter aAdapter;
    private String[] users = { "Suresh Dasari", "Rohini Alavala", "Trishika Dasari", "Praveen Alavala", "Madav Sai", "Hamsika Y"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_funcionario, container, false);
        ControllerFuncionario funcionario = new ControllerFuncionario();
        String [] nome = {"Sanuel","Carlos"};
        //ListView listView = (ListView) view.findViewById(R.id.mainMenu) ;
        //simpleList = (ListView)findViewById(R.id.simpleListView);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, countryList);
        //simpleList.setAdapter(arrayAdapter);
        FuncionarioModelo funcionarioModelo;
        String nomes[]=new String[DataBase.getListaLigadaFuncionario().tamanho()];
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionarioModelo = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            nomes[i] = funcionarioModelo.getNome();
        }
        //funcionario.visualizarFuncionario();
       // aAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, nomes);
        //mListView.setAdapter(aAdapter);
        //listView.setAdapter(aAdapter);
        MyListAdapter adapterList =new MyListAdapter(getActivity(), maintitle, subtitle,imgid);
        list = (ListView) view.findViewById(R.id.list);
        //list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapterList);

        // autocomplete
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv =  (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);

        //
        FloatingActionButton cadFuncionario = view.findViewById(R.id.cadFuncionario);


        cadFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CadFuncionario()).commit();
            }
        });

        return view;
    }
    public void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }
}
