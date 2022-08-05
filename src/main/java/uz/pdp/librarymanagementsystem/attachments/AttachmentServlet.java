package uz.pdp.librarymanagementsystem.attachments;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static uz.pdp.librarymanagementsystem.utils.Util.UPLOAD_DIRECTORY;

@WebServlet("/files/*")
public class AttachmentServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String fileName = pathParts[1];
//     //   String fileName = pathParts[2];


        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        resp.setHeader("Content-Transfer-Encoding", "binary");

        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(resp.getOutputStream());
            FileInputStream inputStream = new FileInputStream(UPLOAD_DIRECTORY + fileName);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();
            resp.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


