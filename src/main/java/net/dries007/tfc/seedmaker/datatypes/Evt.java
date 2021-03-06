package net.dries007.tfc.seedmaker.datatypes;

import net.dries007.tfc.seedmaker.util.IDataType;
import net.dries007.tfc.seedmaker.util.WorldGen;

import java.awt.*;

/**
 * @author Dries007
 */
public enum Evt implements IDataType
{
    EVT_0_125(80, 0.125f),
    EVT_0_25(81, 0.25f),
    EVT_0_5(82, 0.5f),
    EVT_1(83, 1f),
    EVT_2(84, 2f),
    EVT_4(85, 4f),
    EVT_8(86, 8f),
    EVT_16(86, 16f);

    public static final int HIGH = EVT_8.id;
    public static final int LOW = EVT_0_25.id;

    static
    {
        final int mul = 255 / values().length;
        for (Evt x : values())
        {
            final int id = x.ordinal() * mul;
            WorldGen.COLORS[x.id] = (id << 16) + (id << 8) + id;
        }
    }

    public final int id;
    public final float value;

    Evt(final int id, final float value)
    {
        this.id = id;
        this.value = value;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    @Override
    public Color getColor()
    {
        return new Color(WorldGen.COLORS[this.id]);
    }
}
