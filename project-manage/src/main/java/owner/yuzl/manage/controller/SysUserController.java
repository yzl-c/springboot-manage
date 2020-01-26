package owner.yuzl.manage.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import owner.yuzl.manage.common.result.Result;
import owner.yuzl.manage.common.result.ResultFactory;
import owner.yuzl.manage.common.result.ResultPage;
import owner.yuzl.manage.entity.base.BasePage;
import owner.yuzl.manage.entity.base.BaseResultInfo;
import owner.yuzl.manage.entity.base.ResultInfoPage;
import owner.yuzl.manage.entity.po.SysUserPO;
import owner.yuzl.manage.service.SysUserService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Author：yzl_c
 * @Date：2020/1/2 14:45
 * @Description：系统用户Controller
 */
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {
    private Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 跳转主页
     * @return 主页视图
     */
//    @GetMapping(value = "/toIndex")
//    public String toSysUserIndex() {
//        return "manage/sysUser/index";
//    }

    /**
     * 跳转更新系统用户
     * @param id
     * @param model
     * @return 更新视图
     */
//    @GetMapping(value = "/toUpdate")
//    public String toSysUserUpdate(Long id, Model model) {
//        if (!StringUtils.isEmpty(id)) {
//            SysUserPO sysUserPO = sysUserService.getOneById(id);
//            model.addAttribute("sysUser", sysUserPO);
//        }
//        return "manage/sysUser/update";
//    }

    /**
     * 获取用户信息
     * @param id
     * @return 用户信息
     */
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") Long id) {
        if (StringUtils.isEmpty(id)) {
            return ResultFactory.buildFailResult("获取用户信息失败");
        }
        SysUserPO sysUserPO = sysUserService.getOneById(id);
        return ResultFactory.buildSuccessResult(sysUserPO, "获取用户信息成功");
    }

    /**
     * 获取分页查询结果
     * @param queryUser
     * @param pageNum
     * @param pageSize
     * @return 查询结果
     */
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public Result getUsersByPage(SysUserPO queryUser, Integer pageNum, Integer pageSize) {
        long total = sysUserService.countTotal(queryUser);
        List<SysUserPO> dataList = sysUserService.getUsers(queryUser, pageNum, pageSize);
        return ResultFactory.buildSuccessResult(new ResultPage(total, pageNum, dataList), "请求用户列表数据成功");
    }

    /**
     * 执行添加操作
     * @param sysUserPO
     * @return 执行结果
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody SysUserPO sysUserPO) {
        sysUserService.create(sysUserPO);
        return ResultFactory.buildSuccessResult(null, "添加用户成功");
    }

    /**
     * 执行更新操作
     * @param sysUserPO
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody SysUserPO sysUserPO) {
        sysUserService.update(sysUserPO);
        return ResultFactory.buildSuccessResult(null, "更新成功");
    }

    /**
     * 执行删除操作
     * @param id
     * @return 执行结果
     */
    @RequestMapping(value = "/logicDeleteById/{id}", method = RequestMethod.DELETE)
    public Result logicDeleteById(@PathVariable(value = "id") Long id) {
        sysUserService.logicDeleteById(id);
        return ResultFactory.buildSuccessResult(null, "删除成功");
    }

    /**
     * 导出Excel表
     * @param response
     * @return
     */
    @GetMapping(value = "/exportExcel")
    public String exportExcel(HttpServletResponse response) {
        response.reset(); // 清除buffer缓存
        String excelName = "系统用户";
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes(),"iso-8859-1") + localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE) +".xlsx");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook excel = new XSSFWorkbook();
        List<SysUserPO> userList = sysUserService.getPage(null, new BasePage());
        String sheetName = "系统用户-" + localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        XSSFSheet sheet = excel.createSheet(sheetName);
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("账号");
        cell = row.createCell(1);
        cell.setCellValue("用户名");
        cell = row.createCell(2);
        cell.setCellValue("密码");
        for (int i = 0; i < userList.size(); i++) {
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(userList.get(i).getAccount());
            row.createCell(1).setCellValue(userList.get(i).getName());
            row.createCell(2).setCellValue(userList.get(i).getPassword());
        }
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.flush();
            excel.write(bufferedOutputStream);
            bufferedOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 导出pdf
     * @param response
     * @return
     */
    @GetMapping(value = "/exportPdf")
    public String exportPdf(HttpServletResponse response) {
        response.reset(); // 清除buffer缓存
        String pdfName = "系统用户";
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(pdfName.getBytes(),"iso-8859-1") + localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE) +".pdf");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Document document = new Document();
        // 第二步，设置要到出的路径
        //如果是浏览器通过request请求需要在浏览器中输出则使用下面方式
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            // 第三步,设置字符
            try {
                BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
                Font fontZH = new Font(bfChinese, 12.0F, 0);
                // 第四步，将pdf文件输出到磁盘
                PdfWriter writer = PdfWriter.getInstance(document, out);
                // 第五步，打开生成的pdf文件
                document.open();
                // 第六步,设置内容
                String title = "标题";
                document.add(new Paragraph(new Chunk(title, fontZH).setLocalDestination(title)));
                document.add(new Paragraph("\n"));
                // 创建table,注意这里的2是两列的意思,下面通过table.addCell添加的时候必须添加整行内容的所有列
                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(100.0F);
                table.setHeaderRows(1);
                table.getDefaultCell().setHorizontalAlignment(1);
                table.addCell(new Paragraph("账号", fontZH));
                table.addCell(new Paragraph("用户名", fontZH));
                table.addCell(new Paragraph("用密码", fontZH));
                List<SysUserPO> userList = sysUserService.getPage(null, new BasePage());
                for (int i = 0; i < userList.size(); i++) {
                    table.addCell(new Paragraph(userList.get(i).getAccount(), fontZH));
                    table.addCell(new Paragraph(userList.get(i).getName(), fontZH));
                    table.addCell(new Paragraph(userList.get(i).getPassword(), fontZH));
                }
                document.add(table);
                document.add(new Paragraph("\n"));
                // 第七步，关闭document
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("导出pdf成功~");
        return null;
    }
}
