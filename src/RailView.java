
public class RailView extends ElementView{
	private Rail mRail;
	
	public RailView(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void setModel(Rail r){
		mRail = r;
	}
	
	public Rail getModel(){
		return mRail;
	}
}
