package com.example.juddy_rp.myappmd;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.juddy_rp.myappmd.Person.Person;
import com.example.juddy_rp.myappmd.Person.PersonContent;

import java.util.List;

/*
* Se encarga de cargar la lista
*/
public class PersonaListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (PersonContent.getPersonList().isEmpty()) {
            String nms[]=getResources().getStringArray(R.array.medicos);;
            String msjs[]=getResources().getStringArray(R.array.medicosMSJ);
            int idsFoto[]={R.drawable.docs,R.drawable.docs2,R.drawable.docs2,R.drawable.docs,R.drawable.docs2};
            int idsPnts[]={R.drawable.star_5,R.drawable.star_5,R.drawable.star_5,R.drawable.star_5,R.drawable.star_5};

            for(int i=0;i<5;i++){
                //"nombre","Descripcion","foto","puntaje"
                PersonContent.addPerson(new Person(1,nms[i],msjs[i],idsFoto[i],idsPnts[i]));
            }
        }

        View recyclerView = findViewById(R.id.persona_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.persona_detail_container) != null) {
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(PersonContent.getPersonList()));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Person> mValues;

        public SimpleItemRecyclerViewAdapter(List<Person> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.persona_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mNombre.setText(mValues.get(position).getNombre());
            holder.mSlogan.setText(mValues.get(position).getSlogan());
            holder.mFoto.setImageResource(mValues.get(position).getImg());
            holder.mPuntos.setImageResource(mValues.get(position).getPntj());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(PersonaDetailFragment.ARG_ITEM_ID, holder.mItem.getNombre());
                        PersonaDetailFragment fragment = new PersonaDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.persona_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, PersonaDetailActivity.class);
                        intent.putExtra(PersonaDetailFragment.ARG_ITEM_ID, holder.mItem.getNombre());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mNombre;
            public final TextView mSlogan;
            public final ImageView mFoto;
            public final ImageView mPuntos;
            public Person mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mNombre = (TextView) view.findViewById(R.id.person_name);
                mSlogan = (TextView) view.findViewById(R.id.person_slogan);
                mFoto = (ImageView) view.findViewById(R.id.person_img);
                mPuntos = (ImageView) view.findViewById(R.id.person_pnt);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mNombre.getText() + "'";
            }
        }
    }
}
