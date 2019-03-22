 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.daos.tickets;

import java.util.ArrayList;
import java.util.List;
import thang.connection.MyConnection;
import thang.daos.BaseDAO;
import thang.dtos.tickets.TicketDTO;
import thang.dtos.tickets.TicketDetailDTO;

/**
 *
 * @author Thang
 */
public class TicketDAO extends BaseDAO {

    public List<TicketDTO> findByTourId(int tourId) throws Exception {
        List<TicketDTO> result = new ArrayList<>();
        try {
            String sql = "Select ticketId, startDate, ticketLeft, priceAdult, priceChild From Ticket "
                    + "Where tourId = ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, tourId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                int ticketId = rs.getInt("ticketId");
                String startDate = rs.getString("startDate");
                int ticketLeft = rs.getInt("ticketLeft");
                int priceAdult = rs.getInt("priceAdult");
                int priceChild = rs.getInt("priceChild");
                TicketDTO dto = new TicketDTO(ticketId, tourId, startDate, priceAdult, priceChild, ticketLeft);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public TicketDTO findByTicketId(int ticketId) throws Exception {
        TicketDTO dto = null;
        try {
            String sql = "Select tourId, startDate, ticketLeft, priceAdult, priceChild From Ticket "
                    + "Where ticketId = ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ticketId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                int tourId = rs.getInt("tourId");
                String startDate = rs.getString("startDate");
                int ticketLeft = rs.getInt("ticketLeft");
                int priceAdult = rs.getInt("priceAdult");
                int priceChild = rs.getInt("priceChild");
                dto = new TicketDTO(ticketId, tourId, startDate, priceAdult, priceChild, ticketLeft);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public TicketDetailDTO findTicketDetailByTicketId(int ticketId) throws Exception {
        TicketDetailDTO dto = null;
        try {
            String sql = "Select t.tourId, t.tourName, t.imgUrl, ti.startDate, ti.ticketLeft, ti.priceAdult, ti.priceChild "
                    + "From Ticket ti, Tour t "
                    + "Where ti.ticketId = ? "
                    + "And ti.tourId = t.tourId "
                    + "And ti.isDelete = 0 "
                    + "And ti.startDate >= GETDATE() "
                    + "And ti.ticketLeft > 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ticketId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String startDate = rs.getString("startDate");
                int ticketLeft = rs.getInt("ticketLeft");
                int priceAdult = rs.getInt("priceAdult");
                int priceChild = rs.getInt("priceChild");
                int tourId = rs.getInt("tourId");
                String tourName = rs.getString("tourName");
                String imgUrl = rs.getString("imgUrl");
                dto = new TicketDetailDTO(startDate, tourName, imgUrl, ticketLeft, priceAdult, priceChild, ticketId, tourId);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean delete(String ticketId) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Ticket Set isDelete = 1 Where ticketId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, ticketId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteByTourId(String tourId) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Ticket Set isDelete = 1 Where tourId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, tourId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(TicketDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Ticket(tourId, startDate, ticketLeft, priceAdult, priceChild) "
                    + "values(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getTourId());
            preStm.setString(2, dto.getStartDate());
            preStm.setInt(3, dto.getTicketLeft());
            preStm.setInt(4, dto.getPriceAdult());
            preStm.setInt(5, dto.getPriceChild());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(TicketDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Ticket set tourId = ?, startDate = ?, ticketLeft = ?, priceAdult = ?, priceChild = ? "
                    + "Where ticketId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getTourId());
            preStm.setString(2, dto.getStartDate());
            preStm.setInt(3, dto.getTicketLeft());
            preStm.setInt(4, dto.getPriceAdult());
            preStm.setInt(5, dto.getPriceChild());
            preStm.setInt(6, dto.getTicketId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<TicketDetailDTO> findAvailableTicketDetail(int tourId) throws Exception {
        List<TicketDetailDTO> result = new ArrayList<>();
        try {
            String sql = "Select ti.ticketId, t.tourName, t.imgUrl, ti.startDate, ti.ticketLeft, ti.priceAdult, ti.priceChild "
                    + "From Ticket ti, Tour t "
                    + "Where ti.tourId = ? "
                    + "And ti.tourId = t.tourId "
                    + "And ti.isDelete = 0 "
                    + "And ti.startDate >= GETDATE() "
                    + "And ti.ticketLeft > 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, tourId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                int ticketId = rs.getInt("ticketId");
                String startDate = rs.getString("startDate");
                int ticketLeft = rs.getInt("ticketLeft");
                int priceAdult = rs.getInt("priceAdult");
                int priceChild = rs.getInt("priceChild");
                String tourName = rs.getString("tourName");
                String imgUrl = rs.getString("imgUrl");
                TicketDetailDTO dto = new TicketDetailDTO(startDate, tourName, imgUrl, ticketLeft, priceAdult, priceChild, ticketId, tourId);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public int findTicketLeftByTicketId(int ticketId) throws Exception {
        int ticketLeft = 0;
        try {
            String sql = "Select ticketLeft from Ticket "
                    + "Where ticketId = ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ticketId);
            rs = preStm.executeQuery();
            if (rs.next())
                ticketLeft = rs.getInt("ticketLeft");
        } finally {
            closeConnection();
        }
        return ticketLeft;
    }
    
    public boolean checkIfTicketAlreadyBooked(int ticketId) throws Exception {
        boolean check = false;
        try {
            String sql = "Select bookId From Book Where ticketId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ticketId);
            rs = preStm.executeQuery();
            check = rs.next();
        } finally {
            closeConnection();
        }
        return check;
    }
}
