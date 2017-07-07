package sugang.service;

import java.sql.SQLException;

import sugang.model.LectureDAO;
import sugang.model.RegistrationDAO;
import sugang.view.RunningEndView;

public class SugangRegistrationController {
	public static void getAllLectures() {
		try {
			RunningEndView.lectureListView(LectureDAO.getAllLectures());
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� �˻� �� ���� �߻�");
		}
	};

	public static void getLectureByMcode() {
	};

	public static void getLectureByLcode() {
	};

	public static void getLectureByLname() {
	};

	public static void getRegistration(String stuCode) {
		try {
			RunningEndView.registrationListView(RegistrationDAO.getRegistration(stuCode));
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ��� ����� �˻��� ���� �߻�");
		}
	};
}
