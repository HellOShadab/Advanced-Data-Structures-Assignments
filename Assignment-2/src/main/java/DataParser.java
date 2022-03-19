import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation to read from series.xlsx and populate the listTVSeries arraylist.
 * This arraylist is used further to populate the tree.
 *
 * @author Shadab Khan
 *
 */
public class DataParser {

    private List<TVSeries> listTVSeries;
    private static final String FILEPATH = "src\\main\\resources\\series.xlsx";

    /** Constructs an listseries as an ArrayList */
    public DataParser() {
        listTVSeries = new ArrayList<TVSeries>();
    }

    /**
     * Accessor method to access the listseries arraylist
     * @return  arraylist of series populated from the excel file.
     */
    public List<TVSeries> getListSeries() {
        try {
            readFromExcelFile(FILEPATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listTVSeries;
    }

    /**
     * Reads series data from the excel and populated the arraylist
     * @param excelFilePath  file path of the excel
     * @throws IOException	 when the file is not found
     */
    private void readFromExcelFile(String excelFilePath) throws IOException {
        // read the input excel file
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        // read the workbook from the imputed file
        Workbook workbook = new XSSFWorkbook(inputStream);

        // read the first sheet of the excel
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        // iterate over each row (ignoring the header row)
        iterator.next();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            TVSeries series = new TVSeries();

            // read each column value from every row and populate the series object
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    // read the series ID and populate into ID field of series object
                    case 0:
                        series.setId((String) nextCell.getStringCellValue());
                        break;

                    // read the series title and populate into title field of series object
                    case 1:
                        series.setTitle((String) nextCell.getStringCellValue());
                        break;

                    // read the year of release and populate into yearOfRelease field of series
                    // object
                    case 2:
                        series.setYearOfRelease(Integer.parseInt((String) nextCell.getStringCellValue()));
                        break;

                    // read the genre and populate into genre arraylist field of series object
                    case 3:
                        String genre = (String) nextCell.getStringCellValue();
                        if (genre != null) {
                            String[] genreList = genre.split(",");
                            series.setGenre(new ArrayList<String>(Arrays.asList(genreList)));
                        }
                        break;

                    // read the duration of series and populate into duration field of series object
                    case 4:
                        series.setDuration((int) nextCell.getNumericCellValue());
                        break;

                    // read the first language in the language column for each series and populate
                    // into language field of series object. If a language is null or empty, populate
                    // the default 'English' language.
                    case 5:
                        String language = (String) nextCell.getStringCellValue();
                        if (language == null || language.isEmpty()) {
                            series.setLanguage("English");
                        } else {
                            String[] languageList = language.split(",");
                            series.setLanguage(languageList[0]);
                        }
                        break;

                    // read the first two directors of each series into the directors list of the
                    // series object
                    case 6:
                        String director = (String) nextCell.getStringCellValue();
                        if (director != null) {
                            String[] directorList = director.split(",");
                            for (int i = 0; i < 2; i++) {
                                if (i < directorList.length && directorList[i] != null) {
                                    series.addDirectors(directorList[i]);
                                }
                            }
                        }
                        break;

                    // read the first two actors of each series into the actors list of the series
                    // object
                    case 7:
                        String actors = (String) nextCell.getStringCellValue();
                        if (actors != null) {
                            String[] actorsList = actors.split(",");
                            for (int i = 0; i < 2; i++) {
                                if (i < actorsList.length && actorsList[i] != null) {
                                    series.addActors(actorsList[i]);
                                }
                            }
                        }
                        break;

                    // read the average votes into the averageVotes field of the series object
                    case 8:
                        series.setAverageVotes((float) nextCell.getNumericCellValue());
                        break;

                    // read the number of voters into the votes field of the series object
                    case 9:
                        series.setVotes((int) nextCell.getNumericCellValue());
                        break;

                }
            }
            listTVSeries.add(series);
        }

        System.out.println("size of seriesList: " + listTVSeries.size());

        // close the file input stream
        inputStream.close();

    }

}

