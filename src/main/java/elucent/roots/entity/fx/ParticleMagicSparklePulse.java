package elucent.roots.entity.fx;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFallingDust;
import net.minecraft.client.particle.ParticleSuspend;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ParticleMagicSparklePulse extends Particle {

	Random random = new Random();
	public double colorR = 0;
	public double colorG = 0;
	public double colorB = 0;
	public int lifetime = 60;
	public ResourceLocation texture = new ResourceLocation("roots:entity/sparkle");
	public ParticleMagicSparklePulse(World worldIn, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b) {
		super(worldIn, x,y,z,0,0,0);
		this.colorR = r;
		this.colorG = g;
		this.colorB = b;
		if (this.colorR > 1.0){
			this.colorR = this.colorR/255.0;
		}
		if (this.colorG > 1.0){
			this.colorG = this.colorG/255.0;
		}
		if (this.colorB > 1.0){
			this.colorB = this.colorB/255.0;
		}
		this.setRBGColorF(1, 1, 1);
		this.particleMaxAge = 60;
		this.motionX = vx;
		this.motionY = vy;
		this.motionZ = vz;
		this.particleScale = 5.0f;
		this.field_190014_F = random.nextFloat()*2.0f*(float)Math.PI;
	    TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());
		this.setParticleTexture(sprite);
	}
	
	@Override
	public int getBrightnessForRender(float pTicks){
		return 255;
	}
	
	@Override
	public boolean isTransparent(){
		return true;
	}
	
	@Override
	public int getFXLayer(){
		return 1;
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		this.motionX *= 0.9;
		this.motionZ *= 0.9;
		float lifeCoeff = ((float)this.particleMaxAge-(float)this.particleAge)/(float)this.particleMaxAge;
		this.particleRed = Math.min(1.0f, (float)colorR*(1.0f-lifeCoeff)+lifeCoeff);
		this.particleGreen = Math.min(1.0f, (float)colorG*(1.0f-lifeCoeff)+lifeCoeff);
		this.particleBlue = Math.min(1.0f, (float)colorB*(1.0f-lifeCoeff)+lifeCoeff);
		this.particleAlpha = lifeCoeff;
		this.particleScale = lifeCoeff;
		if (lifeCoeff > 0.5){
			this.particleScale = 5.0f+5.0f*(1.0f-lifeCoeff);
		}
		if (lifeCoeff <= 0.5){
			this.particleScale = 10.0f*(lifeCoeff);
		}
		field_190015_G = field_190014_F;
		field_190014_F += 1.0f;
	}
}
