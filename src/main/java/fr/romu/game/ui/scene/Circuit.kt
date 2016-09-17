package fr.romu.game.ui.scene

import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import tornadofx.View
import tornadofx.add

class Circuit : View("Circuit Views") {
    override val root: BorderPane by fxml()
    val trackPane : Pane by fxid("trackPane")
    val heightStepValue = 25
    val widthStepValue = 40

    init{

    }

    fun handleForme1Action(){
        println("forme 1")
        getCanvasSize()
        printGrid()
    }

    fun handleForme2Action(){
        println("forme 2")
        val ligne : Line = Line()
        ligne.startX = 0.0
        ligne.startY = 0.0
        ligne.endX = 100.0
        ligne.endY = 100.0
        ligne.fill = Color.RED
        trackPane.add(ligne)
    }

    fun handleForme3Action(){
        println("forme 3")
    }


    private fun getCanvasSize() {
        println("${trackPane.height} : ${trackPane.width}")
        println("${trackPane.height.toInt() / heightStepValue} : ${trackPane.width.toInt() / widthStepValue}")
    }

    private fun printGrid() {
        val stepH = trackPane.height.toInt() / heightStepValue
        val stepW =  trackPane.width.toInt() / widthStepValue
        val realPointsH : List<Double> = IntRange(0,heightStepValue).toList().map { p -> p.toDouble() }.map { p -> p*stepH }
        val realPointsW : List<Double> = IntRange(0,widthStepValue).toList().map { p -> p.toDouble() }.map { p -> p*stepW }

        realPointsW.forEach { p -> trackPane.children.add(coloredLineW(p)) }
        realPointsH.forEach { p -> trackPane.children.add(coloredLineH(p)) }
    }

    private fun coloredLineW(p:Double) : Line {
        val ligne : Line = Line()
        ligne.startX = p
        ligne.startY = 0.0
        ligne.endX = p
        ligne.endY = trackPane.height
        ligne.fill = Color.GRAY
        return ligne
    }

    private fun coloredLineH(p:Double) : Line {
        val ligne : Line = Line()
        ligne.startX = 0.0
        ligne.startY = p
        ligne.endX = trackPane.width
        ligne.endY = p
        ligne.fill = Color.GRAY
        return ligne
    }



}
