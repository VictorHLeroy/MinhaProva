import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

class CasaMaisVigiadaGUI extends JFrame implements ActionListener {
    private ArrayList<Jogador> participantes;
    private JTextArea votosArea;
    private JButton contarButton;

    public CasaMaisVigiadaGUI() {
        participantes = new ArrayList<>();
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

        setTitle("Casa Mais Vigiada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        votosArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(votosArea);
        add(scrollPane, BorderLayout.CENTER);

        contarButton = new JButton("Contar Votos");
        contarButton.addActionListener(this);
        add(contarButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == contarButton) {
            contarVotos();
        }
    }

    private void contarVotos() {
        String votosText = votosArea.getText();
        String[] votos = votosText.split("\n");

        for (String voto : votos) {
            if (voto.equalsIgnoreCase("sair")) {
                break;
            }
            registrarVoto(voto.trim());
        }

        Jogador eliminado = determinarEliminado();
        JOptionPane.showMessageDialog(this, discursoDeEliminacao(eliminado));
    }

    private void registrarVoto(String voto) {
        for (Jogador jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Voto inválido para: " + voto);
    }

    private Jogador determinarEliminado() {
        Jogador eliminado = participantes.get(0);
        for (Jogador jogador : participantes) {
            if (jogador.getVotos() > eliminado.getVotos()) {
                eliminado = jogador;
            }
        }
        return eliminado;
    }

    private String discursoDeEliminacao(Jogador eliminado) {
        return String.format("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com %d votos, é você quem sai %s", eliminado.getVotos(), eliminado.getNome());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CasaMaisVigiadaGUI();
            }
        });
    }
}