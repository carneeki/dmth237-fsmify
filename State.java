package fsmify;

public class State
{
  int num;
  int o0;
  int o1;
  State s0;
  State s1;
  
  /**
   * create a new empty state
   */
  State()
  {
    //
  }
  
  /**
   * create a new state
   * @param o0 output if given 0
   * @param o1 output if given 1
   * @param s0 new state if given 0
   * @param s1 new state if given 1
   */
  State(int num, int o0, int o1, State s0, State s1)
  {
    this.num = num;
    this.o0 = o0;
    this.o1 = o1;
    this.s0 = s0;
    this.s1 = s1;
  }
  
  /**
   * update / set a state
   * @param o0 output if given 0
   * @param o1 output if given 1
   * @param s0 new state if given 0
   * @param s1 new state if given 1
   */
  public void set(int num, int o0, int o1, State s0, State s1)
  {
    this.num = num;
    this.o0 = o0;
    this.o1 = o1;
    this.s0 = s0;
    this.s1 = s1;
  }
  
  public void fromString(StateMachine sm, String s)
  {
    String[] buf = s.split(" ");
    this.num = Integer.parseInt(buf[0]); 
    this.o0 = Integer.parseInt(buf[1]);
    this.o1 = Integer.parseInt(buf[2]);
    this.s0 = sm.States.get( Integer.parseInt(buf[3])-1 );
    this.s1 = sm.States.get( Integer.parseInt(buf[4])-1 );
  }
  
  public String step(String s)
  {
    if(s.length() == 0)
      return "";
    
    String next = s.substring(1);
    
    if(s.charAt(0) == '0')
      return String.valueOf(o0) + this.s0.step(next);
    else
      return String.valueOf(o1) + this.s1.step(next);
  }
}
