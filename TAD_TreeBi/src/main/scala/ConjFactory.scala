object ConjFactory {
  def crearConjunto(tipo: String): ConjEnt = tipo match {
    case "ArbolBinario" => Vacio
    case "Lista" => new ConjLista(Nil)
    case "AVL" => new ConjAVL(0, Vacio, Vacio) // Proporcionar un nodo inicial para AVL
    case _ => throw new IllegalArgumentException("Tipo de conjunto no soportado")
  }
}
