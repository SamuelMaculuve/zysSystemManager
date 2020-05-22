package ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota;


import java.io.Serializable;

public class NoRota implements Serializable {
    private Object elemento;
    private NoRota proximo;

    public NoRota(NoRota proximo, Object elemento) {
        super();
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public NoRota(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }
    public NoRota getProximo() {
        return proximo;
    }
    public void setProximo(NoRota proximo) {
        this.proximo = proximo;
    }
}
