/*
 * menu
 * 1 : login
 * 
 */

package sugang.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import sugang.model.StudentDAO;
import sugang.view.RunningEndView;

public class SugangMenuController {
	static String[] logInfo = new String[2];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int menu = 0;
	static int selectedMenu = 0;

	public static void initStartMenu() {

		try {
			while (true) {
				switch (menu) {
				case 0: // �α���
					loginMenu();
				case 1: // ���θ޴�
					mainMenu();
				case 11: // ������ȸ/��û
					showLectureList();
				case 12:
					showRegistrationList();
				case 13:
					System.out.println(">>>>>>>>>>>>>�ý����� �����մϴ�<<<<<<<<<<<<<");
					break;
				case 111:// ��ü������ȸ
					showAllLectureList();
				case 112:// �а�����ȸ
					showByMajorList();
				case 113:// ���Ǹ���ȸ
					showByLectureNameList();
				case 114:// �����ڵ���ȸ
					showByLectureCodeList();
				case 121:// �������
					deleteRegistration();
				case 1111:// ������û�ϱ�
					newRegistration();
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
		System.out.println(">>>>>>>>>>>>>������û�ý���<<<<<<<<<<<<");
		System.out.println("***** �α��� *****");
		System.out.print("���̵�: ");
		try {
			logInfo[0] = in.readLine();
			System.out.print("��й�ȣ: ");
			logInfo[1] = in.readLine();
			if (StudentDAO.getLoginInfo(logInfo) != null) {
				RunningEndView.loginInfoView(StudentDAO.getLoginInfo(logInfo));
				menu = 1;
				return;
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
		if (selectedMenu == 1) {
			menu = 11;
			return;
		} else if (selectedMenu == 2) {
			menu = 12;
			return;
		} else if (selectedMenu == 3) {
			menu = 13;
			return;
		} else {
			RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
			return;
		}
	}

	public static void showLectureList() {
		RunningEndView.showMenuInfomation("LectureMenu");
		try {
			selectedMenu = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (selectedMenu == 1) {// ��ü������ȸ��
			menu = 111;
			return;
		} else if (selectedMenu == 2) {// �а�����ȸ��
			menu = 112;
			return;
		} else if (selectedMenu == 3) {// ���Ǹ���ȸ��
			menu = 113;
			return;
		} else if (selectedMenu == 4) {// �����ڵ���ȸ��
			menu = 114;
			return;
		} else if (selectedMenu == 5) {// ��������
			menu = 1;
			return;
		} else {
			RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
			return;
		}
	}

	public static void showRegistrationList() {
		System.out.println("---------����������ȸ/����----------");
		try {
			if (SugangRegistrationController.getRegistration(StudentDAO.getLoginInfo(logInfo).getCode())) {
				System.out.println("1. ��������ϱ�(�̱���)");
				System.out.println("2. ��������");
				System.out.print("��ȣ�� �����ϼ��� : ");
				selectedMenu = Integer.parseInt(in.readLine());
				if (selectedMenu == 1) {// ��������ϱ��
					menu = 121;
					return;
				} else if (selectedMenu == 2) {// ��������
					menu = 1;
					return;
				} else {
					RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
					return;
				}
			} else {
				RunningEndView.showError("���� ��û ������ �������� �ʽ��ϴ�.");
				menu = 1;
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAllLectureList() {
		System.out.println("---------��ü������ȸ----------");
		if (SugangRegistrationController.getAllLectures()) {
			System.out.println("1. ������û�ϱ�(�̱���)");
			System.out.println("2. ������ȸȭ������");
			System.out.print("��ȣ�� �����ϼ��� : ");
			try {
				selectedMenu = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (selectedMenu == 1) {
				menu = 1111;
				return;
			} else if (selectedMenu == 2) {
				menu = 11;
				return;
			} else {
				RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void showByMajorList() {
		System.out.println("---------�а�����ȸ----------");
		System.out.print("�а����� �Է��ϼ��� : ");
		String mName = null;
		try {
			mName = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (SugangRegistrationController.getLectureByMname(mName)) {
			System.out.println("1. ������û�ϱ�(�̱���)");
			System.out.println("2. ������ȸȭ������");
			System.out.print("��ȣ�� �����ϼ��� : ");
			try {
				selectedMenu = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (selectedMenu == 1) {
				menu = 1111;
				return;
			} else if (selectedMenu == 2) {
				menu = 11;
				return;
			} else {
				RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void showByLectureNameList() {
		System.out.println("---------���Ǹ���ȸ----------");
		System.out.print("���Ǹ��� �Է��ϼ��� : ");
		String lName = null;
		;
		try {
			lName = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (SugangRegistrationController.getLectureByLname(lName)) {
			System.out.println("1. ������û�ϱ�(�̱���)");
			System.out.println("2. ������ȸȭ������");
			System.out.print("��ȣ�� �����ϼ��� : ");
			try {
				selectedMenu = Integer.parseInt(in.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (selectedMenu == 1) {
				menu = 1111;
				return;
			} else if (selectedMenu == 2) {
				menu = 11;
				return;
			} else {
				RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void showByLectureCodeList() {
		System.out.println("---------�����ڵ���ȸ----------");
		System.out.print("�����ڵ带 �Է��ϼ��� : ");
		String lCode = null;
		try {
			lCode = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (SugangRegistrationController.getLectureByLcode(lCode)) {
			System.out.println("1. ������û�ϱ�(�̱���)");
			System.out.println("2. ������ȸȭ������");
			System.out.print("��ȣ�� �����ϼ��� : ");
			try {
				selectedMenu = Integer.parseInt(in.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			if (selectedMenu == 1) {
				menu = 1111;
				return;
			} else if (selectedMenu == 2) {
				menu = 11;
				return;
			} else {
				RunningEndView.showError("�ùٸ� ��ȣ�� �Է��ϼ���");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void deleteRegistration() {
		System.out.println("---------�������----------");
		System.out.print("����� ������ �ڵ带 �Է��ϼ��� : ");
		try {
			if (in.readLine() != null) {
				/*
				 * ������� ����
				 */
			} else {
				RunningEndView.showError("�������� �ʴ� �����ڵ��Դϴ�");
				selectedMenu = 12;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void newRegistration() {
		System.out.println("---------������û�ϱ�----------");
		System.out.print("������û�� ������ �ڵ带 �Է��ϼ��� : ");
		try {
			if (in.readLine() != null) {
				/*
				 * ������û�ϱ� ����
				 */
			} else {
				RunningEndView.showError("�������� �ʴ� �����ڵ��Դϴ�");
				selectedMenu = 12;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
