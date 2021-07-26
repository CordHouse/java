import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class shop{
    HashMap<String, Integer> itemList = new HashMap<>();
    HashMap<String, Integer> List = new HashMap<>(); // 아이템 리스트

    customer Person;
    private String item;
    private int price;
    public int decision; // 구매, 판매인지 구별하기 위해

    //List 변수 선언
    int noteBookCount, bookCount, cycleCount, ringCount;

    public void putItem(){

        itemList.put(item, price);
    }

    public int getItemList(String item){

        return itemList.get(item);
    }

    public void setItemList(){
        List.put("노트북", noteBookCount);
        List.put("공책", bookCount);
        List.put("자전거", cycleCount);
        List.put("반지", ringCount);
    }

    public void getList(){
        System.out.println(List);
    }

    //구매
    public void BuyList( ){
        getList();
        System.out.println("구매하고자 하는 물건은 무엇인가요?");
        Scanner itemS = new Scanner(System.in);
        item = itemS.nextLine();

        Random buyRand = new Random();
        price = buyRand.nextInt(1000) + 1; // 가격을 1원부터 1000원까지 랜덤으로 측정
        putItem();

        // 해당 물품이 있는지 없는지 확인
        int count = 0;
        for(String i : List.keySet())
            if(i.equals(item))
                count++;

        if (count == 1) {
            System.out.println("구매할 물품 : " + item);
            System.out.println("구매 금액 : " + getItemList(item) + "원\r\n");
            System.out.println("구매하시겠습니까? : <y> or <n>");
            Scanner Bans = new Scanner(System.in);
            switch (Bans.next()) {
                case "y", "Y" -> {
                    decision = 1; // 구매선택
                    List.put(item, List.get(item) + 1);
                    Person.Calculate(price, decision);
                }
                case "n", "N" -> System.out.println(Person.noAnswer() + "\r\n");
            }
        } else
            System.out.println("목록에 해당 물품이 없습니다.");
        
    }

    //판매
    public void sellList(){
        getList();
        System.out.println("판매하고자 하는 물건은 무엇인가요?");
        Scanner itemS = new Scanner(System.in);
        item = itemS.nextLine();

        Random sellRand = new Random();
        price = sellRand.nextInt(500) + 501; // 가격을 1원부터 1000원까지 랜덤으로 측정
        putItem();

        // 입력한 물품이 있는지 없는지 판단
        int count = 0;
        for(String i : List.keySet())
            if (i.equals(item))
                count++;


        if (count == 1 && List.get(item) > 0) {
            System.out.println("판매할 물품 : " + item);
            System.out.println("판매 금액 : " + getItemList(item) + "원\r\n");
            System.out.println("판매하시겠습니까? : <y> or <n>");
            Scanner Sans = new Scanner(System.in);
            switch (Sans.next()) {
                case "y", "Y" -> {
                    decision = 0; // 판매선택
                    List.put(item, List.get(item) - 1);
                    Person.Calculate(price, decision);
                }
                case "n", "N" -> System.out.println(Person.noAnswer() + "\r\n");
            }
        } else
            System.out.println("목록에 해당 물품이 없습니다.");

    }

    //은행
    public void BankList(){
        Person.bankBenefit();
    }

}
