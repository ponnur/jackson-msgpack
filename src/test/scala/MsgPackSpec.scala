package com.test.messagepack

import org.scalatest.{FlatSpec, Matchers}
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.msgpack.jackson.dataformat.MessagePackFactory


class MsgPackSpec extends FlatSpec {

  "MsgPack" should "handle invalid msg pack message" in {

    val msgpackMapper = new ObjectMapper(new MessagePackFactory)
    msgpackMapper.registerModule(DefaultScalaModule)

    val stringToByteArray = (str: String) => str.split(" ").map(Integer.parseInt(_, 16).toByte)

    val testValues: Array[Int] = Array(10,13)

    val data = "92 0a 0d" // Message pack hex val for the array [10,13]
    val convertedValues: Array[Int] = msgpackMapper.readValue(stringToByteArray(data), classOf[Array[Int]])
    convertedValues.map(println(_)) //Prints 10 and 13


    val invalidData = "93 0a 0d" // Invalid Message pack hex val for the array [10,13]. Array size is 3 instead of 2
    val result: Array[Int] = msgpackMapper.readValue(stringToByteArray(invalidData), classOf[Array[Int]])// java.lang.OutOfMemoryError: Java heap space

  }

}

