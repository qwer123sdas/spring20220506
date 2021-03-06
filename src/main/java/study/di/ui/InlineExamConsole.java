package study.di.ui;

import org.springframework.beans.factory.annotation.Autowired;

import study.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}


	@Override
	public void print() {
		System.out.printf("total is %d, avg %f/n", exam.total(), exam.avg());
	}

	@Autowired
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
