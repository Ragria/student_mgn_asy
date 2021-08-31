package student_mgn_asy.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student_mgn_asy.dao.impl.Student_MgnDaoImpl;
import student_mgn_asy.dto.Student_Mgn;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Student_MgnDaoTest {
	
	private Student_MgnDao dao = Student_MgnDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectStudent_MgnByAll() {
		System.out.println("test01SelectStudent_MgnByAll()");
		ArrayList<Student_Mgn> list = dao.selectStudent_MgnByAll();
		Assert.assertNotEquals(0, list.size());
		
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectStudent_MgnByNo() {
		System.out.println("test02SelectStudent_MgnByNo()");
		Student_Mgn selectStd = dao.selectStudent_MgnByNo(new Student_Mgn(1));
		
		System.out.println(selectStd);
		
	}

	@Test
	public void test03InsertStudent_Mgn() {
		System.out.println("test03InsertStudent_Mgn()");
		Student_Mgn newStd =  new Student_Mgn(3, "이씨", 30, 40, 50);
		
		int res = dao.insertStudent_Mgn(newStd);
		Assert.assertEquals(1, res);
		System.out.println("res >> " +res);
		System.out.println("추가된 학생 : " + newStd);
	}

	@Test
	public void test04UpdateStudent_Mgn() {
		System.out.println("test04UpdateStudent_Mgn()");
		Student_Mgn updateStd = new Student_Mgn(3, "3번", 30, 40, 50);
		
		int res = dao.updateStudent_Mgn(updateStd);
		Assert.assertEquals(1, res);
		System.out.println("res >> " + res);
		System.out.printf("학번 %s의 학생을 %s으로 수정%n", updateStd.getStdNo(), updateStd);
	}

	@Test
	public void test05DeleteStudent_Mgn() {
		System.out.println("test05DeleteStudent_Mgn()");
		Student_Mgn deleteStd = new Student_Mgn(3);
		
		int res = dao.deleteStudent_Mgn(deleteStd);
		Assert.assertEquals(1, res);
		System.out.println("res >> " +res);
		System.out.println("삭제된 학생의 학번 : " + deleteStd.getStdNo());
		
	}

}
