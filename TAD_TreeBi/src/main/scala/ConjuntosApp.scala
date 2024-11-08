
object ConjuntosApp extends App {
  println("Bienvenido a la Gestión de Conjuntos Matemáticos")
  println("Elija el tipo de conjunto a utilizar: (ArbolBinario, Lista, AVL)")

  val tipoConjunto = scala.io.StdIn.readLine()
  var conjunto: ConjEnt = ConjFactory.crearConjunto(tipoConjunto)

  var continuar = true
  while (continuar) {
    println("\nElija una opción: (insertar, pertenece, eliminar, salir)")
    val opcion = scala.io.StdIn.readLine()

    opcion match {
      case "insertar" =>
        println("Ingrese el valor a insertar:")
        val valor = scala.io.StdIn.readInt()
        conjunto = conjunto.insertar(valor)
        println(s"Valor $valor insertado.")

      case "pertenece" =>
        println("Ingrese el valor a verificar:")
        val valor = scala.io.StdIn.readInt()
        val existe = conjunto.pertenece(valor)
        println(s"¿Pertenece $valor?: $existe")

      case "eliminar" =>
        println("Ingrese el valor a eliminar:")
        val valor = scala.io.StdIn.readInt()
        conjunto = conjunto.eliminar(valor)
        println(s"Valor $valor eliminado.")

      case "salir" =>
        continuar = false
        println("Saliendo de la aplicación...")

      case _ =>
        println("Opción no válida. Intente de nuevo.")
    }
  }
}
