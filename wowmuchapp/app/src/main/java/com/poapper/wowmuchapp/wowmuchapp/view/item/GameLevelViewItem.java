package com.poapper.wowmuchapp.wowmuchapp.view.item;

import com.poapper.wowmuchapp.wowmuchapp.math.Operator;

/**
 * Game Level information to be shown on level select list
 */

public class GameLevelViewItem {
    private Operator operator;

    public GameLevelViewItem(Operator operator) {
        this.operator = operator;
    }

    public String getOperatorExample() {
        return operator.getExample();
    }

    public int getDifficulty() {
        return operator.getDifficulty();
    }
}
