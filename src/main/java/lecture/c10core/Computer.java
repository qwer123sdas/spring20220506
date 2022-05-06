package lecture.c10core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Computer {
	
	// 이렇게 해도 주입을 하지만, 권장하진 않는다.
	@Autowired
	private SSD ssd;
}
