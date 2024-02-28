package org.sdwebuiapi

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.util.*
import javax.imageio.ImageIO


class SdWebUIApi constructor(
        private var host: String = "127.0.0.1",
        private var hasControlNet: Boolean = false,
        private var hasAdetailer: Boolean = false,
        private var port: Int = 7860,
        private var baseurl: String = "",
        private var sampler: String = "Euler a",
        private var steps: Int = 20,
        private var useHttps: Boolean = false,
        private var username: String = "",
        private var password: String = "") {
    private val requests = Requests()
    init {
        if (baseurl.isEmpty())
            if (useHttps) {
                baseurl = "https://{host}:{port}/sdapi/v1"
            }
            else {
                baseurl = "http://{host}:{port}/sdapi/v1"
            }
    }
    fun text2img(){

    }
    fun text2img(json: String): WebUIApiResult? {
        return postAndGetApiResult("$baseurl/txt2img",json)
    }
    fun img2img(){

    }
    fun img2img(json: String): WebUIApiResult? {
        return postAndGetApiResult("$baseurl/img2img",json)
    }
    fun base642img(base64:String):BufferedImage{
        val decodedBytes = Base64.getDecoder().decode(base64);
        val bis = ByteArrayInputStream(decodedBytes)
        val bufferedImage = ImageIO.read(bis)
        return bufferedImage
    }
    fun postAndGetApiResult(url:String,json:String,useAsync: Boolean =false): WebUIApiResult? {
        val respnestr = requests.post(url,json)
        return respnestr?.let { toApiResult(it) }
    }
    fun toApiResult(json:String):WebUIApiResult{
        val node = ObjectMapper().readTree(json)
        val images = ArrayList<BufferedImage>()
        if(!node.get("images").isEmpty){
            for (i in node.get("images")){
                images.add(base642img(i.asText()))
            }
        }else{
            images.add(base642img(node.get("image").asText()))
        }
        return WebUIApiResult(images)
    }
    fun checkExtensions(){
        checkAdetailer()
        checkControlNet()
    }
    fun checkControlNet(){

    }
    fun checkAdetailer(){}

    fun getScripts(): String {
           return requests.post("$baseurl/scripts")
    }
    fun interrrput(): String {
        return requests.post("$baseurl/interrput")
    }
    fun skip():String{
        return requests.post("$baseurl/skip")
    }
    fun getOptions():String{
        return requests.post("$baseurl/options")
    }
    fun setOPtions(json: String):String{
        return requests.post("$baseurl/options",json)
    }

}
