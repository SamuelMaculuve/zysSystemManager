package ac.mz.samuel.maculuve.myapplicationta.Models;


import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.ListaLigadaFuncionario;

public class DataBase {
    public static ListaLigadaFuncionario listaLigadaFuncionario = new ListaLigadaFuncionario();
    public static ListaLigadaFuncionario getListaLigadaFuncionario() {
        return listaLigadaFuncionario;
    }
    public static void setListaLigadaFuncionario(FuncionarioModelo funcionarioModelo) {
        listaLigadaFuncionario.adicionaFim(funcionarioModelo);
    }
    public static void updateFuncionarios(FuncionarioModelo funcionarioModelo, int i){
        listaLigadaFuncionario.actualizar(i,funcionarioModelo, getListaLigadaFuncionario());
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
