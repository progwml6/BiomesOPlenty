package biomesoplenty.common.world.features;

import java.lang.reflect.Field;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.world.decoration.IBOPDecoration;
import biomesoplenty.common.world.generation.WorldGeneratorBOP;

public class WorldGenMud extends WorldGeneratorBOP
{
	/** The maximum radius used when generating a patch of blocks. */
	private int radius;

	public WorldGenMud(int radius)
	{
		this.radius = radius;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		//TODO:	  getBlock()			getMaterial()				water
		if (world.func_147439_a(x, y, z).func_149688_o() != Material.field_151586_h)
			return false;
		else
		{
			int var6 = random.nextInt(radius - 2) + 2;
			byte var7 = 2;

			for (int var8 = x - var6; var8 <= x + var6; ++var8)
			{
				for (int var9 = z - var6; var9 <= z + var6; ++var9)
				{
					int var10 = var8 - x;
					int var11 = var9 - z;

					if (var10 * var10 + var11 * var11 <= var6 * var6)
					{
						for (int var12 = y - var7; var12 <= y + var7; ++var12)
						{
							//TODO:				getBlock()
							Block block = world.func_147439_a(var8, var12, var9);

							if (block == Blocks.dirt || block == Blocks.grass)
							{
								//TODO: setBlock()
								world.func_147449_b(var8, var12, var9, BOPBlockHelper.get("mud"));
							}
						}
					}
				}
			}

			return true;
		}
	}

	@Override
	public void doGeneration(World world, Random random, Field worldGeneratorField, WorldGenerator worldGenerator, BiomeGenBase biome, IBOPDecoration bopDecoration, int x, int z) throws Exception
	{
		for (int i = 0; i < worldGeneratorField.getInt(bopDecoration.getWorldFeatures()); i++)
		{
			int randX = x + random.nextInt(16);
			int randZ = z + random.nextInt(16);

			worldGenerator.generate(world, random, randX, world.getTopSolidOrLiquidBlock(randX, randZ), randZ);
		}
	}
}
