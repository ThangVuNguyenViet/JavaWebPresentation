/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.daos.tours;

import java.util.ArrayList;
import java.util.List;
import thang.connection.MyConnection;
import thang.daos.BaseDAO;
import thang.dtos.tours.TourDTO;

/**
 *
 * @author Thang
 */
public class TourDAO extends BaseDAO {

    public List<TourDTO> findByLikeTourName(String search) throws Exception {
        List<TourDTO> result = new ArrayList<>();
        TourDTO dto;
        try {
            String sql = "Select tourId, tourName, tourDuration, tourOrigin, tourDes, description, imgUrl From Tour "
                    + "Where tourName LIKE ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                int tourId = rs.getInt("tourId");
                String tourName = rs.getString("tourName");
                int tourDuration = rs.getInt("tourDuration");
                String tourOrigin = rs.getString("tourOrigin");
                String tourDes = rs.getString("tourDes");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
                dto = new TourDTO(tourId, tourName, tourOrigin, tourDes, tourDuration, description, imgUrl);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String tourId) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Tour Set isDelete = 1 Where tourId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tourId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(TourDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Tour(tourName, tourDuration, tourOrigin, tourDes, description, imgUrl, isDelete) "
                    + "values(?,?,?,?,?,?,0)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTourName());
            preStm.setInt(2, dto.getTourDuration());
            preStm.setString(3, dto.getTourOrigin());
            preStm.setString(4, dto.getTourDes());
            preStm.setString(5, dto.getDescription());
            preStm.setString(6, dto.getImgUrl());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(TourDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Tour set tourName = ?, tourDuration = ?, tourOrigin = ?, tourDes = ?, description = ?, imgUrl = ? "
                    + "Where tourId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, dto.getTourName());
            preStm.setInt(2, dto.getTourDuration());
            preStm.setString(3, dto.getTourOrigin());
            preStm.setString(4, dto.getTourDes());
            preStm.setString(5, dto.getDescription());
            preStm.setString(6, dto.getImgUrl());
            preStm.setInt(7, dto.getTourId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public TourDTO findByTourId(int tourId) throws Exception {
        TourDTO dto = null;
        try {
            String sql = "Select tourName, tourDuration, tourOrigin, tourDes, description, imgUrl From Tour "
                    + "Where tourId = ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, tourId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String tourName = rs.getString("tourName");
                int tourDuration = rs.getInt("tourDuration");
                String tourOrigin = rs.getString("tourOrigin");
                String tourDes = rs.getString("tourDes");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
                dto = new TourDTO(tourId, tourName, tourOrigin, tourDes, tourDuration, description, imgUrl);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<TourDTO> findAvailableTourByLikeTourName(String search) throws Exception {
        List<TourDTO> result = new ArrayList<>();
        TourDTO dto;
        try {
            String sql = "Select tourId, tourName, tourDuration, tourOrigin, tourDes, description, imgUrl From Tour "
                    + "Where tourName LIKE ? "
                    + "And tourId IN "
                    + " (Select tourId From Ticket "
                    + " Where isDelete = 0 "
                    + " And startDate >= GETDATE() "
                    + " And ticketLeft > 0) "
                    + "And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                int tourId = rs.getInt("tourId");
                String tourName = rs.getString("tourName");
                int tourDuration = rs.getInt("tourDuration");
                String tourOrigin = rs.getString("tourOrigin");
                String tourDes = rs.getString("tourDes");
                String description = rs.getString("description");
                String imgUrl = rs.getString("imgUrl");
                dto = new TourDTO(tourId, tourName, tourOrigin, tourDes, tourDuration, description, imgUrl);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkIfTourInTicket(int tourId) throws Exception {
        boolean check = false;
        try {
            String sql = "Select ticketId From Ticket Where tourId = ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, tourId);
            rs = preStm.executeQuery();
            check = rs.next();
        } finally {
            closeConnection();
        }
        return check;
    }
}
