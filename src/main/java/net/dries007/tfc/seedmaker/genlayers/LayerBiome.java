package net.dries007.tfc.seedmaker.genlayers;

import net.dries007.tfc.seedmaker.datatypes.Biome;

import static net.dries007.tfc.seedmaker.datatypes.Biome.ALLOWEDBIOMES;

public class LayerBiome extends Layer
{
    public LayerBiome(final long seed, final Layer parent)
    {
        super(seed, parent);
    }

    @Override
    public int[] getInts(final int x, final int y, final int sizeX, final int sizeY)
    {
        final int[] ints = parent.getInts(x, y, sizeX, sizeY);
        final int[] out = new int[sizeX * sizeY];

        for (int xx = 0; xx < sizeY; ++xx)
        {
            for (int yy = 0; yy < sizeX; ++yy)
            {
                initChunkSeed(yy + x, xx + y);
                final int id = ints[yy + xx * sizeX];
                if (Biome.isOceanicBiome(id)) out[yy + xx * sizeX] = id;
                else out[yy + xx * sizeX] = ALLOWEDBIOMES.get(nextInt(ALLOWEDBIOMES.size())).id;
            }
        }
        return out;
    }
}
