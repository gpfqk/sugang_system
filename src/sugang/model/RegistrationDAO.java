package sugang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import sugang.model.dto.LectureDTO;
import sugang.model.dto.RegistrationDTO;
import sugang.model.util.DBUtil;
import sugang.service.SugangMenuController;

public class RegistrationDAO {
	static Properties sql = DBUtil.getProperties();

	// 학번으로 해당 학생의 수강신청 정보 반환
	public static ArrayList<RegistrationDTO> getRegistration(String stuCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RegistrationDTO> all = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getRegistration"));
			pstmt.setString(1, stuCode);
			rset = pstmt.executeQuery();
			all = new ArrayList<RegistrationDTO>();
			while (rset.next()) {
				all.add(new RegistrationDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return all;
	}

	public static boolean addRegistration(String lecCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<RegistrationDTO> all = null;
		String stuCode = SugangMenuController.session.getCode();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addRegistration"));
			pstmt.setString(1, stuCode);
			pstmt.setString(2, lecCode);
			pstmt.setString(3, stuCode);
			pstmt.setString(4, lecCode);
			int result = pstmt.executeUpdate();
			all = new ArrayList<RegistrationDTO>();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rset1 = null;
//		ResultSet rset2 = null;
//		LectureDTO lecture = null;
//		ArrayList<RegistrationDTO> registrationList = null;
//		String stuCode = SugangMenuController.session.getCode();
//		//System.out.println("lecCode"+lecCode);
//		//System.out.println("stuCode"+stuCode);
//		try {
//			con = DBUtil.getConnection();
//			stmt = con.createStatement();
//			rset1 	= stmt.executeQuery("select * from lecturelist "
//													+ "where lcode = '"+lecCode+"' and '"+lecCode
//													+"' not in(select r.lcode from registration r, registrationlist rl "
//													+ "where r.SCODE = '"+stuCode+"' and r.LCODE = rl.LCODE)");
//			while(rset1.next()){
//				lecture = new LectureDTO(rset1.getString(1), rset1.getString(2), rset1.getString(3), rset1.getString(4),
//						rset1.getString(5), rset1.getString(6), rset1.getString(7), rset1.getInt(8), rset1.getInt(9));
//			}
//			rset2 	= stmt.executeQuery("select r.lcode from registration r, registrationlist rl "
//													+ "where r.SCODE = '"+stuCode+"' and r.LCODE = rl.LCODE");
//			
//			registrationList = new ArrayList<RegistrationDTO>();
//			while (rset2.next()) {
//				registrationList.add(new RegistrationDTO(rset2.getString(1), rset2.getString(2), rset2.getString(3), rset2.getString(4),
//						rset2.getString(5), rset2.getString(6), rset2.getString(7)));
//			}
//			
//			if(lecture != null){
//				for(int i ; i < registrationList.size() ; i++){ 
//					if(lecture.getLecDay().equals(registrationList.get(i))){
//						
//					}
//					int result = stmt.executeUpdate("delete from registration where lcode = '" + lecCode + "' and sCode = '"
//							+ SugangMenuController.session.getCode() + "'");
//					if (result == 1) {
//						int result2 = stmt
//								.executeUpdate("update lecture set lcurrent = lcurrent - 1 where lcode = '" + lecCode + "'");
//						if (result2 == 1) {
//							return true;
//						}
//					}
//				}
//				
//			}
//		} finally {
//			DBUtil.close(con, stmt);
//		}
//		return false;
	}

	public static boolean deleteRegistration(String lecCode) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			int result1 = stmt.executeUpdate("delete from registration where lcode = '" + lecCode + "' and sCode = '"
					+ SugangMenuController.session.getCode() + "'");
			if (result1 == 1) {
				int result2 = stmt
						.executeUpdate("update lecture set lcurrent = lcurrent - 1 where lcode = '" + lecCode + "'");
				if (result2 == 1) {
					return true;
				}
			}
		} finally {
			DBUtil.close(con, stmt);
		}
		return false;
	}

}
