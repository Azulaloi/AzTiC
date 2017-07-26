package az.aztic.util;

import az.aztic.AzTiC;
import az.aztic.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import org.apache.logging.log4j.Level;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class AzUtil {
    public static String unlocalizedWithID(String name){
        return(AzTiC.MODID + "." + name);
    }

    public static void verboseLog(org.apache.logging.log4j.Level level, String message){
        if (Config.verboseLogging){
            AzTiC.logger.log(level, message);
        }
    }

    public static void verboseLog(String message){
        if (Config.verboseLogging){
            AzTiC.logger.log(Level.INFO, message);
        }
    }

    public static class FluidMappingMischief extends StateMapperBase {
        private ModelResourceLocation location;

        public FluidMappingMischief(Fluid fluid){
            this.location = new ModelResourceLocation(new ResourceLocation(AzTiC.MODID, "fluid_block"), fluid.getName());
        }

        @Override
        public ModelResourceLocation getModelResourceLocation(IBlockState something){ return location; }
    }
}
