package ac.mz.samuel.maculuve.myapplicationta.Models;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static android.content.Context.MODE_PRIVATE;

public class Gravar{

    public static void gravarFuncionario (Serializable s, Context context) throws Exception{
        ObjectOutputStream oos=null;
        try{
            FileOutputStream fos=context.openFileOutput("funcionarios.dat",MODE_PRIVATE);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(s);
        }catch (Exception e) {
        }finally
        {
            if (oos!=null){
                oos.close();
            }
        }
    }

    public static void gravarRota (Serializable s, Context context) throws Exception{
        ObjectOutputStream oos=null;
        try{
            FileOutputStream fos=context.openFileOutput("rotas.dat",MODE_PRIVATE);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(s);
        }catch (Exception e) {
        }finally
        {
            if (oos!=null){
                oos.close();
            }
        }
    }

    public static void gravarVeiculo (Serializable s, Context context) throws Exception{
        ObjectOutputStream oos=null;
        try{
            FileOutputStream fos=context.openFileOutput("veiculos.dat",MODE_PRIVATE);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(s);
            System.out.println("Gravou veiculo");
        }catch (Exception e) {
            System.out.println("Erro "+e.getMessage());
        }finally
        {
            if (oos!=null){
                oos.close();
            }
        }
    }


}
