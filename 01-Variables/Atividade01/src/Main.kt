fun main() {
    // Variables var
    var nome: String = "";
    nome  = "Galadriel";

    var altura: Float = 1.80F;
    altura = 1.65F;

    // Variables val e var idade
    val idade: Int = 127;
    val idadeDois: Int = 247;
    var idadeFinal: Int = 0;
    val identificaoAluno: Boolean = false;

    // Saudação
    var saudacao: String = "Olá, $nome!";

    // Cálculos e if
    idadeFinal = idade + idadeDois;
    altura = altura * 2;

    // função retorna se é estudante
    fun estudante() {
        if (identificaoAluno == true) {
            return println("É um estudadante: Sim!")
        } else {
            return println("É um estudadante: Não!")
        }
    }

    // Prints
    println("Idade: $idadeFinal");
    println("Nome: $nome");
    println("Altura: $altura m");
    estudante();
    println("Saudação: $saudacao");
}