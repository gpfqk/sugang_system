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
				case 0: // 로그인
					loginMenu();
				case 1: // 메인메뉴
					mainMenu();
				case 11: // 강의조회/신청
					showLectureList();
				case 12:
					showRegistrationList();
				case 13:
					System.out.println(">>>>>>>>>>>>>시스템을 종료합니다<<<<<<<<<<<<<");
					break;
				case 111:// 전체강의조회
					showAllLectureList();
				case 112:// 학과별조회
					showByMajorList();
				case 113:// 강의명조회
					showByLectureNameList();
				case 114:// 강의코드조회
					showByLectureCodeList();
				case 121:// 수강취소
					deleteRegistration();
				case 1111:// 수강신청하기
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
		System.out.println(">>>>>>>>>>>>>수강신청시스템<<<<<<<<<<<<");
		System.out.println("***** 로그인 *****");
		System.out.print("아이디: ");
		try {
			logInfo[0] = in.readLine();
			System.out.print("비밀번호: ");
			logInfo[1] = in.readLine();
			if (StudentDAO.getLoginInfo(logInfo) != null) {
				RunningEndView.loginInfoView(StudentDAO.getLoginInfo(logInfo));
				menu = 1;
				return;
			} else {
				RunningEndView.showError("아이디 혹은 비밀번호 입력값이 잘못되었습니다.");
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
			RunningEndView.showError("올바른 번호를 입력하세요");
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
		if (selectedMenu == 1) {// 전체강의조회로
			menu = 111;
			return;
		} else if (selectedMenu == 2) {// 학과별조회로
			menu = 112;
			return;
		} else if (selectedMenu == 3) {// 강의명조회로
			menu = 113;
			return;
		} else if (selectedMenu == 4) {// 강의코드조회로
			menu = 114;
			return;
		} else if (selectedMenu == 5) {// 메인으로
			menu = 1;
			return;
		} else {
			RunningEndView.showError("올바른 번호를 입력하세요");
			return;
		}
	}

	public static void showRegistrationList() {
		System.out.println("---------수강내역조회/편집----------");
		try {
			if (SugangRegistrationController.getRegistration(StudentDAO.getLoginInfo(logInfo).getCode())) {
				System.out.println("1. 수강취소하기(미구현)");
				System.out.println("2. 메인으로");
				System.out.print("번호를 선택하세요 : ");
				selectedMenu = Integer.parseInt(in.readLine());
				if (selectedMenu == 1) {// 수강취소하기로
					menu = 121;
					return;
				} else if (selectedMenu == 2) {// 메인으로
					menu = 1;
					return;
				} else {
					RunningEndView.showError("올바른 번호를 입력하세요");
					return;
				}
			} else {
				RunningEndView.showError("수강 신청 내역이 존재하지 않습니다.");
				menu = 1;
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAllLectureList() {
		System.out.println("---------전체강의조회----------");
		if (SugangRegistrationController.getAllLectures()) {
			System.out.println("1. 수강신청하기(미구현)");
			System.out.println("2. 강의조회화면으로");
			System.out.print("번호를 선택하세요 : ");
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
				RunningEndView.showError("올바른 번호를 입력하세요");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void showByMajorList() {
		System.out.println("---------학과별조회----------");
		System.out.print("학과명을 입력하세요 : ");
		String mName = null;
		try {
			mName = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (SugangRegistrationController.getLectureByMname(mName)) {
			System.out.println("1. 수강신청하기(미구현)");
			System.out.println("2. 강의조회화면으로");
			System.out.print("번호를 선택하세요 : ");
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
				RunningEndView.showError("올바른 번호를 입력하세요");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void showByLectureNameList() {
		System.out.println("---------강의명조회----------");
		System.out.print("강의명을 입력하세요 : ");
		String lName = null;
		;
		try {
			lName = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (SugangRegistrationController.getLectureByLname(lName)) {
			System.out.println("1. 수강신청하기(미구현)");
			System.out.println("2. 강의조회화면으로");
			System.out.print("번호를 선택하세요 : ");
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
				RunningEndView.showError("올바른 번호를 입력하세요");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void showByLectureCodeList() {
		System.out.println("---------강의코드조회----------");
		System.out.print("강의코드를 입력하세요 : ");
		String lCode = null;
		try {
			lCode = in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (SugangRegistrationController.getLectureByLcode(lCode)) {
			System.out.println("1. 수강신청하기(미구현)");
			System.out.println("2. 강의조회화면으로");
			System.out.print("번호를 선택하세요 : ");
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
				RunningEndView.showError("올바른 번호를 입력하세요");
				return;
			}
		} else {
			menu = 11;
			return;
		}
	}

	public static void deleteRegistration() {
		System.out.println("---------수강취소----------");
		System.out.print("취소할 강의의 코드를 입력하세요 : ");
		try {
			if (in.readLine() != null) {
				/*
				 * 수강취소 로직
				 */
			} else {
				RunningEndView.showError("존재하지 않는 강의코드입니다");
				selectedMenu = 12;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void newRegistration() {
		System.out.println("---------수강신청하기----------");
		System.out.print("수강신청할 강의의 코드를 입력하세요 : ");
		try {
			if (in.readLine() != null) {
				/*
				 * 수강신청하기 로직
				 */
			} else {
				RunningEndView.showError("존재하지 않는 강의코드입니다");
				selectedMenu = 12;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
