package wm1_backend.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wm1_backend.model.User;
import wm1_backend.web.user.UserRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


public class UserServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private UserRestController userController;



    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        userController = springContext.getBean(UserRestController.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                userController.delete(id);
                response.sendRedirect("users");
                break;
            case "create":
            case "update":
                final User user = "create".equals(action) ?
                        new User() :
                        userController.getById(getId(request));
                request.setAttribute("user", user);
                request.getRequestDispatcher("/userForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("users", userController.getAll());
                request.getRequestDispatcher("/users.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            User user = new User(
                    request.getParameter(request.getParameter("name")),
                    request.getParameter("lastName"),
                    request.getParameter("patronymic"),
                    Integer.parseInt(request.getParameter("amountOfInvestment")),
                    Integer.parseInt(request.getParameter("amountOfRisk")),
                    Integer.parseInt(request.getParameter("term")),
                    request.getParameter("comments"));

            if (request.getParameter("id").isEmpty()) {
                userController.create(user);
            } else {
                userController.update(user);
            }
            response.sendRedirect("users");

        } else if ("filter".equals(action)) {
            int amountOfInvestment = Integer.parseInt(request.getParameter("amountOfInvestment"));
            int amountOfRisk = Integer.parseInt(request.getParameter("amountOfRisk"));

            request.setAttribute("users", userController.getFilterList(amountOfInvestment, amountOfRisk));
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
