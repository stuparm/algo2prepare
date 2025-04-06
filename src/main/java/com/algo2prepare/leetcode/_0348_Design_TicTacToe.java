package com.algo2prepare.leetcode;

public class _0348_Design_TicTacToe implements Task{

    int n;
    int[] rows;
    int[] cols;
    int botomUpDiag;
    int topDownDiag;

    public _0348_Design_TicTacToe() {
        this(3);
    }

    public _0348_Design_TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.botomUpDiag = 0;
        this.topDownDiag = 0;

    }

    private int playerToId(int player) {
        return player == 1 ? 1 : -1;
    }

    private int idToPlayer(int id) {
        return id == 1 ? 1 : 2;
    }

    public int move(int row, int col, int player) {
        int id = playerToId(player);

        rows[row] += id;
        cols[col] += id;
        if (row + col == n - 1) { botomUpDiag += id; }
        if (row == col) { topDownDiag += id; }

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(botomUpDiag) == n || Math.abs(topDownDiag) == n) {
            return idToPlayer(id);
        }

        return 0;
    }


    @Override
    public String name() { return "Design TicTacToe"; }

    @Override
    public int id() { return 248; }

    @Override
    public boolean status() { return true; }
}
