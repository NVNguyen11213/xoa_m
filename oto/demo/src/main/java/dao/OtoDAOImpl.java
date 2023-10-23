package dao;

import model.Oto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtoDAOImpl implements OtoDAO{
    private static String DELETE_OTO = "UPDATE oto SET `delete` = 1 WHERE id = ?";
    private static String UPDATE_OTO= "UPDATE oto SET name = ?, company = ?, yearOfProduction = ? WHERE id = ?";
    private static String ADD_OTO = "INSERT INTO oto (id, name, company, yearOfProduction) VALUES (  ?, ?, ?, ?)";
    private static String SELECT_ALL = "SELECT * FROM oto WHERE `delete` = 0";
    private static String GET_OTO_BY_ID = "SELECT * FROM oto WHERE id = ?";
    @Override
    public List<Oto> getAll() {
        List<Oto> otoList = new ArrayList<>();
        Connection conn = null;
        try{
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Oto oto = new Oto(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("company"),
                  rs.getInt("yearOfProduction"));
                otoList.add(oto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return otoList;
    }

    @Override
    public void create(Oto oto) {

        Connection conn = null;
        try{
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(ADD_OTO);
            pstmt.setInt(1, oto.getId());
            pstmt.setString(2,oto.getName());
            pstmt.setString(3, oto.getCompany());
            pstmt.setInt(4, oto.getYearOfProduction());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try{
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public void update(Oto oto, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_OTO);
            pstmt.setString(1,oto.getName());
            pstmt.setString(2,oto.getCompany());
            pstmt.setInt(3,oto.getYearOfProduction());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try{
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public void deleteOto(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(DELETE_OTO);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException("delete is flase");
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }

    }

    @Override
    public Oto getById(int id) {
        Oto oto = null;
        Connection conn = null;
        try{
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(GET_OTO_BY_ID);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                oto = new Oto(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("company"),
                        rs.getInt("yearOfProduction"));
            }
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return oto;
    }
}
