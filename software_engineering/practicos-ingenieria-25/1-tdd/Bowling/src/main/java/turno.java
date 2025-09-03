public class turno {
    
    boolean spare; 
    boolean strike;
    int primerTiro;
    int segundoTiro;
    int scoreTurno;

    turno(){

        primerTiro = 0;
        segundoTiro = 0;

    }

    public int getPuntosTurno(){
        int total = primerTiro + segundoTiro;
        return total;
    }




}
