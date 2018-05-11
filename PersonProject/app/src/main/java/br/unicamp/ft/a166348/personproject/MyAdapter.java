package br.unicamp.ft.a166348.personproject;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    /*
    * Variável para poder selecionar uma das linhas da listas.
     */
    private int selectedPos = RecyclerView.NO_POSITION;

    /*
        Essa interface serve apenas para que possamos nos comunicar com
        a activity que está em execução. Essa activity deverá ter o método
        onItemClick.
     */
    public interface OnItemClickListener {
        void onItemClick(Person person);
    }

    private final ArrayList<Person> people;
    private final OnItemClickListener listener;

    public MyAdapter(ArrayList<Person> people, OnItemClickListener listener) {
        this.people = people;
        this.listener = listener;
    }


    /*
       Este método cria um novo ViewHolder. Será chamada apenas algumas vezes,
       dependendo de quantas linhas cabem na RecyclerView.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Vai ser chamado uma vez para cada viewHolder
        //Sempre vai pegar um código XML e vai definir uma linha na RecyclerView
        /*
           Usamos o LayoutInflater para transformar um arquivo XML em uma classe
           java. No caso, estamos o arquivo adapter_layout.xml
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        return new ViewHolder(v);
    }



    // Layout Inflator: transforma um XML em um Objeto

    /*
       Este método é chamado sempre que uma mudança ocorre na RecyclerView e
       itens precisam ser substituídos.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//Toda vez que a interface precisar ser impressa (no scroll)
        //Java: preciso imprimir a posição tal, quero que use o viewholder que estou te dando, quero que ele seja a x posição no seu array
        /*
            Colocamos em verde os itens que foram selecionados. Posso deixar para o final
         */
        holder.itemView.setBackgroundColor(selectedPos == position ? Color.GREEN :  Color.TRANSPARENT);
        holder.itemView.setSelected(selectedPos == position);


        holder.bind(people.get(position), listener);
    }

    @Override public int getItemCount() {
        return people.size();
    }




    /*
        Esta classe fornece uma referência para as views dos itens
        que estão na RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder  {
        /*
           Como atributo, colocamos todas as views que estão no layout
           de cada linha da RecyclerView. No nosso caso, são os elementos
           que declaramos em adapter_layout.xml
         */
        private TextView  name;
        private ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            /*
                Populamos os atributos invocando o findViewById dessa linha
                da RecyclerView.
             */
            name      = (TextView) itemView.findViewById(R.id.aPersonText);
            imageView = (ImageView) itemView.findViewById(R.id.aImageView);
        }

        /*
            Invocado quando acoplamos um objeto do array ao Holder. Note
            que os Holders são reaproveitados, então espera-se que este método
            seja chamado várias vezes.
         */

        //variável final: finals ficam no topo da pilha do bytecode (como uma constante global)
        //Se a pessoa for final o código poderá exergar
        public void bind(final Person person, final OnItemClickListener listener) {//Quando o adapter precisar fazer o bind (chamado anteriormente)
            name.setText(person.getName());
            imageView.setImageResource(person.getImageId());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(person);
                    ViewHolder.this.onClick();//Redirecionando o gatilho para si mesmo
                }
            });
        }

        public void onClick(){
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

            notifyItemChanged(selectedPos);
            /*
               getLayoutPosition retorna a posição atual deste viewHolder
             */
            selectedPos = getLayoutPosition();
            notifyItemChanged(selectedPos);
        }
    }
}