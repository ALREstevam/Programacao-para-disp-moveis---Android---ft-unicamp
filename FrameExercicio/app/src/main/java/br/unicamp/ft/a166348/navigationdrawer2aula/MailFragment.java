package br.unicamp.ft.a166348.navigationdrawer2aula;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */

//FRAGMENTOS NÃO HERDAM DE ACTIVITY
    //Não posso passar fragment como context
public class MailFragment extends Fragment {

    private EditText edtTxtBody;
    private EditText edtTxtMail;

    private String savedBody;
    private String savedMail;

    private View lView;

    public MailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setRetainInstance( true );//Faz com que a view não seja tirada da memória quando girar a tel
        //Salva, mas não por muito tempo
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(lView == null){
            Toast.makeText( getActivity(), "VIEW DESTROYED", Toast.LENGTH_SHORT ).show();
            lView = inflater.inflate( R.layout.fragment_mail, container, false );//xml se transformou no lview
        }else{
            Toast.makeText( getActivity(), "VIEW NOT DESTROYED", Toast.LENGTH_SHORT ).show();

            if(savedBody != null && savedMail != null){
                Toast.makeText( getActivity(), "RECOVERED > " + savedMail + " : " + savedBody, Toast.LENGTH_SHORT ).show();
            }
            else{
                Toast.makeText( getActivity(), "NOTHING SAVED", Toast.LENGTH_SHORT ).show();
            }

        }

        this.edtTxtBody = (EditText) lView.findViewById( R.id.setBody );
        this.edtTxtMail = (EditText) lView.findViewById( R.id.setMessage);

        //Listner: não posso usar onClick pois vai ser procurada na main acticity

        //lView.findViewById( R.id.btn_enviar ).setOnClickListener(  );

        lView.findViewById(R.id.btn_enviar).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                savedBody = edtTxtMail.getText().toString();
                savedMail = edtTxtBody.getText().toString();
                Toast.makeText(getActivity(), savedMail+ ":" + savedBody, Toast.LENGTH_SHORT).show();

            }
        });


        return lView;
    }

    @Override
    public void onStart() {
        super.onStart();

        edtTxtBody.setText( savedBody );
        edtTxtMail.setText( savedMail );

    }
}
