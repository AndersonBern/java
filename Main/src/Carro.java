public class Carro {

    String modelo;


    public Carro(String modelo){
        this.modelo = modelo;
    }

    public String acelerar(){
        System.out.println("Acelerando o " + modelo +  "!");
        return "Bi Biii";
    }


}
