package ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota;

import java.io.Serializable;

public class RotaModelo implements Serializable {

    private int id;
    private  String terminal1;
    private  String terminal2;
    private  String via;
    private  double tempo;

    public RotaModelo(int id, String terminal1, String terminal2, String via, double tempo) {
        this.id = id;
        this.terminal1 = terminal1;
        this.terminal2 = terminal2;
        this.via = via;
        this.tempo = tempo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerminal1() {
        return terminal1;
    }

    public void setTerminal1(String terminal1) {
        this.terminal1 = terminal1;
    }

    public String getTerminal2() {
        return terminal2;
    }

    public void setTerminal2(String terminal2) {
        this.terminal2 = terminal2;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
}
