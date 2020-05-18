package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

import java.io.Serializable;
import java.util.Date;

import ac.mz.samuel.maculuve.myapplicationta.Models.Veiculo;

public class FuncionarioModelo implements Serializable {

    private int id;
    private String nome;
    private Date dataNascimento;
    private String residencia;
    private String telefone;
    private Veiculo veiculo;
    private String categoria;

    public FuncionarioModelo() {
        super();
    }

    public FuncionarioModelo(int id, String nome, Date dataNascimento, String residencia, String telefone, Veiculo veiculo, String categoria) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.residencia = residencia;
        this.telefone = telefone;
        this.veiculo = veiculo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "FuncionarioModelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", residencia='" + residencia + '\'' +
                ", telefone='" + telefone + '\'' +
                ", veiculo=" + veiculo +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
