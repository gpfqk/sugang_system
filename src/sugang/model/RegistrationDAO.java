package sugang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import sugang.model.dto.LectureDTO;
import sugang.model.dto.RegistrationDTO;
import sugang.model.util.DBUtil;

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
}
