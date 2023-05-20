import java.time.LocalDate;


enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, val id: Int, var formacao: Formacao?, var conteudoEducacional: ConteudoEducacional?) {

    constructor(nome: String, idade: Int = -1, id: Int = -1) :
            this(nome, idade, id, null, null)

    override fun toString(): String {
        return "Usuario(nome='$nome', idade=$idade, id=$id, formacao=$formacao, conteudoEducacional=$conteudoEducacional)"
    }


}


data class ConteudoEducacional(val nome: String,  val nivel: Nivel) {
    private val inicio: LocalDate = LocalDate.now()
    private val duracao: LocalDate = inicio.plusDays(45)

}

data class Formacao(val nome: String,var conteudos: List<ConteudoEducacional> , val nivel: Nivel) {
    val inicioFormacaocao: LocalDate = LocalDate.now()
    val duracaoFormacao: LocalDate = inicioFormacaocao.plusDays(45)
}

val inscritos = mutableListOf<Usuario>()

fun matricular(usuario: Usuario, formacao: Formacao?, conteudoEducacional: ConteudoEducacional?): Usuario {
    usuario.formacao = formacao
    usuario.conteudoEducacional = conteudoEducacional
    return usuario
}

fun main() {
    val u1: Usuario = Usuario("André", 21, 1000)

    val kotlinBasico: ConteudoEducacional = ConteudoEducacional("Kotlin básico", Nivel.BASICO)
    val kotlinIntermediario: ConteudoEducacional = ConteudoEducacional("Kotlin intermediário", Nivel.INTERMEDIARIO)
    val kotlinAvancado:ConteudoEducacional = ConteudoEducacional("Kotlin avançado", Nivel.AVANCADO)


    val listaKotlin = mutableListOf<ConteudoEducacional>()

    listaKotlin.add(kotlinBasico)
    listaKotlin.add(kotlinIntermediario)
    listaKotlin.add(kotlinAvancado)

    val formacaoKotlin: Formacao = Formacao("Formação Kotlin", listaKotlin, Nivel.AVANCADO)


    matricular(u1, formacaoKotlin, null)


    println("Nome do aluno: ${u1.nome}")
    println("Formação inscrita: ${u1.formacao?.nome}")
    println("Conteúdos da formação: ${u1.formacao?.conteudos}")
    println("Início da formação: ${formacaoKotlin.inicioFormacaocao}")
    println("Prazo para o término da formação: ${formacaoKotlin.duracaoFormacao}")

}
