package ac.mz.samuel.maculuve.myapplicationta;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.getbase.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Veiculo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Veiculo extends Fragment {
    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;
    ListView list;
    ImageView imgPesquisar;
    private FloatingActionButton cadVeiculo,editVeiculo;

    String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };

    Integer[] imgid={
            R.drawable.ic_account_circle_black_24dp,R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_veiculo, container, false);
        cadVeiculo = view.findViewById(R.id.cadVeiculo);
        editVeiculo = view.findViewById(R.id.editVeiculo);
        imgPesquisar = view.findViewById(R.id.imgPesquisar);

        imgPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        editVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EditVeiculo()).commit();
            }
        });
        cadVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CadVeiculo()).commit();
            }
        });

        MyListAdapter adapter=new MyListAdapter(getActivity(), maintitle, subtitle,imgid);
        list = view.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {

                    //code specific to first list item
                    Toast.makeText(getContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}
