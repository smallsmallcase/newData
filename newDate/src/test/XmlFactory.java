package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by huhui on 2017/12/3.
 */
public class XmlFactory {

    private static Properties properties;
    private static DatabaseMetaData metaData;
    private static Connection connection;
    private static final String nameSpace = "com.njupt";
    private static final String pathProfix = "newDate/src/com/njupt/";
    static {
        try {
            InputStream in = XmlFactory.class.getResourceAsStream("//db.properties");
            properties = new Properties();
            properties.load(in);
            Class.forName(properties.getProperty("jdbc.driverClassName"));
            connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password"));
            metaData = connection.getMetaData();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException, IOException {
        XmlFactory xmlFactory = new XmlFactory();
        Set<String> tableNames = xmlFactory.getTableNames();
       /* for (String tableName : tableNames) {
            produce(tableName,xmlFactory);
        }*/
       produce("MarryHistory",xmlFactory);


    }

    private static void produce(String tableName,XmlFactory xmlFactory) throws SQLException, IOException {
        Set<String> columnNames = xmlFactory.getColumnNames(tableName);
        System.out.println(columnNames);
        String primaryKey = xmlFactory.getPrimaryKey(tableName);
        columnNames.remove(primaryKey);
        generationXML(tableName, columnNames,primaryKey);
        generationDao(tableName);
        generationService(tableName);
    }

    public void generationDataMapping()throws SQLException, IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        StringBuilder text = new StringBuilder();
        XmlFactory xmlFactory = new XmlFactory();
        Set<String> tableNames = xmlFactory.getTableNames();
        for (String tableName : tableNames) {
            text.append("private final String[]"+tableName+"Eng={");
            Set<String> columnNames = xmlFactory.getColumnNames(tableName);
            String primaryKey = xmlFactory.getPrimaryKey(tableName);
            columnNames.remove(primaryKey);
            columnNames.remove("basic_id");
            for (String columnName:columnNames) {
                text.append("\"").append(columnName).append("\",");
            }
            text.append("};\n");
            text.deleteCharAt(text.lastIndexOf(","));
        }
        fileOutputStream.write(text.toString().getBytes());
    }

    private static void generationService(String tableName) throws IOException {
        String servicePath = pathProfix+"service/"+tableName+"Service.java";
        File file = createNewFile(servicePath);
        StringBuilder serviceContext = new StringBuilder();
        
        serviceContext.append(
                "package com.njupt.service;\n" +
                "\n" +
                "import com.njupt.dao.").append(tableName).append("Dao;\n" +
                "import com.njupt.po.").append(tableName).append(";\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "import org.springframework.transaction.annotation.Transactional;\n" +
                "\n" +
                "import java.util.List;\n\n"+
                "/**\n" +
                " * Created by huhui on 2017/12/4.\n" +
                " */\n" +
                "@Service(\"").append(tableName).append("Service\")\n" +
                "@Transactional\n" +
                "public class ").append(tableName).append("Service implements BasicService<").append(tableName).append("> {\n" +
                "    @Autowired\n" +
                "    private ").append(tableName).append("Dao templateDao;\n" +
                "\n" +
                "    public ").append(tableName).append(" insert(").append(tableName).append(" item) {\n" +
                "        return templateDao.insert(item);\n" +
                "    }\n" +
                "\n" +
                "    public List<").append(tableName).append(">").append(" query(").append(tableName).append(" item) {\n" +
                "        return templateDao.query(item);\n" +
                "    }\n" +
                "\n" +
                "    public void update(").append(tableName).append(" item) {\n" +
                "        templateDao.update(item);\n" +
                "    }\n" +
                "\n" +
                "    public void delete(").append(tableName).append(" item) {\n" +
                "        templateDao.delete(item);\n" +
                "    }\n" +
                "}\n"
        );
        
        writeFile(file,serviceContext.toString());
    }

    private static void generationDao(String tableName) throws IOException {
        String daoPath = pathProfix+"dao/"+tableName+"Dao.java";
        String daoImplPath = pathProfix+"dao/"+tableName+"DaoImpl.java";
        File daoFile = createNewFile(daoPath);
        File daoImplFile = createNewFile(daoImplPath);
        StringBuilder daoTextContext = new StringBuilder();
        StringBuilder daoImplTextContext = new StringBuilder();
        
        daoTextContext.append("package com.njupt.dao;\n").append("import java.util.List;\n\n").append("import com.njupt.po.").append(tableName).append(";\n\n")
                .append("/**\n")
                .append(" * Created by huhui on 2017/12/4.\n")
                .append(" */\n" )
                .append("public interface ").append(tableName).append("Dao {\n" )
                .append("    ").append(tableName).append(" insert(").append(tableName).append(" item);\n")
                .append("\n    List<").append(tableName).append(">").append(" query(").append(tableName).append(" item);\n\n")
                .append("    void update(").append(tableName).append(" item);\n\n")
                .append( "    void delete(").append(tableName).append(" item);\n")
                .append("\n}\n");

        daoImplTextContext.append("package com.njupt.dao;\n" +
                "\n" +
                "import com.njupt.po.").append(tableName).append(";\n" +
                "import org.mybatis.spring.SqlSessionTemplate;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Repository;\n" +
                "import java.util.List;"+
                "\n" +
                "/**\n" +
                " * Created by huhui on 2017/12/4.\n" +
                " */\n" +
                "@Repository\n" +
                "public class ").append(tableName).append("DaoImpl implements ").append(tableName).append("Dao {\n" +
                "    @Autowired\n" +
                "    private SqlSessionTemplate sqlsession;\n" +
                "\n" +
                "    @Override\n" +
                "    public ").append(tableName).append(" insert(").append(tableName).append(" item) {\n" +
                "        sqlsession.insert(\"").append(nameSpace).append(".").append(tableName).append(".save").append(tableName).append("\",item);\n" +
                "        return item;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public List<").append(tableName).append(">").append(" query(").append(tableName).append(" item) {\n" +
                "        return sqlsession.selectList(\"").append(nameSpace).append(".").append(tableName).append(".query").append(tableName).append("\",item);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void update(").append(tableName).append(" item) {\n" +
                "        sqlsession.update(\"").append(nameSpace).append(".").append(tableName).append(".update").append(tableName).append("\",item);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void delete(").append(tableName).append(" item) {\n" +
                "        sqlsession.delete(\"").append(nameSpace).append(".").append(tableName).append(".delete").append(tableName).append("\",item);\n" +
                "    }\n" +
                "}\n");


        writeFile(daoFile, daoTextContext.toString());
        writeFile(daoImplFile, daoImplTextContext.toString());
    }

    private static void generationXML(String tableName, Set<String> columnNames,String primaryKey) throws IOException {
        
        String path = pathProfix+"po/mapping/"+tableName+".xml";
        File file = createNewFile(path);

        /**将表的列名连成串*/
        StringBuilder nameCol = new StringBuilder();
        StringBuilder nameBracket = new StringBuilder();
        for (String name : columnNames) {
            nameCol.append(name).append(",\n                ");
            nameBracket.append(String.format("#{%s},\n              ", name));
        }
        if (nameCol.length() != 0) {
            nameCol = nameCol.deleteCharAt(nameCol.lastIndexOf(","));
        }
        if (nameBracket.length() != 0) {
            nameBracket = nameBracket.deleteCharAt(nameBracket.lastIndexOf(","));
        }
        String nameColAndPrimaryKey = new StringBuilder(nameCol).append(",").append(primaryKey).toString();
        String nameBracketAndPrimaryKey = new StringBuilder(nameBracket).append(",").append(String.format("#{%s}",primaryKey)).toString();

        /**将表的列名连成if test形式的串*/
        StringBuilder selectByIfTest = new StringBuilder();
        for (String name : columnNames) {
            selectByIfTest
                    .append(
                            "            <if test=\"")
                    .append(name)
                    .append(" != null\">\n")
                    .append("                and ")
                    .append(name)
                    .append(" = #{")
                    .append(name)
                    .append("}\n")
                    .append( "            </if>\n");

        }
        String selectByIfTestAndPrimaryKey = new StringBuilder(selectByIfTest).append(
                "            <if test=\"")
                .append(primaryKey)
                .append(" != null\">\n")
                .append("                and ")
                .append(primaryKey)
                .append(" = #{")
                .append(primaryKey)
                .append("}\n")
                .append( "            </if>\n").toString();




        StringBuilder textContent = new StringBuilder();


        textContent.append(

                /**文件格式*/
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                        "<!DOCTYPE mapper    PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n" +
                        "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                        "\n")
                .append("<mapper namespace=\"").append(nameSpace).append(".")
                .append(tableName)
                .append("\">\n")


                /**向数据库插入数据*/
                .append("    <insert id=\"save")
                .append(tableName)
                .append("\" useGeneratedKeys=\"true\" keyProperty=\"")
                .append(primaryKey)
                .append("\" parameterType=\"com.njupt.po.")
                .append(tableName)
                .append("\">\n")
                .append(String.format("        insert into %s(\n                ", tableName))
                .append(nameCol)
                .append("        \n        ) values(\n              ")
                .append(nameBracket)
                .append(")\n")
                .append("    </insert>\n\n")

                /**从数据库查询数据*/
                .append("<select id=\"query")
                .append(tableName)
                .append("\" parameterType=\"com.njupt.po.")
                .append(tableName)
                .append("\" resultType=\"com.njupt.po.")
                .append(tableName)
                .append("\">\n")
                .append("        SELECT ").append(nameColAndPrimaryKey).append("\n")
                .append("        from ")
                .append(tableName).append("\n")
                .append("        <trim prefix=\"where\" prefixOverrides=\"and\">\n")
                .append(selectByIfTestAndPrimaryKey)
                .append("        </trim>\n    </select>\n\n")

                /**更新数据*/
                .append("<update id=\"update")
                .append(tableName)
                .append("\" parameterType=\"com.njupt.po.")
                .append(tableName)
                .append("\">\n")
                .append("        UPDATE ").append(tableName).append("\n" )
                .append("        <trim prefix=\"set\" suffix=\"where ")
                .append(primaryKey).append(" = #{")
                .append(primaryKey)
                .append("}\"  prefixOverrides=\",\">\n").append(selectByIfTest.toString().replaceAll(" and ",","))
                .append("        </trim>\n    </update>\n\n")

                /**删除数据*/
                .append(" <delete id=\"delete")
                .append(tableName)
                .append("\" parameterType=\"com.njupt.po.")
                .append(tableName)
                .append("\">\n")
                .append("        delete from ")
                .append(tableName)
                .append(" WHERE ")
                .append(primaryKey)
                .append(" = #{")
                .append(primaryKey)
                .append( "}\n    </delete>\n\n")


                .append(" </mapper>");


        writeFile(file, textContent.toString());
    }

    private static File createNewFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    private static void writeFile(File file, String textContent) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(textContent.getBytes());
    }

    /**
     * 获取数据库所有表的名称
     *
     * @return set 表名
     * @throws SQLException
     */
    private Set<String> getTableNames() throws SQLException {
        HashSet<String> result = new LinkedHashSet<>();
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"table"});
        while (tables.next()) {
            result.add(tables.getString(3));
        }
        return result;
    }

    /**
     * 获取指定表的主键
     *
     * @param tableName 表名
     * @return 主键名称
     * @throws SQLException
     */
    private String getPrimaryKey(String tableName) throws SQLException {
        String returnValue = null;
        ResultSet result = metaData.getPrimaryKeys(null, null, tableName);
        while (result.next()) {
            returnValue = result.getString(4);
        }
        return returnValue;
    }

    /**
     * 获取指定表的列名
     *
     * @param tableName 表名
     * @return 列名结合
     * @throws SQLException
     */
    private Set<String> getColumnNames(String tableName) throws SQLException {
        HashSet<String> returnValue = new LinkedHashSet<>();
        PreparedStatement preparedStatement = connection.prepareStatement(String.format("select * from %s limit 1", tableName));
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData rMetaData = resultSet.getMetaData();
        int columnCount = rMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rMetaData.getColumnName(i);
            returnValue.add(columnName);
        }
        return returnValue;
    }
}
