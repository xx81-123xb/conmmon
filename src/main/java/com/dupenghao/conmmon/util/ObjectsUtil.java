package com.dupenghao.conmmon.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by 杜鹏豪 on 2023/6/16.
 */
public class ObjectsUtil {

    /**
     * 将对象集合保存到excel中
     * @param objects 对象集合
     * @param outPath 输出路径
     * @param fileName 输出文件名
     * @param clazz 对象类型
     * @param <T> 对象类型
     * @throws IOException IO异常
     */
    public static <T> void saveObjects2Excel(List<T> objects,String outPath,String fileName,Class<T> clazz) throws IOException {
        //检验fileName
        if(fileName == null || fileName.trim().length() == 0){
            throw new RuntimeException("fileName不能为空");
        }
        //检验outPath
        if(outPath == null || outPath.trim().length() == 0){
            throw new RuntimeException("outPath不能为空");
        }
        //检验fileName是否以.xlsx结尾
        if(!fileName.endsWith(".xlsx")){
            throw new RuntimeException("fileName必须以.xlsx结尾");
        }
        //检验objects
        if(objects == null || objects.size() == 0){
            throw new RuntimeException("objects不能为空");
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        File outDir = new File(outPath);
        if(!outDir.exists()){
            outDir.mkdirs();
        }
        File outFile = new File(outDir, fileName);
        XSSFSheet sheet = workbook.createSheet("sheet1");
        XSSFRow header = sheet.createRow(0);

        Field[] fields = clazz.getDeclaredFields();
        int size = fields.length;
        for (int i = 0; i < size; i++) {
            header.createCell(i).setCellValue(fields[i].getName());
        }

        int index = 1;
        for (T object : objects) {
            XSSFRow row = sheet.createRow(index);
            for (int i = 0; i < size; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    row.createCell(i).setCellValue(value.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            index++;
        }

        workbook.write(Files.newOutputStream(outFile.toPath()));
        workbook.close();
    }

}
