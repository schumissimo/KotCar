package fr.romu.game.ui.test

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.View
import tornadofx.bind

/**
 * Created by Jacques on 14/09/2016.
 */
class CounterView : View("My View") {
    override val root : BorderPane by fxml()
    val counter = SimpleIntegerProperty()
    val counterLabel : Label by fxid()

    init{
        counterLabel.bind(counter)
    }

    fun increment() {
        counter.value += 1
    }
}
