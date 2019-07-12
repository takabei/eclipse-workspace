import com.njupt.sms.beans.Admin;
import com.njupt.sms.beans.Student;
import com.njupt.sms.beans.Teacher;
import com.njupt.sms.ui.HomeAdmin;
import com.njupt.sms.ui.HomeTeacher;
import com.njupt.sms.ui.Login;
import com.njupt.sms.utils.CourseUtils;
import com.njupt.sms.utils.JdbcUtils;
import com.njupt.sms.utils.LoginLogoutUtils;

import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        new Login();
    }

}
