package ac.mz.samuel.maculuve.myapplicationta.Models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static android.content.Context.MODE_PRIVATE;

public class Gravar{

    public static void gravarFuncionario (Serializable s) throws Exception{
        ObjectOutputStream oos=null;
        try{
            File f=new File("funcionarios.dat");
            FileOutputStream fos=new FileOutputStream(f);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(s);
            System.out.println("Gravado");
        }finally{
            if (oos!=null){
                oos.close();
            }
        }
    }

}
