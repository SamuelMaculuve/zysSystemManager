package ac.mz.samuel.maculuve.myapplicationta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Funcionario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Funcionario extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_funcionario, container, false);

        ListView listView = (ListView) view.findViewById(R.id.mainMenu) ;

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);

        return view;

    }
}
