package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.ControllerRota;
import ac.mz.samuel.maculuve.myapplicationta.Controladores.Rota.RotaModelo;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditRota#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditRota extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView txtTerminal1,txtTerminal2,txtVia,txtTempo;
    private Button btnCadastrar;
    static RotaModelo rotaModelo=null;
    public EditRota(RotaModelo rota) {
        rotaModelo=rota;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditRota.
     */
    // TODO: Rename and change types and number of parameters
    public static EditRota newInstance(String param1, String param2) {
        EditRota fragment = new EditRota(rotaModelo);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.e, container, false);
        View view=inflater.inflate(R.layout.fragment_edit_rota, container, false);
        txtTerminal1=view.findViewById(R.id.txtTerminal1);
        txtTerminal2=view.findViewById(R.id.txtTerminal2);
        txtVia=view.findViewById(R.id.txtVia);
        txtTempo=view.findViewById(R.id.txtTempo);
        btnCadastrar=view.findViewById(R.id.saveRota);

        txtTerminal1.setText(rotaModelo.getTerminal1());
        txtTerminal2.setText(rotaModelo.getTerminal2());
        txtVia.setText(rotaModelo.getVia());
        txtTempo.setText(rotaModelo.getTempo()+"");


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ControllerRota controllerRota=new ControllerRota();
                try {
                    controllerRota.actualizarRota(rotaModelo.getId(),txtTerminal1.getText().toString(),
                            txtTerminal2.getText().toString(),txtVia.getText().toString(),Double.parseDouble(txtTempo.getText().toString()),getContext());
                    Toast.makeText(getContext(),"Rota actualizada com sucesso",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(),"Erro ao actualizar Rota, "+e.getMessage(),Toast.LENGTH_SHORT).show();
                }


            }
        });




        return  view;
    }
}
