package br.unicamp.ft.h174720.drawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    View view;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;
    CheckBox checkBox10;


    public BlankFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);

        checkBox1 = (CheckBox) view.findViewById(R.id.checkbox_1);
        checkBox2 = (CheckBox) view.findViewById(R.id.checkbox_2);
        checkBox3 = (CheckBox) view.findViewById(R.id.checkbox_3);
        checkBox4 = (CheckBox) view.findViewById(R.id.checkbox_4);
        checkBox5 = (CheckBox) view.findViewById(R.id.checkbox_5);
        checkBox6 = (CheckBox) view.findViewById(R.id.checkbox_6);
        checkBox7 = (CheckBox) view.findViewById(R.id.checkbox_7);
        checkBox8 = (CheckBox) view.findViewById(R.id.checkbox_8);
        checkBox9 = (CheckBox) view.findViewById(R.id.checkbox_9);
        checkBox10 = (CheckBox) view.findViewById(R.id.checkbox_10);



        view.findViewById(R.id.checkbox_1).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });

        view.findViewById(R.id.checkbox_2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_3).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_4).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_5).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_6).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_7).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_8).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.checkbox_10).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCheckBoxClicked(view);
            }
        });
        view.findViewById(R.id.btn_escolha).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Checkado", Toast.LENGTH_SHORT).show();
            }
        });

        return(view);// Inflate the layout for this fragment

    };

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox_1:
                if (checked) {
                    Toast.makeText(getActivity(), "item cerveja adicionado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "item cerveja removido", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.checkbox_2:
                if (checked) {
                    Toast.makeText(getActivity(), "item pizza adicionado", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "item pizza removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_3:
                if (checked) {
                    Toast.makeText(getActivity(), "item Batata adicionado", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "item Batata removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_4:
                if (checked) {
                    Toast.makeText(getActivity(), "item queijo adicionado", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "item queijo removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_5:
                if (checked) {
                    Toast.makeText(getActivity(), "item Bacon adicionado", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "item Bacon removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_6:
                if (checked) {
                    Toast.makeText(getActivity(), "item chocolate adicionado", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "item chocolate removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_7:
                if (checked) {
                    Toast.makeText(getActivity(), "item nuggets adicionado", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "item nuggets removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_8:
                if (checked) {
                    Toast.makeText(getActivity(), "item maionese adicionado", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "item maionese removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_9:
                if (checked) {
                    Toast.makeText(getActivity(), "item mostarda adicionado", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "item mostarda removido", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.checkbox_10:
                if (checked) {
                    Toast.makeText(getActivity(), "item ketchup adicionado", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "item ketchup removido", Toast.LENGTH_SHORT).show();

                }
                break;

        }
    }
}





