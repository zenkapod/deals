package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import domain.Deal;
import domain.VerietyDeal;
/**
* Класс реализации функций взаимодействия с базой данных для таблицы
persons
* (Сотрудники)
*/
public class DealDbDAO implements RepositoryDAO<Deal> {
// SQL-запросы к таблице persons базы данных
private static final String select_all_person = "SELECT id, ticker, typedeal, currency, verietyid FROM deals ORDER BY id ASC";
private static final String select_person_ById = "SELECT id, verietyid, ticker, typedeal, currency FROM deals WHERE id = ?";
private static final String insert_person = "INSERT INTO deals(verietyid, ticker, typedeal, currency) VALUES(?,?,?,?)";
private static final String edit_person = "UPDATE deals SET verietyid = ?, ticker = ?, typedeal = ?, currency = ? WHERE id = ?";
private static final String delete_person = "DELETE FROM deals WHERE id = ?";
// Создание соединения с базой данных
Connection connection = DbConnectionBuilder.getConnection();

VerietyDbDAO dao = new VerietyDbDAO();
public DealDbDAO() {
// TODO Auto-generated constructor stub
}
@Override
public Long insert (Deal deal) throws Exception {
try (
PreparedStatement pst = connection.prepareStatement(insert_person, new String[] { "id" })) {
Long Id = -1L;
pst.setLong(1, deal.getIdVeriety());
pst.setString(2, deal.getTicker());
pst.setString(3, deal.getType());
pst.setString(4, deal.getCurrency());
pst.executeUpdate();
ResultSet gk = pst.getGeneratedKeys();
if (gk.next()) {
Id = gk.getLong("id");
}
gk.close();
return Id;
} catch (SQLException e) {
throw new Exception(e);
}
}
@Override
public void update(Deal deal) throws Exception {
try (PreparedStatement pst = connection.prepareStatement(edit_person)) {
	pst.setLong(1, deal.getIdVeriety());
pst.setString(2, deal.getTicker());
pst.setString(3, deal.getType());
pst.setString(4, deal.getCurrency());
pst.setLong(5, deal.getId());
pst.executeUpdate();
} catch (SQLException e) {
throw new Exception(e);
}
}
@Override
public void delete(Long Id) throws Exception {
try (PreparedStatement pst = connection.prepareStatement(delete_person)) {
pst.setLong(1, Id);
pst.executeUpdate();
} catch (SQLException e) {
throw new Exception(e);
}
}
@Override
public Deal findById(Long Id) throws Exception {
Deal deal = null;
try (
PreparedStatement pst = connection.prepareStatement(select_person_ById)){
pst.setLong(1, Id);

ResultSet rs = pst.executeQuery();
if (rs.next()) {
deal = fillDeal(rs);
}
rs.close();
pst.close();
} catch (SQLException e) {
throw new Exception(e);
}
return deal;
}
@Override
public List<Deal> findAll() throws Exception {
List<Deal> list = new LinkedList<>();
try (
PreparedStatement pst = connection.prepareStatement(select_all_person);
ResultSet rs = pst.executeQuery()) {
while (rs.next()) {
list.add(fillDeal(rs));
}
rs.close();
} catch (SQLException e) {
throw new Exception(e);
}
return list;
}
private Deal fillDeal(ResultSet rs) throws SQLException, Exception {
	Long idVeriety = rs.getLong("verietyid");
Deal deal = new Deal();
deal.setId(rs.getLong("id"));
deal.setTicker(rs.getString("ticker"));
deal.setType(rs.getString("typedeal"));
deal.setCurrency(rs.getString("currency"));
deal.setIdVeriety(idVeriety);
return deal;
}
}

