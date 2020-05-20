package ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario.FuncionarioModelo;
import ac.mz.samuel.maculuve.myapplicationta.Models.DataBase;
import ac.mz.samuel.maculuve.myapplicationta.Rota;

public class ControllerRota {

    public void registarRota(String terminal1, String terminal2, String via, double tempo) {
        RotaModelo rotaModelo = new RotaModelo(DataBase.getListaLigadaRota().tamanho() + 1, terminal1, terminal2, via, tempo);
        DataBase.setListaLigadaRota(rotaModelo);
    }

    public void apagarRota(int id) {
        DataBase.getListaLigadaRota().removePosicao(id);
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

    public void actualizarRota(int id, String terminal1, String terminal2, String via, double tempo) {
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

    }

}
