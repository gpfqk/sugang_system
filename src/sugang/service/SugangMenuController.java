package sugang.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sugang.model.StudentDAO;
import sugang.model.dto.StudentDTO;
import sugang.view.RunningEndView;

public class SugangMenuController {
	static String[] logInfo = new String[2];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int menu = 0;
	static int selectedMenu = 0;
	public static StudentDTO session = null;

	public static void initStartMenu() {

		try {
			while (true) {
				switch (menu) {
				case 0: // �α���
					loginMenu();
					continue;
				case 1: // ���θ޴�
					mainMenu();
					continue;
				case 11: // ������ȸ/��û
					showLectureList();
					continue;
				case 12: // ����������ȸ/����
					showRegistrationList();
					continue;
				case 13: // ����
					RunningEndView.showMenuInfomation("Exit");
					break;
				case 111:// ��ü������ȸ
					showAllLectureList();
					continue;
				case 112:// �а�����ȸ
					showByMajorList();
					continue;
				case 113:// ���Ǹ���ȸ
					showByLectureNameList();
					continue;
				case 114:// �����ڵ���ȸ
					showByLectureCodeList();
					continue;
				case 121:// �������
					deleteRegistration();
					continue;
				case 1111:// ������û�ϱ�
					newRegistration();
					continue;
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void loginMenu() {
		RunningEndView.showMenuInfomation("LoginMenu");
		try {
			logInfo[0] = in.readLine();
			System.out.print("��й�ȣ: ");
			logInfo[1] = in.readLine();
			session = StudentDAO.getLoginInfo(logInfo);
			if (session != null) {
				RunningEndView.loginInfoView(session);
				menu = 1;
			} else {
				RunningEndView.showError("���̵� Ȥ�� ��й�ȣ �Է°��� �߸��Ǿ����ϴ�.");
				loginMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mainMenu() {
		RunningEndView.showMenuInfomation("MainMenu");
		try {
			selectedMenu = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (selectedMenu == 1) {// ������ȸ/��û
			menu = 11;
		} else if (selectedMenu == 2) {// ����������ȸ/����
			menu = 12;
		} else if (selectedMenu == 3) {// ����
			menu = 13;
		} else {
			RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
		}
	}

	public static void showLectureList() {
		RunningEndView.showMenuInfomation("LectureMenu");
		try {
			selectedMenu = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (selectedMenu == 1) {// ��ü������ȸ
			menu = 111;
		} else if (selectedMenu == 2) {// �а�����ȸ
			menu = 112;
		} else if (selectedMenu == 3) {// ���Ǹ���ȸ
			menu = 113;
		} else if (selectedMenu == 4) {// �����ڵ���ȸ
			menu = 114;
		} else if (selectedMenu == 5) {// ��������
			menu = 1;
		} else {
			RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
		}
	}

	public static void showRegistrationList() {
		RunningEndView.showMenuInfomation("ShowRegistrationList");
		try {
			if (SugangRegistrationController.getRegistration(session.getCode())) {
				RunningEndView.showMenuInfomation("DeleteRegistration");
				selectedMenu = Integer.parseInt(in.readLine());
				if (selectedMenu == 1) {// ��������ϱ�
					menu = 121;
				} else if (selectedMenu == 2) {// ��������
					menu = 1;
				} else {
					RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				}
			} else {
				RunningEndView.showError("���� ��û ������ �������� �ʽ��ϴ�");
				menu = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAllLectureList() {
		RunningEndView.showMenuInfomation("ShowAllLectureList");
		if (SugangRegistrationController.getAllLectures()) {
			RunningEndView.showMenuInfomation("Registration");
			try {
				selectedMenu = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (selectedMenu == 1) {// ������û�ϱ�
				menu = 1111;
			} else if (selectedMenu == 2) {// ������ȸȭ������
				menu = 11;
			} else {
				RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
			}
		} else {
			RunningEndView.showError("�˻��� ���ǰ� �����ϴ�");
			menu = 11;
		}
	}

	public static void showByMajorList() {
		RunningEndView.showMenuInfomation("ShowByMajorList");
		String mName = null;
		try {
			mName = in.readLine();
			if (SugangRegistrationController.getLectureByMname(mName)) {
				RunningEndView.showMenuInfomation("Registration");
				selectedMenu = Integer.parseInt(in.readLine());
				if (selectedMenu == 1) {// ������û�ϱ�
					menu = 1111;
				} else if (selectedMenu == 2) {// ������ȸȭ������
					menu = 11;
				} else {
					RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				}
			} else {
				RunningEndView.showError("�˻��� ���ǰ� �����ϴ�");
				menu = 11;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showByLectureNameList() {
		RunningEndView.showMenuInfomation("ShowByLectureNameList");
		String lName = null;
		try {
			lName = in.readLine();
			if (SugangRegistrationController.getLectureByLname(lName)) {
				RunningEndView.showMenuInfomation("Registration");
				selectedMenu = Integer.parseInt(in.readLine());
				if (selectedMenu == 1) {// ������û�ϱ�
					menu = 1111;
				} else if (selectedMenu == 2) {// ������ȸȭ������
					menu = 11;
				} else {
					RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				}
			} else {
				RunningEndView.showError("�˻��� ���ǰ� �����ϴ�");
				menu = 11;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showByLectureCodeList() {
		RunningEndView.showMenuInfomation("ShowByLectureCodeList");
		String lecCode = null;
		try {
			lecCode = in.readLine();
			if (SugangRegistrationController.getLectureByLcode(lecCode)) {
				RunningEndView.showMenuInfomation("Registration");
				selectedMenu = Integer.parseInt(in.readLine());
				if (selectedMenu == 1) {// ������û�ϱ�
					menu = 1111;
				} else if (selectedMenu == 2) {// ������ȸȭ������
					menu = 11;
				} else {
					RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				}
			} else {
				RunningEndView.showError("�˻��� ���ǰ� �����ϴ�");
				menu = 11;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteRegistration() {
		RunningEndView.showMenuInfomation("DeleteRegistrationMenu");
		String lecCode = null;
		try {
			lecCode = in.readLine();
			SugangRegistrationController.deleteRegistration(lecCode);
			menu = 12;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void newRegistration() {
		RunningEndView.showMenuInfomation("NewRegistration");
		String lecCode = null;
		try {
			lecCode = in.readLine();
			SugangRegistrationController.addRegistration(lecCode);
			menu = 11;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
