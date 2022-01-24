//Threads

class Leitor extends Thread{

    int id; //identificador da thread
    Monitor monitor;//objeto monitor para coordenar a lógica de execução das threads
    int delay; //atraso bobo

    // Construtor
    Leitor (int id, int delayTime, Monitor m) {
        this.id = id;
        this.delay = delayTime;
        this.monitor = m;
    }

    // Método executado pela thread
    public void run () {

        try {
            for(;;){
                this.monitor.EntraLeitor(this.id);
                if(LabOito.variavel%2==0){
                    System.out.println("Variavel par :" + LabOito.variavel);
                }else{
                    System.out.println("Variavel impar :" + LabOito.variavel);
                }
                this.monitor.SaiLeitor(this.id);
                sleep(this.delay); 
            }
        } catch (InterruptedException e) { return; }
    }

}

class Escritor extends Thread{

    int id; //identificador da thread
    Monitor monitor;//objeto monitor para coordenar a lógica de execução das threads
    int delay; //atraso bobo

    // Construtor
    Escritor (int id, int delayTime, Monitor m) {
        this.id = id;
        this.delay = delayTime;
        this.monitor = m;
    }

    // Método executado pela thread
    public void run () {
        try {
            for(;;){
                this.monitor.EntraEscritor(this.id);
                LabOito.variavel = this.id;
                this.monitor.SaiEscritor(this.id);
                sleep(this.delay); 
            }
        } catch (InterruptedException e) { return; }
    }

}

class LeitorEscritor extends Thread{

    int id; //identificador da thread
    Monitor monitor;//objeto monitor para coordenar a lógica de execução das threads
    int delay; //atraso bobo

    // Construtor
    LeitorEscritor (int id, int delayTime, Monitor m) {
        this.id = id;
        this.delay = delayTime;
        this.monitor = m;
    }

    // Método executado pela thread
    public void run () {
        double j=777777777.7, i;

        try {
            for(;;){
                this.monitor.EntraLeitor(this.id);
                System.out.println("Variavel:" + LabOito.variavel );
                this.monitor.SaiLeitor(this.id);
                for (i=0; i<100000000; i++) {j=j/2;} //...loop bobo
                this.monitor.EntraEscritor(this.id);
                LabOito.variavel = LabOito.variavel+1;
                this.monitor.SaiEscritor(this.id);
                sleep(this.delay); 
            }
        } catch (InterruptedException e) { return; }

    }

}
