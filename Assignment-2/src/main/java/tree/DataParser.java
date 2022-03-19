package tree;

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
 * A Parser class to read data from the movie dataset found on ImDb.
 * Apache POI is used via the maven dependency and all data is stored in Movie Objects.
 * Data is further parsed into List to store into the BST.
 *
 */
public class DataParser {

    private List<Movie> listMovies;
    private static final String FILEPATH = "src\\main\\resources\\series.xlsx";

    /** Constructs an listMovies as an ArrayList */
    public DataParser() {
        listMovies = new ArrayList<Movie>();
    }

    /**
     * Accessor method to access the listMovies arraylist
     * @return  arraylist of movies populated from the excel file.
     */
    public List<Movie> getListMovies() {
        try {
            readFromExcelFile(FILEPATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listMovies;
    }

    /**
     * Reads movie data from the excel and populated the arraylist
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
            Movie movie = new Movie();

            // read each column value from every row and populate the movie object
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    // read the movie ID and populate into ID field of movie object
                    case 0:
                        movie.setId((String) nextCell.getStringCellValue());
                        break;

                    // read the movie title and populate into title field of movie object
                    case 1:
                        movie.setTitle((String) nextCell.getStringCellValue());
                        break;

                    // read the year of release and populate into yearOfRelease field of movie
                    // object
                    case 2:
                        movie.setYearOfRelease(Integer.parseInt((String) nextCell.getStringCellValue()));
                        break;

                    // read the genre and populate into genre arraylist field of movie object
                    case 3:
                        String genre = (String) nextCell.getStringCellValue();
                        if (genre != null) {
                            String[] genreList = genre.split(",");
                            movie.setGenre(new ArrayList<String>(Arrays.asList(genreList)));
                        }
                        break;

                    // read the duration of movie and populate into duration field of movie object
                    case 4:
                        movie.setDuration((int) nextCell.getNumericCellValue());
                        break;

                    // read the first language in the language column for each movie and populate
                    // into language field of movie object. If a language is null or empty, populate
                    // the default 'English' language.
                    case 5:
                        String language = (String) nextCell.getStringCellValue();
                        if (language == null || language.isEmpty()) {
                            movie.setLanguage("English");
                        } else {
                            String[] languageList = language.split(",");
                            movie.setLanguage(languageList[0]);
                        }
                        break;

                    // read the first two directors of each movie into the directors list of the
                    // movie object
                    case 6:
                        String director = (String) nextCell.getStringCellValue();
                        if (director != null) {
                            String[] directorList = director.split(",");
                            for (int i = 0; i < 2; i++) {
                                if (i < directorList.length && directorList[i] != null) {
                                    movie.addDirectors(directorList[i]);
                                }
                            }
                        }
                        break;

                    // read the first two actors of each movie into the actors list of the movie
                    // object
                    case 7:
                        String actors = (String) nextCell.getStringCellValue();
                        if (actors != null) {
                            String[] actorsList = actors.split(",");
                            for (int i = 0; i < 2; i++) {
                                if (i < actorsList.length && actorsList[i] != null) {
                                    movie.addActors(actorsList[i]);
                                }
                            }
                        }
                        break;

                    // read the average votes into the averageVotes field of the movie object
                    case 8:
                        movie.setAverageVotes((float) nextCell.getNumericCellValue());
                        break;

                    // read the number of voters into the votes field of the movie object
                    case 9:
                        movie.setVotes((int) nextCell.getNumericCellValue());
                        break;

                }
            }
            listMovies.add(movie);
        }

        System.out.println("size of movieList: " + listMovies.size());

        // close the file input stream
        inputStream.close();

    }

}

