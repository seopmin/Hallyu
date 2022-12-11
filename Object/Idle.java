package Object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Kpop을 상속 받은 Idle 클래스
class Idle extends Kpop {
    private String groupName = "IDLE";
    // 멤버 리스트
    public List<String> member = new ArrayList<String>(Arrays.asList("우기", "소연", "미연", "민니", "슈화"));


    // 인트로 소개
    @Override
    public void intro() {
        System.out.println("파이썬의 IDLE이 아닌 대한민국을 대표하는 여자아이돌 IDLE을 말합니다.");
    }
    // 그룹명 출력
    public void GroupName() {
        System.out.println("그룹명은 " + groupName+"입니다.");
    }
    // 멤버 구성 프린트
    public void members() {
        System.out.println(groupName + "의 멤버 구성은 아래와 같습니다.");
        for(int i=0; i<member.size(); i++){
            System.out.print(member.get(i) + " ");
        }
        System.out.println();
    }
    // 멤버 수 출력
    public void NumOfMembers() {
        System.out.println("멤버수는 " + member.size() + "명 입니다.");
    }
    // 멤버 추가하기
    public void addMember(String e) {
        member.add(e);
        System.out.println(e + "님이 멤버로 추가되었습니다.");
    }
}