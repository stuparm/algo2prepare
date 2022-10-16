package com.algo2prepare.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author Mihailo Stupar
 */
public class Tree {


    /**
     * Prints out the tree in the console.<br>
     * Please note that the printed node with long values can be truncated in order to keep the tree structure
     * in proper format. For example, the tree with 3 nodes (one root and two leaves) <code>[1,7654,987654]</code> will
     * look like:
     * <pre>
     *        1
     *      ┌─┴─┐
     *   7654 987
     * </pre>
     * As shows in the tree above, right child became 987 instead of full length value: 987654. <br>
     * In general, the printing method works very well with short keys (1 or 2 characters long)
     * @param root root of the tree
     */
    public static void print(Object root) {
        int height = height(root);
        Field valueField = valueField(root);
        Field leftField = leftField(root);
        Field rightField = rightField(root);

        Queue<Object> queue = new LinkedList<>();

        queue.add(root);
        for (int level = 0; level < height; level++) {
            int indent = (int) Math.pow(2,(height-level))-1;
            int space = (int) Math.pow(2, height-level+1)-1;


            Object[] levelNodes = queue.toArray();
            if (levelNodes.length > 1) {
                printLines(indent, space, levelNodes);
            }

            printLevel(valueField, indent, space, levelNodes);

            queue.clear();
            for (Object levelNode : levelNodes) {
                if (levelNode == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(ReflectionUtil.get(leftField, levelNode));
                    queue.add(ReflectionUtil.get(rightField, levelNode));
                }
            }
        }

    }

    /**
     * Creates the tree where values in nodes are type Character or char.
     * @param clazz Defined class (i.e. Node ) that contains properties like [Node left, Node right, char val]. This
     *              method creates the tree with instances of provided clazz.
     * @param text text that contains tree definition. The length of the values in text array has to be 1 since this
     *             method generates character trees. Examples of valid texts are:<br>[a,b,c,d]<br>['a','b',null,'d']<br>
     *             ["a","b","c"]<br>[1,2,3,4]
     * @return root of the generated tree that is instance of input parameter clazz
     */
    public static <T> T chars(Class<T> clazz, String text) {
        String[] inputArrString = parseInput(text);
        int n = inputArrString.length;
        Character[] inputArr = new Character[n];
        for (int i = 0; i < n; i++) {
            String stringValue = inputArrString[i];
            if ("null".equals(stringValue) || stringValue.isEmpty())
                continue;
            Character character = stringValue.charAt(0);
            inputArr[i] = character;
        }

        T root = createTree(clazz, inputArr);
        return root;
    }

    /**
     * Creates the tree where values in nodes are type Integer or int.
     * @param clazz Defined class (i.e. Node ) that contains properties like [Node left, Node right, int val]. This
     *              method creates the tree with instances of provided clazz.
     * @param text text that contains tree definition. Values in text array have to be integers.
     *             Examples of valid texts are:<br>[1,2,3,4]<br>[12,23,null,34]
     * @return root of the generated tree that is instance of input parameter clazz
     */
    public static <T> T ints(Class<T> clazz, String text) {
        String[] inputArrString = parseInput(text);
        int n = inputArrString.length;
        Integer[] inputArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            String stringValue = inputArrString[i];
            if ("null".equals(stringValue) || stringValue.isEmpty())
                continue;
            Integer integer = Integer.parseInt(inputArrString[i]);
            inputArr[i] = integer;
        }

        T root = createTree(clazz, inputArr);
        return root;
    }

    /**
     * Creates the tree where values in nodes are type String.
     * @param clazz Defined class (i.e. Node ) that contains properties like [Node left, Node right, String val]. This
     *              method creates the tree with instances of provided clazz.
     * @param text text that contains tree definition.
     *             Examples of valid texts are:<br>[1,2,3,4]<br>[12,23,null,34]<br>[a,b,c,d]<br>['a','b',null,'d']
     *      *             <br>["aa","bb","cc","dd"]
     * @return root of the generated tree that is instance of input parameter clazz
     */
    public static <T> T strings(Class<T> clazz, String text) {
        String[] inputArrString = parseInput(text);
        for (int i = 0; i < inputArrString.length; i++) {
            if (inputArrString[i] == null || inputArrString[i].isEmpty() || inputArrString[i].equals("null"))
                inputArrString[i] = null;
        }
        T root = createTree(clazz, inputArrString);
        return root;
    }

    /**
     * Generates the complete three with the specified height
     * @param clazz Defined class (i.e. Node ) that contains properties like [Node left, Node right, TYPE val]. Based
     *              on the TYPE val, the generated tree can contain ints, chars, strings.
     * @param height height of the generated tree
     * @return root of the complete tree
     */
    public static <T> T generateComplete(Class<T> clazz, int height) {
        Field field = valueField(clazz);
        Class valueClass = field.getType();

        int nodeCount = (int)Math.pow(2,height)-1;

        Object[] input = new Object[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            input[i] = generateRandomValue(valueClass);
        }

        T root = createTree(clazz, input);
        return root;
    }

    /**
     * Generates the three with the specified maximum height. Due to randomness, it might happen that hight of the tree
     * is less than maximum height. <br>
     * The difference between this method and {@link Tree#generateComplete(Class, int)} generateComplete()} is in number
     * of leaves in generated tree. This method (eventually) skips the creation of few leaves.
     * @param clazz Defined class (i.e. Node ) that contains properties like [Node left, Node right, TYPE val]. Based
     *              on the TYPE val, the generated tree can contain ints, chars, strings.
     * @param maxHeight max height of the generated tree
     * @return root of the tree
     */
    public static <T> T generate(Class<T> clazz, int maxHeight) {
        Field field = valueField(clazz);
        Class valueClass = field.getType();

        int nodeCount = (int)Math.pow(2,maxHeight)-1;
        Random random = new Random();

        Object[] input = new Object[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            if ( i > nodeCount/2) {
                if (random.nextBoolean())
                    input[i] = generateRandomValue(valueClass);
            } else {
                input[i] = generateRandomValue(valueClass);
            }
        }

        T root = createTree(clazz, input);
        return root;
    }


    // printing methods - utility
    private static int height(Object root) {
        if (root == null)
            return 0;

        Field left = leftField(root);
        Field right = rightField(root);

        Object leftNode = ReflectionUtil.get(left, root);
        Object rightNode = ReflectionUtil.get(right, root);

        return 1 + Math.max(height(leftNode), height(rightNode));
    }

    private static void printLevel(Field valueField, int indent, int space, Object[] nodes) {
        // %-5.5s
        String format = "%"+(indent+5)+"s";
        for (int i = 0; i < nodes.length-1; i++)
            format += "%"+(space+1)+"."+space+"s";
        format += "\n";

        String[] values = new String[nodes.length];
        for (int i = 0; i < nodes.length; i++)
            values[i] = nodes[i] == null ? "" : String.valueOf(ReflectionUtil.get(valueField, nodes[i]));

        System.out.printf(format,values);
    }

    private static void printLines(int indent, int space, Object[] nodes) {
        print(indent+4," ");
        for (int i = 0; i < nodes.length; i=i+2) {
            Object left = nodes[i];
            Object right = nodes[i+1];
            if (left == null && right == null)  {
                print(space+2, " ");
            }
            if (left != null && right == null)  {
                print(space/2, "┌","─","┘" );
                print(space/2+1, " ");
            }
            if (left == null && right != null) {
                print(space/2+1, " ");
                print(space/2, "└","─","┐");
            }
            if (left != null && right != null) {
                print(space/2, "┌","─","" );
                System.out.print("┴");
                print(space/2, "","─","┐");
            }
            print(space," ");
        }
        System.out.println();
    }

    private static void print(int length, String character) {
        for (int i = 0; i < length; i++)
            System.out.print(character);
    }

    private static void print(int length, String start, String middle, String end) {
        System.out.print(start);
        print(length, middle);
        System.out.print(end);
    }





    // generate tree methods - utility
    private static Object generateRandomValue(Class clazz) {
        Random random = new Random();
        if (clazz == String.class) {
            char x = (char)(random.nextInt(26)+'a');
            char y = (char)(random.nextInt(26)+'a');
            return String.valueOf(new char[]{x,y});
        }
        if (clazz == Character.class || clazz == char.class)
            return (char)(random.nextInt(26)+'a');
        if (clazz == Integer.class || clazz == int.class)
            return random.nextInt(99);
        throw new RuntimeException("Only int/Integer, char/Character, String are supported");
    }

    private static <T> T createTree(Class<T> clazz, Object[] input) {
        int n = input.length;

        Field value = valueField(clazz);
        Field left = leftField(clazz);
        Field right = rightField(clazz);

        T[] array = (T[])new Object[n];
        for (int i = 0; i < n; i++) {
            if (input[i] == null)
                continue;

            T t = ReflectionUtil.newInstance(clazz);
            ReflectionUtil.set(value, t, input[i]);
            array[i] = t;
        }

        for (int i = 0; i < n; i++) {
            if (array[i] != null) {

                if (2*i + 1 >= n) ReflectionUtil.set(left, array[i], null);
                else              ReflectionUtil.set(left, array[i], array[2*i+1]);

                if (2*i + 2 >= n) ReflectionUtil.set(right, array[i], null);
                else              ReflectionUtil.set(right, array[i], array[2*i+2]);
            }
        }

        return array[0];
    }

    private static String[] parseInput(String text) {
        String input = text.replaceAll("\\[","").
                            replaceAll("]","").
                            replaceAll("'","").
                            replaceAll("\"","");

        String[] inputArrString = input.split(",");
        return inputArrString;
    }


    // Reflection methods - utility
    private static Field valueField(Object node) {
        return valueField(node.getClass());
    }

    private static Field valueField(Class clazz) {
        String[] candidates = Array.strings("val", "value","item","x");
        Field field = ReflectionUtil.field(clazz, candidates);
        if (field == null)
            throw new RuntimeException("[ Value ] field not found. Try to enrich candidates array in private Tree.valueField() method");
        return field;
    }

    private static Field leftField(Object node) {
        return leftField(node.getClass());
    }

    private static Field leftField(Class clazz) {
        String[] candidates = Array.strings("left","leftChild");
        Field field = ReflectionUtil.field(clazz, candidates);
        if (field == null)
            throw new RuntimeException("[ Left ] field not found. Try to enrich candidates array in private Tree.leftField() method");
        return field;
    }

    private static Field rightField(Object node) {
        return rightField(node.getClass());

    }

    private static Field rightField(Class clazz) {
        Field field = ReflectionUtil.field(clazz, "right","rightChild");
        if (field == null)
            throw new RuntimeException("[ Right ] field not found. Try to enrich candidates array in private Tree.rightField() method");
        return field;
    }

}
