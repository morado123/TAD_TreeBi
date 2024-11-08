class ConjLista(val elementos: List[Int]) extends ConjEnt {
  def pertenece(x: Int): Boolean = elementos.contains(x)

  def insertar(x: Int): ConjEnt = {
    if (elementos.contains(x)) this
    else new ConjLista(x :: elementos)
  }

  def eliminar(x: Int): ConjEnt = {
    new ConjLista(elementos.filterNot(_ == x))
  }
}
