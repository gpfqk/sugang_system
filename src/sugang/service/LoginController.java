package sugang.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import sugang.model.RegistrationDAO;
import sugang.model.StudentDAO;
import sugang.view.RunningEndView;
import sugang.view.RunningStartView;

public class LoginController {
	public static void init(BufferedReader in) {
		String[] arr = new String[2];
		boolean result = false;
		try {
			while (!result) {
				System.out.print("아이디: ");
				arr[0] = in.readLine();
				System.out.print("비밀번호: ");
				arr[1] = in.readLine();
				if (StudentDAO.getLoginInfo(arr) == null) {
					RunningEndView.showError("아이디 혹은 비밀번호 입력값이 잘못되었습니다.");
					System.out.println("");
					System.out.println("***** 로그인 *****");
				} else {
					RunningEndView.loginInfoView(StudentDAO.getLoginInfo(arr));
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("입력이 잘못되었습니다.");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
