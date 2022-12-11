package Object;

// Hally 인터페이스로 Kpop 클래스 생성
class Kpop implements Hallyu {
    private String[] currentKpop = {"BTS", "IDLE"};  // 현재의 담고있는 그룹 이름 저장

    // 기본 생성자
    Kpop() { }

    // Kpop 분야 소개
    public void branch() {
        System.out.println("한류의 k-pop 분야입니다.");
    }

    // Kpop 클래스의 intro 메서드: kpop를 소개하며, 현재 생성할 수 있는 객체를 말해줌
    public void intro() {
        System.out.print("K-pop은 대한민국의 대중가요를 말합니다.\n현재 ");
        for(int i=0; i<currentKpop.length; i++){
            System.out.print(currentKpop[i]+" ");
        }
        System.out.println("를 소개하는 객체를 생성할 수 있습니다.");
    }
}
