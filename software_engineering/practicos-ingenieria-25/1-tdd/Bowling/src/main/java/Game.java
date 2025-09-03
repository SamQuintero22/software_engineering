public class Game{

    private static int totalScore; 
    public static turno[] turnos = new turno[10];
    private static int turnoActual;

    public Game(){

        totalScore = 0; 

        for (int i = 0; i < turnos.length; i++) {
            turnos[i] = new turno();
        }
    }

    public static void jugarTurno(int turno,int primero,int segundo){

        turnoActual = turno;

        turnos[turno].primerTiro = primero;
        turnos[turno].segundoTiro = segundo;
        
        turnos[turno].strike = isStrike(primero);
        turnos[turno].spare = isSpare(primero, segundo);
        
        Roll(primero);
        Roll(segundo);

        if (turno > 0){
            //calculando bonus de turnos anteriores 
            if (turnos[turno-1].strike) {

                turnos[turno-1].scoreTurno += primero;//si el anterior era strike le sumo el primero 

                if (turno>= 2 && turnos[turno-2].strike) {//si el anterior a ese era strike le sumo el primero 
                    turnos[turno-2].scoreTurno += primero;
                }

                if (!turnos[turno].strike) {//si el actual no es strike le sumo al anterior tambien el segundo 
                turnos[turno-1].scoreTurno += segundo;
                }

            }
        
            
        if(turnos[turno-1].spare){

            turnos[turno-1].scoreTurno += primero;

        }
            
    
    }

        int nuevoPuntaje = 0;
        for(int i = 0; i<=turno; i++){//realculando puntaje total 
            nuevoPuntaje += turnos[i].scoreTurno;
        }

        totalScore = nuevoPuntaje;


    }

    public static void Roll(int pinos){

        turnos[turnoActual].scoreTurno += pinos;
        totalScore += pinos;
    }

    public static int Score(){

        return totalScore;

    }

    public static boolean isStrike(int primero){

        return(primero == 10);

    }

    public static boolean isSpare(int primero, int segundo){

        if(isStrike(primero)) return false;

        return(primero + segundo == 10);

    }
    
    
}