package lecture.c04core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		String path = "lecture/c04core/context.xml";
		// 대표적 클래스
		ApplicationContext context = new ClassPathXmlApplicationContext(path);  // 이 객체 자체가 경로를 통해서 의존성 주입을 시킴
		// 위 path에 있는 파일을 읽고 주입
		
		Servlet s = context.getBean(Servlet.class);
		Dao d= context.getBean(Dao.class);
		
		System.out.println(s);
		System.out.println(d);
	}
}
