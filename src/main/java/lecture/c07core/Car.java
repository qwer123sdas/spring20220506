package lecture.c07core;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Car {
	private Engine engine;
	
	/* AllArgsConstructor어노테이션으로 대체 함
	 * public Car(Engine engine) {
		this.engine = engine;
	}*/
	
	
	public void move() {
		engine.action();
	}
}
