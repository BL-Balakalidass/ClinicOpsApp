import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class FileHandler {

    /**
     * Reads doctor data from a CSV file using OpenCSV.
     *
     * CSV Format:
     * Name,Specialization,Experience,Shift
     *
     * Example:
     * John,CARDIOLOGY,12,MORNING
     * David,NEUROLOGY,8,EVENING
     */
    public static <CsvValidationException extends Throwable> ArrayList<Doctor> readDoctorsFromCSV(
            String fileName,
            int startId,
            List<Doctor> existingDoctors) {

        ArrayList<Doctor> importedDoctors = new ArrayList<>();

        int doctorCounter = startId;

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {

            String[] record;

            while ((record = csvReader.readNext()) != null) {

                // Skip empty records
                if (record.length == 0) {
                    continue;
                }

                // Validate column count
                if (record.length != 4) {

                    System.out.println("---------------------------------------");
                    System.out.println("Invalid Record Skipped");
                    System.out.println("Reason : Incorrect number of columns");
                    System.out.println("---------------------------------------");
                    continue;
                }

                try {

                    String doctorName = record[0].trim();

                    Specialization specialization =
                            Specialization.valueOf(
                                    record[1]
                                            .trim()
                                            .toUpperCase()
                                            .replace(" ", "_"));

                    int experience =
                            Integer.parseInt(record[2].trim());

                    Shift shift =
                            Shift.valueOf(
                                    record[3]
                                            .trim()
                                            .toUpperCase());

                    String doctorId =
                            String.format("D%04d", doctorCounter);

                    Doctor doctor = new Doctor(
                            doctorId,
                            doctorName,
                            specialization,
                            experience,
                            shift);

                    // Duplicate check against existing doctors
                    if (existingDoctors.contains(doctor)
                            || importedDoctors.contains(doctor)) {

                        System.out.println("---------------------------------------");
                        System.out.println("Duplicate Doctor Skipped");
                        System.out.println("Doctor : " + doctorName);
                        System.out.println("---------------------------------------");

                        continue;
                    }

                    importedDoctors.add(doctor);
                    doctorCounter++;

                }
                catch (IllegalArgumentException e) {

                    System.out.println("---------------------------------------");
                    System.out.println("Invalid Record Skipped");
                    System.out.println("Doctor : " + record[0]);
                    System.out.println("Reason : Invalid Specialization or Shift");
                    System.out.println("---------------------------------------");

                }

            }

        }
        catch (IOException e) {

            System.out.println("---------------------------------------");
            System.out.println("Unable to Read File");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------");

        }


        return importedDoctors;

    }

}