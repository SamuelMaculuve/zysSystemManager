package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

import android.widget.Toast;

import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Funcionario;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;

public class ControllerFuncionario {

    public void registarFuncionario(String nome,String cargo, Date dataNascimento, String residencia, String telefone, Veiculo veiculo,String categoria) {

         FuncionarioModelo funcionarioModelo=new FuncionarioModelo(DataBase.getListaLigadaFuncionario().tamanho()+1,nome,cargo,dataNascimento,residencia,telefone,veiculo,categoria);
         DataBase.setListaLigadaFuncionario(funcionarioModelo);
        // DataBase.gravarFuncionarios(DataBase.getListaLigadaFuncionario());
    }

    public void apagarFuncionario(int id){
        DataBase.getListaLigadaFuncionario().removePosicao(id);
    }
    public  void visualizarFuncionarios(){
        FuncionarioModelo funcionario;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionario = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            System.out.println(funcionario);
        }

    }

    public FuncionarioModelo popularFuncionario(int id){
        FuncionarioModelo funcionario;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionario = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }


}
