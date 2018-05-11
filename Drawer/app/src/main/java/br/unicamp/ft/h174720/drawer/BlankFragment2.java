package br.unicamp.ft.h174720.drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    View view;
    EditText edtEmail;
    EditText edtBody;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

         edtEmail = (EditText)view.findViewById(R.id.setEmail);
         edtBody = (EditText)view.findViewById(R.id.setbody);

         view.findViewById(R.id.btn_enviar).setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(), edtEmail.getText().toString()+ ":" + edtBody.getText().toString(), Toast.LENGTH_SHORT).show();
             }
         });

        return(view);// Inflate the layout for this fragment
    }


};



