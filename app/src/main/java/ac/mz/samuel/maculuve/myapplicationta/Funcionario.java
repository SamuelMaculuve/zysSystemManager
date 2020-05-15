package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ControllerFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ListaLigadaFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;


/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class Funcionario extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_funcionario, container, false);
        ControllerFuncionario funcionario=new ControllerFuncionario();
        funcionario.visualizarFuncionario();

        return view;

    }
}
