package com.pmt.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;
//import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.pmt.model.ProductionOrderModel;


public class ExcelAssetGeneralListReportView extends AbstractXlsView {



	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
	
	 String name = Common.getDateCurrent(Common.YYYYMMddHHmmSS)+".xls";
	 response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");
	  
	  @SuppressWarnings("unchecked")
	  List<ProductionOrderModel> list = (List<ProductionOrderModel>) model.get("lstProduction");
	  
	  Sheet sheet = workbook.createSheet("ĐƠN HÀNG");
	  
	  
//	  HSSFCellStyle style = workbook.createCellStyle();
//	  HSSFFont font = workbook.createFont();
////	  font.setFontName(HSSFFont.FONT_ARIAL);
//	  font.setBold(true);
//	  font.setFontName(HSSFFont.FONT_ARIAL);
//	  font.setFontHeightInPoints((short)16);
//	  style.setFont(font);
	  
	  
	  Row header1 = sheet.createRow(1);
	  header1.createCell(0).setCellValue("CÔNG TY TNHH SẢN XUẤT - THƯƠNG MẠI NGỌC MINH");
//	  header1.createCell(0).setCellStyle(style);
	  
	  Row header4 = sheet.createRow(2);
	  header4.createCell(0).setCellValue("GIỜ XUẤT: " + Common.getDateCurrent("HH:mm:ss"));
	  Row header5 = sheet.createRow(3);
	  header5.createCell(0).setCellValue("NGÀY XUẤT: " + Common.getDateCurrent("dd/MM/YYYY"));
	  
	  
	  Row header = sheet.createRow(4);
	  header.createCell(0).setCellValue("STT");
	  header.createCell(1).setCellValue("KHÁCH HÀNG");
	  header.createCell(2).setCellValue("SẢN PHẨM ĐẠI DIỆN");
	  header.createCell(3).setCellValue("ĐƠN HÀNG");
	  header.createCell(4).setCellValue("");
	  header.createCell(5).setCellValue("NGÀY");
	  header.createCell(6).setCellValue("");
	  header.createCell(7).setCellValue("GHI CHÚ");
	  
//	  header.createCell(0).setCellStyle(style);
//	  header.createCell(1).setCellStyle(style);
//	  header.createCell(2).setCellStyle(style);
//	  header.createCell(3).setCellStyle(style);
//	  header.createCell(4).setCellStyle(style);
//	  header.createCell(5).setCellStyle(style);
//	  header.createCell(6).setCellStyle(style);
//	  header.createCell(7).setCellStyle(style);
	  
	  Row header3 = sheet.createRow(5);
	  header3.createCell(0).setCellValue("");
	  header3.createCell(1).setCellValue("");
	  header3.createCell(2).setCellValue("");
	  header3.createCell(3).setCellValue("HD-PO");
	  header3.createCell(4).setCellValue("PSX");
	  header3.createCell(5).setCellValue("NHẬN");
	  header3.createCell(6).setCellValue("GIAO");
	  header3.createCell(7).setCellValue("");
//	  
//	  header3.createCell(0).setCellStyle(style);
//	  header3.createCell(1).setCellStyle(style);
//	  header3.createCell(2).setCellStyle(style);
//	  header3.createCell(3).setCellStyle(style);
//	  header3.createCell(4).setCellStyle(style);
//	  header3.createCell(5).setCellStyle(style);
//	  header3.createCell(6).setCellStyle(style);
//	  header3.createCell(7).setCellStyle(style);
	  
	  sheet.addMergedRegion(new CellRangeAddress(4, 5, 0,0));
	  sheet.addMergedRegion(new CellRangeAddress(4, 5, 1,1));
	  sheet.addMergedRegion(new CellRangeAddress(4, 5, 2,2));
	  
	  sheet.addMergedRegion(new CellRangeAddress(4, 4, 3,4));
	  sheet.addMergedRegion(new CellRangeAddress(4, 4, 5,6));
	  
	  sheet.addMergedRegion(new CellRangeAddress(4, 5, 7,7));
	 
	 
	 
	  									

	  int rowNum = 6;
	  int STT=1;
	  for(ProductionOrderModel user : list){
	   Row row = sheet.createRow(rowNum++);
	   row.createCell(0).setCellValue(STT++);
	   row.createCell(1).setCellValue(user.getCustomerName());
	   row.createCell(2).setCellValue(user.getProduction());
	   row.createCell(3).setCellValue(user.getHD_PO());
	   row.createCell(4).setCellValue(user.getPSX());
	   row.createCell(5).setCellValue(user.getRecieveDt());
	   row.createCell(6).setCellValue(user.getReleaseScheDt());

	  }
	  
	
}



}
