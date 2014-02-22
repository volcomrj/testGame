import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;

public class Square {

private float R,G,B;
private int startX,startY;
private Texture t;

	public Square(float R, float G, float B, int startX, int startY, Texture t){
		this.R=R;
		this.G=G;
		this.B=B;
		this.startX=startX;
		this.startY=startY;
		this.t = t;
		glBindTexture(GL_TEXTURE_2D, this.t.getTextureID());
		this.t.bind();
		
	}
	public void draw(){
		glColor3f(R,G,B);
		glBegin(GL_QUADS);
		glVertex2i(startX,startY);
		glVertex2i(startX+100,startY);
		glVertex2i(startX+100,startY+100);
		glVertex2i(startX,startY+100);
		glEnd();
	}
	
	public void drawT(){
		
		glEnable(GL_TEXTURE_2D);
		
		glColor3f(1f,1f,1f);
		
		glBegin(GL_QUADS);
		glTexCoord2f(0f,0f);
		glVertex2i(startX,startY);
		glTexCoord2f(1f,0f);
		glVertex2i(startX+100,startY);
		glTexCoord2f(1f,1f);
		glVertex2i(startX+100,startY+100);
		glTexCoord2f(0f,1f);
		glVertex2i(startX,startY+100);
		glEnd();
		glDisable(GL_TEXTURE_2D);
	}
	
	
	public void changeColor(float R, float G,float B){
		this.R=R;
		this.G=G;
		this.B=B;
	}
	
	public void move(int startX, int startY){
		this.startX=startX;
		this.startY=startY;
	}
	
	public int getX(){
		return this.startX;
	}
	public int getY(){
		return this.startY;
	}
}
