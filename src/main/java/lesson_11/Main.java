package lesson_11;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(List.of(3,4,5));
        ProxyList<Integer> proxyList = new ProxyList<>(lst);
        //Magic.test(lst);
        Magic.test(proxyList);
        System.out.println(proxyList.getAddCallCounter());
    }
}
