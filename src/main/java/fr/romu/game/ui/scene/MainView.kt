package fr.romu.game.ui.scene

import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import tornadofx.View

class MainView : View("KotCar") {
    override val root: BorderPane by fxml()

    val next : Button by fxid()

    init{
        next.text = "Circuit Scene"
    }
}
