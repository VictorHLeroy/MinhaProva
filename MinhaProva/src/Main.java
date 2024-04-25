import java.util.ArrayList;
import java.util.Scanner;

class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos++;
    }
}

class CasaMaisVigiada
{
    public static void main(String[] args) {
        ArrayList<Jogador> participantes = new ArrayList<>();
        participantes.add(new Jogador("Alane Dias"));
        participantes.add(new Jogador("Beatriz Reis"));
        participantes.add(new Jogador("Davi Brito"));
        participantes.add(new Jogador("Deniziane Ferreira"));
        participantes.add(new Jogador("Fernanda Bande"));
        participantes.add(new Jogador("Giovanna Lima"));
        participantes.add(new Jogador("Giovanna Pitel"));
        participantes.add(new Jogador("Isabelle Nogueira"));
        participantes.add(new Jogador("Juninho"));
        participantes.add(new Jogador("Leidy Elin"));
        participantes.add(new Jogador("Lucas Henrique"));
        participantes.add(new Jogador("Lucas Luigi"));
        participantes.add(new Jogador("Lucas Pizane"));
        participantes.add(new Jogador("Marcus Vinicius"));
        participantes.add(new Jogador("Matteus Amaral"));
        participantes.add(new Jogador("Maycon Cosmer"));
        participantes.add(new Jogador("MC Bin Laden"));
        participantes.add(new Jogador("Michel Nogueira"));
        participantes.add(new Jogador("Nizam"));
        participantes.add(new Jogador("Raquele Cardozo"));
        participantes.add(new Jogador("Rodriguinho"));
        participantes.add(new Jogador("Thalyta Alves"));
        participantes.add(new Jogador("Vanessa Lopes"));
        participantes.add(new Jogador("Vinicius Rodrigues"));
        participantes.add(new Jogador("Wanessa Camargo"));
        participantes.add(new Jogador("Yasmin Brunet"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de votos:");
        int numeroVotos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Os votos serão computados até digitar \"sair\".");
        for (int i = 0; i < numeroVotos; i++) {
            System.out.println("Em quem você vota para sair da casa?");
            String voto = scanner.nextLine();
            if (voto.equalsIgnoreCase("sair")) {
                break;
            }
            registrarVoto(participantes, voto);
        }

        scanner.close();

        Jogador eliminado = determinarEliminado(participantes);
        System.out.println(discursoDeEliminacao(eliminado));
    }

    public static void registrarVoto(ArrayList<Jogador> participantes, String voto) {
        for (Jogador jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                System.out.println("Voto registrado para: " + voto);
                return;
            }
        }
        System.out.println("Voto inválido para: " + voto);
    }

    public static Jogador determinarEliminado(ArrayList<Jogador> participantes) {
        Jogador eliminado = participantes.get(0);
        for (Jogador jogador : participantes) {
            if (jogador.getVotos() > eliminado.getVotos()) {
                eliminado = jogador;
            }
        }
        return eliminado;
    }

    public static String discursoDeEliminacao(Jogador eliminado) {
        return String.format("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com %d votos, é você quem sai %s", eliminado.getVotos(), eliminado.getNome());
    }
}
