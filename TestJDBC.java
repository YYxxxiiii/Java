
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    private static void testInsert() throws SQLException {
        // 0. 准备工作, 需要先在数据库中创建好数据库和数据表
        // 1. 创建 DataSource 对象, 这个对象是 "程序级" , 每个程序创建一个 DataSource 对象即可.
        //    "单例"
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性, 为和数据库建立链接做准备.
        //    MySQL 是个服务器. 要想访问 MySQL, 需要知道 MySQL 的 ip 地址, 端口号,
        //    以及要访问的数据库名, 以及用户名和密码.
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java15_0506?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");
        // 3. 创建 Connection 对象, 用来表示和数据库建立了一次链接.
        Connection connection = dataSource.getConnection();
        // 4. 如果链接建立的没啥问题, 就可以操作数据库了. 核心就是拼装 SQL 语句
        //    ?  是占位符, 可以把具体的变量替换到 ? 位置上.
        //    此处 SQL 是可以没有 ; 的.
        //    拼装 SQL 并没有真的执行 SQL.
        String sql = "insert into student values(?, ?)";
        // statement 用来辅助拼装 SQL 的, setXXX 的类型需要和数据库表的类型匹配.
        // ? 的下标从 1 开始计算
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "蔡徐坤");
        statement.setInt(2, 20);
        System.out.println(statement);
        // 5. 执行 SQL
        int ret = statement.executeUpdate();
        System.out.println(ret);
        // 6. 释放相关资源, 一定是先释放 statement, 再释放 Connection, 顺序不嫩搞错.
        statement.close();
        connection.close();
    }

    private static void testSelect() throws SQLException {
        // 0. 还是准备好库和表
        // 1. 创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性, 为和数据库建立链接做准备.
        //    MySQL 是个服务器. 要想访问 MySQL, 需要知道 MySQL 的 ip 地址, 端口号,
        //    以及要访问的数据库名, 以及用户名和密码.
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java15_0506?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2222");
        // 3. 建立链接
        Connection connection = dataSource.getConnection();
        // 4. 拼装 SQL 语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5. 此处没有 ? , 不需要替换, 直接执行即可
        //    resultSet 中就包含了查询结果
        ResultSet resultSet = statement.executeQuery();
        // 6. 遍历结果集合
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + ": " + age);
        }
        // 7. 释放资源, 顺序不能颠倒. 先被创建的对象要后释放.
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        testSelect();
    }
}
