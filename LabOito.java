//classe main
class LabOito{
    static int variavel = 0;
    static final int NumThreadsL = 2;
    static final int NumThreadsE = 3;
    static final int NumThreadsLE = 3;

    public static void main (String[] args) {
        int i;
        Monitor monitor = new Monitor();            // Monitor (objeto compartilhado entre leitores e escritores)
        Leitor[] leitores = new Leitor[NumThreadsL];       // Threads leitores
        Escritor[] escritores = new Escritor[NumThreadsE];   // Threads escritores
        LeitorEscritor[] leitoresEscritores = new LeitorEscritor[NumThreadsLE];   // Threads leitores/escritores

        for (i=0; i<NumThreadsL; i++) {
            leitores[i] = new Leitor(i+1, (i+1)*500, monitor);
            leitores[i].start(); 
        }
        for (i=0; i<NumThreadsE; i++) {
            escritores[i] = new Escritor(i+1, (i+1)*500, monitor);
            escritores[i].start(); 
        }
        for (i=0; i<NumThreadsLE; i++) {
            //Para visualizar melhor a saída, os ids das threads LeitorEscritor vão começar no 9. Assim, toda vez que um 9 para cima aparecer sabemos que é uma leitorEscritor agindo.
            leitoresEscritores[i] = new LeitorEscritor(i+9, (i+1)*500, monitor);
            leitoresEscritores[i].start(); 
        }

    }
}