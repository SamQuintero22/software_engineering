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


        Roll(primero);
        
        if (turno > 0){

            if (turnos[turno-1].strike) {
            
                 turnos[turno-1].scoreTurno += primero;

                 if(primero < 10){

                    turnos[turno-1].scoreTurno += segundo;

                 }

            }else{
                
                if (turnos[turno-1].spare) {
                 turnos[turno-1].scoreTurno += primero;
            }

        }
            
        }

        if (primero < 10) {

            turnos[turno].segundoTiro = segundo;
            Roll(segundo);

            if(primero + segundo == 10){turnos[turno].spare = true;}

        }else if (primero == 10){ 
            
            turnos[turno].strike = true;
            turnos[turno].segundoTiro = 0; // para mantener coherencia
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
    
    
}