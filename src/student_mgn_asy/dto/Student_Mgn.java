package student_mgn_asy.dto;

public class Student_Mgn {
	private int stdNo;		//학번
	private String stdName;	//성명
	private int kor;		//국어점수
	private int eng;		//영어점수
	private int math;		//수학점수
	
	public Student_Mgn(int stdNo, String stdName, int kor, int eng, int math) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student_Mgn(int stdNo) {
		this.stdNo = stdNo;
	}

	public Student_Mgn() {
		// TODO Auto-generated constructor stub
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return String.format("student_mgn [stdNo=%s, stdName=%s, kor=%s, eng=%s, math=%s]", stdNo, stdName, kor, eng,
				math);
	}
}
