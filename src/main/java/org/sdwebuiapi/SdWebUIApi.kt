package org.sdwebuiapi

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
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
    fun text2img(enable_hr:Boolean=false,
                 denoising_strength: Double =0.7,
                 firstphase_width: Int =0,
                 firstphase_height: Int =0,
                 hr_scale:Int =2,
                 hr_upscaler: HiResUpscaler =HiResUpscaler.Latent,
                 hr_second_pass_steps: Int =0,
                 hr_resize_x: Int =0,
                 hr_resize_y: Int =0,
                 prompt: String ="",
                 styles: String ="[]",
                 seed: Int =-1,
                 subseed: Int =-1,
                 subseed_strength: Double =0.0,
                 seed_resize_from_h: Int =0,
                 seed_resize_from_w: Int =0,
                 sampler_name: String =this.sampler,
                 sampler_index: String =this.sampler,
                 batch_size: Int =1,
                 n_iter: Int =1,
                 steps: Int =this.steps,
                 cfg_scale: Double =7.0,
                 width: Int =512,
                 height: Int =512,
                 restore_faces: Boolean =false,
                 tiling: Boolean =false,
                 do_not_save_samples: Boolean =false,
                 do_not_save_grid: Boolean =false,
                 negative_prompt: String ="",
                 eta: Double =1.0,
                 s_churn: Int =0,
                 s_tmax: Int =0,
                 s_tmin: Int =0,
                 s_noise: Int =1,
                 override_settings: String ="{}",
                 override_settings_restore_afterwards: Boolean =true,
                 script_args: String ="[]",
                 script_name: String ="",
                 send_images: Boolean =true,
                 save_images: Boolean =false,
                 alwaysonscripts: String ="{}",
                 ): WebUIApiResult? {
        var playload = """
            {
            "enable_hr": $enable_hr,
            "hr_scale": $hr_scale,
            "hr_upscaler": $hr_upscaler,
            "hr_second_pass_steps": $hr_second_pass_steps,
            "hr_resize_x": $hr_resize_x,
            "hr_resize_y": $hr_resize_y,
            "denoising_strength": $denoising_strength,
            "firstphase_width": $firstphase_width,
            "firstphase_height": $firstphase_height,
            "prompt": $prompt,
            "styles": $styles,
            "seed": $seed,
            "subseed": $subseed,
            "subseed_strength": $subseed_strength,
            "seed_resize_from_h": $seed_resize_from_h,
            "seed_resize_from_w": $seed_resize_from_w,
            "batch_size": $batch_size,
            "n_iter": $n_iter,
            "steps": $steps,
            "cfg_scale": $cfg_scale,
            "width": $width,
            "height": $height,
            "restore_faces": $restore_faces,
            "tiling": $tiling,
            "do_not_save_samples": $do_not_save_samples,
            "do_not_save_grid": $do_not_save_grid,
            "negative_prompt": $negative_prompt,
            "eta": $eta,
            "s_churn": $s_churn,
            "s_tmax": $s_tmax,
            "s_tmin": $s_tmin,
            "s_noise": $s_noise,
            "override_settings": $override_settings,
            "override_settings_restore_afterwards": $override_settings_restore_afterwards,
            "sampler_name": $sampler_name,
            "sampler_index": $sampler_index,
            "script_name": $script_name,
            "script_args": $script_args,
            "send_images": $send_images,
            "save_images": $save_images,
            "alwayson_scripts": $alwaysonscripts,
            }
        """.trimIndent()
        return postAndGetApiResult("$baseurl/txt2img",playload)

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
