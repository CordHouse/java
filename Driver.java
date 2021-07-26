import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        shop shopList = new shop();
        customer Person = new customer();
        int exit = 0;
        Person.Shop = shopList; // 메인에서 연결 필수
        shopList.Person = Person; // 메인에서 연결 필수

        System.out.println("----- Welcome Samsung Market -----");
        System.out.println("* 판매자에겐 구매하고 구매자에겐 판매하여 이윤을 극대화 시키고 손해를 최소화 하세요! *");
        shopList.setItemList();
        Person.print();
        while(exit == 0) {
            System.out.println("-- choice want you list --");
            System.out.println("1. 거래   2. 종료"); // 1번은 구매, 2번은 판매, 3번은 이자 구성예정
            Scanner number = new Scanner(System.in);
            if(number.nextInt() == 1){
                System.out.println("1. 구매   2. 판매   3.은행"); // 1번은 구매, 2번은 판매, 3번은 이자 구성예정
                Scanner Select = new Scanner(System.in);
                switch (Select.nextInt()) {
                    case 1:
                        shopList.BuyList();
                        break;
                    case 2:
                        shopList.sellList();
                        break;
                    case 3:
                        shopList.BankList();
                        break;
                    default:
                        break;
                }
            }
            else
                exit = 1;
        }
    }
}
