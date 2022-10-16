# algo2prepare 


This repository can be seen as an environment in preparation for coding/algorithm interviews 
in java. It doesn't contain any solution, but set of utility classes and methods that 
are here to speedup the algorithm implementation.

The building of this environment evolved during my coding interview preparation and 
work mostly on **leetcode**, but is it also applicable for **codility**, **hackerank** ... problems. Those platforms provide 
input and output, and sometimes (almost always) it is time-consuming to prepare or transform
provided test case to the input of the algorithm. Additionally, what I find quite helpful is the printing functionality
that I use often during debugging the solution (i.e. printing the matrix or tree).

## Array

There are multple methods that will generate and pritout java arrays. All of them are static methods in class `util.com.algo2prepare.environment.Array` and their usage is shown bellow. Additionally, the shown listing is part or `com.algo2prepare.ArraySample` class:

```java
import com.algo2prepare.util.Array;
import com.algo2prepare.util.NumberType;
import com.algo2prepare.util.Order;


int[] a1 =    Array.ints(1,2,3,4);            // [1, 2, 3, 4]
char[] a2 =   Array.chars(1,2,3,4);           // ['1', '2', '3', '4']
String[] a3 = Array.strings("A","B","C");     // ["A", "B", "C"]
double[] a4 = Array.doubles(1,2,3.0);         // [1.0, 2.0, 3.0]

int[] b1 = Array.randomInts(4);                        // [-1637497961, -905139890, -311524229, -479298768]
int[] b2 = Array.randomInts(5, 0, 10);                 // [4, 9, 0, 3, 10]
int[] b3 = Array.randomInts(3,0,10, Order.ASC);        // [4, 6, 10]
int[] b4 = Array.randomInts(3,0,10, NumberType.EVEN);  // [6, 2, 8]

int[] c1 =    Array.ints("[1,2,3,4]");                // [1, 2, 3, 4]
char[] c2 =   Array.chars("['s','a','n','n']");       // ['s', 'a', 'n', 'n']
String[] c3 = Array.strings("[\"qwe\",\"rty\"]");     // ["qwe", "rty"]
double[] c4 = Array.doubles("[3.2, 5.5]");            // [3.2 5.5]

Array.print(c1);
Array.print(c2);
Array.print(c3);
Array.print(c4);

```


## Matrix

In the same manner, there are few methods in `util.com.algo2prepare.environment.Matrix` class that 
generate and prints the matrices. The shown listing is part of `com.algo2prepare.MatrixSample` class:

```java
import com.algo2prepare.util.Matrix;


int[][] a1 = Matrix.randomInts(3);            // 3x3 matrix with random ints
int[][] a2 = Matrix.randomInts(3, 2);         // 3x2 (3 rows, 2 cols_ with random ints
int[][] a3 = Matrix.randomInts(3, 0, 10);     // 3x3 matrix with random ints in range [0,10]
int[][] a4 = Matrix.randomInts(3, 4, 0, 10);  // 3x4 matrix with random ints in range [0,10]

int[][] b1 =  Matrix.ints("[[1,2,3],[4,5,6],[7,8,9]]");       // 3x3 matrix of ints
char[][] b2 = Matrix.chars("[[g,h,j],[a,b,c]]");              // 3x2 matrix of chars
String[][] b3 = Matrix.strings("[[\"a\",\"b\",\"c\"],[\"d\",\"e\",\"f\"],[\"g\",\"e\",\"h\"]]");

Matrix.print(a1);
Matrix.print(a2);
Matrix.print(a3);
```
## Tree

In order to generate and print the tree you can use the methods implemented in `util.com.algo2prepare.environment.Tree`. The following code is part of class `com.algo2prepare.TreeSample`

```java
import util.com.algo2prepare.environment.Tree

// https://leetcode.com/problems/balanced-binary-tree/
// node definition usually comes from the coding task
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// binary tree array represntation
// is covered after this code block 
TreeNode root = Tree.ints(TreeNode.class, "[3,9,20,null,null,15,7]");
Tree.print(root);
//           3
//       ┌───┴───┐
//       9      20
//             ┌─┴─┐
//            15   7


TreeNode gen1 = Tree.generate(TreeNode.class,4 /*max height*/);
Tree.print(gen1);
//                  39
//           ┌───────┴───────┐
//           9              44
//       ┌───┴───┐       ┌───┴───┐
//       5      82      49      24
//     ┌─┘     ┌─┴─┐     └─┐     └─┐
//    48       3  82       3       6


TreeNode gen2 = Tree.generateComplete(TreeNode.class,4 /*height*/);
Tree.print(gen2);
//                  95
//           ┌───────┴───────┐
//          10              17
//       ┌───┴───┐       ┌───┴───┐
//      59      66      77      37
//     ┌─┴─┐   ┌─┴─┐   ┌─┴─┐   ┌─┴─┐
//    25  78  18  21   5  55  65  22


// other methods:
// NodeChar root1 = Tree.chars(NodeChar.class, "[a,b,c,d,null]");
// NodeChar root2 = Tree.chars(NodeChar.class, "['a','b','c','d',null]");

// NodeString root3 = Tree.string(NodeString.class, "[\"ab\",\"bc\",\"cd\"]");
// NodeString root4 = Tree.string(NodeString.class, "[ab,bc,cd]");

```

### Binary Trees and Arrays
```
                    left child
                    of root
                      │ 
                      │    right child
                      │    of root
                      │     │
                      ⍒     ⍒
array values:  ┌ 3,   9,   20, null, null,   15,   7 ┐
               │ ----------------------------------- │
array indices: └ 0,   1,    2,    3,    4,    5,   6 ┘
                 ⍋
                 │
                root 


Tree representation of defined array, where values in brackets are array indices:
           3(0)
       ┌───┴───┐
    (1)9      20(2)
             ┌─┴─┐
         (5)15   7(6)

```


## How to start

Clone the repository:
```shell
git clone git@github.com:stuparmihailo/algo2prepare.git
```
Open your IDE with this maven project and start with creation of packages and classes inside the project.

<br><br>

### Few additional notes

- This code is meant to use while practicing and learning algorithms
- There are not unit tests implemented (may be implemented in the future, in the moment I find that as a not mandatory thing during the learning phase)
- This project used Java11, it should not be the issue to perform small adjusments and support different version
