package by.it_academy.jd2.Mk_JD2_82_21.Forma.controller;

import by.it_academy.jd2.Mk_JD2_82_21.Forma.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "QuizServlet", urlPatterns = "/")
public class QuizServlet extends HttpServlet {

    private final VoteService service;

    public QuizServlet() {
        this.service = VoteService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        req.getRequestDispatcher("/views/forma.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artist = req.getParameter("artist");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        this.service.addVote(artist, genres, about);

        Map<String, Integer> artistResult = this.service.getArtistResult();
        Map<String, Integer> genreResult = this.service.getGenreResult();
        List<String> aboutResult = this.service.getAboutResult();

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        for (Map.Entry<String, Integer> entry : artistResult.entrySet()) {
            switch (entry.getKey()) {
                case "1":
                    writer.write("Ирина Олегрова");
                    break;
                case "2":
                    writer.write("Каста");
                    break;
                case "3":
                    writer.write("Луна");
                    break;
                case "4":
                    writer.write("Иванушки");
                    break;
            }
            writer.write(String.valueOf(entry.getValue()));
        }
        for (Map.Entry<String, Integer> entry : genreResult.entrySet()) {
            switch (entry.getKey()) {
                case "1":
                    writer.write("Рок");
                    break;
                case "2":
                    writer.write("Поп");
                    break;
                case "3":
                    writer.write("Фолк");
                    break;
                case "4":
                    writer.write("Альт");
                    break;
                case "5":
                    writer.write("Клкассика");
                    break;
                case "6":
                    writer.write("Джаз");
                    break;
                case "7":
                    writer.write("Тиктоник");
                    break;
            }
            writer.write(String.valueOf(entry.getValue()));
        }
        Stream<String> stream = aboutResult.stream();
        stream
                .forEach(element -> {
                    writer.write(String.join("", aboutResult));
                });


    }
}


