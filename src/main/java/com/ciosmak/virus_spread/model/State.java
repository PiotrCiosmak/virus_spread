package com.ciosmak.virus_spread.model;

import javafx.scene.paint.Color;

public enum State
{
    RESISTANT
            {
                @Override
                public Color getColor()
                {
                    return Color.BLUE;
                }
            },
    HEALTHY
            {
                @Override
                public Color getColor()
                {
                    return Color.GREEN;
                }
            },
    HAS_SYMPTOMS
            {
                @Override
                public Color getColor()
                {
                    return Color.RED;
                }
            },
    NO_SYMPYOMS
            {
                @Override
                public Color getColor()
                {
                    return Color.ORANGE;
                }
            };

    public abstract Color getColor();
}
