package sugang.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import sugang.service.LoginController;
import sugang.service.SugangRegistrationController;

public class RunningStartView {
	public static void main(String[] args) {
		System.out.println("***** �α��� *****");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LoginController.init(in);
		System.out.println("\n***** ��� ��� ����� �˻� *****");
		SugangRegistrationController.getAllLectures();
		System.out.println("\n***** �й� 201314135�� ������û ���� �˻� *****");
		String temp = "201314135";
		SugangRegistrationController.getRegistration(temp);
	}

}
