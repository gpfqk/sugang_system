package sugang.view;

import java.util.ArrayList;

import sugang.model.dto.LectureDTO;
import sugang.model.dto.RegistrationDTO;
import sugang.model.dto.StudentDTO;

public class RunningEndView {
	// ��� ���� ���
	public static void lectureListView(ArrayList<LectureDTO> allLecturelist) {
		for (int index = 0; index < allLecturelist.size(); index++) {
			System.out.println(allLecturelist.get(index));
		}
	}

	// ��� ���� ���
	public static void registrationListView(ArrayList<RegistrationDTO> allRegistrationlist) {
		for (int index = 0; index < allRegistrationlist.size(); index++) {
			System.out.println(allRegistrationlist.get(index));
		}
	}

	// �α��� ���� ���
	public static void loginInfoView(StudentDTO student) {
		System.out.println(student.getName() + "(" + student.getStuId() + ")�� ȯ���մϴ�");
	}

	// ���� ��Ȳ ���
	public static void showError(String message) {
		System.out.println(message);
	}

	public static void showSuccess(String message) {
		System.out.println(message);
	}

	public static void showMenuInfomation(String flag) {
		if (flag.equals("MainMenu")) {
			System.out.println("");
			System.out.println("[���θ޴�]");
			System.out.println("1. ������ȸ/��û");
			System.out.println("2. ����������ȸ/����");
			System.out.println("3. ����");
			System.out.print("��ȣ�� �����ϼ��� : ");
		} else if (flag.equals("LectureMenu")) {
			System.out.println("");
			System.out.println("[������ȸ/��û]");
			System.out.println("1. ��ü������ȸ");
			System.out.println("2. �а�����ȸ");
			System.out.println("3. ���Ǹ���ȸ");
			System.out.println("4. �����ڵ���ȸ");
			System.out.println("5. ��������");
			System.out.print("��ȣ�� �����ϼ��� : ");
		} else if (flag.equals("LoginMenu")) {
			System.out.println("=====������û�ý���=====");
			System.out.println("[�α���]");
			System.out.print("���̵�: ");
		} else if (flag.equals("ShowRegistrationList")) {
			System.out.println("");
			System.out.println("[����������ȸ/����]");
		} else if (flag.equals("ShowAllLectureList")) {
			System.out.println("");
			System.out.println("[��ü������ȸ]");
		} else if (flag.equals("ShowByMajorList")) {
			System.out.println("");
			System.out.println("[�а�����ȸ]");
			System.out.print("�а����� �Է��ϼ��� : ");
		} else if (flag.equals("ShowByLectureNameList")) {
			System.out.println("");
			System.out.println("[���Ǹ���ȸ]");
			System.out.print("���Ǹ��� �Է��ϼ��� : ");
		} else if (flag.equals("ShowByLectureCodeList")) {
			System.out.println("");
			System.out.println("[�����ڵ���ȸ]");
			System.out.print("�����ڵ带 �Է��ϼ��� : ");
		} else if (flag.equals("DeleteRegistrationMenu")) {
			System.out.println("");
			System.out.println("[�������]");
			System.out.print("����� ������ �ڵ带 �Է��ϼ��� : ");
		} else if (flag.equals("NewRegistration")) {
			System.out.println("");
			System.out.println("[������û�ϱ�]");
			System.out.print("������û�� ������ �ڵ带 �Է��ϼ��� : ");
		} else if (flag.equals("Exit")) {
			System.out.println("");
			System.out.println("[�ý����� �����մϴ�]");
		} else if (flag.equals("DeleteRegistration")) {
			System.out.println("1. ��������ϱ�");
			System.out.println("2. ��������");
			System.out.print("��ȣ�� �����ϼ��� : ");
		} else if (flag.equals("Registration")) {
			System.out.println("1. ������û�ϱ�");
			System.out.println("2. ������ȸȭ������");
			System.out.print("��ȣ�� �����ϼ��� : ");
		}
	}
}
