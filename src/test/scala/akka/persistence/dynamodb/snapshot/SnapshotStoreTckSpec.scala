package akka.persistence.dynamodb.snapshot

import akka.actor.{ ActorRef, ActorSystem }
import akka.persistence._
import akka.persistence.SnapshotProtocol._
import akka.persistence.scalatest.OptionalTests
import akka.persistence.snapshot.SnapshotStoreSpec
import akka.testkit.TestProbe
import com.typesafe.config.{ Config, ConfigFactory }

import scala.collection.immutable.Seq

class SnapshotStoreTckSpec extends SnapshotStoreSpec(
  ConfigFactory.load()
) with DynamoDBUtils {
  override def beforeAll(): Unit = {
    super.beforeAll()
    ensureSnapshotTableExists()
  }

  override def afterAll(): Unit = {
    super.afterAll()
    client.shutdown()
  }
}