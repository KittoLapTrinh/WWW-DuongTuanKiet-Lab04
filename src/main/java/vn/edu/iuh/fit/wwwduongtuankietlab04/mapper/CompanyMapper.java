package vn.edu.iuh.fit.wwwduongtuankietlab04.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Address;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class CompanyMapper implements RowMapper<Company> {


    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = UUID.fromString(rs.getString("com_id"));
        String name= rs.getString("comp_name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String about = rs.getString("about");
        String webUrl = rs.getString("web_url");
        UUID addressId = UUID.fromString(rs.getString("address"));

        return new Company(id, about, email, name, phone, webUrl, new Address(addressId));
    }
}
