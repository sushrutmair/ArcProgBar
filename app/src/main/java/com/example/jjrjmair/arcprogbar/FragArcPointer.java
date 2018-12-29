package com.example.jjrjmair.arcprogbar;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Method;

import io.github.dvegasa.arcpointer.ArcPointer;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragArcPointer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragArcPointer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragArcPointer extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View myView;

    public FragArcPointer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragArcPointer.
     */
    // TODO: Rename and change types and number of parameters
    public static FragArcPointer newInstance(String param1, String param2) {
        FragArcPointer fragment = new FragArcPointer();
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
        View view = inflater.inflate(R.layout.fragment_frag_arc_pointer, container, false);
        myView = view;

        CreateLocalUIElementHandlers();

        return view;
    }

    private void CreateLocalUIElementHandlers()
    {
        final ArcPointer ap = myView.findViewById(R.id.arcpointer);

        Button btn = (Button)(myView.findViewById(R.id.button));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show arc pointer
                ap.setWorkAngle(160);
                ap.setNotches(10);
                ap.setAnimated(true);
                ap.setLineStrokeWidth(10f);
                ap.setNotchesStrokeWidth(5f);
                ap.setMarkerStrokeWidth(7f);
                ap.setColorBackground(Color.BLUE);

            }
        });

        //1 divided into 180 equal parts...
        final float eqIntv = 0.005555556f;

        //Method m[] = ap.getNotches().getClass().getMethods();

        Button btn3 = (Button) (myView.findViewById(R.id.button3));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float val = ap.getValue();

                if(val <=0f)
                    ap.setValue((eqIntv*15));
                if(val == (eqIntv*15))
                    ap.setValue((eqIntv*40));
                if(val == (eqIntv*40))
                    ap.setValue((eqIntv*55));
                if(val==(eqIntv*55))
                    ap.setValue((eqIntv*90));
                if(val==(eqIntv*90))
                    ap.setValue((eqIntv*15));
            }
        });
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
