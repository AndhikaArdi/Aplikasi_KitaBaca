package models;

import entities.Member;
import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {
    
    public void addMember(Member member) throws SQLException;
    public void updateMember(Member member) throws SQLException;
    public void deleteMember(int id) throws SQLException;
    public Member getMemberById(int id) throws SQLException;
    public List<Member> searchMembers(String keyword) throws SQLException;
    public List<Member> listMembers() throws SQLException;
    
}
