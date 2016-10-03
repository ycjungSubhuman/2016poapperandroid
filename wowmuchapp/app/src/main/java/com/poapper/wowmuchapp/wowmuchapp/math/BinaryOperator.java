package com.poapper.wowmuchapp.wowmuchapp.math;

/**
 * Operator for binary operations on integers
 */

public abstract class BinaryOperator implements Operator {

    private int a, b;

    public void setOperands(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getLeft() {
        return a;
    }

    public int getRight() {
        return b;
    }
}
