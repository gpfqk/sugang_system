package sugang.view;

import java.util.ArrayList;

import sugang.model.dto.LectureDTO;
import sugang.model.dto.StudentDTO;

public class RunningEndView {
	// 모든 강의 출력
	public static void lectureListView(ArrayList<LectureDTO> allLecturelist) {
		int length = allLecturelist.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allLecturelist.get(index));
			}
		} else {
			System.out.println("검색된 강의 리스트가 없습니다.");
		}
	}

	// 모든 강의 출력
	public static void registrationListView(ArrayList allRegistrationlist) {
		// ? 데이터 수가 몇만건
		// 하단 코드 적합 부적합 고민
		int length = allRegistrationlist.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allRegistrationlist.get(index));
			}
		} else {
			System.out.println("검색할 수강신청 리스트가 없습니다.");
		}
	}

	// 로그인 정보 출력
	public static void loginInfoView(StudentDTO student) {
		System.out.println(student);
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}

	public static void showMenuInfomation(String flag) {
		if (flag.equals("MainMenu")) {
			System.out.println("---------메인메뉴----------");
			System.out.println("1. 강의조회/신청");
			System.out.println("2. 수강내역조회/편집");
			System.out.println("3. 종료");
			System.out.print("번호를 선택하세요 : ");
		}
		else if(flag.equals("LectureMenu")) {
			System.out.println("---------강의조회/신청----------");
			System.out.println("1. 전체강의조회");
			System.out.println("2. 학과별조회");
			System.out.println("3. 강의명조회");
			System.out.println("4. 강의코드조회");
			System.out.println("5. 메인으로");
			System.out.print("번호를 선택하세요 : ");
		}
	}
}
