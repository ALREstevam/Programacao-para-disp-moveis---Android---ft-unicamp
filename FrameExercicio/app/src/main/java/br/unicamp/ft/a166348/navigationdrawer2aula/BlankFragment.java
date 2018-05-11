package br.unicamp.ft.a166348.navigationdrawer2aula;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/*
* FragmentManager: gerencia fragmentos (usamos no findFragmentById() )
*   se for android.app.Fragment -> está em duas classes (use a de suporte) e coloque todas iguais
*
*   mas fragmentos criados no código não tem id... uso tags
*
* FragentTransaction
* Fragment
*
* */

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    //Obrigatório pois o android vai instanciar
    public BlankFragment() {
        // Required empty public constructor
    }


    /*
    * COLOCAR FRAGMENTOS EM ACTIVITIES
    *
    * ESTATICAMENTE: inserir o fragmento no código XML
    * DINÂMICAMENTE: pelo código java - preciso usar uma tag para dizer onde quero colocar o fragment
    *
    *
    *
    * */


    //Obrigatório por precisamos ligar o código java com o xml
    /*
    * Inflater: infla o xml gerando um Objeto java
    *
    * */
    @Override
    //Vai ser chamado depois do OnCreate
    /*
    No fragmento

        OnAttatch > OnCreate*(Inicializamos atributos que não dependam da interfade) > OnCreateView*(criamos a interface gráfica aqui)
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_blank_fragment2, container, false );


    }

}



