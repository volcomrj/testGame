import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;


public class Triangle {

private float R,G,B;
private int startX,startY;

	public Triangle(float R, float G, float B, int startX, int startY){
		this.R=R;
		this.G=G;
		this.B=B;
		this.startX=startX;
		this.startY=startY;
	}
	public void draw(){
		glColor3f(R,G,B);
		glBegin(GL_TRIANGLES);
		glVertex2i(startX,startY);
		glVertex2i(startX+100,startY);
		glVertex2i(startX,startY+100);
		glEnd();
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
