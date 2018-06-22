package com.weichi.erp.tool;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.logging.LogFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Wewon on 2018/5/23 9:42
 */
public class MyBatisGen {
    // 改成要生成的表名称，%通配符，支持 [fnd_%],如果连接的数据库、项目的包结构不变，只需改这里就能自动生成domain、xml文件
    private static final String TABLENAME = "user_group";

    private static final String BASEPACKAGE = "com.weichi.erp";

    private static Properties prop = new Properties();


    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();
        String filename = "/application.properties";

        try {
            prop.load(MyBatisGen.class.getResourceAsStream(filename));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Load “" + filename + "” file error.");
        }

        confMysql(config);
        // confOracle(config);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String s : warnings) {
            LogFactory.getLog(MyBatisGen.class).debug(s);
        }
    }

    public static void confMysql(Configuration config) throws IOException {
        String projectPath = ResourceUtils.getFile("classpath:").getAbsolutePath();
        projectPath = projectPath.substring(0, projectPath.indexOf(getPropString("artifactId")));
        projectPath += getPropString("artifactId") + File.separator + "src" + File.separator + "main";
        System.out.println("文件路径：" + projectPath);

        Context context = new Context(ModelType.CONDITIONAL);
        context.setId("mysql_test");

        // 配置数据库连接
        JDBCConnectionConfiguration connectionConf = new JDBCConnectionConfiguration();
        connectionConf.setConnectionURL(getPropString("spring.datasource.url"));
        connectionConf.setDriverClass("com.mysql.jdbc.Driver");
        connectionConf.setUserId(getPropString("spring.datasource.username"));
        connectionConf.setPassword(getPropString("spring.datasource.password"));
        context.setJdbcConnectionConfiguration(connectionConf);

        // 配置javamodel
        JavaModelGeneratorConfiguration modelGeneratorConf = new JavaModelGeneratorConfiguration();
        modelGeneratorConf.setTargetPackage(BASEPACKAGE + ".domain");
        modelGeneratorConf.setTargetProject(projectPath + File.separator + "java");
        modelGeneratorConf.addProperty("enableSubPackages", "true");
        context.setJavaModelGeneratorConfiguration(modelGeneratorConf);

        // 配置生成Sql Mapper接口
        JavaClientGeneratorConfiguration clientGeneratorConf = new JavaClientGeneratorConfiguration();
        clientGeneratorConf.setTargetPackage(BASEPACKAGE + ".dao");
        clientGeneratorConf.setTargetProject(projectPath + File.separator + "java");
        clientGeneratorConf.setConfigurationType("MAPPER");
        context.setJavaClientGeneratorConfiguration(clientGeneratorConf);

        // 配置SqlMapper
        SqlMapGeneratorConfiguration sqlMapGeneratorConf = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConf.setTargetPackage("mapper");
        sqlMapGeneratorConf.setTargetProject(projectPath + File.separator + "resources");
        sqlMapGeneratorConf.addProperty("enableSubPackages", "true");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConf);

        // 配置tables
        TableConfiguration tableConf = new TableConfiguration(context);
        tableConf.setTableName(TABLENAME);
        // 关闭自动生成example
        tableConf.setSelectByExampleStatementEnabled(false);
        tableConf.setUpdateByExampleStatementEnabled(false);
        tableConf.setCountByExampleStatementEnabled(false);
        tableConf.setDeleteByExampleStatementEnabled(false);

        // 关闭自动生成增删改（如果增删改查都关闭，就不会自动生成dao、domain等文件，所以保留自动生成查询语句 ，可以通过不生成主键来不让查询语句生成）
        tableConf.setInsertStatementEnabled(false);
        tableConf.setDeleteByPrimaryKeyStatementEnabled(false);
        tableConf.setUpdateByPrimaryKeyStatementEnabled(false);

        //不用生成的列
        IgnoredColumn ignoredColumn = new IgnoredColumn("insert_username");
        tableConf.addIgnoredColumn(ignoredColumn);
        IgnoredColumn ignoredColumn2 = new IgnoredColumn("insert_time");
        tableConf.addIgnoredColumn(ignoredColumn2);
        IgnoredColumn ignoredColumn3 = new IgnoredColumn("update_username");
        tableConf.addIgnoredColumn(ignoredColumn3);
        IgnoredColumn ignoredColumn4 = new IgnoredColumn("update_time");
        tableConf.addIgnoredColumn(ignoredColumn4);
        IgnoredColumn ignoredColumn5 = new IgnoredColumn("id");
        tableConf.addIgnoredColumn(ignoredColumn5);

//        tableConf.setSelectByPrimaryKeyStatementEnabled(false);

        //tableConf.setDomainObjectName("ReceiptSnapshot");
        context.addTableConfiguration(tableConf);
        config.addContext(context);
    }

    /**
     * 获取字符串属性
     *
     * @param key
     * @return
     */
    private static String getPropString(String key) {
        return prop == null ? null : prop.getProperty(key);
    }

}
