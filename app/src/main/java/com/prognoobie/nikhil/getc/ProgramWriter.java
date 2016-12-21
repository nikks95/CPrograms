package com.prognoobie.nikhil.getc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.*;
import android.content.Context;

/**
 * Created by Nikhil on 12/13/2016.
 */

public class ProgramWriter {



  private Context context;

  static int progid=-1;

  ArrayList<String> al;


  String FileName;


  public ProgramWriter(Context context)
  {
    this.context=context;
  }
  public String[] program(int id)
  {
    String[] arg =new String[3];
    String line;
    String[] value;
    StringBuilder text1,text2;
   BufferedReader reader;

    boolean writerFlag = true;


      text1= new StringBuilder();
      text2 = new StringBuilder();


      try {
      al = new ArrayList<>();
      reader = new BufferedReader(new InputStreamReader(context.getAssets().open("abc.txt")));
      value = context.getAssets().list("Programs");
      /*while ((line = reader.readLine()) != null) {
        al.add(line);

      }
      reader.close();
*/
          for(int i=0;i<value.length;i++)
          {
              al.add(value[i]);
          }


     this.FileName = al.get(id);
     arg[0]=al.get(id);

     reader = new BufferedReader(new InputStreamReader(context.getAssets().open(FileName)));


      while ((line = reader.readLine()) != null) {
        if(line.length()>1 && (line.charAt(0)=='~'|| !writerFlag))
        {
            writerFlag=false;
            text2.append(line);
            text2.append('\n');
        }

        else{
            writerFlag = true;
            text1.append(line);
            text1.append('\n');}

            }
         reader.close();
    }

    catch(IOException ex)
    {
      arg[1]=""+ex;
    }


      arg[1]=text1.toString();
      arg[2]=text2.toString();
    return arg;

  }
 public static void setProgID(int id)
  {
    progid=id;
  }
  public static int getprogID()
  {
    return progid;
  }
}
