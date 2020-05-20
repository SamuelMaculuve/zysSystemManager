package ac.mz.samuel.maculuve.myapplicationta.Models;


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






    public static void lerFuncionarios(){
        try{
            listaLigadaFuncionario =(ListaLigadaFuncionario) Ler.lerFuncionarios();
        }catch(Exception e){
            System.out.println("Problemas ao carregar o ficheiro! \n"+ e.getMessage());
        }
    }
    public static void gravarFuncionarios(ListaLigadaFuncionario funcionario){
        try{
            Gravar.gravarFuncionario(funcionario);
        }catch (Exception e) {
            System.out.println("Problemas ao ler o ficheiro! \n"+ e.getMessage());
        }
    }

}
