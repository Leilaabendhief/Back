package tn.esprit.piDev.entities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.piDev.entities.enumerations.EmployementType;

public class ExcelReader {

    public List<ExcelData> readExcelFile(MultipartFile multipartFile) throws IOException, ParseException {
        List<ExcelData> dataList = new ArrayList<>();
        DateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format for database

        Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        for (Row row : sheet) {
            Date closingDate = row.getCell(0).getDateCellValue();

            EmployementType employmentType = null;
            Cell employmentTypeCell = row.getCell(1);
            if (employmentTypeCell != null) {
                String employmentTypeStr = employmentTypeCell.getStringCellValue();
                try {
                    employmentType = EmployementType.valueOf(employmentTypeStr.toLowerCase());
                } catch (IllegalArgumentException e) {
                    // Handle invalid enum value
                    System.err.println("Invalid employment type: " + employmentTypeStr);
                }
            }

            String location = null;
            Cell locationCell = row.getCell(2);
            if (locationCell != null) {
                location = locationCell.getStringCellValue();
            }

            String offerDescription = null;
            Cell offerDescriptionCell = row.getCell(3);
            if (offerDescriptionCell != null) {
                offerDescription = offerDescriptionCell.getStringCellValue();
            }

            String offerStatus = null;
            Cell offerStatusCell = row.getCell(4);
            if (offerStatusCell != null) {
                offerStatus = offerStatusCell.getStringCellValue();
            }

            String offerTitle = null;
            Cell offerTitleCell = row.getCell(5);
            if (offerTitleCell != null) {
                offerTitle = offerTitleCell.getStringCellValue();
            }

            Date postingDate = row.getCell(6).getDateCellValue();

            ExcelData data = new ExcelData();
            data.setLocation(location);
            data.setClosing_date(closingDate);
            data.setEmployment_type(employmentType);
            data.setOffer_title(offerTitle);
            data.setOffer_status(offerStatus);
            data.setOffer_description(offerDescription);
            data.setPosting_date(postingDate);

            dataList.add(data);
        }


        workbook.close();
        return dataList;
    }
}
