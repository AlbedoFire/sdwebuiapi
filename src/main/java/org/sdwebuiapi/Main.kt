package org.sdwebuiapi

import java.awt.image.BufferedImage
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane


fun getimage(): BufferedImage? {
    val jsonString = """
        {
            "alwayson_scripts": {
                "ADetailer": {
                    "args": [
                        false,
                        false,
                        {
                            "ad_cfg_scale": 7,
                            "ad_checkpoint": "Use same checkpoint",
                            "ad_clip_skip": 1,
                            "ad_confidence": 0.3,
                            "ad_controlnet_guidance_end": 1,
                            "ad_controlnet_guidance_start": 0,
                            "ad_controlnet_model": "None",
                            "ad_controlnet_module": "None",
                            "ad_controlnet_weight": 1,
                            "ad_denoising_strength": 0.4,
                            "ad_dilate_erode": 4,
                            "ad_inpaint_height": 512,
                            "ad_inpaint_only_masked": true,
                            "ad_inpaint_only_masked_padding": 32,
                            "ad_inpaint_width": 512,
                            "ad_mask_blur": 4,
                            "ad_mask_k_largest": 0,
                            "ad_mask_max_ratio": 1,
                            "ad_mask_merge_invert": "None",
                            "ad_mask_min_ratio": 0,
                            "ad_model": "face_yolov8n.pt",
                            "ad_negative_prompt": "",
                            "ad_noise_multiplier": 1,
                            "ad_prompt": "",
                            "ad_restore_face": false,
                            "ad_sampler": "DPM++ 2M Karras",
                            "ad_steps": 28,
                            "ad_use_cfg_scale": false,
                            "ad_use_checkpoint": false,
                            "ad_use_clip_skip": false,
                            "ad_use_inpaint_width_height": false,
                            "ad_use_noise_multiplier": false,
                            "ad_use_sampler": false,
                            "ad_use_steps": false,
                            "ad_use_vae": false,
                            "ad_vae": "Use same VAE",
                            "ad_x_offset": 0,
                            "ad_y_offset": 0,
                            "is_api": []
                        },
                        {
                            "ad_cfg_scale": 7,
                            "ad_checkpoint": "Use same checkpoint",
                            "ad_clip_skip": 1,
                            "ad_confidence": 0.3,
                            "ad_controlnet_guidance_end": 1,
                            "ad_controlnet_guidance_start": 0,
                            "ad_controlnet_model": "None",
                            "ad_controlnet_module": "None",
                            "ad_controlnet_weight": 1,
                            "ad_denoising_strength": 0.4,
                            "ad_dilate_erode": 4,
                            "ad_inpaint_height": 512,
                            "ad_inpaint_only_masked": true,
                            "ad_inpaint_only_masked_padding": 32,
                            "ad_inpaint_width": 512,
                            "ad_mask_blur": 4,
                            "ad_mask_k_largest": 0,
                            "ad_mask_max_ratio": 1,
                            "ad_mask_merge_invert": "None",
                            "ad_mask_min_ratio": 0,
                            "ad_model": "None",
                            "ad_negative_prompt": "",
                            "ad_noise_multiplier": 1,
                            "ad_prompt": "",
                            "ad_restore_face": false,
                            "ad_sampler": "DPM++ 2M Karras",
                            "ad_steps": 28,
                            "ad_use_cfg_scale": false,
                            "ad_use_checkpoint": false,
                            "ad_use_clip_skip": false,
                            "ad_use_inpaint_width_height": false,
                            "ad_use_noise_multiplier": false,
                            "ad_use_sampler": false,
                            "ad_use_steps": false,
                            "ad_use_vae": false,
                            "ad_vae": "Use same VAE",
                            "ad_x_offset": 0,
                            "ad_y_offset": 0,
                            "is_api": []
                        }
                    ]
                },
                "API payload": {
                    "args": []
                },
                "Aspect Ratio Helper": {
                    "args": []
                },
                "ControlNet": {
                    "args": [
                        {
                            "advanced_weighting": null,
                            "batch_images": "",
                            "control_mode": "Balanced",
                            "enabled": false,
                            "guidance_end": 1,
                            "guidance_start": 0,
                            "hr_option": "Both",
                            "image": null,
                            "inpaint_crop_input_image": false,
                            "input_mode": "simple",
                            "is_ui": true,
                            "loopback": false,
                            "low_vram": false,
                            "model": "None",
                            "module": "none",
                            "output_dir": "",
                            "pixel_perfect": false,
                            "processor_res": 512,
                            "resize_mode": "Crop and Resize",
                            "save_detected_map": true,
                            "threshold_a": 64,
                            "threshold_b": 64,
                            "weight": 1
                        },
                        {
                            "advanced_weighting": null,
                            "batch_images": "",
                            "control_mode": "Balanced",
                            "enabled": false,
                            "guidance_end": 1,
                            "guidance_start": 0,
                            "hr_option": "Both",
                            "image": null,
                            "inpaint_crop_input_image": false,
                            "input_mode": "simple",
                            "is_ui": true,
                            "loopback": false,
                            "low_vram": false,
                            "model": "None",
                            "module": "none",
                            "output_dir": "",
                            "pixel_perfect": false,
                            "processor_res": 512,
                            "resize_mode": "Crop and Resize",
                            "save_detected_map": true,
                            "threshold_a": 64,
                            "threshold_b": 64,
                            "weight": 1
                        },
                        {
                            "advanced_weighting": null,
                            "batch_images": "",
                            "control_mode": "Balanced",
                            "enabled": false,
                            "guidance_end": 1,
                            "guidance_start": 0,
                            "hr_option": "Both",
                            "image": null,
                            "inpaint_crop_input_image": false,
                            "input_mode": "simple",
                            "is_ui": true,
                            "loopback": false,
                            "low_vram": false,
                            "model": "None",
                            "module": "none",
                            "output_dir": "",
                            "pixel_perfect": false,
                            "processor_res": 512,
                            "resize_mode": "Crop and Resize",
                            "save_detected_map": true,
                            "threshold_a": 64,
                            "threshold_b": 64,
                            "weight": 1
                        }
                    ]
                },
                "Extra options": {
                    "args": []
                },
                "Refiner": {
                    "args": [
                        false,
                        "",
                        0.8
                    ]
                },
                "Seed": {
                    "args": [
                        -1,
                        false,
                        -1,
                        0,
                        0,
                        0
                    ]
                },
                "Self Attention Guidance": {
                    "args": [
                        false,
                        0.75,
                        1
                    ]
                },
                "Tiled Diffusion": {
                    "args": [
                        false,
                        "MultiDiffusion",
                        false,
                        true,
                        1024,
                        1024,
                        96,
                        96,
                        48,
                        1,
                        "None",
                        2,
                        false,
                        10,
                        1,
                        1,
                        64,
                        false,
                        false,
                        false,
                        false,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0,
                        false,
                        0.4,
                        0.4,
                        0.2,
                        0.2,
                        "",
                        "",
                        "Background",
                        0.2,
                        -1.0
                    ]
                },
                "Tiled VAE": {
                    "args": [
                        false,
                        960,
                        64,
                        true,
                        true,
                        true,
                        false
                    ]
                },
                "Txt/Img to 3D Model": {
                    "args": []
                }
            },
            "batch_size": 1,
            "cfg_scale": 7,
            "comments": {},
            "disable_extra_networks": false,
            "do_not_save_grid": false,
            "do_not_save_samples": false,
            "enable_hr": false,
            "height": 512,
            "hr_negative_prompt": "",
            "hr_prompt": "",
            "hr_resize_x": 0,
            "hr_resize_y": 0,
            "hr_scale": 2,
            "hr_second_pass_steps": 0,
            "hr_upscaler": "Latent",
            "n_iter": 1,
            "negative_prompt": "",
            "override_settings": {},
            "override_settings_restore_afterwards": true,
            "prompt": "",
            "restore_faces": false,
            "s_churn": 0.0,
            "s_min_uncond": 0,
            "s_noise": 1.0,
            "s_tmax": null,
            "s_tmin": 0.0,
            "sampler_name": "Euler a",
            "script_args": [],
            "script_name": null,
            "seed": -1,
            "seed_enable_extras": true,
            "seed_resize_from_h": -1,
            "seed_resize_from_w": -1,
            "steps": 2,
            "styles": [],
            "subseed": -1,
            "subseed_strength": 0,
            "tiling": false,
            "width": 512
        }
    """.trimIndent()

    val res: String? = Requests().post("http://127.0.0.1:7860/sdapi/v1/txt2img",jsonString)

//    println(res)
    val api = SdWebUIApi()
//    val res = api.postAndGetApiResult("http://127.0.0.1:7860/sdapi/v1/txt2img",jsonString)
//    val image = res?.image()

    val result = res?.let { api.toApiResult(it) }
    if (result != null) {
        return result.image()
    }

    // 创建 ImageIcon 对象
    return null
}
fun main() {
    val frame = JFrame("Display BufferedImage")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    val image = getimage()
    val icon: ImageIcon = ImageIcon(image)
    val label = JLabel(icon)

    frame.contentPane.add(label)
    frame.pack()
    frame.isVisible = true
}