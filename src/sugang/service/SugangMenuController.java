/*
 * menu
 * 1 : login
 * 
 */

package sugang.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sugang.model.StudentDAO;
import sugang.view.RunningEndView;

public class SugangMenuController {
	public static void init() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] logInfo = new String[2];
		int selectedMenu = 0;
		int menu = 0;
		try {
			while (true) {
				switch (menu) {
				case 0: // �α���
					System.out.println(">>>>>>>>>>>>>������û�ý���<<<<<<<<<<<<");
					System.out.println("***** �α��� *****");
					System.out.print("���̵�: ");
					logInfo[0] = in.readLine();
					System.out.print("��й�ȣ: ");
					logInfo[1] = in.readLine();
					if (StudentDAO.getLoginInfo(logInfo) != null) {
						RunningEndView.loginInfoView(StudentDAO.getLoginInfo(logInfo));
						menu = 1;
						continue;
					} else {
						RunningEndView.showError("���̵� Ȥ�� ��й�ȣ �Է°��� �߸��Ǿ����ϴ�.");
						continue;
					}
				case 1: // ���θ޴�
					System.out.println("---------���θ޴�----------");
					System.out.println("1. ������ȸ/��û");
					System.out.println("2. ����������ȸ/����");
					System.out.println("3. ����");
					System.out.print("��ȣ�� �����ϼ��� : ");
					selectedMenu = Integer.parseInt(in.readLine());
					if (selectedMenu == 1) {
						menu = 11;
						continue;
					} else if (selectedMenu == 2) {
						menu = 12;
						continue;
					} else if (selectedMenu == 3) {
						menu = 13;
						continue;
					} else {
						System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
						continue;
					}
				case 11: // ������ȸ/��û
					System.out.println("---------������ȸ/��û----------");
					System.out.println("1. ��ü������ȸ");
					System.out.println("2. �а�����ȸ");
					System.out.println("3. ���Ǹ���ȸ");
					System.out.println("4. �����ڵ���ȸ");
					System.out.println("5. ��������");
					System.out.print("��ȣ�� �����ϼ��� : ");
					selectedMenu = Integer.parseInt(in.readLine());
					if (selectedMenu == 1) {// ��ü������ȸ��
						menu = 111;
						continue;
					} else if (selectedMenu == 2) {// �а�����ȸ��
						menu = 112;
						continue;
					} else if (selectedMenu == 3) {// ���Ǹ���ȸ��
						menu = 113;
						continue;
					} else if (selectedMenu == 4) {// �����ڵ���ȸ��
						menu = 114;
						continue;
					} else if (selectedMenu == 5) {// ��������
						menu = 1;
						continue;
					} else {
						System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
						continue;
					}
				case 12:
					System.out.println("---------����������ȸ/����----------");
					
					if(SugangRegistrationController.getRegistration(StudentDAO.getLoginInfo(logInfo).getCode())){
						System.out.println("1. ��������ϱ�(�̱���)");
						System.out.println("2. ��������");
						System.out.print("��ȣ�� �����ϼ��� : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {// ��������ϱ��
							menu = 121;
							continue;
						} else if (selectedMenu == 2) {// ��������
							menu = 1;
							continue;
						} else {
							System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
							continue;
						}
					}
					else{ 
						System.out.println("�˻��� ����� �����Ƿ� �������� ���ư��ϴ�");
						menu = 1;
						continue;
					}
				case 13:
					System.out.println(">>>>>>>>>>>>>�ý����� �����մϴ�<<<<<<<<<<<<<");
					break;
				case 111:// ��ü������ȸ
					System.out.println("---------��ü������ȸ----------");
					if(SugangRegistrationController.getAllLectures()){
						System.out.println("1. ������û�ϱ�(�̱���)");
						System.out.println("2. ������ȸȭ������");
						System.out.print("��ȣ�� �����ϼ��� : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
							continue;
						}
					}
					else{
						System.out.println("�˻��� ����� �����Ƿ� ������ȸ�޴��� ���ư��ϴ�");
						menu = 11;
						continue;
					}
					
				case 112:// �а�����ȸ
					System.out.println("---------�а�����ȸ----------");
					System.out.print("�а����� �Է��ϼ��� : ");
					String mName = in.readLine();
					if(SugangRegistrationController.getLectureByMname(mName)){
						System.out.println("1. ������û�ϱ�(�̱���)");
						System.out.println("2. ������ȸȭ������");
						System.out.print("��ȣ�� �����ϼ��� : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
							continue;
						}
					}
					else{
						System.out.println("�˻��� ����� �����Ƿ� ������ȸ�޴��� ���ư��ϴ�");
						menu = 11;
						continue;
					}
				case 113:// ���Ǹ���ȸ
					System.out.println("---------���Ǹ���ȸ----------");
					System.out.print("���Ǹ��� �Է��ϼ��� : ");
					String lName = in.readLine();
					if(SugangRegistrationController.getLectureByLname(lName)){
						System.out.println("1. ������û�ϱ�(�̱���)");
						System.out.println("2. ������ȸȭ������");
						System.out.print("��ȣ�� �����ϼ��� : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
							continue;
						}
					}
					else{
						System.out.println("�˻��� ����� �����Ƿ� ������ȸ�޴��� ���ư��ϴ�");
						menu = 11;
						continue;
					}
				case 114:// �����ڵ���ȸ
					System.out.println("---------�����ڵ���ȸ----------");
					System.out.print("�����ڵ带 �Է��ϼ��� : ");
					String lCode = in.readLine();
					if(SugangRegistrationController.getLectureByLcode(lCode)){
						System.out.println("1. ������û�ϱ�(�̱���)");
						System.out.println("2. ������ȸȭ������");
						System.out.print("��ȣ�� �����ϼ��� : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���");
							continue;
						}
					}
					else{
						System.out.println("�˻��� ����� �����Ƿ� ������ȸ�޴��� ���ư��ϴ�");
						menu = 11;
						continue;
					}
				case 121:// �������
					System.out.println("---------�������----------");
					System.out.print("����� ������ �ڵ带 �Է��ϼ��� : ");
					if (in.readLine() != null) {
						/*
						 * ������� ����
						 */
					} else {
						System.out.println("�������� �ʴ� �����ڵ��Դϴ�");
						selectedMenu = 12;
						continue;
					}
				case 1111:// ������û�ϱ�
					System.out.println("---------������û�ϱ�----------");
					System.out.print("������û�� ������ �ڵ带 �Է��ϼ��� : ");
					String lecCode = in.readLine();
					if (SugangRegistrationController.addRegistration(lecCode)) {
						System.out.println("������û�� �Ϸ��߽��ϴ�");
						selectedMenu = 1;
						continue;
					} else {
						System.out.println("������û�� �����߽��ϴ�");
						selectedMenu = 11;
						continue;
					}
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
}
