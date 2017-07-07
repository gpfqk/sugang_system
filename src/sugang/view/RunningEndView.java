package sugang.view;

import java.util.ArrayList;

import sugang.model.dto.StudentDTO;

public class RunningEndView {
	// ��� ���� ���
	public static void lectureListView(ArrayList allLecturelist) {
		// ? ������ ���� ���
		// �ϴ� �ڵ� ���� ������ ���
		int length = allLecturelist.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("�˻����� " + (index + 1) + " - " + allLecturelist.get(index));
			}
		} else {
			System.out.println("�˻��� ���� ����Ʈ�� �����ϴ�.");
		}
	}

	// ��� ���� ���
	public static void registrationListView(ArrayList allRegistrationlist) {
		// ? ������ ���� ���
		// �ϴ� �ڵ� ���� ������ ���
		int length = allRegistrationlist.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("�˻����� " + (index + 1) + " - " + allRegistrationlist.get(index));
			}
		} else {
			System.out.println("�˻��� ������û ����Ʈ�� �����ϴ�.");
		}
	}

	// �α��� ���� ���
	public static void loginInfoView(StudentDTO student) {
		System.out.println(student);
	}

	// ���� ��Ȳ ���
	public static void showError(String message) {
		System.out.println(message);
	}

}
