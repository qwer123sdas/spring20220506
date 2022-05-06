package lecture.c03core;

public class Servlet1 {
	// private Dao1 dao = new Dao1();   // dependency, 내가 직접!! 만들어서 넣었음
	private Dao1 dao; // spring이 만들도록함  = 주입을 해주어야 함. 즉 spring이 주입시켜주는 것( = 필드에 값을 넣어준다)
	// 객첼를 만드는 걸 내가 하는게 아니라 스프링에게 넘겨준다= control을 반전 시킨다. = inversion of control(IOC) = 제어의 역전(반전)
	
	public void doGet() {
		// request 파라미터 수집 & 가공
		
		// bussiness 로직 처리
		dao.select();   // dao 객체에 의존하고 잇음 (dependency)
		// 결과 세팅
		
		// forward나redirect 
	}
}	
