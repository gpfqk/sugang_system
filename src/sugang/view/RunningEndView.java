package sugang.view;

import java.util.ArrayList;

import sugang.model.dto.LectureDTO;
import sugang.model.dto.StudentDTO;

public class RunningEndView {
	// ��� ���� ���
	public static void lectureListView(ArrayList<LectureDTO> allLecturelist) {
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

	public static void showMenuInfomation(String flag) {
		if (flag.equals("MainMenu")) {
			System.out.println("---------���θ޴�----------");
			System.out.println("1. ������ȸ/��û");
			System.out.println("2. ����������ȸ/����");
			System.out.println("3. ����");
			System.out.print("��ȣ�� �����ϼ��� : ");
		}
		else if(flag.equals("LectureMenu")) {
			System.out.println("---------������ȸ/��û----------");
			System.out.println("1. ��ü������ȸ");
			System.out.println("2. �а�����ȸ");
			System.out.println("3. ���Ǹ���ȸ");
			System.out.println("4. �����ڵ���ȸ");
			System.out.println("5. ��������");
			System.out.print("��ȣ�� �����ϼ��� : ");
		}
	}
}
