import rikkei.acedemy.dao.CandidateDaoImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

public class TestBt2 {
    public static void main(String[] args) {
        CandidateDaoImpl candidateDAO = new CandidateDaoImpl();
        try {
            int candidateId = candidateDAO.addCandidate(
                    "Jane",
                    "Doe",
                    LocalDate.of(1985, 5, 15),
                    "987-654-3210",
                    "jane.doe@example.com",
                    Arrays.asList(1, 2) // List of skill IDs
            );
            System.out.println("Candidate added with ID: " + candidateId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
