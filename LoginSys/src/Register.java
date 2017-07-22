import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by twx on 2017/5/4.
 */
public class Register extends DBServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login") != null) {
            response.sendRedirect("login.jsp");
            return;
        }
        super.service(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String validation_code = request.getParameter("validation_code");

        request.setAttribute("page","register.jsp");

        if (username == null || password == null || validation_code == null) {
            return;
        }
        if (username.equals("")||password.equals(""))
            return;

        if (!checkValidationCode(request,validation_code))
            return;

        email = (email==null)?"":email;

        try {
            String passwordMD5 = Encrypter.md5Encrypt(password);
            String sql = "insert into t_users(user_name,password_md5,email) values(?,?,?)";
            execSQL(sql,username,passwordMD5,email);
            request.setAttribute("info","用户注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("info",username+"已被注册");
        }finally {
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
    }
}
