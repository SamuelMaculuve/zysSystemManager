package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

import android.content.Context;
import android.widget.Toast;

import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Funcionario;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;

public class ControllerFuncionario {

    public void registarFuncionario(String nome, String cargo, Date dataNascimento, String residencia, String telefone, String veiculo, String categoria, Context context) throws Exception {

         FuncionarioModelo funcionarioModelo=new FuncionarioModelo(DataBase.getListaLigadaFuncionario().tamanho()+1,nome,cargo,dataNascimento,residencia,telefone,veiculo,categoria);
         DataBase.setListaLigadaFuncionario(funcionarioModelo);
         DataBase.gravarFuncionarios(DataBase.getListaLigadaFuncionario(),context);
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

    public FuncionarioModelo popularFuncionario(int id,Context context){
        DataBase.lerFuncionarios(context);
        FuncionarioModelo funcionario;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionario = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public void actualizarFuncionario(int id, String nome,String cargo, Date dataNascimento, String residencia, String telefone, String veiculo,String categoria, Context context) throws Exception {
        FuncionarioModelo funcionarioModelo;
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            funcionarioModelo = (FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i);
            if (funcionarioModelo.getId() == id) {
                ((FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i)).setNome(nome);
                ((FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i)).setCargo(cargo);
                ((FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i)).setDataNascimento(dataNascimento);
                ((FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i)).setResidencia(residencia);
                ((FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i)).setTelefone(telefone);
                ((FuncionarioModelo) DataBase.getListaLigadaFuncionario().pega(i)).setVeiculo(veiculo);

            }
        }
        DataBase.gravarFuncionarios(DataBase.getListaLigadaFuncionario(),context);

    }


}
