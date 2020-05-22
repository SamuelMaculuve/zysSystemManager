package ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo;

import android.content.Context;

import java.net.PortUnreachableException;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Rota;
import ac.mz.samuel.maculuve.myapplicationta.Veiculo;

public class ControllerVeiculo {

    public void registarVeiculo(String nome, String matricula, String rota, int lotacao, int nrPassageiros, Context context) throws Exception {
        VeiculoModelo veiculoModelo = new VeiculoModelo(DataBase.getListaLigadaVeiculo().tamanho() + 1, nome, matricula, rota, lotacao,nrPassageiros);
        DataBase.setListaLigadaVeiculo(veiculoModelo);
        DataBase.gravarVeiculos(DataBase.getListaLigadaVeiculo(),context);
    }
    public void apagarVeiculo(int id,Context context) throws Exception {
        DataBase.getListaLigadaVeiculo().removePosicao(id);
        DataBase.gravarVeiculos(DataBase.getListaLigadaVeiculo(),context);
    }


    public VeiculoModelo popularVeiculo(int id) {
        VeiculoModelo veiculoModelo;
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            if (veiculoModelo.getId() == id) {
                return veiculoModelo;
            }
        }
        return null;
    }

    public void actualizarVeiculo(int id, String nome, String matricula, String rota, int lotacao, int nrPassageiros) {
        VeiculoModelo veiculoModelo;
        for (int i = 0; i < DataBase.getListaLigadaVeiculo().tamanho(); i++) {
            veiculoModelo = (VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i);
            if (veiculoModelo.getId() == id) {
                ((VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i)).setNome(nome);
                ((VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i)).setMatricula(matricula);
                ((VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i)).setRota(rota);
                ((VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i)).setLotacao(lotacao);
                ((VeiculoModelo) DataBase.getListaLigadaVeiculo().pega(i)).setNrPassageiros(nrPassageiros);

            }
        }

    }




}
