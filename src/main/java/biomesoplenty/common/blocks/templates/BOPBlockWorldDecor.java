package biomesoplenty.common.blocks.templates;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class BOPBlockWorldDecor extends BlockBush
{
	public BOPBlockWorldDecor(Material material)
	{
		super(material);
	}
	
	public boolean isValidPosition(World world, int x, int y, int z, int metadata)
	{
    	//TODO:	  getBlock()
    	if (world.getBlock(x, y - 1, z) == Blocks.air) return false;
		
		//TODO:	canPlaceBlockAt()
		return canPlaceBlockAt(world, x, y, z);
	}
	
    @Override
	//TODO:		updateTick()
	public void updateTick(World world, int x, int y, int z, Random random)
    {
    	//TODO:				getBlock()
    	Block block = world.getBlock(x, y, z);
    	
        this.dropIfCantStay(world, x, y, z, new ItemStack(block, 1, world.getBlockMetadata(x, y, z)));
    }
	
    @Override
    //TODO:			canReplace()
    public boolean canReplace(World world, int x, int y, int z, int side, ItemStack itemStack)
    {
    	//TODO:	  getBlock()
    	if (world.getBlock(x, y - 1, z) == Blocks.air) return false;

    	return isValidPosition(world, x, y, z, itemStack.getItemDamage());
    } 
	
    public void dropIfCantStay(World world, int x, int y, int z, ItemStack stack)
    {
    	//TODO:	  canReplace
        if (!this.canReplace(world, x, y, z, 0, stack))
        {
        	//TODO:	dropBlockAsItem()
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            //TODO:	setBlockToAir()
            world.setBlockToAir(x, y, z);
        }
    }

	@Override
	//TODO:		onNeighborBlockChange()
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock)
	{
		//TODO:												getBlock()
		dropIfCantStay(world, x, y, z, new ItemStack(world.getBlock(x, y, z), 1, world.getBlockMetadata(x, y, z)));
	}
}
