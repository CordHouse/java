import java.util.Scanner;

public class customer{
    private int Purse; // 판매자 지갑
    private double bankBook = 0; // 통장
    private double benefit; // 이자
    private int count = 0; // 입금 10번에 이자 1회 지급
    shop Shop;

    public void setPurse(int in){
        this.Purse = in;
    }

    public int getPurse(){
        return this.Purse;
    }

    public void print(){
        System.out.println("소지금액을 입력해주세요.");
        Scanner sPurseIn = new Scanner(System.in);
        setPurse(sPurseIn.nextInt());
    }

    public void Calculate(int price, int decision){
        int tmp = getPurse();
        if(tmp > 0 && tmp - price > 0) {
            if(decision == 1) {
                tmp -= price;
                setPurse(tmp);
                System.out.println("구매자가 " + price + "원에 구매하였습니다.");
                System.out.println("거래가 성사되었습니다.");
                System.out.println("현재 소지금액: " + tmp);
                return;
            }
            else if(decision == 0) {
                tmp += price;
                setPurse(tmp);
                System.out.println("판매자가 " + price + "원에 판매하였습니다.");
                System.out.println("거래가 성사되었습니다.");
                System.out.println("현재 소지금액: " + tmp);
                return;
            }
        }
        System.out.println("소지 잔액이 부족하여 거래를 종료합니다.");
    }

    public String noAnswer(){
        return "거래가 성사되지 못했습니다.\r\n거래를 종료합니다.";
    }

    public void bankBenefit(){
        System.out.println("Welcome Samsung Bank");
        System.out.println("입금과 출금을 통해 이윤을 얻어보세요!");
        System.out.println("-- choice want you list --");
        System.out.println("1. 입금   2. 출금   3. 이자   4. 종료");
        Scanner menu = new Scanner(System.in);
        int Menu = menu.nextInt();
        switch (Menu){
            case 1:
            case 2:
                Bank(Menu);
                break;
            case 3:
                getBenefit();
                break;
            default :
                break;
        }
    }

    // 은행
    public void Bank(int menu){
        if(menu == 1) {
            if(count == 10 && bankBook >= 0) {
                benefit += bankBook * 0.01;
                bankBook += benefit;
                count -= 10;
            }
            System.out.println("입금할 금액을 입력해주세요.");
            Scanner inMoney = new Scanner(System.in);
            int money = inMoney.nextInt();
            Purse -= money;
            bankBook += money;
            System.out.println(money + "원이 입금되었습니다. \r\n통장잔고: " + bankBook + "원");
            count++;
            System.out.println("이자를 받기까지 " + (10-count) + "번 남았습니다.");
        }
        else if(menu == 2){
            System.out.println("출금할 금액을 입력해주세요.");
            Scanner outMoney = new Scanner(System.in);
            int money = outMoney.nextInt();
            Purse += money;
            bankBook -= money;
            System.out.println(money + "원이 출금되었습니다. \r\n통장잔고: " + bankBook + "원");
        }
    }

    //이자
    public void getBenefit(){
        System.out.println("현재 누적 이윤: " + benefit);
    }
}
