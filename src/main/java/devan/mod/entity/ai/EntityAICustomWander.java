package devan.mod.entity.ai;

import devan.mod.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityAICustomWander extends EntityAIWander {

    public EntityAICustomWander(EntityCreature creatureIn, double speedIn) {
        super(creatureIn, speedIn, 50);
    }

    @Override
    public boolean shouldExecute() {
        if (!this.mustUpdate)
        {
            if (this.entity.getIdleTime() >= 100)
            {
                return false;
            }

            if (this.entity.getRNG().nextInt(this.executionChance) != 0)
            {
                return false;
            }
        }

        Vec3d vec3d = this.getPosition();

        if (vec3d == null)
        {
            return false;
        }
        else
        {
            this.x = vec3d.x;
            this.y = vec3d.y;
            this.z = vec3d.z;
            this.mustUpdate = true;
            return true;
        }
    }

    @Nullable
    @Override
    protected Vec3d getPosition() {
        Vec3d pos = null;

        if (this.entity.isInWater())
        {
            pos = RandomPositionGenerator.getLandPos(this.entity, 15, 7);
        }
        else{
            pos = findNearestTree();
        }

        return pos == null ? super.getPosition() : pos;
    }

    private Vec3d findNearestTree(){

        int posX = 0;
        int posY = 0;
        int pozZ = 0;

        BlockPos pos = new BlockPos(this.entity);
        BlockPos corner1 = new BlockPos(pos.getX() + 50, pos.getY() + 50, pos.getZ() + 50);
        BlockPos corner2 = new BlockPos(pos.getX() - 50, pos.getY() - 50, pos.getZ());
        Iterable<BlockPos.MutableBlockPos> blocks = BlockPos.getAllInBoxMutable(corner1, corner2);

        World world = this.entity.world;
        for(BlockPos bp : blocks){
            Block block = world.getBlockState(bp).getBlock();
            if(block == BlockInit.BLOCK_COPPER)
            {
                posX = bp.getX();
                posY = bp.getY();
                posY = bp.getZ();

                return new Vec3d(posX + 1, posY + 1, pozZ);
            }
        }

        return null;
    }
}
