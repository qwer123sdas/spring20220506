package study.aop;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import study.di.entity.Exam;
import study.di.entity.NewlecExam;
import study.di.ui.ExamConsole;
import study.di.ui.GridExamConsole;
import study.di.ui.InlineExamConsole;

public class Program {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
		
		
	}
}
