package zhang.xmlread;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;

import domain.City;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    List<City> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            }
    public  void click(View v) {
        //先找到待解析的文件,使用输入流来获取
        InputStream is = getClassLoader().getResourceAsStream("test.xml");
        //获取XMPUL解析器
        XmlPullParser xp = Xml.newPullParser();
        //初始化XMLPUL里面的值
        try {
            //传进去值,然后开始解析
            xp.setInput(is, "utf-8");
            //解析第一步,先配置一个开始节点,下面这个type类似于指针,
            //从第一行开始解析
            int type = xp.getEventType();
            //下面用while循环开始处理文件内容
            //city对象为了方便name处理,所以放在while循环外面
            City city = null;
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_TAG:
                        //获取当前节点的名字
                        if ("weather".equals(xp.getName())) {
                            //当到天气这一行的时候,创建一个city的数组
                            //存放city几个对象
                            cityList = new ArrayList<City>();
                        } else if ("city".equals(xp.getName())) {
                            //到城市这一行的时候,创建一个city具体的对象
                            //下面就开始往对象里面写内容
                            city = new City();
                        } else if ("name".equals(xp.getName())) {
                            //写入到city对象的name字段
                            String name = xp.nextText();
                            city.setName(name);
                        } else if ("temp".equals(xp.getName())) {
                            //写入到city对象的name字段
                            String temp = xp.nextText();
                            city.setTemp(temp);
                        } else if ("pm25".equals(xp.getName())) {
                            //写入到city对象的name字段
                            String pm25 = xp.nextText();
                            city.setPm25(pm25);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("city".equals(xp.getName())) {
                            //当到达结束标签city时,把city对象,分别塞入
                            //之前定义的city list里面去
                            cityList.add(city);
                        }
                        break;
                }
                //把指针移动之下一个节点
                //并返回该节点的事件类型
                type = xp.next();
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        for (City city : cityList) {
            System.out.println(city.toString());
        }
    }
}



