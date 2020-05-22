package ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo;

import java.io.Serializable;

import ac.mz.samuel.maculuve.myapplicationta.Rota;

public class VeiculoModelo implements Serializable {

    private  int id;
    private  String nome;
    private String matricula;
    private String rota;
    private  int lotacao;
    private  int nrPassageiros;

    public VeiculoModelo(int id, String nome, String matricula, String rota, int lotacao, int nrPassageiros) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.rota = rota;
        this.lotacao = lotacao;
        this.nrPassageiros = nrPassageiros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getNrPassageiros() {
        return nrPassageiros;
    }

    public void setNrPassageiros(int nrPassageiros) {
        this.nrPassageiros = nrPassageiros;
    }


}
