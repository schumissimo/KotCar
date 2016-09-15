package fr.romu.game.ui.scene

import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.BorderPane
import tornadofx.View

class Circuit : View("Circuit Views") {
    override val root: BorderPane by fxml()
    val canvas : Canvas by fxid("canvasTrack")
    val heightStepValue = 25
    val widthStepValue = 40

    init{

    }

    fun handleForme1Action(){
        println("forme 1")
        getCanvasSize()

        val gc = canvas.graphicsContext2D
        printGrid(gc)
    }

    fun handleForme2Action(){
        println("forme 2")
    }

    fun handleForme3Action(){
        println("forme 3")
    }

    private fun getCanvasSize() {
        println("${canvas.height} : ${canvas.width}")
    }

    private fun printGrid(gc: GraphicsContext) {
        val stepH = canvas.height.toInt() / heightStepValue
        val stepW =  canvas.width.toInt() / widthStepValue
        val realPointsH : List<Double> = IntRange(0,heightStepValue).toList().map { p -> p.toDouble() }.map { p -> p*stepH }
        val realPointsW : List<Double> = IntRange(0,widthStepValue).toList().map { p -> p.toDouble() }.map { p -> p*stepW }

        realPointsH.forEach { p -> gc.strokeLine(p,0.0,p,canvas.height) }
        realPointsW.forEach { p -> gc.strokeLine(0.0,p,canvas.width,p) }

    }

}
