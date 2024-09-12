package rikkei.acedemy.dao;

import ra.mvc.configorutil.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CandidateDaoImpl {

    public int addCandidate(String firstName, String lastName, LocalDate dob, String phone, String email, List<Integer> skillIds) throws SQLException {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement csCandidate = null;
        CallableStatement csCandidateSkills = null;
        int candidateId = -1;

        try {
            conn.setAutoCommit(false); // Start transaction

            // 1. Insert candidate
            String insertCandidateSQL = "{call insertCandidate(?, ?, ?, ?, ?, ?)}";
            csCandidate = conn.prepareCall(insertCandidateSQL);
            csCandidate.setString(1, firstName);
            csCandidate.setString(2, lastName);
            csCandidate.setDate(3, java.sql.Date.valueOf(dob));
            csCandidate.setString(4, phone);
            csCandidate.setString(5, email);
            csCandidate.registerOutParameter(6, java.sql.Types.INTEGER); // Register the OUT parameter
            csCandidate.executeUpdate();

            // Get generated candidate ID
            candidateId = csCandidate.getInt(6); // Retrieve the generated candidate ID

            if (candidateId <= 0) {
                throw new SQLException("Failed to obtain candidate ID.");
            }

            // 2. Insert candidate_skills
            String insertCandidateSkillsSQL = "{call insertCandidateSkills(?, ?)}";
            csCandidateSkills = conn.prepareCall(insertCandidateSkillsSQL);

            for (Integer skillId : skillIds) {
                csCandidateSkills.setInt(1, candidateId);
                csCandidateSkills.setInt(2, skillId);
                csCandidateSkills.addBatch();
            }
            csCandidateSkills.executeBatch();

            conn.commit(); // Commit transaction
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Rollback
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true); // Restore default auto-commit behavior
                conn.close();
            }
        }

        return candidateId;
    }
}
