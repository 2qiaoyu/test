package com.joham.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.joham.easyexcel.listen.AfterWriteHandlerImpl;
import com.joham.easyexcel.model.WriteModel;
import com.joham.easyexcel.util.FileUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import static com.joham.easyexcel.util.DataUtil.*;

/**
 * @author qiaoyu
 * https://blog.csdn.net/qq_35206261/article/details/88579151
 */
public class WriteTest {

    public static void main(String[] args) throws IOException {
//        writeV2007();
//        writeExcelOneSheetOnceWrite();
//        writeExcelOneSheetMoreWrite();
        writeExcelMoreSheetMoreWrite();
    }

    public static void writeV2007() throws IOException {
        OutputStream out = new FileOutputStream("/Users/joham/2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");

        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 40000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);

        //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
        sheet2.setTableStyle(createTableStyle());
        //writer.write1(null, sheet2);
        writer.write(createTestListJavaMode(), sheet2);
        //需要合并单元格
        writer.merge(5, 20, 1, 1);

        //写第三个sheet包含多个table情况
        Sheet sheet3 = new Sheet(3, 0);
        sheet3.setSheetName("第三个sheet");
        Table table1 = new Table(1);
        table1.setHead(createTestListStringHead());
        writer.write1(createTestListObject(), sheet3, table1);

        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
        table2.setTableStyle(createTableStyle());
        table2.setClazz(WriteModel.class);
        writer.write(createTestListJavaMode(), sheet3, table2);

        writer.finish();
        out.close();

    }


    public void writeV2007WithTemplate() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("temp.xlsx");
        OutputStream out = new FileOutputStream("/Users/joham/2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriterWithTemp(inputStream, out, ExcelTypeEnum.XLSX, true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");
        sheet1.setStartRow(20);

        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 40000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);

        //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
        sheet2.setTableStyle(createTableStyle());
        sheet2.setStartRow(20);
        writer.write(createTestListJavaMode(), sheet2);

        //写第三个sheet包含多个table情况
        Sheet sheet3 = new Sheet(3, 0);
        sheet3.setSheetName("第三个sheet");
        sheet3.setStartRow(30);
        Table table1 = new Table(1);
        table1.setHead(createTestListStringHead());
        writer.write1(createTestListObject(), sheet3, table1);

        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
        table2.setTableStyle(createTableStyle());
        table2.setClazz(WriteModel.class);
        writer.write(createTestListJavaMode(), sheet3, table2);

        writer.finish();
        out.close();

    }

    public void writeV2007WithTemplateAndHandler() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("temp.xlsx");
        OutputStream out = new FileOutputStream("/Users/jipengfei/2007.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriterWithTempAndHandler(inputStream, out, ExcelTypeEnum.XLSX, true,
                new AfterWriteHandlerImpl());
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");
        sheet1.setStartRow(20);

        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 40000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);

        //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
        sheet2.setTableStyle(createTableStyle());
        sheet2.setStartRow(20);
        writer.write(createTestListJavaMode(), sheet2);

        //写第三个sheet包含多个table情况
        Sheet sheet3 = new Sheet(3, 0);
        sheet3.setSheetName("第三个sheet");
        sheet3.setStartRow(30);
        Table table1 = new Table(1);
        table1.setHead(createTestListStringHead());
        writer.write1(createTestListObject(), sheet3, table1);

        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
        table2.setTableStyle(createTableStyle());
        table2.setClazz(WriteModel.class);
        writer.write(createTestListJavaMode(), sheet3, table2);

        writer.finish();
        out.close();

    }


    public void writeV2003() throws IOException {
        OutputStream out = new FileOutputStream("/Users/joham/2003.xls");
        ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLS, true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个sheet");

        //设置列宽 设置每列的宽度
        Map columnWidth = new HashMap();
        columnWidth.put(0, 10000);
        columnWidth.put(1, 40000);
        columnWidth.put(2, 10000);
        columnWidth.put(3, 10000);
        sheet1.setColumnWidthMap(columnWidth);
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);

        //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
        sheet2.setTableStyle(createTableStyle());
        writer.write(createTestListJavaMode(), sheet2);

        //写第三个sheet包含多个table情况
        Sheet sheet3 = new Sheet(3, 0);
        sheet3.setSheetName("第三个sheet");
        Table table1 = new Table(1);
        table1.setHead(createTestListStringHead());
        writer.write1(createTestListObject(), sheet3, table1);

        //写sheet2  模型上打有表头的注解
        Table table2 = new Table(2);
        table2.setTableStyle(createTableStyle());
        table2.setClazz(WriteModel.class);
        writer.write(createTestListJavaMode(), sheet3, table2);

        writer.finish();
        out.close();
    }

    /**
     * 针对较少的记录数(20W以内大概)可以调用该方法一次性查出然后写入到EXCEL的一个SHEET中
     * 注意： 一次性查询出来的记录数量不宜过大，不会内存溢出即可。
     * excel2010最大支持1048576行
     * 14秒
     *
     * @throws IOException
     */
    public static void writeExcelOneSheetOnceWrite() throws IOException {
        long time = System.currentTimeMillis();
        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("/Users/apple/projects/my/test/单次写入.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("sheet1");

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("用户ID"));
        titles.add(Arrays.asList("名称"));
        titles.add(Arrays.asList("年龄"));
        titles.add(Arrays.asList("生日"));
        table.setHead(titles);

        // 查询数据导出即可 比如说一次性总共查询出100条数据
        List<List<String>> userList = new ArrayList<>();
        for (int i = 0; i < 1048575; i++) {
            userList.add(Arrays.asList("ID_" + i, "小明" + i, String.valueOf(i), new Date().toString()));
        }

        writer.write0(userList, sheet, table);
        writer.finish();
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }

    /**
     * 针对105W以内的记录数可以调用该方法分多批次查出然后写入到EXCEL的一个SHEET中
     * 注意：
     * 每次查询出来的记录数量不宜过大，根据内存大小设置合理的每次查询记录数，不会内存溢出即可。
     * 数据量不能超过一个SHEET存储的最大数据量105W
     * 14秒
     *
     * @throws IOException
     */
    public static void writeExcelOneSheetMoreWrite() throws IOException {
        long time = System.currentTimeMillis();
        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("/Users/apple/projects/my/test/多次写入.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("sheet1");

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("用户ID"));
        titles.add(Arrays.asList("名称"));
        titles.add(Arrays.asList("年龄"));
        titles.add(Arrays.asList("生日"));
        table.setHead(titles);

        // 模拟分批查询：总记录数50条，每次查询20条，  分三次查询 最后一次查询记录数是10
        Integer totalRowCount = 1048575;
        Integer pageSize = 10000;
        Integer writeCount = totalRowCount % pageSize == 0 ? (totalRowCount / pageSize) : (totalRowCount / pageSize + 1);


        // 注： 此处仅仅为了模拟数据，实用环境不需要将最后一次分开，合成一个即可， 参数为： currentPage = i+1;  pageSize = pageSize
        for (int i = 0; i < writeCount; i++) {

            // 前两次查询 每次查20条数据
            if (i < writeCount - 1) {
                List<List<String>> userList = new ArrayList<>();
                for (int j = 0; j < pageSize; j++) {
                    userList.add(Arrays.asList("ID_" + Math.random(), "小明", String.valueOf(Math.random()), new Date().toString()));
                }
                writer.write0(userList, sheet, table);
            } else if (i == writeCount - 1) {
                List<List<String>> userList = new ArrayList<>();
                Integer lastWriteRowCount = totalRowCount - (writeCount - 1) * pageSize;
                for (int j = 0; j < lastWriteRowCount; j++) {
                    userList.add(Arrays.asList("ID_" + Math.random(), "小明", String.valueOf(Math.random()), new Date().toString()));
                }
                writer.write0(userList, sheet, table);
            }
        }
        writer.finish();
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }

    /**
     * 针对几百万的记录数可以调用该方法分多批次查出然后写入到EXCEL的多个SHEET中
     * 注意：
     * perSheetRowCount % pageSize要能整除  为了简洁，非整除这块不做处理
     * 每次查询出来的记录数量不宜过大，根据内存大小设置合理的每次查询记录数，不会内存溢出即可。
     * 33秒
     *
     * @throws IOException
     */
    public static void writeExcelMoreSheetMoreWrite() throws IOException {
        long time = System.currentTimeMillis();
        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("/Users/apple/projects/my/test/多SHEET写入.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET名称
        String sheetName = "测试SHEET";

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("用户ID"));
        titles.add(Arrays.asList("名称"));
        titles.add(Arrays.asList("年龄"));
        titles.add(Arrays.asList("生日"));
        table.setHead(titles);

        // 模拟分批查询：总记录数250条，每个SHEET存100条，每次查询20条  则生成3个SHEET，前俩个SHEET查询次数为5， 最后一个SHEET查询次数为3 最后一次写的记录数是10
        // 注：该版本为了较少数据判断的复杂度，暂时perSheetRowCount要能够整除pageSize， 不去做过多处理  合理分配查询数据量大小不会内存溢出即可。
        Integer totalRowCount = 3000000;
        Integer perSheetRowCount = 1000000;
        Integer pageSize = 10000;
        Integer sheetCount = totalRowCount % perSheetRowCount == 0 ? (totalRowCount / perSheetRowCount) : (totalRowCount / perSheetRowCount + 1);
        Integer previousSheetWriteCount = perSheetRowCount / pageSize;
        Integer lastSheetWriteCount = totalRowCount % perSheetRowCount == 0 ?
                previousSheetWriteCount :
                (totalRowCount % perSheetRowCount % pageSize == 0 ? totalRowCount % perSheetRowCount / pageSize : (totalRowCount % perSheetRowCount / pageSize + 1));

        for (int i = 0; i < sheetCount; i++) {

            // 创建SHEET
            Sheet sheet = new Sheet(i, 0);
            sheet.setSheetName(sheetName + i);

            if (i < sheetCount - 1) {

                // 前2个SHEET, 每个SHEET查5次 每次查20条 每个SHEET写满100行  2个SHEET合计200行  实用环境：参数： currentPage: j+1 + previousSheetWriteCount*i, pageSize: pageSize
                for (int j = 0; j < previousSheetWriteCount; j++) {
                    List<List<String>> userList = new ArrayList<>();
                    for (int k = 0; k < 10000; k++) {
                        userList.add(Arrays.asList("ID_" + Math.random(), "小明", String.valueOf(Math.random()), new Date().toString()));
                    }
                    writer.write0(userList, sheet, table);
                }

            } else if (i == sheetCount - 1) {

                // 最后一个SHEET 实用环境不需要将最后一次分开，合成一个即可， 参数为： currentPage = i+1;  pageSize = pageSize
                for (int j = 0; j < lastSheetWriteCount; j++) {

                    // 前俩次查询 每次查询20条
                    if (j < lastSheetWriteCount - 1) {

                        List<List<String>> userList = new ArrayList<>();
                        for (int k = 0; k < 10000; k++) {
                            userList.add(Arrays.asList("ID_" + Math.random(), "小明", String.valueOf(Math.random()), new Date().toString()));
                        }
                        writer.write0(userList, sheet, table);

                    } else if (j == lastSheetWriteCount - 1) {

                        // 最后一次查询 将剩余的10条查询出来
                        List<List<String>> userList = new ArrayList<>();
                        Integer lastWriteRowCount = totalRowCount - (sheetCount - 1) * perSheetRowCount - (lastSheetWriteCount - 1) * pageSize;
                        for (int k = 0; k < lastWriteRowCount; k++) {
                            userList.add(Arrays.asList("ID_" + Math.random(), "小明1", String.valueOf(Math.random()), new Date().toString()));
                        }
                        writer.write0(userList, sheet, table);

                    }
                }
            }
        }
        writer.finish();
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }
}
