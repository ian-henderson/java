# Dynamic Programming

1) Characterize the structure of an optimal solution.

2) Recursively define the value of an optimal solution.

3) Compute the value of an optimal solution, typically in a bottom-up
   fashion.

4) Construct an optimal solution from computed information.

## Elements of Dynamic Programming

### Optimal Substructure

You will find yourself following a common pattern in discovering
optimal substructure:

1) You show that a solution to the problem consists of making a
   choice, such as choosing an initial cut in a rod or choosing an
   index at which to split the matrix chain. Making this choice
   leaves one or more subproblems to be solved.

2) You suppose that for a given problem, you are given the choice
   that leads to an optimal solution. You do not concern yourself
   yet with how to determine this choice. You just assume that it
   has been given to you.

3) Given this choice, you determine which subproblems ensue and
   how to best characterize the resulting space of subproblems.

4) You show that the solutions to the subproblems used within an
   optimal solution to the problem must themselves be optimal by
   using a "cut-and-paste" technique. You do so by supposing that
   each of the subproblem solutions is not optimal and then
   deriving a contradiction. In particular, by "cutting out" the
   non-optimal solution to each subproblem and "pasting in" the
   optimal one, you show that you can get a better solution to the
   original problem, thus contradicting your supposition that you
   already had an optimal solution. If an optimal solution gives
   rise to more than one subproblem, they are typically so similar
   that you can modify the cut-and-paste argument for one to apply
   to the others with little effort.

### Overlapping Subproblems
