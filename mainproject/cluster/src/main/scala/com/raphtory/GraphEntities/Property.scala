package com.raphtory.GraphEntities

import scala.collection.mutable

/** *
  * Node or Vertice Property. Created by Mirate on 10/03/2017.
  *
  * @param creationTime
  * @param key           Property name
  * @param value         Property value
  */
class Property(creationTime: Long,
               key: String,
               value: String) {

  // Initialize the TreeMap
  var previousState: mutable.TreeMap[Long, (Boolean, String)] = mutable.TreeMap()

  // add in the initial information
  update(creationTime, value)

  /**
    * update the value of the property
    *
    * @param msgTime
    * @param newValue
    */
  def update(msgTime: Long, newValue: String): Unit = {
    previousState += msgTime -> (true, newValue)
  }

  /** *
    * returns a string with all the history of that property
    *
    * @return
    */
  override def toString: String = {
    var toReturn = System.lineSeparator()
    previousState.foreach(p =>
      toReturn = s"$toReturn           MessageID ${p._1}: ${p._2._1} -- ${p._2._2} " + System
        .lineSeparator())
    s"Property: ${key} ----- Previous State: $toReturn"
  }

  /** *
    * returns a string with only the current value of the property
    *
    * @return
    */
  def toStringCurrent: String = {
    val toReturn = System.lineSeparator() +
      s"           MessageID ${previousState.head._1}: ${previousState.head._2._1} -- ${previousState.head._2._2} " +
      System.lineSeparator()
    s"Property: ${key} ----- Current State: $toReturn"
  }

}
