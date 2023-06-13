package csu07419.tictactoe;


public class TokenPosition {
    int Row;
    int Column;

    public TokenPosition( int Rowen,int Column){

        this.Row=Rowen;
        this.Column=Column;

    }
    public int getRow(){

        return Row;
    }
    public int getColumn(){
        return Column;
    }

    @Override
    public boolean equals(Object obj) {
//        if(getRow()==getColumn()){
//            return false;
//        }
       return super.equals(obj);

    }
}
