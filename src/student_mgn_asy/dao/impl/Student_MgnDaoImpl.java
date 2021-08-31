package student_mgn_asy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_asy.dao.Student_MgnDao;
import student_mgn_asy.dto.Student_Mgn;
import student_mgn_asy.util.jdbcUtil;

public class Student_MgnDaoImpl implements Student_MgnDao {
	private static final Student_MgnDaoImpl instance = new Student_MgnDaoImpl();
	
	public Student_MgnDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Student_Mgn> selectStudent_MgnByAll() {
		String sql = "select stdNo, stdName, kor, eng, math from student";
		ArrayList<Student_Mgn> list = null;
		
		try(Connection con = jdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			list = new ArrayList<Student_Mgn>();
			while(rs.next()) {
				Student_Mgn student = getStudent(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	private Student_Mgn getStudent(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdNo");
		String stdName = rs.getString("stdName");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
		Student_Mgn student = new Student_Mgn(stdNo, stdName, kor, eng, math);
		return student;
	}

	

	@Override
	public Student_Mgn selectStudent_MgnByNo(Student_Mgn student) {
		String sql = "select stdNo, stdName, kor, eng, math from student where stdNo = ?";
		try(Connection con = jdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudent_Mgn(Student_Mgn student) {
		String sql = "insert into student values (?, ?, ?, ?, ?)";
		try(Connection con = jdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getStdName());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent_Mgn(Student_Mgn student) {
		String sql = "update student set stdName = ?, kor = ?, eng = ?, math = ? where stdNo = ?;";
		try(Connection con = jdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, student.getStdName());
			pstmt.setInt(2, student.getKor());
			pstmt.setInt(3, student.getEng());
			pstmt.setInt(4, student.getMath());
			pstmt.setInt(5, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent_Mgn(Student_Mgn student) {
		String sql = "delete from student where stdNo = ?";
		try(Connection con = jdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
		pstmt.setInt(1, student.getStdNo());
		return pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return 0;
	}

	public static Student_MgnDaoImpl getInstance() {
		return instance;
	}

}
