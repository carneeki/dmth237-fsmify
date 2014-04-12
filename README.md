dmth237-fsmify
==============

Finite State Machine for Passing DMTH237 quizzes at MQ.

Copy the FSM from the quiz into the file called 'machine', it will take a
format similar to:

```
0 0 1 3
1 0 2 3
1 0 3 4
1 1 4 1
```

Where the first two columns represent the output for a zero or one, and the
last two columns represent the next state for a zero or one.

Internally the program uses states which count from 0, however, input your
states starting from 1 to follow the same format that the quizzes and lecturers
use.
