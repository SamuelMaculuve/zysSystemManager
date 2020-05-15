package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

public class NoFuncionario {

    private Object elemento;
    private NoFuncionario proximo;

    public NoFuncionario(NoFuncionario proximo, Object elemento) {
        super();
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public NoFuncionario(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }
    public NoFuncionario getProximo() {
        return proximo;
    }
    public void setProximo(NoFuncionario proximo) {
        this.proximo = proximo;
    }

}
