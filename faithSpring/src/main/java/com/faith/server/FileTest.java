package com.faith.server;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @description:
 * @author:faith
 * @time:2023/8/214:33
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //当前路径
        /*System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
        File file=new File("C:\\Users\\faith\\Desktop\\test.txt");
        File deskFile=new File("C:\\Users\\faith\\Desktop");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        System.out.println(deskFile.isDirectory());
        System.out.println(deskFile.isFile());

        File createFile=new File("C:\\Users\\faith\\Desktop\\demo.txt");
        System.out.println(createFile.isFile());//是否是个文件
        System.out.println(createFile.isDirectory());//是否是个文件夹
        if (createFile.isFile()){//文件已经存在
            System.out.println("文件已经存在！");
            //删除
            if (createFile.delete()){
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        }else{
            //创建
            createFile.createNewFile();
            System.out.println("创建成功！");
        }

        //有些时候程序需要读写一些临时文件 File提供了createTempFile来创建一个临时文件以及deleteOnExit()在JVM退出时自动删除文件
        File temp = File.createTempFile("temp-",".txt");
        temp.deleteOnExit();//jvm退出自动删除
        System.out.println(temp.isFile());
        System.out.println(temp.getAbsolutePath());

        //遍历文件和目录
        //当File对象表示一个目录树的时候，可以使用list()和listFiles()列出目录下的文件和子目录名
        //listFiles提供了一系列重载方法，可以过滤不想要的文件和目录
        File desk=new File("C:\\Users\\faith\\Desktop");
        if (desk.isDirectory()){
            File[] files = desk.listFiles(); //列出所有文件和子目录
            printFile(files);
            //筛选出.txt的文件
           File [] txtFile = desk.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });
           printFile(txtFile);
        }*/
        //和文件操作类似 File对象如果表示一个目录 可以通过以下方法创建和删除目录
        //  boolean mkdir 创建当前File对象表示的目录
        //  boolean mkdirs 创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来
        //  boolean delete 删除当前File对象表示的目录，当前目录必须为空才能删除
/*        File deskmkdir = new File("D:\\GGboy\\GGboy1");
        System.out.println(deskmkdir.mkdirs());
        System.out.println(deskmkdir.delete());
        //Java标准库还提供了一个Path对象，它位于java.nio.file包。Path对象和File对象类似，但操作更加简单：
        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);
        Path path = p1.toAbsolutePath();
        System.out.println(path);
        Path p3 = path.normalize(); // 转换为规范路径
        System.out.println(p3);*/

        //遍历出D:\\GGboy下的所有文件中的文件
 /*       File file = new File("D:\\\\GGboy");
        if (file.isDirectory()){
            printFile(file.listFiles());
        }*/
/*        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        File f1 = new File(".");
        System.out.println(f1.getPath());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getCanonicalPath());*/
        //i = 0    j = 7
/*        int [] arr = {2,5,6,7,9,11,45,66};
        int i = binarySearchBasic(arr, 66);
        System.out.println(i);*/
    /*        int i = 0 ;
            int j = Integer.MAX_VALUE - 1;
            int m = (i+j)/2;

            i = m + 1;
            System.out.println(i);
            System.out.println(j);
            System.out.println(i+j);
            m = (i+j) / 2;*/
        //System.out.println(m);
/*        int[] nums = {1,2,8,43,3,4};
        int[] nums2 =twoSum(nums,5);
        for (int a:
             nums2) {
            System.out.println(a);
        }*/

        //原始数组
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 1 0 0 0 0 0 0 0 0
        // 0 0 0 3 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0

        //稀疏数组
        //row col val
        //11  11  0
        //1   2   1
        //2   3   3
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][4] = 3;
        int sum = 0;
        System.out.println("原始数组");
        for (int[] a:
             arr) {
            System.out.println("");
            for (int b:
                 a) {
                if (b!=0){
                    sum++;

                }
                System.out.print(b+" ");
            }
        }
        System.out.println();
        System.out.println("数据个数"+sum);
        //原始数组--->稀疏数组
        //定义稀疏数组的长度
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;j<arr[i].length;j++){
                if (arr[i][j] != 0 ){
                    sparseArr[index][0]=i;
                    sparseArr[index][1]=j;
                    sparseArr[index][2]=arr[i][j];
                    index++;
                }
            }
        }
        System.out.println("稀疏数组");
        for (int[] a:
                sparseArr) {
            for (int b:
                    a) {
                if (b!=0){
                    sum++;

                }
                System.out.print(b+" ");
            }
            System.out.println("");
        }
        //稀疏数组--->原始数组
        int[][] originalArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <= sparseArr.length - 1; i++) {
            originalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("稀疏数组还原成原始数组");
        for (int[] a:
                originalArr) {
            System.out.println("");
            for (int b:
                    a) {
                if (b!=0){
                    sum++;
                }
                System.out.print(b+" ");
            }
        }
    }
    /*
    *两数之和
    *   输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * @description:
     * @author: faith
     * @date: 2023/8/3 15:59
     * @param: [nums, target]
     * @return: int[]
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return nums;
    }

    /*
    *
     * @description: 二分查找
     * @author: faith
     * @date: 2023/8/3 11:08
     * @param: [arr, target]
     * @return: int
     **/
    public static int binarySearchBasic(int [] arr,int target){
        int i = 0;//起始
        int j = arr.length - 1;
        int m = 0;
        int index = 0;
        while (i <= j){
             m = (j+i) >>> 1;
            //中间值大于目标值
             if (arr[m] > target){
                 //靠左边 j = midd - 1
                 j = m - 1;
             } else if (arr[m] < target) {
                 i = m + 1;
             }else {
                 return m;
             }
        }
        return -1;
    }

    static void printFile(File [] files){
        if (files != null) {
            for (File f : files) {
                if (f.isFile()){
                    System.out.println("   " + f.getName());
                }
                if (f.isDirectory()){
                    System.out.println(f);
                    printFile(f.listFiles());
                }
            }
        }else {
            return;
        }
    }
}
