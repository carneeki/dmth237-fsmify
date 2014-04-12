package fsmify;

import java.util.ArrayList;

public class StateMachine
{
  ArrayList<State> States;
  
  StateMachine()
  {
    States = new ArrayList();
  }
  
  /**
   * add a new empty state
   */
  public void addState()
  {
    States.add(new State());
  }
  
  /**
   * add a new complete states
   * @param o0 output if given 0
   * @param o1 output if given 1
   * @param s0 new state if given 0
   * @param s1 new state if given 1
   */
  public void addState(int num, int o0, int o1, State s0, State s1)
  {
    States.add(new State(num, o0, o1, s0, s1));
  }
  
  /**
   * update / set a state
   * @param o0 output if given 0
   * @param o1 output if given 1
   * @param s0 new state if given 0
   * @param s1 new state if given 1
   */
  public void setState(int num, int o0, int o1, State s0, State s1)
  {
    State tmp = States.get(num);
    tmp.set(num, o0, o1, s0, s1);
    States.set(num, tmp);
  }
  
  /**
   * dump the state table
   */
  public void dump()
  {
    int i=0;
    System.out.println(" |   w   |   v   |");
    System.out.println(" | 0   1 | 0   1 |");
    
    for(State tmp : States)
    {
      i++;
      System.out.printf("%d| %d   %d | %d   %d |\n",
          tmp.num,tmp.o0, tmp.o1, tmp.s0.num, tmp.s1.num);
    }
  }
}
