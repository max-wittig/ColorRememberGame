package com.maxwittig.colorremember;

import javafx.scene.paint.Color;

public class ColorUtils
{
    public static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    public static Color getBrighterColor(Color color)
    {
        return new Color(color.getRed(), color.getGreen(), color.getBlue()-0.5, 1);
    }
}
