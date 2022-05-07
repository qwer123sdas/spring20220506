package study.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.di.entity.Exam;
import study.di.entity.NewlecExam;
import study.di.ui.ExamConsole;
import study.di.ui.GridExamConsole;
import study.di.ui.InlineExamConsole;

public class Program {
	public static void main(String[] args) {
		/* 스프링에게 지시하는 방법으로 코드 만들기
		Exam exam = new NewlecExam();
		ExamConsole console = new GridExamConsole(exam);
		
		console.setExam(exam);
		*/
		String path = "study/di/setting.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		// Object형으로 꺼내오기 때문에 형변환을 해야 한다.
		ExamConsole console = (ExamConsole) context.getBean("console");
		
		// .class : 이 class타입과 이름에 맞는 녀석을 찾아달라는 것.
		//ExamConsole console = context.getBean(ExamConsole.class);
		
		console.print();
	}
}
