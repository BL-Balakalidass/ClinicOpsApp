import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    public static ArrayList<Doctor> readDoctorsFromCSV(String fileName, int startId) {

        ArrayList<Doctor> doctors = new ArrayList<>();

        int idCounter = startId;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length != 4) {
                    System.out.println("Invalid Record : " + line);
                    continue;
                }

                try {

                    String name = data[0].trim();

                    Specialization specialization =
                            Specialization.valueOf(
                                    data[1].trim().toUpperCase().replace(" ", "_"));

                    int experience =
                            Integer.parseInt(data[2].trim());

                    Shift shift =
                            Shift.valueOf(
                                    data[3].trim().toUpperCase());

                    String doctorId =
                            String.format("D%04d", idCounter++);

                    Doctor doctor =
                            new Doctor(
                                    doctorId,
                                    name,
                                    specialization,
                                    experience,
                                    shift);

                    doctors.add(doctor);

                } catch (IllegalArgumentException e) {

                    System.out.println("Invalid specialization/shift : " + line);

                } catch (Exception e) {

                    System.out.println("Error Reading Record : " + line);

                }

            }

        } catch (IOException e) {

            System.out.println("Unable to open file.");

        }

        return doctors;

    }

}