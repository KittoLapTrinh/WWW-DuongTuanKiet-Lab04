"# WWW-DuongTuanKiet-Lab04" 

### Entity-diagram
![entity-diagram](https://github.com/user-attachments/assets/b3dff1c1-03a6-4b18-b78c-249176989dfa)


### Database-diagram
![database-diagram](https://github.com/user-attachments/assets/eb7a1ce4-85ca-4616-b463-c4431d6e35d8)

### Mapper-Convert
```
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
```
