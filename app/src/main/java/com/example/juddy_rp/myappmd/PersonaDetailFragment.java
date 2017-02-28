package com.example.juddy_rp.myappmd;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juddy_rp.myappmd.Person.Person;
import com.example.juddy_rp.myappmd.Person.PersonContent;

/*
* Se encarga de mostrar en pantalla los datos detallados de la persona
*/

public class PersonaDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    private Person person;


    public PersonaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
             person = PersonContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            //int index=Integer.valueOf(getArguments().getString(ARG_ITEM_ID));
            //Obtener la persona que se encuenta en esa posición de la lista
            //person=(Person)PersonContent.getPersonList().get(index);
            /*Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.persona_detail, container, false);

        // Show the dummy content as text in a TextView.
        /*if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.persona_detail)).setText(mItem.details);
        }*/
        if(person!=null){
            //Rellenar los elementos de la pantalla DETALLE

            ((TextView) rootView.findViewById(R.id.persona_name)).setText(person.getNombre());
            ((ImageView) rootView.findViewById(R.id.persona_img)).setImageResource(person.getImg());
            ((ImageView) rootView.findViewById(R.id.persona_pnt)).setImageResource(person.getPntj());

        }
        return rootView;
    }
}
