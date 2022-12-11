package Object;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n안녕하세요, 한류 소개 페이지에 들어오셨습니다!");
        while(true) {
            int number;

            // Kpop, 종료 중 선택
            System.out.println("\n--------------------");
            System.out.print("Kpop(1)과 종료 버튼(0) 양자택일 : ");
            try { // 숫자 입력을 하지 않을 때 예외 처리
                number = input();
                if (number > 1 || number < 0) {
                    System.out.println("!!숫자 0~1 중 하나를 선택해주세요!!");
                    continue;
                } else if (number == 0) {
                    System.out.println("한류 소개를 종료합니다. 감사합니다:)");
                    break;
                } else { // Kpop을 선택했을 때 Kpop함수 실행
                    KpopMethod();
                }
            } catch (IOException e) {
                System.out.println("숫자를 입력해주세요");
                continue; // continue로 다시 while문 돌기
            }
        }
    }

    // 예외처리를 위한 input() 함수
    public static int input() throws IOException{
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        return num;
    }


    // Kpop 객체 생성을 위한 method
    public static void KpopMethod() {
        Kpop k = new Kpop();
        k.branch();

        while(true) {
            int number; // 입력받은 숫자를 넣을 변수
            System.out.print("\n--------------------\n다음의 해당 번호를 선택해주세요! \nkpop 소개(1), BTS에 대해 알아보기(2), 아이들에 대해 알아보기(3), 종료(0) : ");

            // 입력 받은 게 숫자가 아닐 때 예외처리
            try {
                number = input();
                System.out.println();
                if (number > 3 || number < 0) {
                    System.out.println("숫자 0~2 중 하나를 선택해주세요!");
                    continue;
                } else if (number == 0) {
                    System.out.println("Kpop 소개가 종료되었습니다.");
                    break;
                }
            } catch (IOException e) {
                System.out.println("숫자를 입력해주세요");
                continue;
            }

            if (number == 1){
                k.intro();
            } else if (number == 2) {
                k = new BTS();  // 다형성 이용
                k.intro();  // 다형성 활용

                // BTSDetail 함수에서 파일 읽기 오류가 날 예외 처리
                try {
                    BTSDetail((BTS) k);  // 강제타입변환 및 BTSDetail 함수 호출
                } catch (Exception e) {
                    System.out.println("파일 읽기에 오류가 나 BTS 상세 페이지를 종료합니다.");
                }
            } else {
                k = new Idle();  // 다형성 이용
                k.intro();  // 다형성 활용

                // IdleDetail 함수에서 파일 읽기 오류가 날 예외 처리
                try {
                    IdleDetail((Idle) k);  // 강제타입변환 및 IdleDetail 함수 호출
                } catch (Exception e) {
                    System.out.println("파일 읽기에 오류가 나 Idle 상세 페이지를 종료합니다.");
                }
            }
        }
    }

    // Kpop 관련 객체 dtail 내용
    public static void BTSDetail(BTS k) throws Exception{
        while(true) {
            int number;
            System.out.print("\n--------------------\n해당 번호를 입력해주세요!\n그룹명(1) / 멤버 구성(2) / 멤버 인원수(3) / 멤버 추가하기(4) / 멤버 저장하기(5) / 종료(0) : ");

            // 입력한 게 숫자가 아닐 때 예외처리
            try {
                number = input();
                System.out.println();
                if (number > 5 || number < 0) {
                    System.out.println("숫자 0~4 중 하나를 선택해주세요!");
                    continue;
                } else if (number == 0) {
                    System.out.println("소개가 종료되었습니다.");
                    break;
                }
            } catch (IOException e) {
                System.out.println("숫자를 입력해주세요");
                continue;
            }

            if (number == 1) {  // 그룹명 출력
                k.GroupName();
            } else if (number == 2) {  // 그룹 멤버 출력
                k.members();
            } else if (number == 3) {  // 그룹 인원수 출력
                k.NumOfMembers();
            } else if(number == 4){  // 그룹 멤버 추가하기

                // BufferedReader 이용
                BufferedReader reader = new BufferedReader(
                        new FileReader("E:\\file.txt")
                );

                // 한 라인씩 읽기
                String str;
                while ((str = reader.readLine()) != null) {
                    k.addMember(str);
                }

                reader.close();
            } else {  // 그룹멤버 저장
                File file = new File("E:\\BTS_file.txt");

                // 파일 쓰기 예외처리
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    for(int i=0; i<k.member.size(); i++) {
                        writer.write(k.member.get(i)+" ");
                    }
                    writer.close();
                } catch (IOException e) {
                    System.out.println("저장에 실패하였습니다.");
                }

                System.out.println("성공적으로 저장되었습니다.");
            }
        }
    }

    // Idle detail 함수
    public static void IdleDetail(Idle k) throws Exception {
        while(true) {
            int number;
            System.out.print("\n해당 번호를 입력해주세요!\n그룹명(1) / 멤버 구성(2) / 멤버 인원수(3) / 멤버 추가하기(4) / 멤버 저장하기(5) / 종료(0) : ");

            // 입력한 게 숫자가 아닐 때 예외처리
            try {
                number = input();
                if (number > 5 || number < 0) {
                    System.out.println("숫자 0~4 중 하나를 선택해주세요!");
                    continue;
                } else if (number == 0) {
                    System.out.println("소개가 종료되었습니다.");
                    break;
                }
            } catch (IOException e) {
                System.out.println("숫자를 입력해주세요");
                continue;
            }

            if (number == 1) {  // 그룹명 출력
                k.GroupName();
            } else if (number == 2) {  // 그룹 멤버 출력
                k.members();
            } else if (number == 3) {  // 그룹 인원수 출력
                k.NumOfMembers();
            } else if(number == 4) {  // 그룹 멤버 추가하기
                BufferedReader reader = new BufferedReader(
                        new FileReader("E:\\file.txt")
                );

                // 한 라인씩 읽기
                String str;
                while ((str = reader.readLine()) != null) {
                    k.addMember(str);
                }

                reader.close();
            } else {  // 그룹멤버 저장
                File file = new File("E:\\Idle_file.txt");
                // 파일 쓰기 예외처리
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    for(int i=0; i<k.member.size(); i++) {
                        writer.write(k.member.get(i)+" ");
                    }
                    writer.close();
                } catch (IOException e) {
                    System.out.println("저장에 실패하였습니다.");
                }

                System.out.println("성공적으로 저장되었습니다.");
            }
        }
    }
}