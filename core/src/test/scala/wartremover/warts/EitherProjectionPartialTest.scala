package org.brianmckenna.wartremover
package test

import org.scalatest.FunSuite

import org.brianmckenna.wartremover.warts.EitherProjectionPartial

class EitherProjectionPartialTest extends FunSuite {
  test("can't use LeftProjection#get on Left") {
    val result = WartTestTraverser(EitherProjectionPartial) {
      println(Left(1).left.get)
    }
    assertResult(List("LeftProjection#get is disabled - use LeftProjection#toOption instead"), "result.errors")(result.errors)
    assertResult(List.empty, "result.warnings")(result.warnings)
  }
  test("can't use LeftProjection#get on Right") {
    val result = WartTestTraverser(EitherProjectionPartial) {
      println(Right(1).left.get)
    }
    assertResult(List("LeftProjection#get is disabled - use LeftProjection#toOption instead"), "result.errors")(result.errors)
    assertResult(List.empty, "result.warnings")(result.warnings)
  }
  test("can't use RightProjection#get on Left") {
    val result = WartTestTraverser(EitherProjectionPartial) {
      println(Left(1).right.get)
    }
    assertResult(List("RightProjection#get is disabled - use RightProjection#toOption instead"), "result.errors")(result.errors)
    assertResult(List.empty, "result.warnings")(result.warnings)
  }
  test("can't use RightProjection#get on Right") {
    val result = WartTestTraverser(EitherProjectionPartial) {
      println(Right(1).right.get)
    }
    assertResult(List("RightProjection#get is disabled - use RightProjection#toOption instead"), "result.errors")(result.errors)
    assertResult(List.empty, "result.warnings")(result.warnings)
  }
}
