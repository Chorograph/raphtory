//package com.raphtory.core.storage.OldStorageAccess
//
//import com.raphtory.core.analysis.GraphRepoProxy
//import com.raphtory.core.model.graphentities.{Edge, Entity, Property}
//import com.raphtory.core.storage.EntityStorage
//import com.raphtory.core.utils.KeyEnum
//
//import scala.collection.mutable
//import scala.collection.parallel.ParSet
//import scala.collection.parallel.mutable.ParTrieMap
//
//private object MemoryConnector extends ReaderConnector {
//  import EntityStorage.{edges, vertices}
//  //val entities = Map[KeyEnum.Value, TrieMap[_ <: AnyVal, _ <: Entity]]((KeyEnum.edges -> edges), (KeyEnum.vertices -> vertices))
//
//  /**
//    * @param entityType
//    * @param entityId
//    * @param property
//    * @param startTime
//    * @param endTime
//    * @return
//    */
//  override def rangeQuery(entityType: String, entityId: Long, property: String, startTime: Long, endTime: Long): Any = {
//    null // TODO
//  }
//
//  override def lookupEntity(entityType: KeyEnum.Value, entityId: Long): Boolean = {
//    entityType match {
//      case KeyEnum.vertices => lookupVertex(entityId.toInt)
//      case KeyEnum.edges => lookupEdge(entityId)
//    }
//  }
//
//  override def getEntity(entityType: KeyEnum.Value, entityId: Long): Option[_ <: Entity] = {
//    entityType match {
//      case KeyEnum.vertices => Some(vertices(entityId.toInt))
//      case KeyEnum.edges    => Some(edges(entityId))
//      case _ => None
//    }
//  }
//
//  override def getHistory(entityType: KeyEnum.Value, entityId: Long): mutable.TreeMap[Long, Boolean] = {
//    entityType match {
//      case KeyEnum.vertices => vertices(entityId.toInt).previousState
//      case KeyEnum.edges => edges(entityId).previousState
//      case _ => null
//    }
//  }
//
//  override def getProperties(entityType: KeyEnum.Value, entityId: Long): ParTrieMap[String, Property] = {
//    entityType match {
//      case KeyEnum.vertices => vertices(entityId.toInt).properties
//      case KeyEnum.edges    => edges(entityId.toInt).properties
//      case _ => null
//    }
//  }
//
//  override def getEntities(entityType: KeyEnum.Value): ParSet[Long] = {
//    entityType match { // Not needed method
//      case KeyEnum.vertices => GraphRepoProxy.getVerticesSet()
////      case KeyEnum.edges    => GraphRepoProxy.getEdgesSet()
//    }
//  }
//
//  override def getEntitiesObjs(entityType: KeyEnum.Value): ParTrieMap[_ <: AnyVal, _ <: Entity] = {
//    entityType match {
//      case KeyEnum.vertices => EntityStorage.vertices
//      case KeyEnum.edges    => EntityStorage.edges
//    }
//  }
//
//  override def getAssociatedEdges(entityId: Long): ParTrieMap[Long, Edge] = {
//    vertices(entityId.toInt).incomingEdges //TODO both, place holder whilst things are rewritten
//  }
//
//  private def lookupVertex(vertexId : Int) : Boolean = {
//    vertices.get(vertexId) match {
//      case Some(_) => true
//      case None    => false
//    }
//  }
//
//  private def lookupEdge(edgeId : Long) : Boolean = {
//    edges.get(edgeId) match {
//      case Some(_) => true
//      case None    => false
//    }
//  }
//}
