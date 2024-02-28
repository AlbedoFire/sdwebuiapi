package org.sdwebuiapi

import java.awt.image.BufferedImage

data class WebUIApiResult(var images:List<BufferedImage>, var info:String="", var paramater:String=""){
    fun image(): BufferedImage {
        return images[0];
    }
}
