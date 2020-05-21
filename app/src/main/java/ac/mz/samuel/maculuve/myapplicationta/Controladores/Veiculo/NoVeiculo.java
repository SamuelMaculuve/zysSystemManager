package ac.mz.samuel.maculuve.myapplicationta.Controladores.Veiculo;

public class NoVeiculo {

    private Object elemento;
    private NoVeiculo proximo;

    public NoVeiculo(NoVeiculo proximo, Object elemento) {
        super();
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public NoVeiculo(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }
    public NoVeiculo getProximo() {
        return proximo;
    }
    public void setProximo(NoVeiculo proximo) {
        this.proximo = proximo;
    }

}
