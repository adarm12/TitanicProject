import java.util.List;

public class Passenger {

    private int passengerId;
    private int survived;
    private int pClass;
    private String name;
    private String sex;
    private int age;
    private int sibSp;
    private int parch;
    private String ticket;
    private int fare;
    private String cabin;
    private char embarked;

    public Passenger(int passengerId, int survived, int pClass, String name, String sex, int age, int sibSp,
                     int parch, String ticket, int fare, String cabin, char embarked) {
        this.passengerId = passengerId;
        this.survived = survived;
        this.pClass = pClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }

    public Passenger(List<String> list) {
        this.passengerId = Integer.parseInt(list.get(0));
        this.survived = Integer.parseInt(list.get(1));
        this.pClass = Integer.parseInt(list.get(2));
        this.name = list.get(3);
        this.sex = list.get(4);
        this.age = Integer.parseInt(list.get(5));
        this.sibSp = Integer.parseInt(list.get(6));
        this.parch = Integer.parseInt(list.get(7));
        this.ticket = list.get(8);
        this.fare = Integer.parseInt(list.get(9));
        this.cabin = list.get(10);
       // this.embarked = (list.get(11));
    }

    public String getFormattedName() {
        int comma = 0;
        int dot = 0;
        for (int i = 0; i < this.name.length(); i++) {
            if (this.name.charAt(i) == Constants.COMMA)
                comma = i;
            else if (this.name.charAt(i) == Constants.DOT)
                dot = i;
        }
        String name = this.name.substring(0, comma) + this.name.substring(dot);
        return (name);
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public int getpClass() {
        return pClass;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public void setSibSp(int sibSp) {
        this.sibSp = sibSp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public char getEmbarked() {
        return embarked;
    }

    public void setEmbarked(char embarked) {
        this.embarked = embarked;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", survived=" + survived +
                ", pClass=" + pClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked=" + embarked +
                '}';
    }
}

