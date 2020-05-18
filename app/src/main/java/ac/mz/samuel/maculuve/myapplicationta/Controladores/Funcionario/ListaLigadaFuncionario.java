package ac.mz.samuel.maculuve.myapplicationta.Controladores.Funcionario;

import java.io.Serializable;

import ac.mz.samuel.maculuve.myapplicationta.Models.InterfaceGeral;

public class ListaLigadaFuncionario implements InterfaceGeral,Serializable {

    private NoFuncionario primeiro;
    private NoFuncionario ultimo;
    private int totalElem;


    @Override
    public void adicionaInicio(Object elemento) {
        NoFuncionario novo = new NoFuncionario(this.primeiro, elemento);
        this.primeiro = novo;
        if(this.totalElem == 0){
            this.ultimo = this.primeiro;
        }
        this.totalElem++;
    }
    private NoFuncionario pegaNo(int posicao) {
        NoFuncionario atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    @Override
    public void adicionaPosicao(int posicao, Object elemento) {
        if(posicao == 0){ // No começo.
            this.adicionaInicio(elemento);
        } else if(posicao == this.totalElem){
            this.adicionaFim(elemento);
        } else {
            NoFuncionario anterior = this.pegaNo(posicao - 1);
            NoFuncionario novo = new NoFuncionario(anterior.getProximo(), elemento);
            anterior.setProximo(novo);
            this.totalElem++;
        }
    }

    @Override
    public void adicionaFim(Object elemento) {
        if (this.totalElem == 0) {
            this.adicionaInicio(elemento);
        } else {
            NoFuncionario novo = new NoFuncionario(elemento);
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
            this.totalElem++;
        }

    }

    @Override
    public Object pega(int posicao) {
        return this.pegaNo(posicao).getElemento();
    }

    @Override
    public void removeInicio() {
        this.primeiro = this.primeiro.getProximo();
        this.totalElem--;
        if (this.totalElem == 0) {
            this.ultimo = null;
        }
    }

    @Override
    public void removePosicao(int posicao) {
        if(posicao<1 || posicao>totalElem)
            throw new IllegalArgumentException("Posição não existe");

        if (posicao == 1) {
            this.removeInicio();
        } else if (posicao == this.totalElem) {
            this.removeFim();
        } else {
            NoFuncionario anterior = this.pegaNo(posicao-2);
            NoFuncionario atual = anterior.getProximo();
            NoFuncionario proximo = atual.getProximo();
            anterior.setProximo(proximo);
            // proximo.setAnterior(anterior);
            this.totalElem--;
        }

    }

    @Override
    public void removeFim() {
        if (this.totalElem == 1) {
            this.removeInicio();
        } else {
            NoFuncionario anterior = pegaNo(this.totalElem-1);
            anterior.setProximo(null);
            this.ultimo = anterior;
            this.totalElem--;
        }
    }

    @Override
    public boolean contem(Object elemento) {
        NoFuncionario atual = this.primeiro;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public int tamanho() {
        return this.totalElem;
    }
    public void actualizar(int posicao, Object elemento, ListaLigadaFuncionario lista) {

        if(posicao==lista.tamanho()-1) {
            lista.adicionaFim(elemento);
            lista.removePosicao(posicao);
        }else {
            lista.removePosicao(posicao);
            lista.adicionaPosicao(posicao, elemento);
        }

    }
}
