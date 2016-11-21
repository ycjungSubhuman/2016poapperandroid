package com.poapper.wowmuchapp.wowmuchapp.math;

/**
 * Adds two integers when applied
 */

public class Adder extends BinaryOperator {
    @Override
    public int apply() {
        return getLeft() + getRight();
    }

    @Override
    public String toString() {
        return String.format("%d + %d", getLeft(), getRight());
    }

    @Override
    public String getExample() {
        return "a + b";
    }

    @Override
    public int getDifficulty() {
        return 1;
    }
}