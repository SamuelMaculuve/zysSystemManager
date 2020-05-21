package ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota;

import android.content.Context;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Models.Gravar;
import ac.mz.samuel.maculuve.myapplicationta.Rota;

public class ControllerRota {

    public void registarRota(String terminal1, String terminal2, String via, double tempo, Context context) throws Exception {
        RotaModelo rotaModelo = new RotaModelo(DataBase.getListaLigadaRota().tamanho() + 1, terminal1, terminal2, via, tempo);
        DataBase.setListaLigadaRota(rotaModelo);
        DataBase.gravarRotas(DataBase.getListaLigadaRota(), context);
    }

    public void apagarRota(int id,Context context) throws Exception {
        DataBase.getListaLigadaRota().removePosicao(id);
        Gravar.gravarRota(DataBase.getListaLigadaRota(),context);
    }

    public RotaModelo popularRota(int id) {
        RotaModelo rotaModelo;
        for (int i = 0; i < DataBase.getListaLigadaRota().tamanho(); i++) {
            rotaModelo = (RotaModelo) DataBase.getListaLigadaRota().pega(i);
            if (rotaModelo.getId() == id) {
                return rotaModelo;
            }
        }
        return null;
    }

    public void actualizarRota(int id, String terminal1, String terminal2, String via, double tempo,Context context) throws Exception {
        RotaModelo rotaModelo;
        for (int i = 0; i < DataBase.getListaLigadaRota().tamanho(); i++) {
            rotaModelo = (RotaModelo) DataBase.getListaLigadaRota().pega(i);
            if (rotaModelo.getId() == id) {
                ((RotaModelo) DataBase.getListaLigadaRota().pega(i)).setTerminal1(terminal1);
                ((RotaModelo) DataBase.getListaLigadaRota().pega(i)).setTerminal2(terminal2);
                ((RotaModelo) DataBase.getListaLigadaRota().pega(i)).setVia(via);
                ((RotaModelo) DataBase.getListaLigadaRota().pega(i)).setTempo(tempo);
            }
        }
        DataBase.gravarRotas(DataBase.getListaLigadaRota(),context);

    }

}
