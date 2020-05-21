package ac.mz.samuel.maculuve.myapplicationta.Models;


import android.content.Context;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ListaLigadaFuncionario;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.ListaLigadaRota;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.ListaLigadaVeiculo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo.VeiculoModelo;

public class DataBase {
    public static ListaLigadaFuncionario listaLigadaFuncionario = new ListaLigadaFuncionario();
    public static ListaLigadaRota listaLigadaRota=new ListaLigadaRota();
    public static ListaLigadaVeiculo listaLigadaVeiculo=new ListaLigadaVeiculo();

    public static ListaLigadaFuncionario getListaLigadaFuncionario() { return listaLigadaFuncionario; }
    public static void setListaLigadaFuncionario(FuncionarioModelo funcionarioModelo) {
        listaLigadaFuncionario.adicionaFim(funcionarioModelo);
    }


    public static ListaLigadaRota getListaLigadaRota() {
        return listaLigadaRota;
    }
    public static void setListaLigadaRota(RotaModelo rotaModelo) {
        listaLigadaRota.adicionaFim(rotaModelo);
    }

    public static ListaLigadaVeiculo getListaLigadaVeiculo() {
        return listaLigadaVeiculo;
    }
    public static void setListaLigadaVeiculo(VeiculoModelo veiculoModelo) {
        listaLigadaRota.adicionaFim(veiculoModelo);
    }


    public static void gravarFuncionarios(ListaLigadaFuncionario listaLigadaFuncionario, Context context) throws Exception {
        Gravar.gravarFuncionario(listaLigadaFuncionario,context);
    }

    public static void  lerFuncionarios(Context context){
        try{
            listaLigadaFuncionario=(ListaLigadaFuncionario) Ler.lerFuncionarios(context);
        }catch(Exception e){
            System.out.println("Problemas ao ler os funcionarios");
        }
    }

    public static void gravarRotas(ListaLigadaRota listaLigadaRota, Context context) throws Exception {
        Gravar.gravarRota(listaLigadaRota,context);
    }

    public static void  lerRotas(Context context){
        try{
            listaLigadaRota=(ListaLigadaRota) Ler.lerRota(context);
        }catch(Exception e){
            System.out.println("Problemas ao ler os funcionarios");
        }
    }

    public static void gravarVeiculos(ListaLigadaVeiculo listaLigadaVeiculo, Context context) throws Exception {
        Gravar.gravarVeiculo(listaLigadaVeiculo,context);
    }

    public static void  lerVeiculos(Context context){
        try{
            listaLigadaVeiculo=(ListaLigadaVeiculo) Ler.lerVeiculo(context);
        }catch(Exception e){
            System.out.println("Problemas ao ler os funcionarios");
        }
    }


}
