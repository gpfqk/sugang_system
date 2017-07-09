package sugang.service;

import java.sql.SQLException;
import java.util.ArrayList;

import sugang.model.LectureDAO;
import sugang.model.RegistrationDAO;
import sugang.model.dto.LectureDTO;
import sugang.model.dto.RegistrationDTO;
import sugang.view.RunningEndView;

public class SugangRegistrationController {
	
	public static boolean getAllLectures() {
		ArrayList<LectureDTO> allLectureList = null;
		boolean isData = false;
		try {
			allLectureList = LectureDAO.getAllLectures();
			if(allLectureList.size() != 0){
				RunningEndView.lectureListView(allLectureList);
				isData = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� �˻� �� ���� �߻�");
		}
		return isData;
	};

	public static boolean getLectureByMname(String majName) {
		ArrayList<LectureDTO> lecturLlist = null;
		boolean isData = false;
		try {
			lecturLlist = LectureDAO.getLectureByMname(majName);
			if(lecturLlist.size() != 0){
				RunningEndView.lectureListView(lecturLlist);
				isData = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� �˻� �� ���� �߻�");
		}
		return isData;
	};
	public static boolean getLectureByLname(String lecName) {
		ArrayList<LectureDTO> lecturLlist = null;
		boolean isData = false;
		try {
			lecturLlist = LectureDAO.getLectureByLname(lecName);
			if(lecturLlist.size() != 0){
				RunningEndView.lectureListView(lecturLlist);
				isData = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� �˻� �� ���� �߻�");
		}
		return isData;
	};
	public static boolean getLectureByLcode(String lecCode) {
		ArrayList<LectureDTO> lecturLlist = null;
		boolean isData = false;
		try {
			lecturLlist = LectureDAO.getLectureByLcode(lecCode);
			if(lecturLlist.size() != 0){
				RunningEndView.lectureListView(lecturLlist);
				isData = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� �˻� �� ���� �߻�");
		}
		return isData;
	};
	public static boolean getRegistration(String stuCode) {
		ArrayList<RegistrationDTO> allRegistrationList = null;
		boolean isData = false;
		try {
			allRegistrationList = RegistrationDAO.getRegistration(stuCode);
			if(allRegistrationList.size() != 0){
				RunningEndView.registrationListView(allRegistrationList);
				isData = true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� �˻� �� ���� �߻�");
		}
		return isData;
	};
	
	public static boolean addRegistration(String lecCode) {
		boolean isData = false;
		try {
//			if(RegistrationDAO.addRegistration(lecCode)){
//				RunningEndView.showSuccess("������û ����");
//				isData = true;
//			}
//			else{
//				RunningEndView.showError("������û ����(�ο� �ʰ� or �ð� ��ħ or �̹� ��û�� ����)");
//			}
			RegistrationDAO.addRegistration(lecCode);
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("������û ���� �߻�");
		}
		return isData;
	};
	public static boolean deleteRegistration(String lecCode) {
		boolean isData = false;
		try {
			if(RegistrationDAO.deleteRegistration(lecCode)){
				RunningEndView.showSuccess("������� ����");
				isData = true;
			}
			else{
				RunningEndView.showError("�ش� �ڵ��� ���ǳ����� �����ϴ�");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("������û ���� �߻�");
		}
		return isData;
	};
}
