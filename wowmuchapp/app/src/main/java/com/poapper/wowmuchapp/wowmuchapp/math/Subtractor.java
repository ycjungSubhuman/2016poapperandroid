package com.poapper.wowmuchapp.wowmuchapp.math;

/**
 * Subtracts two operands
 */

public class Subtractor extends BinaryOperator {

    @Override
    public int apply() {
        return getLeft() - getRight();
    }

    @Override
    public String toString() {
        return String.format("%d - %d", getLeft(), getRight());
    }
}
