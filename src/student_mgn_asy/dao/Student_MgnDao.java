package student_mgn_asy.dao;

import java.util.ArrayList;

import student_mgn_asy.dto.Student_Mgn;

public interface Student_MgnDao {
	ArrayList<Student_Mgn> selectStudent_MgnByAll();
	Student_Mgn selectStudent_MgnByNo(Student_Mgn student);
	
	int insertStudent_Mgn(Student_Mgn student);
	int updateStudent_Mgn(Student_Mgn student);
	int deleteStudent_Mgn(Student_Mgn student);
}
