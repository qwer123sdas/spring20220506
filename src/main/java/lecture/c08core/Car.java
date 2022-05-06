package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class Car {
	private Engine engine;
	
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void go() {
		engine.action();
	}
	// 지금 nullpointexception이 발생했다는 것은 bean만 생기고 주입이 안됐다는 말임.
	// 주입하는 방법 : set메소드 or 생성자
	// 게다가 @Autowired를 써야지 자동으로 주입된다.
}
