package com.raphtory.caseclass.clustercase

/**
  * Created by Mirate on 13/06/2017.
  */
import akka.actor.Props
import com.raphtory.Actors.RaphtoryActors._
import com.raphtory.Actors.ClusterActors.DocSvr
import com.raphtory.Actors.RaphtoryActors.UpdateGen

case class UpdateNode(seedLoc: String, partitionNumber: String) extends DocSvr {
  implicit val system = init(List(seedLoc))
  system.actorOf(Props(new UpdateGen(partitionNumber.toInt)), "updateGen")
}