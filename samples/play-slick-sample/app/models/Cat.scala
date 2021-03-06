package models

import play.api.db.slick.Config.driver.simple._

case class Cat(name: String, color: String)

/* Table mapping
 * 
 * NOTE: objects extending Table not be used
 */
class Cats extends Table[Cat]("CAT") {

  def name = column[String]("name", O.PrimaryKey)
  def color = column[String]("color", O.NotNull)

  def * = name ~ color <> (Cat.apply _, Cat.unapply _)
}
