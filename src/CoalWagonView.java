
public class CoalWagonView extends ElementView{
	
	public CoalWagonView(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setImage("img/cwright.jpg");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void setX(int x){
		if (x > xCoord){
			this.setImage("img/cwright.jpg");
			width = 80;
			height = 23;
		}
		if (x < xCoord){
			this.setImage("img/cwleft.jpg");
			width = 80;
			height = 23;
		}
		xCoord = x;
		setBounds(xCoord, yCoord, width, height);
	}
	
	public void setY(int y){
		if (y > yCoord){
			this.setImage("img/cwdown.jpg");
			width = 23;
			height = 80;
		}
		if (y < yCoord){
			this.setImage("img/cwup.jpg");
			width = 23;
			height = 80;
		}
		yCoord = y;
		setBounds(xCoord, yCoord, width, height);
	}
	
}
