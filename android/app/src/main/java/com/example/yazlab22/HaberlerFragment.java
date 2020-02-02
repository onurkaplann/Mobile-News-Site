package com.example.yazlab22;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HaberlerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HaberlerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HaberlerFragment extends Fragment {

    String haberturu;
    LinearLayout haberler;

    public static List<haber> list = new ArrayList<haber>();
    public static String deger;
    Butonolustur buton = null;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HaberlerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HaberlerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HaberlerFragment newInstance(String param1, String param2) {
        HaberlerFragment fragment = new HaberlerFragment();
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
        View RootView = inflater.inflate(R.layout.fragment_haberler,container,false);

        haberturu = MainActivity.girisSpinnertut;
        haberler = (LinearLayout) RootView.findViewById(R.id.haberlerLinearLayout);

        list.clear();

        if(haberturu.equals("")){

            new arkaPlan().execute("http://10.0.2.2:9000/haber");
        }else{

            new arkaPlan().execute("http://10.0.2.2:9000/haber/"+haberturu+"");
        }

        return RootView;

    }


    class arkaPlan extends AsyncTask<String,String,String> {

        protected  String doInBackground (String... params){
            HttpURLConnection connection = null;
            BufferedReader br = null;
            try{
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                String satir;
                String dosya = "";
                while ((satir = br.readLine()) != null){
                    dosya += satir;
                }

                return dosya;
            }catch (Exception e){
                e.printStackTrace();
            }
            return "hata";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONArray ja = new JSONArray(s);

                for (int i = 0; i < ja.length(); i++) {

                    JSONObject jo = (JSONObject) ja.get(i);
                    haber haber = new haber();

                    haber.id = jo.getString("id");
                    haber.url = jo.getString("haberresim");
                    haber.haberbaslik = jo.getString("haberbaslik");
                    haber.habericerik = jo.getString("habericerik");
                    haber.haberturu = jo.getString("haberturu");
                    haber.yayintarihi = jo.getString("yayintarihi");
                    haber.goruntusayisi = jo.getString("goruntulenme");

                    list.add(haber);

                }

            }catch (Exception e){
                e.printStackTrace();
            }



            for(int i = 0 ; i < list.size() ; i++){
                buton = new Butonolustur(getContext(),list.get(i).haberbaslik);
                haberler.addView(buton);
                buton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deger = ""+((Button)v).getText();
                        for(int i = 0 ; i < list.size() ; i++){
                            if(list.get(i).getHaberbaslik().equals(deger)) {
                                new onPlan().execute("http://10.0.2.2:9000/goruntu/"+list.get(i).getId());
                            }
                        }
                        gosterme Gosterme = new gosterme();
                        setFragment(Gosterme);
                    }
                });
            }

        }

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

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
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
