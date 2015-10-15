package com.smt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Huangyipeng on 2015/10/09.
 */
@RestController
public class PDFFileController {

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public void downloadPDFFile(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        fileName = fileName + ".pdf";
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "download/" + fileName)) {
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
