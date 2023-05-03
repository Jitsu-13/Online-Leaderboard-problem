import java.util.Objects;

public class User {
    private String name;
    private String email;
    private Integer score;
    private String country;

    public User(String name, String email,String country) {
        this.name = name;
        this.email = email;
        this.score = null;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return score == user.score && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, score, country);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", country='" + country + '\'' +
                '}';
    }
}
