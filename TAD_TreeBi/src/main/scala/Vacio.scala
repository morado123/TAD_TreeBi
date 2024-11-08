

object Vacio extends ConjEnt {
  def pertenece(x: Int): Boolean = false
  def insertar(x: Int): ConjEnt = new NoVacio(x, Vacio, Vacio)
  def eliminar(x: Int): ConjEnt = this
}
