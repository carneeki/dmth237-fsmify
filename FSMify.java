package fsmify;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Queue;

public class FSMify
{

  public static void main(String[] args) throws IOException
  {
    StateMachine sm = new StateMachine();

    FileReader fr = new FileReader(args[0]);
    BufferedReader br = new BufferedReader(fr);
    String buf;

    ArrayList<String> lines = new ArrayList<String>();

    // create empty state table
    while ((buf = br.readLine()) != null)
    {
      lines.add(buf);
      sm.addState();
    }
    br.close();

    for(int i=1; i <= lines.size(); i++)
    {
      buf = lines.get(i-1);
      sm.States.get(i-1).fromString(sm, (i + " " + buf));
    }
    
    System.out.println("dumping state table:");
    sm.dump();
    
    System.out.printf("Processing input:\n%s\n", args[1]);
    System.out.println(sm.States.get(0).step(args[1]));
  }
}
