package elucent.roots.block;

import java.util.Random;

import elucent.roots.Roots;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpiritStairs extends BlockStairs {
	public BlockSpiritStairs(String name, IBlockState state, float hardness){
		super(state);
		setUnlocalizedName(name);
		setSoundType(SoundType.GLASS);
		setRegistryName(Roots.MODID+":"+name);
		setCreativeTab(Roots.tab);
		setHardness(hardness);
		setLightLevel(1.0f);
	}
	
	@Override
	public boolean isFullBlock(IBlockState state){
		return false;
	}
	
	@Override
	public boolean isBlockSolid(IBlockAccess world, BlockPos pos, EnumFacing side){
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state){
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
	@Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face){
        return false;
    }
	
	@Override
	public boolean canRenderInLayer(BlockRenderLayer layer){
		if (layer == BlockRenderLayer.TRANSLUCENT){
			return true;
		}
		return false;
	}
	
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random){
		int side = random.nextInt(6);
		if (side == 0){
			Roots.proxy.spawnParticleMagicAuraFX(world, pos.getX(), pos.getY()+random.nextDouble(), pos.getZ()+random.nextDouble(), 0, 0, 0, 76, 230, 0);
		}
		if (side == 1){
			Roots.proxy.spawnParticleMagicAuraFX(world, pos.getX()+1.0, pos.getY()+random.nextDouble(), pos.getZ()+random.nextDouble(), 0, 0, 0, 76, 230, 0);
		}
		if (side == 2){
			Roots.proxy.spawnParticleMagicAuraFX(world, pos.getX()+random.nextDouble(), pos.getY(), pos.getZ()+random.nextDouble(), 0, 0, 0, 76, 230, 0);
		}
		if (side == 3){
			Roots.proxy.spawnParticleMagicAuraFX(world, pos.getX()+random.nextDouble(), pos.getY()+1.0, pos.getZ()+random.nextDouble(), 0, 0, 0, 76, 230, 0);
		}
		if (side == 4){
			Roots.proxy.spawnParticleMagicAuraFX(world, pos.getX()+random.nextDouble(), pos.getY()+random.nextDouble(), pos.getZ(), 0, 0, 0, 76, 230, 0);
		}
		if (side == 5){
			Roots.proxy.spawnParticleMagicAuraFX(world, pos.getX()+random.nextDouble(), pos.getY()+random.nextDouble(), pos.getZ()+1.0, 0, 0, 0, 76, 230, 0);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
}
