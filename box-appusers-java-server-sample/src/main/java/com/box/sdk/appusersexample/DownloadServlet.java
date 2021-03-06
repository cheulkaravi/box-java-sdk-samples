package com.box.sdk.appusersexample;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.box.sdk.BoxFile;
import com.helpers.BoxHelper;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        String boxFileId = request.getParameter("id");
        String boxAppUserId = BoxHelper.getBoxAppUserId(request);
        if (boxAppUserId == null) { // session timeout. force login again.
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        URL downloadUrl;
        BoxFile boxFile = new BoxFile(BoxHelper.userClient(boxAppUserId), boxFileId);
        downloadUrl = boxFile.getDownloadURL();
        response.sendRedirect(downloadUrl.toString());
    }
}
