package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditFuncionario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditFuncionario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView txtData,txtCategoria,txtResidencia,txtTelefone,txtNome;
    private Spinner spCategoria,spVeiculo;

    static FuncionarioModelo funcionario = null;
    public EditFuncionario(FuncionarioModelo funcionarioModelo) {
        funcionario=funcionarioModelo;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditFuncionario.
     */
    // TODO: Rename and change types and number of parameters
    public static EditFuncionario newInstance(String param1, String param2) {

        EditFuncionario fragment = new EditFuncionario(funcionario);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit_funcionario, container, false);

        txtNome=view.findViewById(R.id.txtNome);
        txtResidencia=view.findViewById(R.id.txtResidencia);
        txtTelefone=view.findViewById(R.id.txtTelefone);
        txtData=view.findViewById(R.id.txtData);
        spCategoria = view.findViewById(R.id.spCategoria);
        spVeiculo = view.findViewById(R.id.spVeiculo);

        txtNome.setText(funcionario.getNome());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        txtData.setText(formato.format(funcionario.getDataNascimento()));
        txtResidencia.setText(funcionario.getResidencia());
        txtTelefone.setText(funcionario.getTelefone());


        return view;

    }
}
