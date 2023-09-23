package _06_frogger;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Frogger extends PApplet {
	int frogX = 400;
	int frogY = 500;
	int hopDistance = 12;
	Car c1o1;
	Car c1o2;
	Car c2o1;
	Car c2o2;
	Car c2o3;
	Car c3o1;
	Car c3o2;
	Car c3o3;
	Car c3o4;
	
	List<DSpot> hitList = new ArrayList <DSpot>();
	
	@Override
	public void settings() {
		size(800,600);
	}

	@Override
	public void setup() {
		c1o1 = new Car(30,400,80,5);
		c1o2 = new Car(430, 400, 80, 5);

		c2o1 = new Car (30,250,80,7);
		c2o2 = new Car (296,250,80,7);
		c2o3 = new Car (562,250,80,7);

		c3o1 = new Car (0,100,100,3);
		c3o2 = new Car (200,100,60,10);
		c3o3 = new Car (400,100,100,3);
		c3o4 = new Car (600,100,60,10);
	}

	@Override
	public void draw() {
		background(20,50,255);

		fill(90,60,0);
		rect(0,550,800,50);
		c1o1.moveRight();
		c1o2.moveRight();

		c2o1.moveLeft();
		c2o2.moveLeft();
		c2o3.moveLeft();

		c3o1.moveRight();
		c3o2.moveRight();
		c3o3.moveRight();
		c3o4.moveRight();

		c1o1.makeRoad();
		c2o1.makeRoad();
		c3o1.makeRoad();
		fill(0,180,30);
		ellipse(frogX,frogY,40,40);

for(DSpot d:hitList) {
	fill(200,220,80);
	ellipse(d.x-20,d.y,100,40);
}

		c1o1.display();
		c1o2.display();

		c2o1.display();
		c2o2.display();
		c2o3.display();

		c3o1.display();
		c3o2.display();
		c3o3.display();
		c3o4.display();

		if(isDed()) {
			die();
		}
	}
	boolean isDed() {
		if(intersects(c1o1) ) {
			return true;
		}
		else if(intersects(c1o2)) {
			return true;
		}
		else if(intersects(c2o1)) {
			return true;
		}
		else if(intersects(c2o2)) {
			return true;
		}
		else if(intersects(c2o3)) {
			return true;
		}
		else if(intersects(c3o1)) {
			return true;
		}
		else if(intersects(c3o2)) {
			return true;
		}
		else if(intersects(c3o3)) {
			return true;
		}
		else if(intersects(c3o4)) {
			return true;
		}
		else {
			return false;
		}
	}
	boolean intersects(Car car) {
		if ((frogY > car.getY() && frogY < car.getY()+50) &&
				(frogX > car.getX() && frogX < car.getX()+car.getSize())) {
			return true;
		}
		else  {
			return false;
		}


	}
	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());

	}
	public void keyPressed()
	{
		System.out.println("FrogX: " + frogX + " FrogY: " + frogY);
		if(key == CODED){
			if(keyCode == UP)
			{
				frogY-=hopDistance;
				//Frog Y position goes up
			}
			else if(keyCode == DOWN)
			{
				frogY+=hopDistance;
				//Frog Y position goes down 
				if(frogY>=550) {
					frogY-=hopDistance;
				}
			}
			else if(keyCode == RIGHT)
			{
				frogX+=hopDistance;
				//Frog X position goes right
			}
			else if(keyCode == LEFT)
			{
				frogX-=hopDistance;
				//Frog X position goes left
			}
			//around the world code
			if(frogX<=-20) {
				frogX=790;
			}
			if(frogX>=820) {
				frogX=10;
			}

		}
	}
	public class Car {
		int carX;
		int carY;
		int carSize;
		int carSpeed;
		Car(int carX,int carY, int carSize, int carSpeed) {
			this.carX = carX;
			this.carY = carY;
			this.carSize = carSize;
			this.carSpeed = carSpeed;

		}
		void makeRoad() {
			fill(0,0,0);
			rect(0,carY-15,800,70);
		}
		void display()
		{
			fill(255,20,40);
			rect(carX , carY,  carSize, 40);
		}
		void moveRight() {
			carX+=carSpeed;
			if(carX>=800) {
				carX=0-carSize;
			}
		}
		void moveLeft() {
			carX-=carSpeed;
			if(carX<=0-carSize) {
				carX=800;
			}
		}
		int getX() {
			return carX;
		}
		int getY() {
			return carY;
		}
		int getSize() {
			return carSize;
		}
	}
	
	public class DSpot 
	{int x;
		int y;
		DSpot(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
		
	}
	
	void die() {
		
		hitList.add(new DSpot(frogX,frogY));
		
		frogX=400;
		frogY = 500;
	}
}