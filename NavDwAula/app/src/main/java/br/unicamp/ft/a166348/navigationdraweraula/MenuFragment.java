package br.unicamp.ft.a166348.navigationdraweraula;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.ft.a166348.navigationdraweraula.adapter.ProductItemMenuAdapter;
import br.unicamp.ft.a166348.navigationdraweraula.pojo.ProductType;
import br.unicamp.ft.a166348.navigationdraweraula.sell.RestaurantMenu;
import br.unicamp.ft.a166348.navigationdraweraula.sell.SellableProduct;
import br.unicamp.ft.a166348.navigationdraweraula.utils.SimpleAlert;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements ProductItemMenuAdapter.OnItemClickListener {
    private View view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RestaurantMenu menu = null;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_menu, container, false);

        /*
        edtEmail = (EditText)view.findViewById(R.id.setEmail);
        edtBody = (EditText)view.findViewById(R.id.setbody);

        view.findViewById(R.id.btn_enviar).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), edtEmail.getText().toString()+ ":" + edtBody.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return(view);// Inflate the layout for this fragment
        */

        Fresco.initialize(getContext());
        mRecyclerView = (RecyclerView) view.findViewById( R.id.aRecyclerView);


        mRecyclerView.setHasFixedSize( true );//Mudanças nos elementos da tabela não irão aumentar o tamanho dela

        mLayoutManager = new LinearLayoutManager( getContext() );//recebe um context, a activity é um context
        mRecyclerView.setLayoutManager( mLayoutManager );//recycler view precisa de um layout manager


        menu = new RestaurantMenu( getMockProducts() );


        mAdapter = new ProductItemMenuAdapter(menu,this);
        mRecyclerView.setAdapter( mAdapter );

        view.findViewById(R.id.closeOrder).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onCloseOrderClicked(view);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(SellableProduct prod) {
        Toast.makeText( getContext(), prod.getName(), Toast.LENGTH_LONG ).show();

    }

    public void onCloseOrderClicked(View view){
        new SimpleAlert().alertOk( "Botão continuar foi clicado",
                "O botão continuar foi clicado.\nE essa mensagem foi disparada usando um listner dentro de um fragmento",
                getContext() );

    }

    public static List<SellableProduct> getMockProducts(){
        List<SellableProduct> mockProducts = new ArrayList<>();
        mockProducts.add(
                new SellableProduct(
                        "Pastel de Carne",
                        "Descrição do produto aqui uma descrição do produto",
                        "http://www.fotografiadecomida.com.br/wp-content/uploads/2013/12/MG_7283_alta_blog-660x270.jpg",
                        ProductType.SALGADO , 20.50, 0, 0)
        );
        mockProducts.add(
                new SellableProduct(
                        "Prato feito",
                        "Descrição do produto aqui uma descrição do produto",
                        "http://www.fotografiadecomida.com.br/wp-content/uploads/2013/12/MG_6274_m_alta_blog-660x270.jpg",
                        ProductType.SALGADO , 20.50, 0, 0)
        );

        mockProducts.add(
                new SellableProduct(
                        "Hamburguer",
                        "Descrição do produto aqui uma descrição do produto",
                        "http://i.dailymail.co.uk/i/pix/2015/12/14/15/03C5A3E8000005DC-3359403-image-a-63_1450106294393.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );

        mockProducts.add(
                new SellableProduct(
                        "Sopa da Casa",
                        "Descrição do produto aqui uma descrição do produto",
                        "https://guiadacozinha.com.br/wp-content/uploads/2017/02/sopa-cremosa-legumes-1.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );

        mockProducts.add(
                new SellableProduct(
                        "Produto 5",
                        "Descrição do produto aqui uma descrição do produto",
                        "https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );
        mockProducts.add(
                new SellableProduct(
                        "Produto 6",
                        "Descrição do produto aqui uma descrição do produto",
                        "https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );

        mockProducts.add(
                new SellableProduct(
                        "Produto 7",
                        "Descrição do produto aqui uma descrição do produto",
                        "https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );

        mockProducts.add(
                new SellableProduct(
                        "Produto 8",
                        "Descrição do produto aqui uma descrição do produto",
                        "https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );

        mockProducts.add(
                new SellableProduct(
                        "Produto 9",
                        "Descrição do produto aqui uma descrição do produto",
                        "https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg",
                        ProductType.DOCE , 20.50, 0, 0)
        );

        return mockProducts;
    }
}



