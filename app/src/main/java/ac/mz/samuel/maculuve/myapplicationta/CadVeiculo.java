package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadVeiculo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadVeiculo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Button btnSaveVeiculo;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadVeiculo() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CadVeiculo newInstance(String param1, String param2) {
        CadVeiculo fragment = new CadVeiculo();
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
        /*
        * iew view = inflater.inflate(R.layout.fragment_rssitem_detail,
    container, false);
   Button button = (Button) view.findViewById(R.id.btn_conferma);
   button.setOnClickListener(new OnClickListener()
   {
             @Override
             public void onClick(View v)
             {
                // do something
             }
   });
   return view;*/
        View view =  inflater.inflate(R.layout.fragment_cad_veiculo, container, false);

        btnSaveVeiculo = (Button) view.findViewById(R.id.saveVeiculo);
        btnSaveVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is my Toast message!", Toast.LENGTH_LONG).show();
                new SweetAlertDialog(getContext())
                        .setTitleText("Here's a message!")
                        .show();
            }
        });

        return view;
    }
}
