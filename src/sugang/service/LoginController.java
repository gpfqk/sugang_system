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
				System.out.print("���̵�: ");
				arr[0] = in.readLine();
				System.out.print("��й�ȣ: ");
				arr[1] = in.readLine();
				if (StudentDAO.getLoginInfo(arr) == null) {
					RunningEndView.showError("���̵� Ȥ�� ��й�ȣ �Է°��� �߸��Ǿ����ϴ�.");
					System.out.println("");
					System.out.println("***** �α��� *****");
				} else {
					RunningEndView.loginInfoView(StudentDAO.getLoginInfo(arr));
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			RunningEndView.showError("�Է��� �߸��Ǿ����ϴ�.");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
