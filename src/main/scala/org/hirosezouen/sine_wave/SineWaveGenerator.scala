/*
 * Copyright (c) 2013, Hidekatsu Hirose
 * Copyright (c) 2013, Hirose-Zouen
 * This file is subject to the terms and conditions defined in
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package org.hirosezouen.sine_wave

import java.awt.Color

import scala.collection.mutable.Buffer
import scala.swing.Component
import scala.swing.Dimension
import scala.swing.Graphics2D
import scala.swing.MainFrame
import scala.swing.Panel
import scala.swing.SimpleSwingApplication

object SineWaveGenerator extends SimpleSwingApplication {
    def top = new MainFrame {
        title = "Graphic Sample"
        minimumSize = new Dimension(300, 300)

        contents = new Panel {
            override def contents: Buffer[Component] = Buffer.empty
            override def paint(g: Graphics2D) = super.paint(g)
            override protected def paintComponent(g: Graphics2D) {
                super.paint(g)
                g.setColor(Color.GREEN)
                g.fillOval(0,0,size.width*2,size.height*2)
            }
        }
    }
}
