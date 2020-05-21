package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

import java.io.Serializable;

public class NoFuncionario implements Serializable {

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
