package captify.test.scala

import captify.test.scala.SparseIterators.iteratorFromOne
import captify.test.scala.TestAssignment._
import org.scalatest.{FlatSpec, Matchers}

class TestAssignmentSpec extends FlatSpec with Matchers {

  "iteratorFromOne" should "return iterator with subsequence" in {
    val iterator = iteratorFromOne
    val after = 1
    val sampleSize = 2
    val result = sampleAfter(iterator, after, sampleSize)
    val expected = Seq[BigInt](2, 3, 4).toIterator
    iteratorsValuesEquals(3)(result, expected)
  }

  "valueAt" should "return respective value" in {
    val iterator = iteratorFromOne
    val result = valueAt(iterator, 5)
    result should be (6)
  }

  "mergeIterators" should "return merged iterators from Seq(iterators)" in {
    val iterators = Seq(iteratorFromOne, iteratorFromOne)
    val result = mergeIterators(iterators)
    val expected = Seq[BigInt](1, 1, 2, 2, 3, 3).toIterator
    iteratorsValuesEquals(6)(result, expected)
  }

  def iteratorsValuesEquals(amount: Int)(result: Iterator[BigInt], expected: Iterator[BigInt]) =
    for(_ <- 0 until amount)
      result.next() should be (expected.next())
}
