import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;


@SuppressWarnings("unused")
public class DisplayDriver {

	static Texture ball;
	
	public static void main(String[] args){
		
		
		
		
		
		
		try{
			Display.setDisplayMode(new DisplayMode(640,480));
			Display.setTitle("Test LWJGL Display");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		try {
			ball = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/ball.png")));
		        // Replace PNG with your file extension
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		
		
		startDraw();
		Line line = new Line(0f,1.0f,0f,100,100);
		Triangle triangle = new Triangle(0f,0f,1.0f,300,100);
		Square square = new Square(1.0f,0f,0f,300,300,ball);
		
		
		
		while (!Display.isCloseRequested()){
			
			
			
			arrowMove(square);
			wsadMove(triangle);
			ijklMove(line);
			squareAct(square);
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			line.draw();
			triangle.draw();
			square.drawT();
			
			Display.update();
			Display.sync(60);
		}
		ball.release();
		Display.destroy();
		System.exit(0);
	}
	
	public static void arrowMove(Square square){
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			square.move(square.getX()+5,square.getY());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			square.move(square.getX()-5,square.getY());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			square.move(square.getX(),square.getY()-5);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			square.move(square.getX(),square.getY()+5);
		}
	}
	
	public static void wsadMove(Triangle triangle){
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			triangle.move(triangle.getX()+5,triangle.getY());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			triangle.move(triangle.getX()-5,triangle.getY());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			triangle.move(triangle.getX(),triangle.getY()-5);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			triangle.move(triangle.getX(),triangle.getY()+5);
		}
	}
	
	public static void ijklMove(Line line){
		if (Keyboard.isKeyDown(Keyboard.KEY_L)) {
			line.move(line.getX()+5,line.getY());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_J)) {
			line.move(line.getX()-5,line.getY());
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_I)) {
			line.move(line.getX(),line.getY()-5);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_K)) {
			line.move(line.getX(),line.getY()+5);
		}
	}
	
	public static void squareAct(Square square){
		while(Keyboard.next()) {
			
			if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
				System.out.println("Co-ordinates of square are: ("+square.getX()+","+square.getY()+")");
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_B)) {
				square.changeColor(0f, 0f, 1f);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
				square.changeColor(1f, 0f, 0f);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
				square.changeColor(0f, 1f, 0f);
			}
		}
	}
	
	
	
	public static void startDraw(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,640,480,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		
		
	}
}