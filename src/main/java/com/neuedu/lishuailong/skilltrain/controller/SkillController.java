package com.neuedu.lishuailong.skilltrain.controller;

import com.alibaba.excel.EasyExcel;
import com.neuedu.lishuailong.skilltrain.config.MyConfig;
import com.neuedu.lishuailong.skilltrain.listener.UserDataListener;
import com.neuedu.lishuailong.skilltrain.model.Member;
import com.neuedu.lishuailong.skilltrain.model.User;
import com.neuedu.lishuailong.skilltrain.service.MemberService;
import com.neuedu.lishuailong.skilltrain.service.UserService;
import com.neuedu.lishuailong.skilltrain.utils.ContentTypeUtil;
import com.neuedu.lishuailong.skilltrain.utils.FileOperateUtils;
import com.neuedu.lishuailong.skilltrain.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


@Slf4j
@RequestMapping("/skill")
@Api(tags = "技能控制器")
@RestController
@CrossOrigin
public class SkillController {

//    @Value("${sk.storage.localPath}")
//    private String LOCAL_PATH;

    @PostMapping("/upload")
    @ApiOperation("上传功能")
    public String upload(@RequestPart("file") MultipartFile file){
        //上传文件名称
        String name = file.getOriginalFilename();
        //上传文件扩展名
        String ext = FilenameUtils.getExtension(name);
        //校验扩展名
        if (StringUtils.isBlank(ext)) {
            return "扩展名不能为空。";
        }
        //检查上传路径“D:/upload/doc/2022/06/”
        String dirPath = FileOperateUtils.checkDirectory(file);
        // A->AA.doc : B->AA.doc？？？ A,B->自己的AA.doc
        //转换上传文件名称（保证唯一不重复）
        String fileName = UUID.randomUUID() + "." + ext;
        //创建上传文件对象（路径+文件名）
        File newFile = new File(dirPath, fileName); //"D:/upload/doc/2022/06/42742HU3JR.doc"


        //传输文件
        try {
            // A:0000111.....B:0000111
            //传输文件
            file.transferTo(newFile);
            //获取上传路径，保证上传路径灵活可用
            String uploadPath = newFile.getAbsolutePath().replaceAll("\\\\", "/").replaceAll(MyConfig.getLocalPath(), "");
            //"/doc/2022/06/42742HU3JR.doc"
            //返回上传路径，根据需要修改业务库表数据
            return uploadPath;
        } catch (IOException e) {
            e.printStackTrace();
            //返回统一的异常错误
            return e.getMessage();
        }
    }

    @ApiOperation("下载")
    @GetMapping(path = "/download")
    public void download(@RequestParam("path") String filePathEncoded,
                         @RequestParam(name = "fileName", required = false) String fileName){
        //获取到响应对象response
        HttpServletResponse response = ResponseUtil.getResponse();

        //文件下载名称，如果不指定，直接获取数据库文件名称
        //"D:/upload/doc/2022/06/42742HU3JR.doc"
        if (StringUtils.isEmpty(fileName)) {
            String[] args = filePathEncoded.split("/");
            fileName = args[args.length - 1];
        }
        //设置响应头
        String fileRealName = fileName;
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileRealName.replace("+", "%20"));

        //获取下载文件类型
        String contentType = ContentTypeUtil.getContentTypeByFileName(filePathEncoded);
        if (StringUtils.isNotBlank(contentType)) {
            response.setContentType(contentType);
        }

        //拼接根路径，开始写流
        File file = new File(MyConfig.getLocalPath() + FileOperateUtils.decode(filePathEncoded));
        //输入输出流对象，从服务器读取下载的文件，写入到本地下载的位置
        FileInputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();
            byte[] readBytes = new byte[1024];
            int read = 0;
            while ((read = inputStream.read(readBytes)) != -1) {
                outputStream.write(readBytes, 0, read);
                outputStream.flush();
            }

        } catch (Exception e) {
            log.error("下载异常：" + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ApiOperation("下载模板")
    @PostMapping("/downloadModel")
    public void downloadModel(HttpServletResponse response) {
        //获取到响应对象response
        // HttpServletResponse response = ResponseUtil.getResponse();
        try {
            //获取当前工程资源路径
            Resource resource = new ClassPathResource("/templates/User.xlsx");
            //下载文件命名
            String filename = "成员导入模板.xlsx";

            InputStream inputStream = resource.getInputStream();
            OutputStream out = response.getOutputStream();
            // 使用URLEncoder来防止文件名乱码或者读取错误
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + URLEncoder.encode(filename, CharEncoding.UTF_8));

            int b = 0;
            int length = 0;
            byte[] buffer = new byte[4096];
            while (b != -1) {
                b = inputStream.read(buffer);
                if (b != -1) {
                    length += b;
                    out.write(buffer, 0, b);
                }
            }
            response.setHeader("Content-Length", String.valueOf(length));
            inputStream.close();
            out.close();
            out.flush();
            log.info("下载成功");
        } catch (IOException e) {
            log.error("下载失败：" + e.getMessage());
        }
    }

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;

    @PostMapping("/importExcel")
    @ApiOperation("导入Excel")
    public void importExcel(@ModelAttribute MultipartFile file){
        try {
            EasyExcel.read(file.getInputStream(), User.class,new UserDataListener(userService)).sheet().doRead();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("导出excel")
    @PostMapping("/exportExcel")
    public void exportExcel(){
        //Member参数用于条件查询携带的参数。
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
        //创建临时文件
        File file;
        //要保存的文件名
        String filename = "User导出信息" + ".xlsx";
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        String path = rootDir + File.separator + "tempfile";
        File saveDir = new File(path);
        if (!saveDir.exists()) {
            saveDir.mkdirs();// 如果文件不存在则创建文件夹
        }
        //文件路径
        path = path + File.separator + filename;
        file = new File(path);   //初始化临时文件
        //导出全部Member数据
        List<User> memberExportList = userService.list();
        if (memberExportList == null) {
//            throw new SkException("没有需要导出的数据");
            log.error("没有需要导出的数据");
            return;
        }
        //写入Excel
        EasyExcel.write(file, User.class).sheet("模板").doWrite(memberExportList);
        //输出文件
        try {
            // 清空response
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.setHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream;charset=UTF-8");
            //导出文件
            try (FileInputStream inputStream = new FileInputStream(file)) {
                OutputStream outputStream = response.getOutputStream();
                int b = 0;
                byte[] buffer = new byte[10240];
                while (b != -1) {
                    b = inputStream.read(buffer);
                    if (b != -1) outputStream.write(buffer, 0, b);
                }
                outputStream.close();
                outputStream.flush();
            }
        } catch (Exception e) {
            log.error("Export file error", e);
        } finally {
            // 删除临时文件
            if (file.exists() && !file.delete()) {
                log.error("delete temp file error");
            }
        }


    }

}
