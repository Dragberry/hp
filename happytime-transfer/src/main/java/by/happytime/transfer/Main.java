package by.happytime.transfer;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-transfer.xml");
        Importer importer = context.getBean(ExcelImporter.class);
        File file = new File("D:\\Шары.xls");
        FileInputStream is = new FileInputStream(file);
        try {
            importer.doImport(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
        context.close();
    }

}
