import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class DBServlet extends HttpServlet {
    //  用于连接数据库的Connection对象
    protected Connection conn = null;

    //  执行各种SQL语句的方法
    protected ResultSet execSQL(String sql, Object... args)
            throws Exception {
        //  建立PreparedStatement对象
        PreparedStatement pStmt = conn.prepareStatement(sql);
        //  为pStmt对象设置SQL参数值
        for (int i = 0; i < args.length; i++) {
            pStmt.setObject(i + 1, args[i]);
        }

        pStmt.execute();//  执行SQL语句
        return pStmt.getResultSet();  // 返回结果集，如果执行的SQL语句不返回结果集，则返回null
    }

    //  核对用户输入的验证码是否合法
    protected boolean checkValidationCode(HttpServletRequest request, String validationCode) {
        //  从HttpSession对象中获得系统随机生成的验证码
        String validationCodeSession = (String) request.getSession().getAttribute("validation_code");

        //  如果获得的验证码为null，说明验证码过期，用户必须刷新客户端页面，以重新获得新的验证码
        if (validationCodeSession == null) {
            request.setAttribute("info", "验证码过期");//  设置result.jsp需要的结果信息
            request.setAttribute("codeError", "验证码过期");//  设置login.jsp需要我错误信息
            return false;
        }
        //  将用户输入的验证码和系统随机生成的验证码进行比较
        if (!validationCode.equalsIgnoreCase(validationCodeSession)) {
            request.setAttribute("info", "验证码不正确");//  设置result.jsp需要的结果信息
            request.setAttribute("codeError", "验证码不正确");//  设置login.jsp需要我错误信息
            return false;
        }
        return true;
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

        @Override
        public void destroy () {
            try {
                //  如果数据库连接正常打开，关闭它
                if (conn != null)
                    conn.close();
            } catch (Exception e) {

            }
        }

    }
