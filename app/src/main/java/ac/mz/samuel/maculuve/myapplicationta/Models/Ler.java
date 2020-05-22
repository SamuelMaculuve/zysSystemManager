package ac.mz.samuel.maculuve.myapplicationta.Models;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ler {

    public static Object lerFuncionarios(Context  context) throws IOException {

        ObjectInputStream ois = null;
        try {
            FileInputStream fis =context.openFileInput("funcionarios.dat");
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return null;
    }

    public static Object lerRota(Context  context) throws IOException {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis =context.openFileInput("rotas.dat");
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return null;
    }

    public static Object lerVeiculo(Context  context) throws IOException {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis =context.openFileInput("veiculos.dat");
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return null;
    }
}
