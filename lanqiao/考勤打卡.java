package lanqiao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class Main7 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // 在此输入您的代码...
    int n = scan.nextInt();
    TreeMap<String, Date> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String time = scan.nextLine();
      // 将时间转换为Date类型
      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
      Date date = null;
      try {
        date = sdf.parse(time);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        String id = scan.nextLine();
        if (map.containsKey(id)) {
          Date d = map.get(id);
          // 如果打卡时间早于之前的打卡时间，更新打卡时间
          if (date.before(d)) {
            map.put(id, date);
          }
        }
        map.put(id, date);
      }
    }
    scan.close();
    // 将map中的value值排序并用数组存储
    Date[] dates = new Date[map.size()];
    map.values().toArray(dates);
    // 对dates排序
    Arrays.sort(dates);
    // 按照时间顺序输出id
    for (Date date : dates) {
      for (String id : map.keySet()) {
        if (map.get(id).equals(date)) {
          System.out.println(id);
        }
      }
    }

  }
}
