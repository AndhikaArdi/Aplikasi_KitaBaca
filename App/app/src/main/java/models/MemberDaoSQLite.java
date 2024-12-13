package models;

import entities.Member;
import helpers.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoSQLite implements MemberDAO {
    @Override
    public void addMember(Member member) throws SQLException {
        String query = "INSERT INTO members (name, address, phone_number, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getAddress());
            stmt.setString(3, member.getPhoneNumber());
            stmt.setString(4, member.getEmail());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateMember(Member member) throws SQLException {
        String query = "UPDATE members SET name = ?, address = ?, phone_number = ?, email = ? WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getAddress());
            stmt.setString(3, member.getPhoneNumber());
            stmt.setString(4, member.getEmail());
            stmt.setInt(5, member.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMember(int id) throws SQLException {
        String query = "DELETE FROM members WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Member getMemberById(int id) throws SQLException {
        String query = "SELECT * FROM members WHERE id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Member> searchMembers(String keyword) throws SQLException {
        String query = "SELECT * FROM members WHERE name LIKE ? OR email LIKE ? OR id = ?";
        List<Member> members = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            try {
                int id = Integer.parseInt(keyword);
                stmt.setInt(3, id);
            } catch (NumberFormatException e) {
                stmt.setInt(3, -1);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    members.add(new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                    ));
                }
            }
        }
        return members;
    }

    @Override
    public List<Member> listMembers() throws SQLException {
        String query = "SELECT * FROM members";
        List<Member> members = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    members.add(new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                    ));
                }
            }
        }
        return members;
    }
}
