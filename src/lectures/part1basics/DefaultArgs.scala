package lectures.part1basics

object DefaultArgs extends App {

  def savePicture(format: String = "jpeg", width: Int = 1024, height: Int = 768): Unit = {
    println("saving picture with format: " + format + " , width: " + width + " , height: " + height)
  }

  savePicture()
  savePicture("PNG")
  savePicture(width = 800, height = 600)
  savePicture(format = "RAW", width = 6000, height = 3500)
}
