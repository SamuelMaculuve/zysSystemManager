package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

import android.widget.Toast;

import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;

public class ControllerFuncionario {

    public void registarFuncionario(String nome, Date dataNascimento, String residencia, String telefone, Veiculo veiculo) {

       // DataBase.lerFuncionarios();
       // FuncionarioModelo funcionario;
      //  int lastCodigo=0;
        ////Pegar ultimo codigo
//        produtos=(Produto)DataBase.getVectorProdutos().get(DataBase.getVectorProdutos().size()-1);
//        lastCodigo=produtos.getId();
//
         FuncionarioModelo funcionarioModelo=new FuncionarioModelo(1,nome,dataNascimento,residencia,telefone,veiculo);
         DataBase.setListaLigadaFuncionario(funcionarioModelo);
         DataBase.gravarFuncionarios(DataBase.getListaLigadaFuncionario());
    }

    public  void visualizarFuncionario(){
      //  DataBase.lerFuncionarios();
        for (int i = 0; i < DataBase.getListaLigadaFuncionario().tamanho(); i++) {
            System.out.println(DataBase.getListaLigadaFuncionario().pega(i));
        }

    }


}
