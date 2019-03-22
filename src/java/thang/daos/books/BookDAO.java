/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.daos.books;

import java.util.ArrayList;
import java.util.List;
import thang.connection.MyConnection;
import thang.daos.BaseDAO;
import thang.dtos.books.BookDTO;
import thang.dtos.books.BookDetailDTO;

/**
 *
 * @author Thang
 */
public class BookDAO extends BaseDAO {

    public List<BookDTO> findByTicketId(int ticketId) throws Exception {
        List<BookDTO> result = new ArrayList<>();
        try {
            String sql = "Select bookId, username, adultQuant, childQuant From Book "
                    + "Where ticketId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, ticketId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                String username = rs.getString("username");
                int adultQuant = rs.getInt("adultQuant");
                int childQuant = rs.getInt("childQuant");
                BookDTO dto = new BookDTO(bookId, ticketId, adultQuant, childQuant, username);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public BookDTO findByBookId(int bookId) throws Exception {
        BookDTO dto = null;
        try {
            String sql = "Select ticketId, username, adultQuant, childQuant From Book "
                    + "Where bookId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, bookId);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int ticketId = rs.getInt("ticketId");
                String username = rs.getString("username");
                int adultQuant = rs.getInt("adultQuant");
                int childQuant = rs.getInt("childQuant");
                dto = new BookDTO(bookId, ticketId, adultQuant, childQuant, username);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<BookDetailDTO> findByLikeTourName(String search) throws Exception {
        List<BookDetailDTO> result = new ArrayList<>();
        try {
            String sql = "SELECT b.bookId, b.ticketId, t.tourName, ti.startDate, b.username, b.adultQuant, b.childQuant, ti.priceChild, ti.priceAdult\n"
                    + "FROM Book b, Ticket ti, Tour t\n"
                    + "WHERE t.tourName LIKE ?\n"
                    + "AND t.tourId = ti.tourId\n"
                    + "AND b.ticketId = ti.ticketId";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                int ticketId = rs.getInt("ticketId");
                String username = rs.getString("username");
                int adultQuant = rs.getInt("adultQuant");
                int childQuant = rs.getInt("childQuant");
                int priceAdult = rs.getInt("priceAdult");
                int priceChild = rs.getInt("priceChild");
                String tourName = rs.getString("tourName");
                String startDate = rs.getString("startDate");
                BookDetailDTO detailDto = new BookDetailDTO(bookId, ticketId, adultQuant, childQuant, username, tourName, startDate);
                detailDto.setPriceAdult(priceAdult);
                detailDto.setPriceChild(priceChild);
                detailDto.setTotal(priceAdult * adultQuant + priceChild + childQuant);
                result.add(detailDto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    /*public boolean delete(int bookId) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete from Book Where bookId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, bookId);
            boolean isDeleted = preStm.executeUpdate() > 0;
            if (isDeleted) {
                sql = "Update Ticket set ticketLeft = ticketLeft + "
                        + "(Select quantity from Book where bookId = ?) "
                        + "Where ticketId = "
                        + "(Select ticketId from Book Where bookId = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, bookId);
                preStm.setInt(2, bookId);
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }*/
    
    public List<BookDetailDTO> findHistoryByUsername(String username) throws Exception {
        List<BookDetailDTO> result = new ArrayList<>();
        try {
            String sql = "SELECT b.bookId, b.ticketId, t.tourName, ti.startDate, ti.priceAdult, ti.priceChild, b.adultQuant, b.childQuant, t.imgUrl\n"
                    + "FROM Book b, Ticket ti, Tour t\n"
                    + "WHERE b.username = ?\n"
                    + "AND t.tourId = ti.tourId\n"
                    + "AND b.ticketId = ti.ticketId";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                int ticketId = rs.getInt("ticketId");
                int adultQuant = rs.getInt("adultQuant");
                int childQuant = rs.getInt("childQuant");
                int priceAdult = rs.getInt("priceAdult");
                int priceChild = rs.getInt("priceChild");
                String tourName = rs.getString("tourName");
                String startDate = rs.getString("startDate");
                String imgUrl = rs.getString("imgUrl");
                BookDetailDTO detailDto = new BookDetailDTO(bookId, ticketId, adultQuant, childQuant, username, tourName, startDate);
                detailDto.setImgUrl(imgUrl);
                detailDto.setPriceAdult(priceAdult);
                detailDto.setPriceChild(priceChild);
                detailDto.setTotal(priceAdult * adultQuant + priceChild * childQuant);
                result.add(detailDto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(BookDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Book(ticketId, username, adultQuant, childQuant) "
                    + "values(?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getTicketId());
            preStm.setString(2, dto.getUsername());
            preStm.setInt(3, dto.getAdultQuant());
            preStm.setInt(4, dto.getChildQuant());
            boolean isInserted;
            isInserted = preStm.executeUpdate() > 0;

            if (isInserted) {
                sql = "Update Ticket set ticketLeft = ticketLeft - ? "
                        + "Where ticketId = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, dto.getAdultQuant() + dto.getChildQuant());
                preStm.setInt(2, dto.getTicketId());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    /*public boolean update(BookDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Book set ticketId = ?, username = ?, isChild = ?, quantity = ? "
                    + "Where bookId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getTicketId());
            preStm.setString(2, dto.getUsername());
            preStm.setBoolean(3, dto.isChild());
            preStm.setInt(4, dto.getAdultQuant());
            preStm.setInt(5, dto.getBookId());
            boolean isInserted;
            isInserted = preStm.executeUpdate() > 0;

            if (isInserted) {
                sql = "Update Ticket set ticketLeft = ticketLeft - ? + "
                        + "(Select quantity from Book Where bookId = ?) "
                        + "Where ticketId = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, dto.getAdultQuant());
                preStm.setInt(2, dto.getBookId());
                preStm.setInt(3, dto.getTicketId());
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }*/

    public boolean checkIfAdultUserHasBooked(String username, int ticketId) throws Exception {
        boolean check = true;
        try {
            String sql = "Select bookId From Book "
                    + "Where username = ? "
                    + "And ticketId = ? "
                    + "And adultQuant > 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setInt(2, ticketId);
            rs = preStm.executeQuery();
            check = rs.next();
        } finally {
            closeConnection();
        }
        return check;
    }
}
