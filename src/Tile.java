import processing.core.*;

public class Tile extends GameObject {

	float x, y, w;
	PApplet parent;
	
	Tile(PApplet p){
		parent = p;
		this.x = 100;
		this.y = 100;
		this.w = 150;
	}
	
	public void render(){
		parent.fill(0);
		parent.rect(x,y,w,w);
		System.out.println("Working");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
