package com.poapper.wowmuchapp.wowmuchapp.math;

/**
 * Gets (59/60)*a + b
 */

public class WowFyer extends BinaryOperator {
    @Override
    public int apply() {
        return (59 * getLeft())/60 + getRight();
    }

    @Override
    public String toString() {
        return String.format("(59/60) * %d + %d", getLeft(), getRight());
    }
}
