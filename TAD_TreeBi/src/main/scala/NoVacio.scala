class NoVacio(elem: Int, izq: ConjEnt, der: ConjEnt) extends ConjEnt {

  def pertenece(x: Int): Boolean = {
    if (x < elem) izq.pertenece(x)
    else if (x > elem) der.pertenece(x)
    else true
  }

  def insertar(x: Int): ConjEnt = {
    if (x < elem) new NoVacio(elem, izq.insertar(x), der)
    else if (x > elem) new NoVacio(elem, izq, der.insertar(x))
    else this
  }

  def eliminar(x: Int): ConjEnt = {
    if (x < elem) {
      new NoVacio(elem, izq.eliminar(x), der)
    } else if (x > elem) {
      new NoVacio(elem, izq, der.eliminar(x))
    } else {
      (izq, der) match {
        case (Vacio, Vacio) => Vacio
        case (Vacio, _) => der
        case (_, Vacio) => izq
        case (_, noVacio: NoVacio) =>
          val minElem = noVacio.encontrarMinimo
          new NoVacio(minElem, izq, der.eliminar(minElem))
      }
    }
  }

  // Métodos de acceso para izq, der y elem
  def getIzq: ConjEnt = izq
  def getDer: ConjEnt = der
  def getElem: Int = elem

  private def encontrarMinimo: Int = {
    var current: ConjEnt = this
    while (current.isInstanceOf[NoVacio] && current.asInstanceOf[NoVacio].getIzq != Vacio) {
      current = current.asInstanceOf[NoVacio].getIzq
    }
    current.asInstanceOf[NoVacio].getElem
  }
}
