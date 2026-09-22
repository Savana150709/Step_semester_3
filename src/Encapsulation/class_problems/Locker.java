package Encapsulation.class_problems;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> success");
            return true;
        } else {
            System.out.println("changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> rejected, code is still \"" + this.code + "\"");
            return false;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
