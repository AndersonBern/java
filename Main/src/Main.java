public class Main {
    public static void main(String[] args) {

        Carros meuCarro = new Palio();
        Carros meuCarro2 = new Sandero();

        meuCarro.acelerador();
        meuCarro2.acelerador();

        SerVivo meuSer = new Humano();

        meuSer.respirar();

        Carros carroQuebrado = null;

        try{
            carroQuebrado.acelerador();
        }catch (NullPointerException exception){
            System.out.println("Venda este carro. Ele não funciona!");
        }

    }

}