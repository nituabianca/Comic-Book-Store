package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.Constants;

public class ComicBookRepository implements ComicBookRepositoryInterface
{
	//@Override
    public void insertLine(String csvLine) {
        FileWriter fileWriter = null;
        try 
        {
            fileWriter = new FileWriter(Constants.CSV_FILE_NAME, true);
            fileWriter.append(Constants.NEW_LINE_SEPARATOR);
            fileWriter.append(csvLine);

            System.out.println("Comicbook adaugat cu succes!");
        } 
        catch (Exception e) 
        {
            System.out.println("Eroare in CsvFileWriter!");
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                fileWriter.flush();
                fileWriter.close();
            } 
            catch (Exception e) 
            {
                System.out.println("Eroare la inchiderea fileWriter!!");
                e.printStackTrace();
            }
        }
    }
    
        @Override
        public List<String> readCsv() {
            try {
                List<String> records = new ArrayList<>();
                try (BufferedReader bf = new BufferedReader(new FileReader(Constants.CSV_FILE_NAME))) 
                {
                    String line;
                    boolean firstLineFlag = false;
                    while ((line = bf.readLine()) != null) 
                    {
                        if (!firstLineFlag) 
                        {
                            firstLineFlag = true;
                            continue;
                        }
                        records.add(line);
                    }
                }
                return records;
            } catch (IOException e) {
                System.out.println("Error while reading CSV file!");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void deleteLine(int comicId) {
            BufferedReader br = null;
            StringBuilder sb = null;
            try {
                br = new BufferedReader(new FileReader(Constants.CSV_FILE_NAME));
                sb = new StringBuilder();
                String line;
                boolean firstLineFlag = true;
                while ((line = br.readLine()) != null) {
                    if (firstLineFlag) {
                        firstLineFlag = false;
                        sb.append(line);
                        sb.append(Constants.NEW_LINE_SEPARATOR);
                    } else {
                        String[] lineValues = line.split(Constants.COMMA_DELIMITER);
                        if (Integer.parseInt(lineValues[0]) != comicId) {
                            sb.append(line);
                            sb.append((Constants.NEW_LINE_SEPARATOR));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Eroare la stergere!");
                try {
                    br.close();
                } catch (IOException ioE) {
                    ioE.printStackTrace();
                }
            }
            writeAllInfoToDatabase(sb);
        }
        public void updateLine(int comicBookeId, String comicBookDetails) {
            BufferedReader br = null;
            StringBuilder sb = null;
            try{
                br = new BufferedReader(new FileReader(Constants.CSV_FILE_NAME));
                sb = new StringBuilder();
                String line;
                boolean firstLineFlag = true;
                while((line = br.readLine()) != null){
                    if(firstLineFlag){
                        firstLineFlag = false;
                        sb.append(line);
                        sb.append(Constants.NEW_LINE_SEPARATOR);
                    }else{
                        String[] lineValues = line.split(Constants.COMMA_DELIMITER);
                        if(Integer.parseInt(lineValues[0]) == comicBookeId){
                            sb.append(comicBookDetails);
                            sb.append(Constants.NEW_LINE_SEPARATOR);
                        }else{
                            sb.append(line);
                            sb.append(Constants.NEW_LINE_SEPARATOR);
                        }
                    }
                }
            } catch(Exception e){
                System.out.println("Eroare la actualizare!");
            }finally {
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            writeAllInfoToDatabase(sb);
        }
        private void writeAllInfoToDatabase(StringBuilder sb) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(new File(Constants.CSV_FILE_NAME));
                fw.write(sb.toString());
            } catch (Exception e) {
                System.out.println("Eroare la scrierea in fisier dupa stergere!");
                e.printStackTrace();
            }finally {
                try {
                    if(fw != null) {
                        fw.flush();
                        fw.close();
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }   
    }
}
