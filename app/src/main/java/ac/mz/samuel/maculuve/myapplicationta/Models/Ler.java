package ac.mz.samuel.maculuve.myapplicationta.Models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ler {
    public static Object lerFuncionarios() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = null;
        try {
            File f = new File("funcionarios.dat");
            FileInputStream fis = new FileInputStream(f);
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
