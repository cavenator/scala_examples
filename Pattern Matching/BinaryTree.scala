sealed abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(operator: Char, nodes: BinaryTree*) extends BinaryTree
