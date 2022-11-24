

public class Cliente {
   
    

    private String num;

    public Cliente(String num) {
        
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }



    @Override
    public String toString() {
        return num ;
    }
    


}
