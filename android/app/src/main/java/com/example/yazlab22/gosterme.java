package com.example.yazlab22;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link gosterme.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link gosterme#newInstance} factory method to
 * create an instance of this fragment.
 */
public class gosterme extends Fragment {

    List<haber> list2 = HaberlerFragment.list;
    String gelendeger = HaberlerFragment.deger;

    TextView haberbaslik;
    TextView habericerik;
    TextView yayintarihi;
    TextView goruntusayisi;
    ImageView url;
    Button begen;
    Button begenme;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public gosterme() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment gosterme.
     */
    // TODO: Rename and change types and number of parameters
    public static gosterme newInstance(String param1, String param2) {
        gosterme fragment = new gosterme();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View RootView = inflater.inflate(R.layout.fragment_gosterme,container,false);

        url = (ImageView) RootView.findViewById(R.id.gostermeimageView);
        haberbaslik = (TextView) RootView.findViewById(R.id.textViewHaberBaslikYazi);
        habericerik = (TextView) RootView.findViewById(R.id.textViewHaberİcerikYazi);
        yayintarihi = (TextView) RootView.findViewById(R.id.textViewYayinTarihiYazi);
        goruntusayisi = (TextView) RootView.findViewById(R.id.textViewGoruntuSayisiYazi);

        begenme = (Button) RootView.findViewById(R.id.buttonBegenme);
        begen = (Button) RootView.findViewById(R.id.buttonBegen);

        begen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i < list2.size() ; i++){
                    if(list2.get(i).getHaberbaslik().equals(gelendeger)){

                        new onPlan().execute("http://10.0.2.2:9000/begendi/"+list2.get(i).getId());


                        begen.setVisibility(View.INVISIBLE);
                        begenme.setVisibility(View.INVISIBLE);

                    }
                }
            }
        });


        begenme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i < list2.size() ; i++){
                    if(list2.get(i).getHaberbaslik().equals(gelendeger)){

                        new onPlan().execute("http://10.0.2.2:9000/begenmedi/"+list2.get(i).getId());

                        begen.setVisibility(View.INVISIBLE);
                        begenme.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });



        for(int i = 0 ; i < list2.size() ; i++){
            if(list2.get(i).getHaberbaslik().equals(gelendeger)){
                Glide.with(this).load(""+list2.get(i).getUrl()+"").into(url);
                haberbaslik.setText(list2.get(i).getHaberbaslik());
                habericerik.setText(list2.get(i).habericerik);
                yayintarihi.setText(list2.get(i).yayintarihi);
                String goruntu = list2.get(i).goruntusayisi;
                int tut = Integer.valueOf(goruntu);
                tut = tut+1;
                goruntu = "" + tut;
                goruntusayisi.setText(goruntu);
            }
        }

        return RootView;

    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    class onPlan extends AsyncTask<String,String,String> {

        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "hata";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
