package hello.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

public class Algorithm {

  @Test
  void algo() throws IOException {
    String[] input = {"AAAA", "BB"};
    String param = "XXXXXX";

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String data = reader.readLine();

    String answer = "";
    data = data.replaceAll("XXXX", "AAAA");
    answer = data.replaceAll("XX", "BB");

    if (answer.contains("X")) {
      System.out.println(-1);
    }

    System.out.println(answer);

//    System.out.println("XXXXXX".replace("XXXX", "AAAA"));

//    String[] paramSplit = param.split("\\.");
//    List<String> list = new ArrayList<>(List.of(paramSplit));
//    list.removeAll(Arrays.asList(""));
//
//    for (int i = 0; i < list.size(); i++) {
//      if (list.get(i).length() % 2 != 0) {
//        System.out.println(-1);
//        break;
//      }
//
//      if (list.get(i).length() >= 4) {
//        stringBuilder.append("AAAA");
//      }
//
//      if (param.length() % 2 != 0) {
//        System.out.println(-1);
//      }

  }





  /*
   * 1. 최대 공약수 2로 나눠지는지 확인
   *  - 안나눠지면 return -1
   * 2. .을 기준으로 split 했을 때 loof를 돌면서 이때도 2로 안나눠지면 return -1
   *
   * 1. split을 했을 때 split이 안 된 경우
   *  - 길이가 4이상이면 AAAA, 아니면 BB
   *  - 문자열 만큼 앞에서부터 자르기
   * 2. split을 했을 때 split이 된 경우
   *  - 길이가 4이상이면 자르기, 아니면 BB
   *  - 문자열 만큼 앞에서 자르기
   *  */
}

