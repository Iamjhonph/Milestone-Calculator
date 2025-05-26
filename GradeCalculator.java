public class GradeCalculator {
    private int milestone1;
    private int milestone2;
    private int terminal;

    public boolean setGrades(int m1, int m2, int term) {
        if (m1 < 0 || m1 > 25) return false;
        if (m2 < 0 || m2 > 40) return false;
        if (term < 0 || term > 35) return false;
        this.milestone1 = m1;
        this.milestone2 = m2;
        this.terminal = term;
        return true;
    }

    public int calculateTotal() {
        return milestone1 + milestone2 + terminal;
    }
}