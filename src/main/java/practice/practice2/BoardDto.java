package practice.practice2;



public class BoardDto {
    private int bno;
    private String bcontent;
    private String bwriter;

    public BoardDto(){}
    public BoardDto(int bno, String bwriter, String bcontent) {
        this.bno = bno;
        this.bwriter = bwriter;
        this.bcontent = bcontent;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}
