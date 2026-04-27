import java.util.Random;

public class Main {
    public static void soma(FlexMatriz<Integer> flex1 ,FlexMatriz<Integer> otherFlex) throws Exception{
        if(otherFlex.getRows() != flex1.getRows() || flex1.getColumns() != otherFlex.getColumns()){
            throw new Exception("Error os tamanhos diferentes de colunas ou linhas");
        }

        for(int i =0; i < flex1.getRows(); i++){
            for(int  j = 0; j < flex1.getColumns(); j++){
                flex1.at(i, j).setValue(flex1.at(i, j).getValue() + otherFlex.at(i, j).getValue());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("NOME : GABRIEL AGOSTINHO DA SILVA");
        System.out.println("NOME : ISAQUE DE SOUSA ALMEIDA");
        FlexMatriz<Integer> matriz = new FlexMatriz<Integer>(8, 8);
        
        for (int i = 0; i < matriz.getRows(); i++) {
            for (int j = 0; j < matriz.getColumns(); j++) {
                    matriz.at(i, j).setValue(new Random().nextInt(90));
            }
        }

        System.out.println("----------------------------------MATRIZ 1----------------------------------");
        System.out.println(matriz);

        FlexMatriz<Integer> matriz2 = new FlexMatriz<Integer>(matriz);
       
        try {
            soma(matriz, matriz2);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------------------MATRIZ 2----------------------------------");
        System.out.println(matriz2);
        System.out.println("----------------------------------SOMA MATRIZ----------------------------------");
        System.out.println(matriz);

    }
}
