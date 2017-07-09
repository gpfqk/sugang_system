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
				case 0: // 로그인
					System.out.println(">>>>>>>>>>>>>수강신청시스템<<<<<<<<<<<<");
					System.out.println("***** 로그인 *****");
					System.out.print("아이디: ");
					logInfo[0] = in.readLine();
					System.out.print("비밀번호: ");
					logInfo[1] = in.readLine();
					if (StudentDAO.getLoginInfo(logInfo) != null) {
						RunningEndView.loginInfoView(StudentDAO.getLoginInfo(logInfo));
						menu = 1;
						continue;
					} else {
						RunningEndView.showError("아이디 혹은 비밀번호 입력값이 잘못되었습니다.");
						continue;
					}
				case 1: // 메인메뉴
					System.out.println("---------메인메뉴----------");
					System.out.println("1. 강의조회/신청");
					System.out.println("2. 수강내역조회/편집");
					System.out.println("3. 종료");
					System.out.print("번호를 선택하세요 : ");
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
						System.out.println("올바른 번호를 입력하세요");
						continue;
					}
				case 11: // 강의조회/신청
					System.out.println("---------강의조회/신청----------");
					System.out.println("1. 전체강의조회");
					System.out.println("2. 학과별조회");
					System.out.println("3. 강의명조회");
					System.out.println("4. 강의코드조회");
					System.out.println("5. 메인으로");
					System.out.print("번호를 선택하세요 : ");
					selectedMenu = Integer.parseInt(in.readLine());
					if (selectedMenu == 1) {// 전체강의조회로
						menu = 111;
						continue;
					} else if (selectedMenu == 2) {// 학과별조회로
						menu = 112;
						continue;
					} else if (selectedMenu == 3) {// 강의명조회로
						menu = 113;
						continue;
					} else if (selectedMenu == 4) {// 강의코드조회로
						menu = 114;
						continue;
					} else if (selectedMenu == 5) {// 메인으로
						menu = 1;
						continue;
					} else {
						System.out.println("올바른 번호를 입력하세요");
						continue;
					}
				case 12:
					System.out.println("---------수강내역조회/편집----------");
					
					if(SugangRegistrationController.getRegistration(StudentDAO.getLoginInfo(logInfo).getCode())){
						System.out.println("1. 수강취소하기(미구현)");
						System.out.println("2. 메인으로");
						System.out.print("번호를 선택하세요 : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {// 수강취소하기로
							menu = 121;
							continue;
						} else if (selectedMenu == 2) {// 메인으로
							menu = 1;
							continue;
						} else {
							System.out.println("올바른 번호를 입력하세요");
							continue;
						}
					}
					else{ 
						System.out.println("검색된 결과가 없으므로 메인으로 돌아갑니다");
						menu = 1;
						continue;
					}
				case 13:
					System.out.println(">>>>>>>>>>>>>시스템을 종료합니다<<<<<<<<<<<<<");
					break;
				case 111:// 전체강의조회
					System.out.println("---------전체강의조회----------");
					if(SugangRegistrationController.getAllLectures()){
						System.out.println("1. 수강신청하기(미구현)");
						System.out.println("2. 강의조회화면으로");
						System.out.print("번호를 선택하세요 : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("올바른 번호를 입력하세요");
							continue;
						}
					}
					else{
						System.out.println("검색된 결과가 없으므로 강의조회메뉴로 돌아갑니다");
						menu = 11;
						continue;
					}
					
				case 112:// 학과별조회
					System.out.println("---------학과별조회----------");
					System.out.print("학과명을 입력하세요 : ");
					String mName = in.readLine();
					if(SugangRegistrationController.getLectureByMname(mName)){
						System.out.println("1. 수강신청하기(미구현)");
						System.out.println("2. 강의조회화면으로");
						System.out.print("번호를 선택하세요 : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("올바른 번호를 입력하세요");
							continue;
						}
					}
					else{
						System.out.println("검색된 결과가 없으므로 강의조회메뉴로 돌아갑니다");
						menu = 11;
						continue;
					}
				case 113:// 강의명조회
					System.out.println("---------강의명조회----------");
					System.out.print("강의명을 입력하세요 : ");
					String lName = in.readLine();
					if(SugangRegistrationController.getLectureByLname(lName)){
						System.out.println("1. 수강신청하기(미구현)");
						System.out.println("2. 강의조회화면으로");
						System.out.print("번호를 선택하세요 : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("올바른 번호를 입력하세요");
							continue;
						}
					}
					else{
						System.out.println("검색된 결과가 없으므로 강의조회메뉴로 돌아갑니다");
						menu = 11;
						continue;
					}
				case 114:// 강의코드조회
					System.out.println("---------강의코드조회----------");
					System.out.print("강의코드를 입력하세요 : ");
					String lCode = in.readLine();
					if(SugangRegistrationController.getLectureByLcode(lCode)){
						System.out.println("1. 수강신청하기(미구현)");
						System.out.println("2. 강의조회화면으로");
						System.out.print("번호를 선택하세요 : ");
						selectedMenu = Integer.parseInt(in.readLine());
						if (selectedMenu == 1) {
							menu = 1111;
							continue;
						} else if (selectedMenu == 2) {
							menu = 11;
							continue;
						}
						else {
							System.out.println("올바른 번호를 입력하세요");
							continue;
						}
					}
					else{
						System.out.println("검색된 결과가 없으므로 강의조회메뉴로 돌아갑니다");
						menu = 11;
						continue;
					}
				case 121:// 수강취소
					System.out.println("---------수강취소----------");
					System.out.print("취소할 강의의 코드를 입력하세요 : ");
					if (in.readLine() != null) {
						/*
						 * 수강취소 로직
						 */
					} else {
						System.out.println("존재하지 않는 강의코드입니다");
						selectedMenu = 12;
						continue;
					}
				case 1111:// 수강신청하기
					System.out.println("---------수강신청하기----------");
					System.out.print("수강신청할 강의의 코드를 입력하세요 : ");
					String lecCode = in.readLine();
					if (SugangRegistrationController.addRegistration(lecCode)) {
						System.out.println("수강신청을 완료했습니다");
						selectedMenu = 1;
						continue;
					} else {
						System.out.println("수강신청에 실패했습니다");
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
