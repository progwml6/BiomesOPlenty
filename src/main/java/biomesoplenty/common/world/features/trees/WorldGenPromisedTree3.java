package biomesoplenty.common.world.features.trees;

import java.util.Random;

import biomesoplenty.api.BOPBlockHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPromisedTree3 extends WorldGenAbstractTree
{
	public WorldGenPromisedTree3(boolean var1)
	{
		super(var1);
	}

	@Override
	public boolean generate(World world, Random var2, int var3, int var4, int var5)
	{
		int var6 = var2.nextInt(20) + 30;
		int var7 = var2.nextInt(5) + 10;
		int var8 = var6 - var7;
		int var9 = 2 + var2.nextInt(3);
		boolean var10 = true;

		if (var4 >= 1 && var4 + var6 + 1 <= 256)
		{
			int var11;
			int var13;
			int var14;
			//int var15;
			int var24;

			for (var11 = var4; var11 <= var4 + 1 + var6 && var10; ++var11)
			{
				boolean var12 = true;

				if (var11 - var4 < var7)
				{
					var24 = 0;
				}
				else
				{
					var24 = var9;
				}

				for (var13 = var3 - var24; var13 <= var3 + var24 && var10; ++var13)
				{
					for (var14 = var5 - var24; var14 <= var5 + var24 && var10; ++var14)
					{
						if (var11 >= 0 && var11 < 256)
						{
							Block block = world.getBlock(var13, var11, var14);
							
							if (block.isAir(world, var13, var11, var14) || block.isLeaves(world, var13, var11, var14))
							{
								var10 = false;
							}
						}
						else
						{
							var10 = false;
						}
					}
				}
			}

			if (!var10)
				return false;
			else
			{
				Block block11 = world.getBlock(var3, var4 - 1, var5);
				Block block24 = world.getBlock(var3 - 1, var4 - 1, var5);
				Block block13 = world.getBlock(var3, var4 - 1, var5 - 1);
				Block block14 = world.getBlock(var3 - 1, var4 - 1, var5 - 1);

				if ((block11 == BOPBlockHelper.get("holyGrass") || block11 == BOPBlockHelper.get("holyDirt")) && var4 < 256 - var6 - 1)
				{
					if ((block24 == BOPBlockHelper.get("holyGrass") || block24 == BOPBlockHelper.get("holyDirt")) && var4 < 256 - var6 - 1)
					{
						if ((block13 == BOPBlockHelper.get("holyGrass") || block13 == BOPBlockHelper.get("holyDirt")) && var4 < 256 - var6 - 1)
						{
							if ((block14 == BOPBlockHelper.get("holyGrass") | block14 == BOPBlockHelper.get("holyDirt")) && var4 < 256 - var6 - 1)
							{
								world.setBlock(var3, var4 - 1, var5, BOPBlockHelper.get("holyDirt"), 0, 2);
								world.setBlock(var3 - 1, var4 - 1, var5, BOPBlockHelper.get("holyDirt"), 0, 2);
								world.setBlock(var3, var4 - 1, var5 - 1, BOPBlockHelper.get("holyDirt"), 0, 2);
								world.setBlock(var3 - 1, var4 - 1, var5 - 1, BOPBlockHelper.get("holyDirt"), 0, 2);
								int var15 = var2.nextInt(2);
								int var16 = 1;
								boolean var17 = false;
								int var19;
								int var18;
								int var20;

								for (var18 = 0; var18 <= var8; ++var18)
								{
									var19 = var4 + var6 - var18;

									for (var20 = var3 - var15; var20 <= var3 + var15; ++var20)
									{
										int var21 = var20 - var3;

										for (int var22 = var5 - var15; var22 <= var5 + var15; ++var22)
										{
											int var23 = var22 - var5;

											if ((Math.abs(var21) != var15 || Math.abs(var23) != var15 || var15 <= 0) && !world.getBlock(var20, var19, var22).isOpaqueCube())
											{
												this.setBlockAndNotifyAdequately(world, var20, var19, var22, Blocks.leaves, 0);
												this.setBlockAndNotifyAdequately(world, var20 - 1, var19, var22, Blocks.leaves, 0);
												this.setBlockAndNotifyAdequately(world, var20, var19, var22 - 1, Blocks.leaves, 0);
												this.setBlockAndNotifyAdequately(world, var20 - 1, var19, var22 - 1, Blocks.leaves, 0);
											}
										}
									}

									if (var15 >= var16)
									{
										var15 = var17 ? 1 : 0;
										var17 = true;
										++var16;

										if (var16 > var9)
										{
											var16 = var9;
										}
									}
									else
									{
										++var15;
									}
								}

								var18 = var2.nextInt(3);

								for (var19 = 0; var19 < var6 - var18; ++var19)
								{
									Block block = world.getBlock(var3, var4 + var19, var5);

									if (block.isAir(world, var3, var4 + var19, var5) || block == Blocks.leaves)
									{
										this.setBlockAndNotifyAdequately(world, var3, var4 + var19, var5, Blocks.log, 0);
										this.setBlockAndNotifyAdequately(world, var3 - 1, var4 + var19, var5, Blocks.log, 0);
										this.setBlockAndNotifyAdequately(world, var3, var4 + var19, var5 - 1, Blocks.log, 0);
										this.setBlockAndNotifyAdequately(world, var3 - 1, var4 + var19, var5 - 1, Blocks.log, 0);
									}
								}

								return true;
							} else
								return false;
						} else
							return false;
					} else
						return false;
				} else
					return false;
			}
		} else
			return false;
	}
}
