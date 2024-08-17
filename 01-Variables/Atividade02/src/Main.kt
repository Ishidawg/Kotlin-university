import java.text.DecimalFormat

fun main() {
    // Variávies
    var nome: String = "Fenror";
    var idade:Int = 387;
    var salario:Double = 1200.80;
    var mesesTrabalhados:Int = 8;
    var produtosComprados:Int = 12;

    var salarioAnualLiquido:Double = 0.0;

    // Cálculo
    var desconto: Double =  (salario * 0.25) * mesesTrabalhados;
    var mediaGastaPorProduto = 100/produtosComprados;
    salarioAnualLiquido = (salario * mesesTrabalhados) - desconto;

    val dec = DecimalFormat("#,###.00")

    // mensagem
    println("Olá, $nome! Seu sálario anual líquido é: R$${dec.format(salarioAnualLiquido)} ");
    println("Você gastou em média por produto: R$$mediaGastaPorProduto");
    println("\nInformações adicionais:")
    println("Nome: $nome");
    println("Produtos: $produtosComprados");
    println("Idade: $idade");
    println("Meses trabalhados: $mesesTrabalhados");
    println("Média gasta por produtos: R$$mediaGastaPorProduto");
    println("Desconto: R$$desconto");
    println("Salário bruto: R$$salario")
}