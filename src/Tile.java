

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.*;


public class Tile extends GameObject implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float x, y, w;
	int color = 0;
	int tint = 0;
	String id;
	public boolean selected = false;
	PApplet parent;
    int type;
    PImage img;
	String cat;
	String fr;
	AudioPlayer track;
	Minim minim = new Minim(this);
	
	Tile(PApplet p, float x, float y, String id, int type, String cat, String fr){
		parent = p;
		this.x = x;
		this.y = y;
		this.w = 80;
		this.id = id;
		this.type = type;
		this.cat = cat;
		this.fr = fr;
		this.img = parent.loadImage("Images/"+cat+"/"+id+".jpg");
		parent.addMouseListener(this);
	}
	
	public void render(){
		if(overTile(x,y,w)){
			color = 122;
		}
		
		if(selected){
			color = 190;
			tint = 80;
		}
		else{
			color = 0;
			tint = 255;
		}
		if(type == 0){
		    //gets the matching audio for value in x
		    //parent.imageMode(PConstants.CENTER);
		    parent.tint(255,tint);
		    parent.imageMode(0);
		    parent.image(img, x, y, w, w);
		    parent.noFill();
		    parent.noStroke();
			parent.rect(x,y,w,w);
		}
		if(type == 1){
			parent.fill(color);
			parent.rect(x, y, w, w);
			parent.fill(255);
			parent.textSize(8);
			parent.textAlign(PConstants.CENTER);
			parent.text(fr,x+w/2,y+w/2);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Application.hitTarget == false && Application.shootAndStrike == true){
			Application.gameObjects.remove(this);
			selected = !selected;
		}
	}
	
	//function to check if mouse is over tile
	boolean overTile(float x, float y, float w){
		if(parent.mouseX >= x && parent.mouseX <= x + w
				&& parent.mouseY >= y && parent.mouseY <= y + w){
			
			return true;
		}
		else{
			return false;
		}

	}
	void delete(){
		Application.gameObjects.remove(this);
	}
	
	public void mousePressed(){
		System.out.println("Hello");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(overTile(x,y,w)){
			selected = !selected;
			System.out.println("tile id: " + id + "Type:" + type);
			if(Application.matchGame == true){
				track = minim.loadFile("Button.mp3");
				track.rewind();
				track.play();
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
