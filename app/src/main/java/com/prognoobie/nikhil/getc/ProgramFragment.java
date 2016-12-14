package com.prognoobie.nikhil.getc;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragment extends Fragment {


    public ProgramFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Context context = this.getContext();
        String[] arg=new String[3];
        ProgramWriter program = new ProgramWriter(this.getContext());
         View v = inflater.inflate(R.layout.fragment_program, container, false);
        TextView header = (TextView)v.findViewById(R.id.header_program);
        TextView programArea =(TextView)v.findViewById(R.id.main_program);
        TextView Output= (TextView)v.findViewById(R.id.output_program);
        Button button = (Button)v.findViewById(R.id.getProg);
        arg = program.program(ProgramWriter.getprogID());
        header.setText(arg[0]);
        programArea.setText(arg[1]);
        Output.setText(arg[2]);
        final String str = arg[1];
        final String filename = arg[0]+".c";
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        File mydir = new File("/sdcard/CPrograms/"); //Creating an internal dir;
                        if (!mydir.exists())
                        {
                            mydir.mkdirs();
                            Toast.makeText(context, "Directory created",
                                    Toast.LENGTH_SHORT).show();
                        }

                        try{
                            File gpxfile = new File(mydir, filename);
                            FileWriter writer = new FileWriter(gpxfile);
                            writer.append(str);
                            writer.flush();
                            writer.close();
                            Toast.makeText(context, "File saved successfully!",
                                    Toast.LENGTH_SHORT).show();

                        }catch (Exception e){

                        }
                    }
                }
        );

        return v;
    }

}
