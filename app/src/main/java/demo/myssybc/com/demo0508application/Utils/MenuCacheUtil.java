package demo.myssybc.com.demo0508application.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import demo.myssybc.com.demo0508application.Demo0508.entity.MenuItem;

/**
 * 为了储存菜单的数据
 * Created by wang on 2018/3/15.
 */

public class MenuCacheUtil {
    //定义缓存文件的名字，方便外部调用
    public static final String docCache = "docs_cache.txt";//缓存文件
    //缓存超时时间
    public static final int CACHE_SHORT_TIMEOUT = 1000 * 60 * 5; // 5 分钟

    /**
     * 设置缓存
     * content是要存储的内容，可以是任意格式的，不一定是字符串。
     */
    public static void setCache(String content, Context context, String cacheFileName, int mode) {
        FileOutputStream fos = null;
        try {
            //打开文件输出流，接收参数是文件名和模式
            fos = context.openFileOutput(cacheFileName, mode);
            fos.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取缓存，返回字符串（JSON）
    public static String getCache(Context context, String cacheFileName) {
        FileInputStream fis = null;
        StringBuffer sBuf = new StringBuffer();
        try {
            fis = context.openFileInput(cacheFileName);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                sBuf.append(new String(buf, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sBuf != null) {
            return sBuf.toString();
        }
        return null;
    }

    public static String getCachePath(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    //判断缓存是否过期,比较文件最后修改时间
    private boolean cacheIsOutDate(String cacheFileName, Context context) {
        File file = new File(MenuCacheUtil.getCachePath(context) + "/"
                + cacheFileName);
        //获取缓存文件最后修改的时间，判断是是否从缓存读取
        long date = file.lastModified();
        long time_out = (System.currentTimeMillis() - date);
        if (time_out > MenuCacheUtil.CACHE_SHORT_TIMEOUT) {
            return true;
        }
        return false;//未过期
    }

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public MenuCacheUtil(Context mContext, String preferenceName) {
        preferences = mContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * 保存List
     *
     * @param tag
     * @param datalist
     */
    public void setDataList(String tag, List<MenuItem> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;

        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(datalist);
//        editor.clear();
        editor.putString(tag, strJson);
        editor.commit();

    }


    /**
     * 获取List
     *
     * @param tag
     * @return
     */
    public List<MenuItem> getDataList(String tag) {
        List<MenuItem> datalist = new ArrayList<>();
        String strJson = preferences.getString(tag, null);
        if (null == strJson) {
            return datalist;
        }
        Gson gson = new Gson();
        datalist = gson.fromJson(strJson, new TypeToken<List<MenuItem>>() {
        }.getType());

        Log.e("读取数据", datalist.toString());
        return datalist;

    }



    /**
     * @param tag
     * @param data
     */
    public void setData(String tag, String data) {
        if (null == data || data.isEmpty())
            return;
//        editor.clear();
        editor.putString(tag, data);
        editor.commit();
    }

    /**
     * 获取String
     *
     * @param tag
     * @return
     */
    public String getData(String tag) {
        String strJson = preferences.getString(tag, null);
        return strJson;

    }

//    /**
//     * 存放实体类以及任意类型
//     *
//     * @param key
//     * @param obj
//     */
//    public void putBean(String key, MenuObject obj) {
//        if (obj instanceof Serializable) {// obj必须实现Serializable接口，否则会出问题
//            try {
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ObjectOutputStream oos = new ObjectOutputStream(baos);
//                oos.writeObject(obj);
//                String string64 = new String(Base64.encode(baos.toByteArray(),
//                        0));
//                editor.putString(key, string64).commit();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            throw new IllegalArgumentException(
//                    "the obj must implement Serializble");
//        }
//
//    }
//
//    /**
//     * @param key
//     * @return
//     */
//    public MenuObject getBean(String key) {
//        MenuObject obj = null;
//        try {
//            String base64 = preferences.getString(key, "");
//            if (base64.equals("")) {
//                return null;
//            }
//            byte[] base64Bytes = Base64.decode(base64.getBytes(), 1);
//            ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            obj = (MenuObject) ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return obj;
//    }

    /**
     * 序列化对象
     *
     * @param menuObject
     * @return
     * @throws IOException
     */
//    public String serialize(MenuObject menuObject) throws IOException {
////        startTime = System.currentTimeMillis();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                byteArrayOutputStream);
//        objectOutputStream.writeObject(menuObject);
//        String serStr = byteArrayOutputStream.toString("ISO-8859-1");
//        serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
//        objectOutputStream.close();
//        byteArrayOutputStream.close();
//        LogUtil.d("serial", "serialize str =" + serStr);
////        endTime = System.currentTimeMillis();
////        Log.d("serial", "序列化耗时为:" + (endTime - startTime));
//        return serStr;
//    }

    /**
     * 反序列化对象
     *
     * @param str
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
//    public Object deSerialization(String str) throws IOException,
//            ClassNotFoundException {
////        startTime = System.currentTimeMillis();
//        String redStr = java.net.URLDecoder.decode(str, "UTF-8");
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
//                redStr.getBytes("ISO-8859-1"));
//        ObjectInputStream objectInputStream = new ObjectInputStream(
//                byteArrayInputStream);
//        MenuObject menuObject = (MenuObject) objectInputStream.readObject();
//        objectInputStream.close();
//        byteArrayInputStream.close();
////        endTime = System.currentTimeMillis();
////        LogUtil.d("serial", "反序列化耗时为:" + (endTime - startTime));
//        return menuObject;
//    }


}
