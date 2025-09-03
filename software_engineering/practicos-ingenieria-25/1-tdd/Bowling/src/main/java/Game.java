public class Game{

    private static int totalScore; 
    public static turno[] turnos = new turno[10];

    public Game(){

        totalScore = 0; 

        for (int i = 0; i < turnos.length; i++) {
            turnos[i] = new turno();
        }
    }

    public static void jugarTurno(int turno,int primero,int segundo){

        turnos[turno].primerTiro = primero;
        turnos[turno].segundoTiro = segundo;


        Roll(primero);
        
        if (turno > 0) {

            if (turnos[turno-1].spare) {
                 totalScore += primero;
                 turnos[turno-1].scoreTurno += primero;
            }

            if (turnos[turno-1].strike) {
                 totalScore += primero + segundo;
                 turnos[turno-1].scoreTurno += primero + segundo;

            }

        }

        Roll(segundo);


        if (primero < 10) {

            turnos[turno].segundoTiro = segundo;

            if(primero + segundo == 10){turnos[turno].spare = true;}

        }else if (primero == 10){ 
            
            turnos[turno].strike = true;

        }

        turnos[turno].scoreTurno = primero + segundo; 

    }

    public static void Roll(int pinos){

        totalScore += pinos;
        
    }

    public static int Score(){

        return totalScore;

    }
    
    
}