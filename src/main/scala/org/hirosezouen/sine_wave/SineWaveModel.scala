/*
 * Copyright (c) 2013, Hidekatsu Hirose
 * Copyright (c) 2013, Hirose-Zouen
 * This file is subject to the terms and conditions defined in
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package org.hirosezouen.sine_wave

//import javax.sound.sampled._

import org.hirosezouen.hzutil._
import org.hirosezouen.hzutil.HZLog._

case class SinWaveModel() {
    implicit val logger = getLogger(this.getClass.getName)

    def main(args: Array[String]) {

        def SAMPLE_HZ = 44100.0
        def WAVE_HZ = 440.0

        val wave_data= new Array[Byte](SAMPLE_HZ.toInt * 2)    /* 44100Hz * 2sec */
        log_debug((f"swave_data.length=${wave_data.length}%d").format())
        val l1 = SAMPLE_HZ/WAVE_HZ
        log_debug("l1=%f".format(l1))
        for(i <- (0 to (wave_data.length-1)))
        {
            val i_l1 = i % l1
            val radian2 = i_l1 * Math.PI * 2
            val sin = Math.sin(radian2)
            log_trace("%1$05d_l1 = %2$10f : Radian = %3$11f : Sin = %4$9f ".format(i, i_l1, radian2, sin))
//            wave_data(i)= (110*Math.sin((i/l1)*Math.PI*2)).toByte
            wave_data(i)= (110*sin).toByte
        }                                                      		//@A-end@

//        val dump = hexDump(wave_data)
//        log_debug("%n%s".format(dump))
//        println(dump)

        log_debug("end")
    /*
        AudioFormat   frmt= new AudioFormat(44100,8,1,true,false);// @B-sta@
        DataLine.Info info= new DataLine.Info(Clip.class,frmt);
        Clip clip= (Clip)AudioSystem.getLine(info);
        clip.open(frmt,wave_data,0,wave_data.length);             // @B-end@
        clip.start();

        Thread.sleep(100);
        while(clip.isRunning()) {
            Thread.sleep(100);
        }
    */
    }
}

