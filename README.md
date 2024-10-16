# WWW-DuongTuanKiet-Lab04
# 💻 Công nghệ và công cụ sử dụng
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)	![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)

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
