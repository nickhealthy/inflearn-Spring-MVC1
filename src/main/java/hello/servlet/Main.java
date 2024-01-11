package hello.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String data = reader.readLine();

    String answer = "";
    data = data.replaceAll("XXXX", "AAAA");
    answer = data.replaceAll("XX", "BB");

    if (answer.contains("X")) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }

  }

}
